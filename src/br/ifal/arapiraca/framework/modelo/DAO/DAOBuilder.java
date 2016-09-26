package br.ifal.arapiraca.framework.modelo.DAO;

import br.ifal.arapiraca.framework.configuration.ModelConfiguration;

public class DAOBuilder {

	private static ItemDAOAbstrato itemDao;
	
	public static ItemDAOAbstrato buildMesaDAO() throws InstantiationException {
		if (itemDao == null) {
			try {
				itemDao = ModelConfiguration.criaItemDAO();
			} catch (Exception e) {
				e.printStackTrace();
				throw new InstantiationException();
			}
		}		
		return itemDao;
	}
	
}
