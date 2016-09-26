package br.ifal.arapiraca.framework.modelo.DAO;

import java.util.Map;

import br.ifal.arapiraca.framework.modelo.Item;

public abstract class ItemDAOAbstrato {

	public abstract Map<Integer, Item> carregarItens();

}
