package logs;

import java.io.FileWriter;
import java.io.IOException;

public class QueryRecord implements EventLogger{

  @Override
  public void event(String name, long timeELapsed) throws IOException {
    System.out.println("Query executed successfully!");

    FileWriter fileWriter = new FileWriter("databases/Yashvi/" + name + ".txt", true);
    fileWriter.write(name + "Already exists!" + " " + "Executed in " + timeELapsed / 1000000 + "ms");
  }

}
