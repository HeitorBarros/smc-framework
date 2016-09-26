package br.ifal.arapiraca.framework.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import br.ifal.arapiraca.framework.modelo.Conta;
import br.ifal.arapiraca.framework.modelo.Pedido;
import br.ifal.arapiraca.framework.modelo.DAO.ItemDAOAbstrato;

public class ModelConfiguration {

	public static Conta createConta(List<Pedido> pedidos) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		String contaName = readProperties().getProperty("conta");

		Class classConta = Class.forName(contaName);
		Conta novaConta = (Conta) classConta.newInstance();
		
		novaConta.adicionarPedidos(pedidos);
		return novaConta;
	}
	
	public static ItemDAOAbstrato criaItemDAO() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		String DaoName = readProperties().getProperty("itemDAO");

		Class clazz = Class.forName(DaoName);
		ItemDAOAbstrato novoDAO = (ItemDAOAbstrato) clazz.newInstance();
		
		return novoDAO;

	}
	
	private static Properties readProperties(){
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream("config.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			//System.out.println(prop.getProperty("conta"));
			return prop;
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop;
	}

	public static Integer carregaNumeroDeMesas() {
		String strNumeroDeMesas = readProperties().getProperty("numeroMesas");
		return Integer.parseInt(strNumeroDeMesas);
	}

}
