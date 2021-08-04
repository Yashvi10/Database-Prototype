package parser;

import Resources.Database;

import java.io.File;

public class dropTable {
  Database queryToken = new Database();
  public void dropTableName(String query) {

    if (dropSyntax(query)) {
      System.out.println("drop successful");
    }

  }

  private boolean dropSyntax(String query) {
    String[] getTable = query.split("table");
    String tableName = getTable[1];
    if(checkIfTableExists(tableName)){
      drop();
    }
    return false;
  }

  private void drop() {
    System.out.println(queryToken.getPath());
    File file = new File(queryToken.getPath());
    if(file.delete())
    {
      System.out.println("table deleted successfully");
    }
    else
    {
      System.out.println("Failed to delete the table");
    }
  }

  private boolean checkIfTableExists(String tableName) {
    String dbName = Database.getDatabase();
    String path = dbName + "/" + tableName.trim() + ".txt";
    File tableFile = new File(path.trim());
    if (tableFile.exists()) {
      queryToken.setPath(path);
      return true;
    }
    return false;
  }
}
