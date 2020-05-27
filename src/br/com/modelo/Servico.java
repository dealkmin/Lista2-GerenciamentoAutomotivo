package br.com.modelo;

public class Servico {
	private int servicoID;
	public int getServicoID() {
		return servicoID;
	}

	public void setServicoID(int servicoID) {
		this.servicoID = servicoID;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	private String descricao;
	
	public Servico(int servicoID, String descricao) {
		this.servicoID = servicoID;
		this.descricao = descricao;
	}

}
