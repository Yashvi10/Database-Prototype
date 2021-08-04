package parser;

import logs.ExistRecord;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class DeleteValidity {

  String store = "databases/";
  boolean t = false;
  public void deleteQuery(String query) throws IOException {

    System.out.println(query);
    String[] splitDeleteQuery = query.toLowerCase().split(" ");
    System.out.println(Arrays.toString(splitDeleteQuery));
    if (splitDeleteQuery[0].equals("delete") && splitDeleteQuery[1].equals("from")){
      checkTableExists(splitDeleteQuery[2]);
    }else{
      System.out.println("Syntaxx Error");
    }
    if(splitDeleteQuery.length == 3){
      if(checkTableExists(splitDeleteQuery[2])){
        performDeleteOperation(splitDeleteQuery[2]);
      }
    }
    else if(splitDeleteQuery.length == 5){
      if(checkTableExists(splitDeleteQuery[2])){
        if(splitDeleteQuery[3].equals("where")){
          performDeleteRowOperation(splitDeleteQuery[2],splitDeleteQuery[4]);
        }
      }
    }else{
      System.out.println("Syntax Error");
      System.out.println("The expected format is... Delete From database.TABLENAME WHERE <CONDITION>");
    }
  }

  private void performDeleteRowOperation(String tableName,String condition) throws IOException {
    String[] getFilePath = tableName.split("\\.");
    String path = "databases/" + getFilePath[0] + "/" + getFilePath[1] + ".txt";
    File file = new File(path);
    String line = null;
    String[] rows = new String[10];
    Scanner sc = new Scanner(file);
    sc.useDelimiter("\\Z");
    line = sc.next();
    String parts[] = line.split("\\r?\\n");
    int i = 0;
    for (String word : parts) {
      String[] temp = word.split(",");
      System.out.println("temp:"+Arrays.toString(temp));
      String tempstr = temp[0] + "," + temp[1] + "," + temp[2];
      System.out.println("tempstr:"+tempstr);
      if(!tempstr.contains(condition)){
        rows[i] = tempstr;
        i++;
      }
    }
    FileWriter myWriter = new FileWriter(file);
    for(int j=0; j<i;j++){
      System.out.println("rowsss:"+rows[j]);
      myWriter.write(rows[j] + "\n");
    }
    myWriter.close();
  }

  private boolean checkTableExists(String tableName) {
    String[] getDbValue = tableName.split("\\.");
    store = store + getDbValue[0];
    File createFolder = new File(store);
    if (createFolder.exists()) {
      store = store + "/" + getDbValue[1] + ".txt";
      File tableFile = new File(store);
      if (tableFile.exists()) {
        t = true;
      }else{
        t = false;
        System.out.println("The tablename doesnt exists ");
      }
    }
    return t;
  }

  private void performDeleteOperation(String str) throws IOException {
    String[] getFilePath = str.split("\\.");
    String path = "databases/" + getFilePath[0] + "/" + getFilePath[1] + ".txt";
    FileWriter deleteWriter = new FileWriter(path);
    deleteWriter.write( " ");
    deleteWriter.close();
  }
}
