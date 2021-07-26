package parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yashvi Lad
 * This class is reponsible for parsing the SQL delete query
 */

public class deletequeryParser {

  static ArrayList<String> attr = new ArrayList<>();
  static ArrayList<String> from = new ArrayList<>();

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
            from.add(splitQuery[word + 1]);
            mapping.put("From", from);

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
//            System.out.println("clause: " +Clause);
          }
          mapping.put("Where", Clause);
          System.out.println("where1: " +mapping);
          if(mapping.containsValue(Clause)) {
//            System.out.println("contains: " +mapping.containsValue(Clause) );
            mapping.remove(attr);
            mapping.remove(from);
            mapping.remove(Clause);
          }
          System.out.println("where2: " +mapping);
        }

      } else if (valid.validateDelete(query) == false) {
        System.out.println("Invalid syntax for delete query. Please check the SQL user manual for query syntax");
      }
    }
    return mapping;
  }


}
