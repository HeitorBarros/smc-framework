package br.ifal.arapiraca.framework.modelo;

import java.util.HashMap;
import java.util.Map;

import br.ifal.arapiraca.framework.exceptions.MesaFechadaException;
import br.ifal.arapiraca.framework.exceptions.MesaNotFoundException;
import br.ifal.arapiraca.framework.exceptions.MesaOcupadaException;
import br.ifal.arapiraca.framework.modelo.factory.ContaFactory;

public class Restaurante{
	
	protected Map<Integer,Mesa> mesas;
	
	public Restaurante() throws InstantiationException{
		mesas = new HashMap<>();
		this.carregarMesas();
	}

	protected void carregarMesas() throws InstantiationException{
		mesas.putAll(MesasBuilder.criaMesas());
	}
	
	public void inicializarMesa(Integer id) throws MesaNotFoundException, MesaOcupadaException{
		Mesa novaMesa = this.getMesa(id);
		novaMesa.inicializar();
		
	}
	
	private Mesa getMesa(Integer id) throws MesaNotFoundException{
		if(mesas.containsKey(id)){
			return mesas.get(id);
		}
		
		throw new MesaNotFoundException();
	}
	
	public Map<Integer, Mesa> listarMesas(){
		return mesas;
	}
	
	public Conta gerarParcial(Integer id) throws MesaNotFoundException, InstantiationException{
		Mesa mesa = this.getMesa(id);
		Conta conta = ContaFactory.createConta(mesa.getPedidos());
		return conta;
	}
	
	public Conta encerrarConta(Integer id) throws MesaNotFoundException, InstantiationException{
		Mesa mesa = this.getMesa(id);
		Conta conta = ContaFactory.createConta(mesa.getPedidos());
		mesa.finalizar();
		return conta;
	}
	
	public void adicionarPedido(Integer idMesa, Pedido pedido) throws MesaNotFoundException, MesaFechadaException{
		Mesa mesa = this.getMesa(idMesa);
		if (mesa.estaOcupada) {
			mesa.addPedido(pedido);
		}else{
			throw new MesaFechadaException();
		}
	}

}
