/**
 * 
 */
package user;

import java.io.IOException;
import java.util.Scanner;

import parser.CreateTable;
import parser.UpdateQueryValidity;
import parser.deletequeryParser;
import parser.deletequeryValidity;
import parser.queryParser;
import tables.CreateDatabase;

public class application {

  public void Application() throws IOException {
 
    System.out.println("Please Enter the query for parsing:");
    Scanner scanner = new Scanner(System.in);
    String query = scanner.nextLine();
    String[] queryToken = query.split(" ");
    System.out.println(queryToken[1].toLowerCase());

    switch (queryToken[0].toLowerCase()){
        case "select":
            queryParser parser = new queryParser();
            parser.parsingAttributes((query).toLowerCase());
            break;

        case "update":
            System.out.println("in update");
            UpdateQueryValidity update = new UpdateQueryValidity();
            update.updateQuery(query);
      
            break;

        case "create":
            if(queryToken[1].toLowerCase().equals("database")){
                System.out.println("in create");
                CreateDatabase create = new CreateDatabase();
                create.createDatabases(query);
            }
            if(queryToken[1].toLowerCase().equals("table")){
              System.out.println("in create");
              CreateTable create = new CreateTable(query);
              create.tableCreationCheck();
          }
            break;

        case "delete":
            deletequeryValidity delete = new deletequeryValidity();
            deletequeryParser dparser = new deletequeryParser();
            System.out.println("Delete query parser: "+dparser.parsingAttributes((query).toLowerCase()));
            break;



    }
  }

}
