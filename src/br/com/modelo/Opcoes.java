package br.com.modelo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.negocio.Controle;

public class Opcoes {

	public Scanner scanner = new Scanner(System.in);
	public List<Cliente> clientes = new ArrayList<Cliente>();
	public List<Agendamento> agendamentos = new ArrayList<Agendamento>();
	public List<Servico> servicos = new ArrayList<Servico>();
	SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
	int idS = 0;
	int idService = 0;
	int idC = 0;

	public void cadastraCliente() {

		Controle controle = new Controle();
		// Nome
		System.out.println("Digite o nome do cliente:");
		String nome = controle.texto();

		// Dados de contato
		System.out.println("Digite o telefone do cliente:");
		controle = new Controle();
		String numero = controle.texto();
		Telefone telefone = new Telefone(numero);

		// Dados de endereco
		System.out.printf("Digite a cidade: ");
		controle = new Controle();
		String cidade = controle.texto();
		System.out.printf("Digite a rua: ");
		controle = new Controle();
		String rua = controle.texto();
		System.out.printf("Digite o bairro: ");
		controle = new Controle();
		String bairro = controle.texto();
		System.out.printf("Digite o estado: ");
		controle = new Controle();
		String estado = controle.texto();
		System.out.printf("Digite o CEP: ");
		controle = new Controle();
		String cep = controle.texto();
		Endereco endereco = new Endereco(cidade, rua, bairro, estado, cep);

		// CPF
		System.out.println("Digite o CPF do cliente");
		controle = new Controle();
		String cpf = controle.texto();

		Cliente cliente = new Cliente(nome, telefone, endereco, cpf);
		cliente.setIdCliente(idC);
		idC++;
		clientes.add(cliente);
		System.out.println("Novo cliente adicionado!");

	}

	public void cadastraVeiculo() {

		if (clientes.isEmpty() != true) {
			int cont = 0;

			// Número da placa
			System.out.println("Digite a placa do carro:");
			Controle controle = new Controle();
			String placa = controle.texto();

			// Modelo
			System.out.println("Digite o modelo do carro:");
			controle = new Controle();
			String modelo = controle.texto();

			// Ano de fabricação
			System.out.println("Insira o ano de fabricação (aaaa): ");
			int ano = Integer.parseInt(scanner.nextLine());

			// Valor de compra
			System.out.println("Insira o valor de compra:");
			double valor = Double.parseDouble(scanner.nextLine());

			Veiculo veiculo = new Veiculo(placa, modelo, ano, valor);

			System.out.println("Selecione o dono do veículo (pelo id): ");
			for (Cliente cliente : clientes) {
				if (cliente.getVeiculo() == null) {
					System.out.println("[ " + cliente.getIdCliente() + " ] - " + "NOME: " + cliente.getNome() + "\n"
							+ "CPF: " + cliente.getCpf());
				}
			}

			int idCli = Integer.parseInt(scanner.nextLine());
			for (Cliente cliente : clientes) {
				if (cliente.getIdCliente() == idCli) {
					cliente.setVeiculo(veiculo);
					;
					System.out.println("Novo veiculo adicionado!");
				} else {
					cont++;
				}
			}

			if (cont == clientes.size()) {
				System.out.println("Cliente não encontrado! Tente novamente");
			}

		} else {
			System.out.println("Por favor cadastre um cliente antes de cadastrar o veículo!");
		}

	}

	public void cadastraServico() {
		// Nome
		System.out.println("Digite a descrição do serviço:");
		Controle controle = new Controle();
		String descricao = controle.texto();

		Servico servico = new Servico(idService, descricao);
		idService++;
		servicos.add(servico);
		System.out.println("Novo serviço adicionado!");

	}

