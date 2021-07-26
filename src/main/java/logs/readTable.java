package logs;

import java.io.*;

public class readTable {

    private static FileWriter log = null;
    private static boolean fileOut = true;

//    public static void println(String output) {
//      print(output+"\n");
//    }

    public static void print(String output) {
      if (fileOut) {

        File file = new File("src/main/java/logs/log.txt");
        try {

          ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(file));

//          System.out.println(output);
          objectOut.writeObject(output);

          objectOut.flush();
          objectOut.close();

        } catch (IOException e) {
          e.printStackTrace();
        }
      } else {
        System.out.print(output);
      }
    }
//    public static void setConsoleOut() {
//      fileOut = false;
//    }
}

