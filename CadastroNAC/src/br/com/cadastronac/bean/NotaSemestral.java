package br.com.cadastronac.bean;

import java.text.NumberFormat;
import java.util.List;

public class NotaSemestral {

	private String rm;
	private String disciplina;
	
	private Double ps;
	private Double am;
	private List<Double> nacs;
	
	
	public String getRm() {
		return rm;
	}

	public void setRm(String rm) {
		this.rm = rm;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	
	public Double getPs() {
		return ps;
	}

	public void setPs(Double ps) {
		this.ps = ps;
	}

	public Double getAm() {
		return am;
	}

	public void setAm(Double am) {
		this.am = am;
	}

	public List<Double> getNacs() {
		return nacs;
	}

	public void setNacs(List<Double> nac) {
		this.nacs = nac;
	}

	public String getNotaFinal() {
		
		Double nf = 0D;
		
		for(Double n : nacs){
			nf += n;
		}
		
		nf = (nf / nacs.size()) * 0.2;
		
		nf += am * 0.3 + ps * 0.5; 
		
		NumberFormat fmt = NumberFormat.getInstance();
		fmt.setMaximumFractionDigits(2);
		
		return fmt.format(nf);
	}
		
}
