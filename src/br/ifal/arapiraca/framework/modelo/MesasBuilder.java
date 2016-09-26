package br.ifal.arapiraca.framework.modelo;

import java.util.HashMap;
import java.util.Map;

import br.ifal.arapiraca.framework.configuration.ModelConfiguration;

public class MesasBuilder {

	public static Map<Integer,Mesa> criaMesas() {
		Map<Integer,Mesa> mesas = new HashMap<Integer,Mesa>();
		Integer numeroDeMesas = ModelConfiguration.carregaNumeroDeMesas();
		for (int i = 1; i <=numeroDeMesas; i++) {
			mesas.put(i,new Mesa(i));
		}
		return mesas;
	}
	
	

}
