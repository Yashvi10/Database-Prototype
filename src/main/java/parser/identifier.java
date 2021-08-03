/**
 * 
 */
package parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author Deeksha Sareen
 *
 */
public class identifier {
  public boolean identifyTableSelect(Map<String, ArrayList<String>> mapping) {

    ArrayList<String> attributes = mapping.get("Attributes");
    ArrayList<String> tablename = mapping.get("From");
    ArrayList<String> wherevalues = mapping.get("Where");
    String where = "";
    for (String a : wherevalues) {
      where += a + " ";
    }
    if (where.contains("and")) {
      String[] values = where.trim().split(" and ");
      if (attributes.contains("*")) {
        File file = new File("databases/test/" + tablename.get(0) + ".txt");
        if (!file.exists()) {
          System.out.println("Table does not exist");
          return false;
        } else {
          try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
              for (String a : values) {
                if (line.indexOf(a) != -1) {

                  System.out.println(line);
                }
              }

            }
          } catch (IOException e) {
            e.printStackTrace();
          }
        }

      }
    }
    else {
      if (attributes.contains("*")) {
        File file = new File("databases/test/" + tablename.get(0) + ".txt");
        if (!file.exists()) {
          System.out.println("Table does not exist");
          return false;
        } else {
          try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
              System.out.println(where);
                if (line.indexOf(where) != -1) {
                   
                  System.out.println(line);
                }
              

            }
          } catch (IOException e) {
            e.printStackTrace();
          }
        }

      }
    }

    return true;

  }
}
