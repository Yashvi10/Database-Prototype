package parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Resources.Database;
import Resources.regex;

/**
 * @author Deeksha Sareen
 *
 */
public class insertParser {

	public void insertQuery(String query) throws IOException {
		// String[] queryValues = query.split(" ");
		String colNames = "";
		String values = "";
		Matcher m = Pattern.compile(regex.BETWEENBRACKETS).matcher(query);
		int flag = 0;
		while (m.find()) {
			if (flag == 0) {
				colNames += m.group(1);

			} else {
				values += m.group(1);
			}
			flag++;

		}
		String output = "";
		String line;
		String tablePath = Database.getDatabase() + "/" + getTable(query);
		String metaTablePath = Database.getDatabase() + "/meta_" + getTable(query);
		String[] entries = values.trim().split(",");
		String[] columns = colNames.trim().split(",");
		int size = 0;
		if (entries.length != columns.length) {
			System.err.println("Column names don't match the column values");
		} else {
			for (int i = 0; i < columns.length; i++) {
				BufferedReader in = new BufferedReader(new FileReader(metaTablePath));
				while ((line = in.readLine()) != null) {
					if (line.contains(columns[i].trim()) && line.toLowerCase().contains("primary--key")) {
						if (checkPrimaryConstraint(tablePath, entries[i].trim()) == true) {
							output += "#" + columns[i] + "=" + entries[i] + ", ";
							size++;
						} else {
							System.err.println("Primary key constraint fails");
						}

					} else if (line.contains(columns[i].trim()) && line.toLowerCase().contains("foreign--key")) {
						String[] references = line.toLowerCase().split("--references--");
						String[] refTableName = references[1].split("\\(");
						// System.out.println(refTableName[0]);
						String refPath = Database.getDatabase() + "/" + refTableName[0] + ".txt";
						File file = new File(refPath);
						if (!file.exists()) {
							System.err.println("Table does not exist");
						} else if (checkPrimaryConstraint(refPath, columns[i].trim()) == false && file.exists()) {
							output += columns[i] + "=" + entries[i] + ", ";
							size++;
						} else {
							System.err.println("Foreign key constraint fails");
						}

					}

					else if (!output.contains(columns[i]) && line.contains(columns[i].trim())
							&& !line.toLowerCase().contains("primary--key")
							&& !line.toLowerCase().contains("foreign--key")) {
						output += columns[i] + "=" + entries[i] + ", ";
						size++;
					}

				}
				FileWriter fileWriter = null;
				if (size == columns.length) {
					fileWriter = new FileWriter(tablePath, true);
					fileWriter.write(System.lineSeparator());
					fileWriter.write(output);
					System.out.println("Row successfully inserted.");
					fileWriter.flush();
				}

			}

		}

		// insert into student (id, name ,last_name) values (1,'Deeksha', 'Sareen');

	}

	private boolean checkPrimaryConstraint(String tablePath, String contraint) throws IOException {
		String line;
		BufferedReader in = new BufferedReader(new FileReader(tablePath));
		while ((line = in.readLine()) != null) {
			if (line.contains(contraint)) {
				return false;
			}
		}
		return true;
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
