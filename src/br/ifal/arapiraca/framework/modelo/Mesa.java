package br.ifal.arapiraca.framework.modelo;

import java.util.ArrayList;
import java.util.List;

import br.ifal.arapiraca.framework.exceptions.MesaOcupadaException;

public class Mesa {
	
	protected Integer id;
	protected Boolean estaOcupada;
	protected List<Pedido> pedidos;

	
	
	public Mesa(Integer id) {
		super();
		this.id = id;
		estaOcupada =false;
		pedidos = new ArrayList<>();
	}

	public Integer getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public void inicializar() throws MesaOcupadaException {
		if(estaOcupada){
			throw new MesaOcupadaException();
		}
		this.estaOcupada=true;
		this.pedidos = new ArrayList<>();
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void finalizar() {
		estaOcupada =false;
		pedidos.clear();
	}
	
	public void addPedido(Pedido p){
		pedidos.add(p);
	}

	@Override
	public String toString() {
		String result = "Mesa " + id;
		if (estaOcupada) {
			result+=" (ocupada) ";
		}else{
			result+=" (livre) ";
		}
		result += pedidos.size()+" pedidos";
		return result;
	}

}
