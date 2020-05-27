package br.com.app;

import br.com.modelo.Opcoes;
import br.com.negocio.Controle;
import br.com.negocio.Menu;

public class GerenciamentoAutomotivoApplication {

	public static void main(String[] args) {
		
		Menu menu = new Menu();
		Opcoes opcoes = new Opcoes();
		int op = 10;
		while (op != 0) {
			menu.imprimeMenu();
			Controle controle = new Controle();
			op = controle.opcao();
			switch (op) {
			case 1:
				opcoes.cadastraCliente();
				break;
			case 2:
				opcoes.cadastraVeiculo();
				break;
			case 3:
				opcoes.cadastraServico();
				break;
			case 4:
				opcoes.agendaRevisao();
				break;
			case 7:
				opcoes.printAgendamento();
				break;
			case 5:
				opcoes.alteraAgendamento();
				break;
			case 6:
				opcoes.deletaAgendamento();
				break;
			case 0:
				System.out.println("Programa finalizado!");
				break;
			default:
				menu.imprimeMenu();
			}
		 }

	}

}
