package br.com.cadastronac.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.cadastronac.bean.NotaSemestral;

public class CadastroBO {
	// Negocio
	public CadastroBO() {
		// TODO Auto-generated constructor stub
	}
	
	public static List<NotaSemestral> geraCadastroNotas(String disciplina, int qtdAlunos, int qtdNacs){
		
		ArrayList<NotaSemestral> alunos=new ArrayList<NotaSemestral>(qtdAlunos);
		for (int i=0; i<qtdAlunos; i++){
			NotaSemestral aluno = new NotaSemestral();
			aluno.setDisciplina(disciplina);
			
			ArrayList<Double> nac=new ArrayList<Double>(qtdNacs);
			for (int k=0; k<qtdNacs; k++){
				nac.add(0D);
			}
			aluno.setNacs(nac);
			alunos.add(aluno);
		}
		//new NotaSemestral();		
		return alunos;		
	}
	
}
