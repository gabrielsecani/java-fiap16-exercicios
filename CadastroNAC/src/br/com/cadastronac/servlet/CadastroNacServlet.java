package br.com.cadastronac.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cadastronac.bean.NotaSemestral;
import br.com.cadastronac.bo.NotasBO;

/**
 * Servlet implementation class entradaServlet
 */
@WebServlet("/cadnac")
public class CadastroNacServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CadastroNacServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// URL de saída, para onde o servlet vai encaminha a requisição (camada
		// de apresentação)
		String action = request.getParameter("action");
//		action = request.getRequestURI();
//		action = action.substring(action.lastIndexOf("/") + 1);
		System.out.println("in:" + action);

		switch (action) {
		case "entrada":
			action = trataEntrada(request, response);
			break;
		case "digitacao":
			action = trataDigitacao(request, response);
			break;
		case "confirmacao":
			action = trataConfirmacao(request, response);
			break;
		}
		System.out.println("out:" + action);

		// Encaminha
		request.getRequestDispatcher(action + ".jsp").forward(request, response);

	}

	private String trataEntrada(HttpServletRequest request, HttpServletResponse response) {
		try {
			String disciplina = request.getParameter("txtDisciplina");
			Integer qtdNacs = Integer.parseInt(request.getParameter("txtQtdNacs"));
			Integer qtdAlunos = Integer.parseInt(request.getParameter("txtQtdAlunos"));

			request.getSession().setAttribute("disciplina", disciplina);
			request.getSession().setAttribute("qtdNacs", qtdNacs);
			request.getSession().setAttribute("qtdAlunos", qtdAlunos);

			return "digitacao";

		} catch (Exception e) {
			request.getSession().setAttribute("msgErro", e.getMessage());
			return "erro";
		}
	}

	private String trataDigitacao(HttpServletRequest request, HttpServletResponse response) {

		String[] listaRM, listaNAC, listaAM, listaPS;
		String disciplina;
		Integer qtdNacs;
		try {
			listaRM = request.getParameterValues("txtRM");
			listaNAC = request.getParameterValues("txtNAC");
			listaAM = request.getParameterValues("txtAM");
			listaPS = request.getParameterValues("txtPS");

			//Pega na sessao
			qtdNacs = (Integer) request.getSession().getAttribute("qtdNacs");
			disciplina = (String) request.getSession().getAttribute("disciplina");

			// chama classe de negocio que sabem resolver os problemas
			NotasBO bo=new NotasBO();
			List<NotaSemestral> notas = bo.getListOfNotaSemestralFromArrays(listaRM, listaNAC, listaAM, listaPS, qtdNacs, disciplina);
			
			// compartilhar a informação
			request.getSession().setAttribute("notas", notas);
			
			return "confirmacao";
		} catch (Exception e) {
			request.getSession().setAttribute("msgErro", e.getMessage());
			return "erro";
		}
	}

	private String trataConfirmacao(HttpServletRequest request, HttpServletResponse response) {
		//Declaracao das variaveis
		String url;
		
		NotasBO bo = new NotasBO();
		
		try{
			//Leitura de informacao armazenada na memoria (escopo de sessao)
			List<NotaSemestral> notas = (List<NotaSemestral>)request.getSession().getAttribute("notas");
			
			//Chama classes de negocio para resolver qualquer problema (nao eh responsabilidade do servlet)
			List<NotaSemestral> notasMax = bo.getMaxNotaSemestral(notas);
			List<NotaSemestral> notasMin = bo.getMinNotaSemestral(notas);
			Double media = bo.getMediaNotaSemestral(notas);
			
			//Compartilhamento das informacoes na memoria (escopo de requisicao) para serem utilizadas pela camada de apresentacao (JSP)
			request.setAttribute("maximas", notasMax);
			request.setAttribute("minimas", notasMin);
			request.setAttribute("media", media);
			
			//Define o recurso (JSP) usado na camada de apresentacao
			return "final"; 
		}catch(Exception e){
			
			//Armazena a mensagem de um eventual erro na memÃ³ria (escopo de requisicao)
			request.setAttribute("mensagemErro", e.getMessage());
			
			//Define o recurso (JSP) usado na camada de apresentacao
			return "erro";
		}

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
