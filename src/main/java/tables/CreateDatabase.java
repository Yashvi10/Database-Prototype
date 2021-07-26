/**
 * @author Sai Vaishnavi Jupudi
 * This class is reponsible for checking the validity/ syntax of the creating database
 *
 */
package tables;

import java.io.File;

public class CreateDatabase {

  String store = "databases/";

  public void createDatabases(String query) {
    String[] splitQuery = query.toLowerCase().split(" ");
    System.out.println(splitQuery.length);
    if (splitQuery.length == 3) {
      if (splitQuery[0].equals("create") && splitQuery[1].equals("database")) {
        checkDatabaseExists(splitQuery[2]);
      }
    }
  }

  private void checkDatabaseExists(String dbName) {
    System.out.println(dbName);
    store = store + dbName;
    File createFolder = new File(store);
    if (createFolder.exists()) {
      System.out.println("The schema already exists");
    }else{
      createFolder.mkdir();
      System.out.println("The schema has been created");
    }
  }

}
