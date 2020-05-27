package br.com.modelo;

public class Telefone {
	private String numero;
	
	public Telefone(String numero) {
		this.numero = numero;
	}
	
	public String getNumero() {
		String n = this.numero;
		if(this.numero.length() == 9) {
			n = this.numero.substring(0, 5) + "-";
			n += this.numero.substring(5);
		}else if(this.numero.length() == 8) {
			n = this.numero.substring(0, 4) + "-";
			n += this.numero.substring(4);
		}
		
		return n;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}

}
