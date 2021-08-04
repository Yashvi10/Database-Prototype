package parser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import Resources.Database;

/**
 * @author Deeksha Sareen : This class creates a new table and a corresponding meta data file
 *
 */
public class CreateTable {

	public void createTable(String query) {
//CREATE TABLE student(id INT PRIMARY KEY, name VARCHAR(100), last_name VARCHAR(100), FOREIGN KEY last_name REFERENCES T1(last_name));
		String tableName = getTable(query);
		String tablePath = Database.getDatabase() + "/" + getTable(query);
		String tableMetaPath = Database.getDatabase() + "/meta_" + getTable(query);
		boolean flag = false;
		File file = new File(tablePath);
		if (file.exists()) {
			System.err.println("Table with name " + getTable(query) + " already exists");
		} else {
			try {
				flag = file.createNewFile();
				file = new File(tableMetaPath);
				if(file.exists()) {
				   System.err.println("Metadata file with name " + getTable(query) + " already exists");
				}
				else {
					file.createNewFile();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String[] getToken = query.split("\\);");
		String[] colList = getToken[0].split(tableName.replace(".txt", "")+"\\(");
		String[] tableCols = colList[1].split(",");
		if (flag) {
			System.out.println("Table successfully created.");
			FileWriter fileWriter;
			try {
				fileWriter = new FileWriter(tableMetaPath);
				for (int i = 0; i < tableCols.length; i++) {
					fileWriter.write(tableCols[i].replaceAll(" ", "--") + "\n");
				}
				fileWriter.close();
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private String getTable(String query) {
		query = query.replaceAll(";", "");
		query = query.replaceAll(",", " ");
		query = query.replaceAll("[^a-zA-Z ]", " ");
		String[] sqlWords = query.split(" ");
		String name = sqlWords[2] + ".txt";
		return name;
	}
}