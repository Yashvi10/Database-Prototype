/**
 * 
 */
package parser;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author HP
 *
 */
//boolean is_correct =queryParser.getQueryDetails("CREATE TABLE remote.db1.student (id INT PRIMARY KEY,name VARCHAR(100),last_name VARCHAR(100) FOREIGN KEY REFERENCES T1(last_name);");

public class createParser {
  
  
  String createRegex = "(?i)(CREATE\\\\sTABLE\\\\s(\\\\w+)\\\\s?\\\\(((?:\\\\s?\\\\w+\\\\s\\\\w+\\\\(?[0-9]*\\\\)?,?)+)\\\\)\\\\s?;)";
  String table_name, columns, only_table;
  
  public Boolean checkSyntax(String statement) {
      Pattern re = Pattern.compile(createRegex);
      Matcher matcher = re.matcher(statement);
      while (matcher.find()) {
          table_name = matcher.group(1);
          columns = matcher.group(2);
      }
      return matcher.matches();
  }
      public Map<String, List<String>> getTokens() {
          Map<String, List<String>> tokens = new HashMap<>();
       
          List<String> columns_seperated = Arrays.asList(columns.split(","));
          List<String> column_name_list = new ArrayList<>();
          List<String> column_type_list = new ArrayList<>();

          int i=0;
          for(String columns : columns_seperated){
              List<String> columns_parts = Arrays.asList(columns.trim().split(" "));

              if(columns_parts.size()>2){
                  if(columns.contains("FOREIGN")){
                      List<String> foreign_key = new ArrayList<>();
                      foreign_key.add(only_table);
                      String foreign_table = columns_parts.get(5);
                      List<String> foreign_table_list = Arrays.asList(foreign_table.split("\\("));
                      foreign_key.add(foreign_table_list.get(0));
                      foreign_key.add(columns_parts.get(0));
                      tokens.put("foreign_key", foreign_key);

                      column_name_list.add(columns_parts.get(0).trim());
                      column_type_list.add(columns_parts.get(1).trim());
                  }else {
                      column_name_list.add(columns_parts.get(0).trim());
                      column_type_list.add(columns_parts.get(1).trim() + "PK");
                  }
              }else{
                  column_name_list.add(columns_parts.get(0).trim());
                  column_type_list.add(columns_parts.get(1).trim());
              }
          }
          tokens.put("column_name", column_name_list);
          tokens.put("column_type", column_type_list);
          return tokens;
      }

  }
  



