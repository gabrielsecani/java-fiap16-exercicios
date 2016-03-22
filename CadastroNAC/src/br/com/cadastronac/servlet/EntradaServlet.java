package br.com.cadastronac.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cadastronac.bean.NotaSemestral;

/**
 * Servlet implementation class entradaServlet
 */
@WebServlet("/entrada")
public class EntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EntradaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		switch (action) {
		case "entrada":
			trataEntrada(request, response);	
			break;
		case "digitacao":
			trataDigitacao(request, response);	
			break;
		case "confirmacao":
			trataConfirmacao(request, response);	
			break;
		}

		request.getRequestDispatcher(action + ".jsp").forward(request, response);

	}

	private void trataEntrada(HttpServletRequest request, HttpServletResponse response) {
		String disciplina = request.getParameter("txtDisciplina");
		System.out.println(disciplina);
		request.setAttribute("txtDisciplina", disciplina);
		request.setAttribute("txtQtdNacs", request.getParameter("txtQtdNacs"));
		request.setAttribute("txtQtdAlunos", request.getParameter("txtQtdAlunos"));
	}
	private void trataDigitacao(HttpServletRequest request, HttpServletResponse response) {
		
	}

	private void trataConfirmacao(HttpServletRequest request, HttpServletResponse response) {
		
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
