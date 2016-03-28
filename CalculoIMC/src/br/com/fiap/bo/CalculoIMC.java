package br.com.fiap.bo;

import java.text.NumberFormat;
import java.util.Locale;

public class CalculoIMC {

	private float altura;
	private float peso;
	private float imc;

	public CalculoIMC(float altura, float peso) throws Exception {
		super();
		this.altura = altura;
		this.peso = peso;
		calc();
	}

	private void calc() throws Exception {
		if (altura <= 0) {
			throw new Exception("Altura deve maior que zero!");
		}

		if (peso <= 0) {
			throw new Exception("Peso deve maior que zero!");
		}

		imc = peso / (altura * altura);
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) throws Exception {
		this.altura = altura;
		calc();
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) throws Exception {
		this.peso = peso;
		calc();
	}

	public String getValorIMC(){

		
		NumberFormat fmt = NumberFormat.getInstance(new Locale("en", "US"));
		fmt.setMaximumFractionDigits(2);
		
		return fmt.format(imc);
	}

	public String getCor() {
		return (imc > 28 ? "red" : (imc > 20 ? "yellow" : "blue"));
	}

}
