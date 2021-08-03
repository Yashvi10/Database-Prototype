package logs;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * File: SQLDump.java
 *
 * @author Yashvi Lad
 * Purpose & Description: This java file contains logic of generating SQL Dumps
 */
public class SQLDump {

  File path;

  /*
   * This method gets files from the given path, reads its content and
   * writes into a text file to form its dump.
   * */
  public void SQLDumpGeneration() throws IOException {

    path = new File("databases/Yashvi/");
    GeneralLogRecord generalLogRecord = new GeneralLogRecord();

    File[] filesList = path.listFiles();
    List<String> fileNames = new ArrayList<>();
    String brRead = "";
    BufferedReader bufferedReader = null;
    FileWriter fileWriter = new FileWriter("LogAndDumpFiles/SQLDump/dump.txt");
    List<String> storeTableValues;
    String value = "";

    //loop that rotates through the list of files and adds it into list
    for (int i = 0; i < filesList.length; i++) {
      if (filesList[i].isFile()) {
        fileNames.add(filesList[i].getName());
      }
    }

    //loop that rotates through a file content and values are added into list
    for (int j = 0; j < fileNames.size(); j++) {
      storeTableValues = new ArrayList<>();
      bufferedReader = new BufferedReader(new FileReader(path + "/" + fileNames.get(j)));
      while ((brRead = bufferedReader.readLine()) != null) {
        String[] fileValues = brRead.split("\n");
        storeTableValues.add(fileValues[0]);
      }
      value = value + fileNames.get(j) + "\n";
      for (int k = 0; k < storeTableValues.size(); k++) {
        value = value + storeTableValues.get(k) + "\n";
      }
      value = value + "\n";
    }
    fileWriter.append(value + "\n");
    fileWriter.close();
    generalLogRecord.generalLog();
  }

}
