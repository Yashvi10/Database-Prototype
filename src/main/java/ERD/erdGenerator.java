package ERD;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import Resources.Database;

/**
 * @author Deeksha Sareen: This class generates an ERD of the database tables.
 *
 */

public class erdGenerator {


	public void ERD() throws IOException {
		FileReader fileReader = null;
        String dbPath = Database.getDatabase();
		String[] tablenames;
		File directory = new File(dbPath);
		File[] files = directory.listFiles((d, name) -> name.startsWith("meta"));
		for (File file : files) {
			System.out.println(file.getName());
//			String[] fileName = file.getName().split("\\.");
//			BufferedReader bufferedReader = new BufferedReader(fileReader);
//			String line = "", mergedLine = "";
//			tablenames = fileName[0].split("_");
//			System.out.println(tablenames);
//			// System.out.println("The metadata for " + tablenames[1] + " is:");
//			System.out.println("-----------------  " + tablenames[1].toUpperCase() + "  -----------------");
//			while ((line = bufferedReader.readLine()) != null) {
//
//				System.out.println(line);
//			}
		}
	}

}
