package br.com.fiap.si.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.fiap.si.bean.Funcionario;
import br.com.fiap.si.dao.FuncionarioDAO;

@ManagedBean
public class FuncionarioMB {

	//Propriedades de entrada
	private Funcionario funcionario;

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	//Propriedade de saida (placeholder)
	private List<Funcionario> listaFuncionarios;

	public List<Funcionario> getListaFuncionarios() {
		return listaFuncionarios;
	}
	
	//Metodo construtor
	public FuncionarioMB(){
		funcionario = new Funcionario();
		listaFuncionarios = new ArrayList<Funcionario>();
	}
	
	//Metodos action controller
	public String incluir(){
		
		try{
			FuncionarioDAO dao = new FuncionarioDAO();
			dao.insert(funcionario);
			
			return listar();
			
		}catch(Exception e){
			return "erro";
		}
	}
	
	public String listar(){
		
		try{
			FuncionarioDAO dao = new FuncionarioDAO();
			listaFuncionarios = dao.getAll();
			
			return "lista";
			
		}catch(Exception e){
			return "erro";
		}
		
	}
	
	public String pesquisar(){
		
		try{
			FuncionarioDAO dao = new FuncionarioDAO();
			listaFuncionarios = dao.getFuncionarioByPk(funcionario.getCpf());
			
			return "lista";
			
		}catch(Exception e){
			return "erro";
		}
		
	}
	
}
