package parser;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class UpdateQueryValidity {

  String store = "databases/";

  public void updateQuery(String query) throws FileNotFoundException {
    System.out.println("in update");
    String[] splitQuery = query.toLowerCase().split(" ");
    System.out.println(Arrays.toString(splitQuery));
    if (splitQuery.length == 6) {
      if (splitQuery[0].equals("update") && splitQuery[2].equals("set") && splitQuery[4].equals("where")) {
        String[] getDbValue = splitQuery[1].split("\\.");
        System.out.println(getDbValue.length);
        if (getDbValue.length == 2) {
          checkDbAndTableExists(getDbValue[0], getDbValue[1], splitQuery[3], splitQuery[5]);
        } else {
          System.out.println("Syntax Error: The schema name or the table name is not present");
        }
      } else {
        System.out.println("Syntax Error");
        System.out.println("The expected format is... UPDATE <TABLENAME> SET <COL1=VAL1>WHERE <CONDITION>;");
      }
    }
  }

  private void checkColumnExists(String col1, String col2, File f) throws FileNotFoundException {

    try {
      BufferedReader br = null;
      System.out.println("hii");
      File file = new File(f.getPath());
      br = new BufferedReader(new FileReader(file));
      String line = null;
      String[] rows = new String[100];
      String[] remainingRows = new String[100];
      Scanner sc = new Scanner(file);
      sc.useDelimiter("\\Z");
      line = sc.next();

      //System.out.println(line);
      String updateParts[] = line.split("\\r?\\n");
      //System.out.println("update" + Arrays.toString(updateParts));
      int i = 0;
      int c = 0;
      for (String word : updateParts) {
        String[] temp = word.split(",");
        //System.out.println("temp:"+Arrays.toString(updateParts));
        String tempstr = temp[0] + "," + temp[1] + "," + temp[2];
        //System.out.println("tempstr:"+tempstr);
        if (tempstr.contains(col2)) {
          rows[i] = tempstr;
        } else {
          remainingRows[c] = tempstr;
          //System.out.println("rem:" + remainingRows[c]);
          c++;
        }
      }
      String[] splitCol = col1.split("=");
      for (int x = 0; x <= i; x++) {
        String[] tempArr = rows[x].split(",");
        //System.out.println("tempARR" + tempArr);
        String str = null;
        for (int y = 0; y < tempArr.length; y++) {
          if (tempArr[y].contains(splitCol[0])) {
            str = tempArr[y];
            //System.out.println("str" + str);
          }
        }
        if (rows[x].contains(splitCol[0])) {
          rows[x] = rows[x].replace(str, col1);
          // System.out.println("rowsodx"+rows[x]);
        }
      }

      FileWriter myWriter = new FileWriter(file, true);
      myWriter.write(rows[0] + "\n");
      //System.out.println("rows:"+rows[0]);
      for (int s = 0; s < updateParts.length - 1; s++) {

        myWriter.write(remainingRows[s] + "\n");
        //System.out.println(("remmmaining"+" "+remainingRows[s]));
      }

      myWriter.close();


    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void checkDbAndTableExists(String folder, String table, String column1, String column2) throws FileNotFoundException {
    //System.out.println("in check" + folder);
    store = store + folder;
    boolean t;
    File createFolder = new File(store);
    if (createFolder.exists()) {
      System.out.println("The schema is selected");
      store = store + "/" + table + ".txt";
      File tableFile = new File(store);
      if (tableFile.exists()) {
        checkColumnExists(column1, column2, tableFile);
      }
    } else {
      System.out.println("The schema doesn't exists");
    }

  }
}
