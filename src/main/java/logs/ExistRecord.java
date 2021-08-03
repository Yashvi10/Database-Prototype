package logs;

import java.io.FileWriter;
import java.io.IOException;

/**
 * File: ExistRecord.java
 *
 * @author Yashvi Lad
 * Purpose & Description: This java file generates event log.
 */
public class ExistRecord implements EventLogger {

  /*
   * This method writes events logs into text file with execution time and message
   * */
  @Override
  public void event(String name, long timeELapsed) throws IOException {

    FileWriter fileWriter = new FileWriter("LogAndDumpFiles/EventLogs/log.txt", true);
    fileWriter.write(name + "\tAlready exists!" + " " + "Executed in " + timeELapsed / 1000000 + "ms" + "\n");
    fileWriter.close();
  }

}
