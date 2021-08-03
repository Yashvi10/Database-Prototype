package parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Resources.Database;

/**
 * @author Deeksha Sareen
 *
 */
public class selectExecutioner {
	
	String tablename= "";
	String wherefields = "";
	String attributefields = "";

	public void executeSelect(String query) throws IOException {
		SelectParser parse = new SelectParser();
		Map<String, ArrayList<String>> mapping = new HashMap<>(parse.parsingAttributes(query));
		System.out.println(mapping);
		ArrayList<String> tablename = new ArrayList<>(mapping.get("From"));
		ArrayList<String> colFields = new ArrayList<>(mapping.get("Attributes"));
		String store = Database.getDatabase() + "/" + tablename.get(0) + ".txt";
		System.out.println(store);
		File tableFile = new File(store);
		if (tableFile.exists()) {
			if(colFields.get(0).equals("*") && wherefields == "") {
				BufferedReader in = new BufferedReader(new FileReader(store));
				String line;
				while((line = in.readLine())!=null) {
					System.out.println(line);
				}
				in.close();
			}
			if(colFields.get(0).equals("*") && wherefields!= "") {
				
			}
			
		} else {
			System.out.println("The required table does not exist");
		}

	}
}
