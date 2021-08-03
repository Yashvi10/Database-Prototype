package logs;

import java.io.FileWriter;
import java.io.IOException;

public class DatabaseRecord implements EventLogger{

  @Override
  public void event(String name, long timeELapsed) throws IOException {

    FileWriter fileWriter = new FileWriter("LogAndDumpFiles/EventLogs/log.txt", true);
    fileWriter.write(name + "\tDatabase Created Successfully!" + "\tExecuted in " + timeELapsed / 1000000 + "ms" + "\n");
    fileWriter.close();
  }

}