	public void agendaRevisao() {

		if (servicos.isEmpty() != true) {
			if (clientes.isEmpty() != true) {

				int cont = 0;
				// Data
				System.out.println("Insira a data da revisão(dd/mm/aaaa):");
				String data = scanner.nextLine();

				List<String> descricaoServico = new ArrayList<String>();
				int resp = 1;
				while (resp == 1) {
					// Serviço
					System.out.println("Selecione o serviço (pelo id): ");
					for (Servico servico : servicos) {
						System.out.println(
								"[ " + servico.getServicoID() + " ] - " + "DESCRIÇÃO: " + servico.getDescricao());
					}
					int idSer = Integer.parseInt(scanner.nextLine());
					for (Servico servico : servicos) {
						if (servico.getServicoID() == idSer) {
							descricaoServico.add((String) servico.getDescricao());
						}
					}
					System.out.println("Serviço adicionado");
					System.out.println("Deseja adicionar mais um serviço ? SIM(1), NÃO(2)");
					resp = Integer.parseInt(scanner.nextLine());
				}

				// Cliente
				System.out.println("Digite o cpf do cliente que deseja fazer agendar uma revisão: ");
				String cl = scanner.nextLine();
				Cliente cls = null;
				for (Cliente cli : clientes) {

					if (cli.getCpf().equals(cl) && cli.getVeiculo() != null) {
						cls = cli;
					} else {
						cont++;
						// System.out.println("Cliente não encontrado ou não possui veiculo");
						// return;
					}
				}

				if (cont == clientes.size()) {
					System.out.println("Cliente não encontrado ou não possui veiculo");
					return;
				} else {
					System.out.println("Agendamento realizado com sucesso!");
				}

				Agendamento agendamento = new Agendamento(descricaoServico, data, cls);

				agendamento.setIdAgendamento(idS);
				idS++;

				agendamentos.add(agendamento);

			} else {
				System.out.println("Por favor cadastre um cliente antes de realizar um agendamento!");
			}
		} else {
			System.out.println("Por favor cadastre os serviços antes de realizar um agendamento!");
		}
	}

	public void printAgendamento() {
		int cont = 0;

		if (agendamentos.isEmpty() != true) {
			System.out.println("Selecione o agendamento que deseja gerar o relatorio (pelo id)");
			for (Agendamento agendamento : agendamentos) {
				System.out.println("[ " + agendamento.getIdAgendamento() + " ] - NOME DO CLIENTE: "
						+ agendamento.getCliente().getNome() + "\n" + "DATA DO AGENDAMENTO: "
						+ f.format(agendamento.getData()));
			}
			int idCliente = Integer.parseInt(scanner.nextLine());
			for (Agendamento agend : agendamentos) {
				if (agend.getIdAgendamento() == idCliente) {
					System.out.println("Agendamento feito para o/a: " + agend.getCliente().getNome());
					System.out.println("Placa do carro: " + agend.getCliente().getVeiculo().getPlaca());
					System.out.println("Modelo : " + agend.getCliente().getVeiculo().getModelo());
					System.out.println("Ano : " + agend.getCliente().getVeiculo().getAno());
					System.out.println("No dia: " + f.format(agend.getData()));
					System.out.println("Contendo os seguintes serviços: ");
					List<String> services = agend.getServico();
					for (Servico servico : servicos) {
						System.out.println(servico.getDescricao());
					}
				} else {
					cont++;

				}
				if (cont == agendamentos.size()) {
					System.out.println("ID do cliente não encontrado! Tente novamente");
				}
			}

		} else {
			System.out.println("Primeiro faça um agendamento!");
		}
	}

	public void alteraAgendamento() {
		int cont = 0;

		if (agendamentos.isEmpty() != true) {
			System.out.println("Selecione o agendamento que deseja alterar (pelo id)");
			for (Agendamento agendamento : agendamentos) {
				System.out.println("[ " + agendamento.getIdAgendamento() + " ] - NOME DO CLIENTE: "
						+ agendamento.getCliente().getNome() + "\n" + "DATA DO AGENDAMENTO: "
						+ f.format(agendamento.getData()));

			}
			int idClient = Integer.parseInt(scanner.nextLine());
			for (Agendamento agend : agendamentos) {
				if (agend.getIdAgendamento() == idClient) {
					agend.alteraServico(servicos);
				} else {
					cont++;
				}
				if (cont == agendamentos.size()) {
					System.out.println("ID de agendamento não encontrado! Tente novamente");
				}
			}
		} else {
			System.out.println("Primeiro faça um agendamento!");
		}
	}

	public void deletaAgendamento() {
		int cont = 0;
		if (agendamentos.isEmpty() != true) {
			System.out.println("Selecione o agendamento que deseja cancelar (pelo id)");
			for (Agendamento agendamento : agendamentos) {
				System.out.println("[ " + agendamento.getIdAgendamento() + " ] - NOME DO CLIENTE: "
						+ agendamento.getCliente().getNome() + "\n" + "CPF: " + agendamento.getCliente().getCpf() + "\n"
						+ "DATA DO AGENDAMENTO: " + f.format(agendamento.getData()));

			}
			int idSchedule = Integer.parseInt(scanner.nextLine());
			for (Agendamento agend : agendamentos) {
				if (agend.getIdAgendamento() == idSchedule) {
					agendamentos.remove(agend);
					System.out.println("Agendamento cancelado");
					return;
				} else {
					cont++;
				}
				if (cont == agendamentos.size()) {
					System.out.println("Agendamento não encontrado! Tente novamente");
				}
			}

		} else {
			System.out.println("Primeiro faça um agendamento!");
		}

	}

}
