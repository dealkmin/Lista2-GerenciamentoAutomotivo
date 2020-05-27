package br.com.modelo;

public class Endereco {
	
	private String rua;
	private String bairro;
	private String estado;
	private String cidade;
	private String CEP;
	
	public Endereco(String rua, String bairro, String estado, String cidade, String CEP) {
		this.rua = rua;
		this.bairro = bairro;
		this.estado = estado;
		this.cidade = cidade;
		this.CEP = CEP;
	}
	
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public String getRua() {
		return this.rua;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getBairro() {
		return this.bairro;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getEstado() {
		return this.estado;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getCidade() {
		return this.cidade;
	}
	
	public void setCEP(String CEP) {
		this.CEP= CEP;
	}
	
	public String getCEP() {
		return this.CEP;
	}

}
