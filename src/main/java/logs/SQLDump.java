package logs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SQLDump {

  File path;

  public SQLDump() throws IOException {
  }

  public void SQLDumpGeneration(String location){

    path = new File("databases/Yashvi/");
  }

  File[] filesList = path.listFiles();
  List<String> fileNames = new ArrayList<>();
  String brRead = "";
  String split = "\n";
  BufferedReader bufferedReader = null;
  FileWriter fileWriter = new FileWriter("LogAndDumpFiles/SQLDump/dump.txt");

}
