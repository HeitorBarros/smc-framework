package br.ifal.arapiraca.framework.modelo;

import java.util.Map;

import br.ifal.arapiraca.framework.exceptions.MesaFechadaException;
import br.ifal.arapiraca.framework.exceptions.MesaNotFoundException;
import br.ifal.arapiraca.framework.exceptions.MesaOcupadaException;
import br.ifal.arapiraca.framework.modelo.DAO.DAOBuilder;

public class Fachada {
	
	private Restaurante restaurante;

	public Fachada() throws InstantiationException {
		super();
		this.inicializarRestaurante();
	}

	public Map<Integer, Item> listarItens() throws InstantiationException{
		return DAOBuilder.buildMesaDAO().carregarItens();
	}
	
	private void inicializarRestaurante() throws InstantiationException{
		this.restaurante = new Restaurante(); 
	}

	public void abrirMesa(int mesa) throws MesaNotFoundException, MesaOcupadaException {
		this.restaurante.inicializarMesa(mesa);
	}
	
	public void adicionarPedido(int idMesa, Pedido pedido) throws MesaNotFoundException, MesaFechadaException{
		restaurante.adicionarPedido(idMesa, pedido);
	}

	public Conta encerrarMesa(int mesa) throws InstantiationException, MesaNotFoundException {
		return restaurante.encerrarConta(mesa);
		
	}
	
}
