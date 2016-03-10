package br.hellomvc.bo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import br.hellomvc.model.NotaSemestral;

public class NotasBO {

	private List<NotaSemestral> notasSemestrais;

	public NotasBO() {
		notasSemestrais = new ArrayList<NotaSemestral>();

		NotaSemestral n = new NotaSemestral();
		ArrayList<Double> nacs = new ArrayList<Double>();
		n.setRm("72468");
		n.setDisciplina("TAP");
		nacs.add(7.9);
		nacs.add(4.3);
		n.setNacs(nacs);
		n.setAm(6.2);
		n.setPs(9.5);
		notasSemestrais.add(n);

		n = new NotaSemestral();
		n.setRm("12345");
		n.setDisciplina("TAP");
		nacs.add(7.9);
		nacs.add(4.3);
		n.setNacs(nacs);
		n.setAm(6.6);
		n.setPs(5.5);
		notasSemestrais.add(n);

		n = new NotaSemestral();	 
		nacs = new ArrayList<Double>();
		n.setRm("56789");
		n.setDisciplina("TAP");
		nacs.add(5.9);
		nacs.add(7.3);
		n.setNacs(nacs);
		n.setAm(9.7);
		n.setPs(6.9);
		notasSemestrais.add(n);

	}

	public NotaSemestral getNotaByRmAndDisciplina(String rm, String disciplina) {

		notasSemestrais = notasSemestrais.stream()
				.filter(m -> 
						m.getRm().equals(rm) &&
						m.getDisciplina().equals(disciplina))
				.limit(1)
				.collect(Collectors.toList());

		if (notasSemestrais.size() == 1)
			return notasSemestrais.get(0);
		else
			return null;
	}
}
