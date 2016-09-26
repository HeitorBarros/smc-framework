package br.ifal.arapiraca.framework.modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Conta {
	
	protected List<Pedido> pedidos;

	public Conta(List<Pedido> pedidos) {
		super();
		this.pedidos = pedidos;
	}

	public Conta(){
		super();
		this.pedidos = new ArrayList<Pedido>();
	}

	public void adicionarPedidos(List<Pedido> pedidos) {
		this.pedidos.addAll(pedidos);
		
	}
	
	public abstract Double calcularTotal();

}
