package br.ifal.arapiraca.implementation.modelo;

import java.util.Map;
import java.util.Scanner;

import br.ifal.arapiraca.framework.exceptions.MesaFechadaException;
import br.ifal.arapiraca.framework.exceptions.MesaNotFoundException;
import br.ifal.arapiraca.framework.exceptions.MesaOcupadaException;
import br.ifal.arapiraca.framework.modelo.Conta;
import br.ifal.arapiraca.framework.modelo.Fachada;
import br.ifal.arapiraca.framework.modelo.Item;
import br.ifal.arapiraca.framework.modelo.Pedido;

public class TextUI {
	private static Scanner teclado;
	private static Fachada fachada;
	private static void printMenu(){
		System.out.println();
		System.out.println("Escolha a opção:");
		System.out.println("1- abrir uma nova mesa.");
		System.out.println("2- adicionar um pedido.");
		System.out.println("3- fechar uma conta.");
		System.out.println("0- para encerrar.");
	}
	
	private static void opcao1(){
		System.out.println("Opção 1 - Abrir uma nova mesa");
		System.out.println("Digite o número da mesa");
		int mesa = teclado.nextInt();
		try {
			fachada.abrirMesa(mesa);
			System.out.println("Mesa aberta com sucesso");
		} catch (MesaNotFoundException e) {
			System.out.println("Número de mesa Inválido");
		} catch (MesaOcupadaException e) {
			System.out.println("Mesa já ocupada");
		}
	}
	
	private static void opcao2(){
		Pedido pedido = new Pedido();
		int idItem, qtde;
		Map<Integer, Item> itens;
		try {
			itens = fachada.listarItens();
		} catch (InstantiationException e1) {
			System.out.println("Não foi possível carregar os itens do cardápio.");
			e1.printStackTrace();
			return;
		}
		System.out.println("Opção 2 - Adicionar pedido");
		System.out.println("Digite o número da mesa");
		int mesa = teclado.nextInt();
		
		while(true){
			System.out.println("Digite o número do item: (0 para encerrar)");
			idItem = teclado.nextInt();
			if (idItem==0) {
				break;
			}
			if (itens.containsKey(idItem)) {
				System.out.println("Digite a quantidade:");
				qtde = teclado.nextInt();
				pedido.addItem(itens.get(idItem), qtde);
			} else{
				System.out.println("item inexistente");
			}
		}
		try {
			fachada.adicionarPedido(mesa, pedido);
			System.out.println(pedido);
			System.out.println("Pedido adicionado com sucesso");
		} catch (MesaNotFoundException e) {
			System.out.println("Número de mesa Inválido");
		} catch (MesaFechadaException e) {
			System.out.println("A mesa "+mesa+" não está ativa");
		}
	}
	
	private static void opcao3(){
		System.out.println("Opção 3 - Finalizar conta");
		System.out.println("Digite o número da mesa");
		int mesa = teclado.nextInt();
		try {
			Conta conta = fachada.encerrarMesa(mesa);
			System.out.println("Mesa encerrada");
			System.out.println(conta);
		} catch (MesaNotFoundException e) {
			System.out.println("Número de mesa Inválido");
		} catch (InstantiationException e) {
			System.out.println("Erro no encerramento da conta!");
			e.printStackTrace();
		} 
	}
	
	public static void main(String[] args) throws InstantiationException {
		teclado  = new Scanner(System.in);
		fachada = new Fachada();
		System.out.println("Sistema de Controle de Mesas");
		while(true){
			printMenu();
			String option = teclado.next();

			switch (option) {
			case "1":
				opcao1();
				break;
			case "2":
				opcao2();
				break;
			case "3":
				opcao3();
				break;
			case "0":
				System.out.println("Encerrando o sistema.");
				return;
			default:
				System.out.println("Digite uma opção válida.");
				break;
			}
		}
	}

}
