package br.com.fiap.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.bo.CalculoIMC;

/**
 * Servlet implementation class CalculoIMCSvl
 */
@WebServlet("/calcular")
public class CalculoIMCSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculoIMCSvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=null;
		try{
			Float altura = Float.parseFloat(request.getParameter("txtAltura"));
			Float peso = Float.parseFloat(request.getParameter("txtPeso"));
			
			
			CalculoIMC c = new CalculoIMC(altura,peso);
			
			request.getSession().setAttribute("imc", c);
			
			action = "resultado";
		} catch(Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute("msgErro", e.getMessage());
			action = "erro";
		}
		
		request.getRequestDispatcher(action+".jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
