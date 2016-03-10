package br.hellomvc.model;

import java.text.NumberFormat;
import java.util.ArrayList;

import javax.annotation.ManagedBean;

public class NotaSemestral {

	//
	private String rm;
	private String disciplina;
	private ArrayList<Double> nacs;
	private Double am;
	private Double ps;

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

	public ArrayList<Double> getNacs() {
		return nacs;
	}

	public void setNacs(ArrayList<Double> nacs) {
		this.nacs = nacs;
	}

	public Double getAm() {
		return am;
	}

	public void setAm(Double am) {
		this.am = am;
	}

	public Double getPs() {
		return ps;
	}

	public void setPs(Double ps) {
		this.ps = ps;
	}

	public String getNotaFinal() {
		Double nota = 0D;
		for (Double n : nacs) {
			nota += n;
		}
		nota = (nota / nacs.size()) * 0.2;
		nota += (getAm() * 0.3) + (getPs() * 0.5);
		NumberFormat fmt = NumberFormat.getInstance();
		fmt.setMaximumFractionDigits(2);
		return fmt.format(nota);
	}

}
