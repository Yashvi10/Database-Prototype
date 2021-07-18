package tables;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class createDatabaseAndTables {

  public void createDbOrTable() throws IOException {
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
        if (!createFolder.exists()) {
          createFolder.mkdir();
          System.out.println("The folder is created");
        } else {
          System.out.println("The schema already exists");
        }
        break;
      case 2:
        System.out.println("Enter the name of schema");
        String schema = scanner.next();
        store = "databases/" + schema;
        File checkFolder = new File(store);
        if (!checkFolder.exists()) {
          System.out.println("The schema doesnt exist");
        } else {
          System.out.println("Enter the name of table");
          String createTable = scanner.next();
          store = store + "/" + createTable + ".txt";
          System.out.println(store);
          File tableFile = new File(store);
          if (tableFile.exists()) {
            System.out.println("The table already exists");
          } else {
            tableFile.createNewFile();
            System.out.println("The table has been created");
          }
        }

        break;
      case 3:
        break;

      }

    }
  }

  public static void main(String[] args) throws IOException {
    createDatabaseAndTables create = new createDatabaseAndTables();
    create.createDbOrTable();
  }
}
