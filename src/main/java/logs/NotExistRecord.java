package logs;

import java.io.FileWriter;
import java.io.IOException;

public class NotExistRecord implements EventLogger{

  @Override
  public void event(String name, long timeELapsed) throws IOException {

    FileWriter fileWriter = new FileWriter("databases/EventLogs/log.txt", true);
    fileWriter.write(name + "\tSchema does not exist!" + " " + "Executed in " + timeELapsed / 1000000 + "ms"+"\n");
    fileWriter.close();
  }

}
