package br.com.fiap.rm72468.managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.fiap.rm72468.bean.Funcionario;
import br.com.fiap.rm72468.dao.FuncionarioDAO;

@ManagedBean
public class FuncionarioMB {

	//Propriedades de entrada
	private Funcionario funcionario;

	public Funcionario getFuncionario() {
		if(funcionario==null) funcionario = new Funcionario();
		return funcionario;
	}
	
	//Propriedade de saída (placeholder)
	private List<Funcionario> listaFuncionario;

	public List<Funcionario> getListaFuncionario() {
		return listaFuncionario;
	}

	// Metodos action controller
	public String incluir(){
		try{
			FuncionarioDAO dao = new FuncionarioDAO();
			dao.insert(funcionario);
			
			//return "menu";
			return listar();
			
		}catch(Exception e){
			return "erro";
		}	
	}
	
	public String listar(){
		try{
			FuncionarioDAO dao = new FuncionarioDAO();
			listaFuncionario = dao.getAll();
			
			return "lista";
			
		}catch(Exception e){
			return "erro";
		}		
	}
	
	public String pesquisar(){
		try{
			FuncionarioDAO dao = new FuncionarioDAO();
			listaFuncionario = dao.getFuncionarioByPk(funcionario.getCpf());			

			return "lista";
			
		}catch(Exception e){
			return "erro";
		}		
	}
	
}
