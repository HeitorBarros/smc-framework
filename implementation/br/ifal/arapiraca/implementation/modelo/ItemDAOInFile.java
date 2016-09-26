package br.ifal.arapiraca.implementation.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import br.ifal.arapiraca.framework.modelo.Item;
import br.ifal.arapiraca.framework.modelo.DAO.ItemDAOAbstrato;
import br.ifal.arapiraca.util.json.JSONArray;
import br.ifal.arapiraca.util.json.JSONObject;

public class ItemDAOInFile extends ItemDAOAbstrato{
	private final String filePath = "itens.json"; 
	@Override
	public Map<Integer, Item> carregarItens() {
		Map<Integer, Item> itens = new HashMap<Integer, Item>();
		Item novoItem;
		try {
			String fileContent = readJson(filePath);
			JSONArray arrayDeItens = new JSONArray(fileContent);
			
			for (int i = 0; i < arrayDeItens.length(); i++) {
				JSONObject umItem = arrayDeItens.getJSONObject(i);
				System.out.println(umItem);
				int id = umItem.getInt("id");
				String nome = umItem.getString("nome");
				String descricao = umItem.getString("descricao");
				String categoria = umItem.getString("categoria");
				double valor = umItem.getDouble("valor");
				novoItem = new Item(id, nome, descricao, categoria, valor);
				itens.put(id, novoItem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itens;
	}

	private static String readJson(String filePath) throws Exception{
		String lines = "";
		
		File f = new File(filePath);
        BufferedReader reader = new BufferedReader(new FileReader(f));
        String line="";

		while ((line = reader.readLine())!=null) {
			lines+=line;
		}
        
        reader.close();
        return lines;
    }
	public static void main(String[] args) {
		ItemDAOAbstrato dao = new ItemDAOInFile();
		try {
			System.out.println(dao.carregarItens());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
