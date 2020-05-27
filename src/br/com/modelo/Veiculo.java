package br.com.modelo;

public class Veiculo {
	
	private String placa;
	private String modelo;
	private int ano;
	private double valor;
	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Veiculo(String placa, String modelo, int ano, double valor) {

		this.ano = ano;
		this.modelo = modelo;
		this.placa = placa;
		this.valor = valor;
	}

}
