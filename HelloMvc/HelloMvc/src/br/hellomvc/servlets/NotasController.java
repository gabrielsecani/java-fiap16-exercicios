package br.hellomvc.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.hellomvc.bo.NotasBO;
import br.hellomvc.model.NotaSemestral;

/**
 * Servlet implementation class NotasController
 */
@WebServlet("/verificar")
public class NotasController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NotasController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		String url = "";
		
		String rm = request.getParameter("txtRM");
		String disciplina = request.getParameter("txtDisciplina");
		
		NotasBO bo = new NotasBO();
		try{
			NotaSemestral nota = bo.getNotaByRmAndDisciplina(rm, disciplina);
			request.setAttribute("notaSemestral", nota);
			url="notas.jsp";
		}catch(Exception e){
			url="erro.jsp";		
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
