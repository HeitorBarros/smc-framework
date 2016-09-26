package br.ifal.arapiraca.implementation.modelo;


import br.ifal.arapiraca.framework.modelo.Conta;
import br.ifal.arapiraca.framework.modelo.Item;
import br.ifal.arapiraca.framework.modelo.Pedido;


public class ContaSimples extends Conta{

	public ContaSimples() {
		super();
	}

	@Override
	public Double calcularTotal() {
		Double total = 0.0;
		for (Pedido pedido : super.pedidos) {
			for (Item item : pedido.getItens().keySet()) {
				total+= item.getValor()* (pedido.getItens().get(item));
			}
		}
		return total;
	}

	@Override
	public String toString() {
		String result = "\n--------------------------";
		result+="\nCONTA";
		result+="\n--------------------------";
		result+= "\nPedidos\n";
		for (Pedido pedido : pedidos) {
			result+= pedido+"\n";
		}
		result+="\n Total: "+calcularTotal();
		return result;
	}
	
	

}
