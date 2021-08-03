package logs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class GeneralLogRecord {

  public void generalLog() throws IOException {

    FileWriter fileWriter = new FileWriter("LogAndDumpFiles/GeneralLogs/dumpLogs.txt",true);
    LocalDateTime localDateTime = LocalDateTime.now();

    try {
        if(fileWriter != null) {
          fileWriter.append("**********SQL Dump Generated Successfully**********" + "\t" + localDateTime + "\n");
        }
        fileWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
