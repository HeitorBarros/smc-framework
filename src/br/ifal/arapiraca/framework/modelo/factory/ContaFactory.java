package br.ifal.arapiraca.framework.modelo.factory;

import java.util.ArrayList;
import java.util.List;

import br.ifal.arapiraca.framework.configuration.ModelConfiguration;
import br.ifal.arapiraca.framework.modelo.Conta;
import br.ifal.arapiraca.framework.modelo.Pedido;

public class ContaFactory {

	public static Conta createConta(List<Pedido> pedidos) throws InstantiationException {
		try {
			return ModelConfiguration.createConta(pedidos);
		} catch (Exception e) {
			e.printStackTrace();
			throw new InstantiationException(); 
		}
	}
	
	public static void main(String[] args) throws InstantiationException {
		ContaFactory.createConta(new ArrayList<Pedido>());
	}

}
