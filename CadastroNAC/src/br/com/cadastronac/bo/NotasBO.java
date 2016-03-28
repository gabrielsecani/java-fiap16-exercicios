package br.com.cadastronac.bo;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.cadastronac.bean.NotaSemestral;


public class NotasBO {

	public List<NotaSemestral> getListOfNotaSemestralFromArrays(String[] listaRM, String[] listaNAC, String[] listaAM, String[] listaPS, Integer qtdNacs, String disciplina){
		
		List<NotaSemestral> notas = new ArrayList<NotaSemestral>();
		
		for(int i=0;i<listaRM.length;i++){
			NotaSemestral n = new NotaSemestral();
			ArrayList<Double> nacs = new ArrayList<Double>();
			
			
			for(int j=0;j<qtdNacs;j++){
				nacs.add(Double.parseDouble(listaNAC[j + qtdNacs * i]));
			}
			
			n.setDisciplina(disciplina);
			n.setRm(listaRM[i]);
			n.setNacs(nacs);
			n.setAm(Double.parseDouble(listaAM[i]));
			n.setPs(Double.parseDouble(listaPS[i]));
			
			notas.add(n);
		}
		
		return notas;
	}
	
	public List<NotaSemestral> getMaxNotaSemestral(List<NotaSemestral> notas){
		
		Double max = notas.stream().map(NotaSemestral::getNotaFinal).mapToDouble(Double::parseDouble).max().getAsDouble();
		List<NotaSemestral> resultado = notas.stream().filter(n -> Double.parseDouble(n.getNotaFinal()) == max).collect(Collectors.toList());
		
		return resultado;
	}
	
	public List<NotaSemestral> getMinNotaSemestral(List<NotaSemestral> notas){
		Double min = notas.stream().map(NotaSemestral::getNotaFinal).mapToDouble(Double::parseDouble).min().getAsDouble();
		List<NotaSemestral> resultado = notas.stream().filter(n -> Double.parseDouble(n.getNotaFinal()) == min).collect(Collectors.toList());
		
		return resultado;
	}
	
	public Double getMediaNotaSemestral(List<NotaSemestral> notas){
		Double media = notas.stream().map(NotaSemestral::getNotaFinal).mapToDouble(Double::parseDouble).average().getAsDouble();
		
		return media;
	}
	
}
