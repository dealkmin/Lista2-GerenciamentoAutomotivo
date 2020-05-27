package br.com.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import br.com.negocio.Controle;

public class Agendamento {
	
	public Scanner scanner = new Scanner(System.in);
	public List<String> servico = new ArrayList<String>();
	private Date data;
	private Cliente cliente;
	private int idAgendamento;
	
	public Agendamento(List<String> servico, String data, Cliente cliente) {
		this.servico  = servico;
		try {
			this.data = new SimpleDateFormat("dd/MM/yyyy").parse(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.cliente = cliente;
	}
	
	public void alteraData(){
		System.out.println("Digite a nova data de agendamento de revisão:");
		Controle controle = new Controle();
		String dataNova = controle.texto(); 
	    Date dataFormatada = null;
		try {
			dataFormatada = new SimpleDateFormat("dd/MM/yyyy").parse(dataNova);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		this.setData(dataFormatada);
		System.out.println("Data da revisão alterada!");
		
	}
	
	public void alteraServico(List<Servico> servicos){
		List<String> descricaoServico = new ArrayList<String>();
		int resp = 1;
		while(resp == 1) {
			//Serviço
			System.out.println("Selecione o serviço (pelo id): ");
			for (Servico servico : servicos) {
				System.out.println("[ "+servico.getServicoID()+" ] - " +"DESCRIÇÃO: " +servico.getDescricao());
			}
			int idSer = Integer.parseInt(scanner.nextLine());
			for (Servico servico : servicos) {
				if(servico.getServicoID() == idSer) {
					descricaoServico.add((String) servico.getDescricao());
				}
			}
			System.out.println("Serviço adicionado");
			System.out.println("Deseja adicionar mais um serviço ? SIM(1), NÃO(2)");
			resp = Integer.parseInt(scanner.nextLine());
		}
		this.setServico(descricaoServico);
		System.out.println("Serviço alterado!");
	}
	
	public void editaAgendamento(List<Servico> servicos){
		System.out.println("1- Mudar data.");
		System.out.println("2- Editar serviço.");
		Controle controle = new Controle();
		int opt = controle.opcao();
		switch(opt){
		case 1:
			alteraData();
			break;
		
		case 2:
			alteraServico(servicos);
			break;
	
		}
		
	}

	public List<String> getServico() {
		return servico;
	}

	public void setServico(List<String> servico) {
		this.servico = servico;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getIdAgendamento() {
		return idAgendamento;
	}

	public void setIdAgendamento(int idAgendamento) {
		this.idAgendamento = idAgendamento;
	}

}
