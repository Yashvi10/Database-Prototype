package logs;

import java.io.FileWriter;
import java.io.IOException;

public class EventFailRecord implements EventLogger{

  @Override
  public void event(String name, long timeELapsed) throws IOException {
    System.out.println("System not responding!");

    FileWriter fileWriter = new FileWriter("LogAndDumpFiles/EventLogs/log.txt", true);
    fileWriter.write("System not responding!" + " " + "Executed in " + timeELapsed / 1000000 + "ms"+"\n");
    fileWriter.close();
  }

}
