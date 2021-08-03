package logs;

import java.io.FileWriter;
import java.io.IOException;

/**
 * File: QueryError.java
 *
 * @author Yashvi Lad
 * Purpose & Description: This java file generates event log.
 */
public class QueryError implements EventLogger {

  /*
   * This method writes events logs into text file with execution time and message
   * */
  @Override
  public void event(String name, long timeELapsed) throws IOException {
    FileWriter fileWriter = new FileWriter("LogAndDumpFiles/EventLogs/log.txt", true);
    fileWriter.write(name + "\tIncorrect Query!" + " " + "Executed in " + timeELapsed / 1000000 + "ms" + "\n");
    fileWriter.close();
  }

}
