package br.ifal.arapiraca.framework.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Pedido {

	private String horaCriacao;
	//Um pedido tem um mapa de itens e suas quantidades
	private Map<Item, Integer> itens;
	
	public Pedido() {
		super();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date hora = Calendar.getInstance().getTime();
		horaCriacao = sdf.format(hora);
		itens = new HashMap<>();
	}

	public String getHoraCriacao() {
		return horaCriacao;
	}

	public void setHoraCriacao(String horaCriacao) {
		this.horaCriacao = horaCriacao;
	}

	public Map<Item, Integer> getItens() {
		return itens;
	}

	public void setItens(Map<Item, Integer> itens) {
		this.itens = itens;
	}
	
	public void addItem(Item novoItem){
		Integer quantidade = 1;
		if (this.itens.containsKey(novoItem)) {
			quantidade += this.itens.get(novoItem);
		}
		this.itens.put(novoItem, quantidade);
	}
	
	public void addItem(Item novoItem, Integer quantidade){
		if (quantidade < 1){
			return;
		}
		
		if (this.itens.containsKey(novoItem)) {
			quantidade += this.itens.get(novoItem);
		}
		this.itens.put(novoItem, quantidade);
	}

	@Override
	public String toString() {
		String result = "Hora de lançamento: "+ horaCriacao+"\n";
		for (Item item : itens.keySet()) {
			result+="- "+item.getNome()+" x"+itens.get(item)+"\n";
		}
		
		return result;
	}
	
	

}
