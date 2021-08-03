package parser;

import logs.DatabaseRecord;
import logs.EventFailRecord;
import logs.ExistRecord;

import java.io.File;
import java.io.IOException;

public class createDatabase {

	String store = "databases/";
	DatabaseRecord databaseRecord = new DatabaseRecord();
	EventFailRecord eventFailRecord = new EventFailRecord();
	ExistRecord existRecord = new ExistRecord();

	public void createDatabases(String query) throws IOException {

		String[] splitQuery = query.replace(";", "").split(" ");
		System.out.println(splitQuery.length);
		if (splitQuery.length == 3) {
			if (splitQuery[0].toLowerCase().equals("create") && splitQuery[1].toLowerCase().equals("database")) {
				checkDatabaseExists(splitQuery[2]);
			}
		}
	}

	private void checkDatabaseExists(String dbName) throws IOException {
		System.out.println(dbName);
		store = store + dbName;
		File createFolder = new File(store);
		long startTime = System.nanoTime();
		if (createFolder.exists()) {
			System.out.println("The schema already exists");
			long endTime = System.nanoTime();
			long timeElapsed = endTime - startTime;
			existRecord.event(dbName, timeElapsed);
		} else if (!createFolder.exists()) {
			createFolder.mkdir();
			System.out.println("The schema has been created");
			long endTime = System.nanoTime();
			long timeElapsed = endTime - startTime;
			databaseRecord.event(dbName, timeElapsed);
		} else {
			long endTime = System.nanoTime();
			long timeElapsed = endTime - startTime;
			eventFailRecord.event(dbName, timeElapsed);
		}
	}

}