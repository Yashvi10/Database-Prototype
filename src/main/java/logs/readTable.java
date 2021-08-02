package logs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class readTable {

  private static FileWriter log = null;
  private static boolean fileOut = true;

  public static void print(String output) {
    LocalDateTime localDateTime = LocalDateTime.now();
    if (fileOut) {

      String path = "src/main/java/logs/log.txt";
      File file = new File(path);
      try {

        FileWriter fileWriter = new FileWriter(file,true);

        fileWriter.write(output + " " +localDateTime + "\n") ;

        fileWriter.flush();
        fileWriter.close();

      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      System.out.print(output);
    }
  }
}

