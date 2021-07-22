/**
 * @author Deeksha Sareen
 * This class is reponsible for parsing the SQL query
 */
package parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class queryParser {

  public static Map<String, ArrayList<String>> parsingAttributes(String query) {
    String[] splitQuery = query.split(" ");
    String Attributes = "";
    String conditions = "";
    Map<String, ArrayList<String>> mapping = new HashMap<String, ArrayList<String>>();
    if (splitQuery[0].compareToIgnoreCase("SELECT") == 0) {
      queryValidity valid = new queryValidity();
      if (valid.validateSelect(query) == true) {
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

      } else if (valid.validateSelect(query) == false) {
        System.out.println("Invalid syntax. Please check the SQL user manual for query sytax");
      }
    }
    identifier obj = new identifier();
    obj.identifyTableSelect(mapping);
    return mapping;
  }

}
