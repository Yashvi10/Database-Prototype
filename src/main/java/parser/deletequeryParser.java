package parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yashvi Lad
 * This class is reponsible for parsing the SQL delete query
 */

public class deletequeryParser {

  public static Map<String, ArrayList<String>> parsingAttributes(String query) {
    String[] splitQuery = query.split(" ");
    String Attributes = "";
    String conditions = "";
    Map<String, ArrayList<String>> mapping = new HashMap<String, ArrayList<String>>();
    if (splitQuery[0].compareToIgnoreCase("DELETE") == 0) {
      deletequeryValidity valid = new deletequeryValidity();
      if (valid.validateDelete(query) == true) {
        for (int word = 1; word < splitQuery.length; word++) {
          if (splitQuery[word].equalsIgnoreCase("FROM")) {
            ArrayList<String> from = new ArrayList<>();
            from.add(splitQuery[word + 1]);
            mapping.put("From", from);

            ArrayList<String> attr = new ArrayList<>();
            String[] attributes = Attributes.split("\\s");
            for (String a : attributes) {
              attr.add(a);
            }
            mapping.put("Attributes", attr);
            break;
          } else {
            Attributes = splitQuery[word] + " " + Attributes;
          }
        }
        if (query.indexOf("where") != -1) {
          String[] where = query.split("where");
          String[] whereClause = where[1].trim().split(" ");
          ArrayList<String> Clause = new ArrayList<>();
          for (String b : whereClause) {
            Clause.add(b);
          }
          mapping.put("Where", Clause);
        }

      } else if (valid.validateDelete(query) == false) {
        System.out.println("Invalid syntax for delete query. Please check the SQL user manual for query sytax");
      }
    }
    return mapping;
  }


}
