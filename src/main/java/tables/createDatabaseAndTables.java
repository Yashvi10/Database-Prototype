package tables;

import logs.DatabaseRecord;
import logs.ExistRecord;
import logs.NotExistRecord;
import logs.TableRecord;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class createDatabaseAndTables {

  public void createDbOrTable() throws IOException {

    DatabaseRecord databaseRecord = new DatabaseRecord();
    ExistRecord existRecord = new ExistRecord();
    NotExistRecord notExistRecord = new NotExistRecord();
    TableRecord tableRecord = new TableRecord();

    while (true) {
      String store = "databases/";
      System.out.println("Please select a number from 1 to 3");
      System.out.println("1. Create a new schema");
      System.out.println("2. Create a new Table");
      System.out.println("3. Exit");
      Scanner scanner = new Scanner(System.in);
      int choice = scanner.nextInt();

      switch (choice) {
        case 1:
          System.out.println("Enter the name of schema");
          String schemaName = scanner.next();
          store = store + schemaName;
          File createFolder = new File(store);
          long startTime = System.nanoTime();
          if (!createFolder.exists()) {
            createFolder.mkdir();
            System.out.println("The folder is created");
            long endTime = System.nanoTime();
            long timeElapsed = endTime - startTime;
            databaseRecord.event(schemaName,timeElapsed);
          } else {
            System.out.println("The schema already exists");
            long endTime = System.nanoTime();
            long timeElapsed = endTime - startTime;
            existRecord.event(schemaName,timeElapsed);
          }
          break;
        case 2:
          System.out.println("Enter the name of schema");
          String schema = scanner.next();
          store = "databases/" + schema;
          File checkFolder = new File(store);
          long startTime1 = System.nanoTime();
          if (!checkFolder.exists()) {
            System.out.println("The schema doesnt exist");
            long endTime = System.nanoTime();
            long timeElapsed = endTime - startTime1;
            notExistRecord.event(schema,timeElapsed);
          } else {
            System.out.println("Enter the name of table");
            String createTable = scanner.next();
            store = store + "/" + createTable + ".txt";
            System.out.println(store);
            File tableFile = new File(store);
            if (tableFile.exists()) {
              System.out.println("The table already exists");
              long endTime = System.nanoTime();
              long timeElapsed = endTime - startTime1;
              existRecord.event(createTable,timeElapsed);
            } else {
              tableFile.createNewFile();
              System.out.println("The table has been created");
              long endTime = System.nanoTime();
              long timeElapsed = endTime - startTime1;
              tableRecord.event(createTable,timeElapsed);
            }
          }
          break;

        case 3:
          System.exit(0);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    createDatabaseAndTables create = new createDatabaseAndTables();
    create.createDbOrTable();
  }
}
