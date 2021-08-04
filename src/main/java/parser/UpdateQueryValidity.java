/**
 * @author Sai Vaishnavi Jupudi
 * This class is reponsible for checking the validity/ syntax of the SQL update query
 *
 */
package parser;

import logs.NotExistRecord;
import logs.QueryError;
import logs.QueryRecord;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class UpdateQueryValidity {

  String store = "databases/";
  QueryRecord queryRecord = new QueryRecord();
  NotExistRecord notExistRecord = new NotExistRecord();
  QueryError queryError = new QueryError();

  public void updateQuery(String query) throws IOException {
    System.out.println("in update");
    String[] splitQuery = query.toLowerCase().split(" ");
    System.out.println(Arrays.toString(splitQuery));
    long startTime = System.nanoTime();
    if (splitQuery.length == 6) {
      if (splitQuery[0].equals("update") && splitQuery[2].equals("set") && splitQuery[4].equals("where")) {
        String[] getDbValue = splitQuery[1].split("\\.");
        System.out.println(getDbValue.length);
        if (getDbValue.length == 2) {
          checkDbAndTableExists(getDbValue[0], getDbValue[1], splitQuery[3], splitQuery[5]);
        } else {
          System.out.println("Syntax Error: The schema name or the table name is not present");
          long endTime = System.nanoTime();
          long timeElapsed = endTime - startTime;
          notExistRecord.event("Syntax error",timeElapsed);
        }
      } else {
        System.out.println("Syntax Error");
        System.out.println("The expected format is... UPDATE <TABLENAME> SET <COL1=VAL1>WHERE <CONDITION>;");
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        queryError.event("Syntax error", timeElapsed);
      }
    }
  }

  private void checkColumnExists(String col1, String col2, File f) throws FileNotFoundException {

    try {
      File file = new File(f.getPath());
      String line = null;
      String[] rows = new String[100];
      String[] remainingRows = new String[100];
      Scanner sc = new Scanner(file);
      sc.useDelimiter("\\Z");
      line = sc.next();

      String updateParts[] = line.split("\\r?\\n");
      int i = 0;
      int c = 0;
      for (String word : updateParts) {
        String[] temp = word.split(",");
        String tempstr = temp[0] + "," + temp[1] + "," + temp[2];
        if (tempstr.contains(col2)) {
          rows[i] = tempstr;
        } else {
          remainingRows[c] = tempstr;
          c++;
        }
      }
      String[] splitCol = col1.split("=");
      for (int x = 0; x <= i; x++) {
        String[] tempArr = rows[x].split(",");
        String str = null;
        for (int y = 0; y < tempArr.length; y++) {
          if (tempArr[y].contains(splitCol[0])) {
            str = tempArr[y];
          }
        }
        if (rows[x].contains(splitCol[0])) {
          rows[x] = rows[x].replace(str, col1);
        }
      }

      FileWriter myWriter = new FileWriter(file);
      myWriter.write(rows[0] + "\n");
      for (int s = 0; s < updateParts.length - 1; s++) {
        myWriter.write(remainingRows[s] + "\n");
      }
      myWriter.close();

    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void checkDbAndTableExists(String folder, String table, String column1, String column2) throws IOException {
    store = store + folder;
    boolean t;
    File createFolder = new File(store);
    if (createFolder.exists()) {
      System.out.println("The schema is selected");
      store = store + "/" + table + ".txt";
      File tableFile = new File(store);
      long startTime = System.nanoTime();
      if (tableFile.exists()) {
        checkColumnExists(column1, column2, tableFile);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        queryRecord.event(tableFile.toString(),timeElapsed);
      }
    } else {
      long startTime = System.nanoTime();
      System.out.println("The schema doesn't exists");
      long endTime = System.nanoTime();
      long timeElapsed = endTime - startTime;
      notExistRecord.event("Schema",timeElapsed);
    }
  }
}
