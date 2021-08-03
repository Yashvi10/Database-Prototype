/**
 * 
 */
package user;

import java.io.File;
import java.io.IOException;
import Resources.Database;
import parser.CreateTable;
import parser.UpdateQueryValidity;
import parser.SelectParser;
import tables.CreateDatabase;

public class application {

  public void Application() throws IOException {
 
	  Common obj = new Common();
      String queryToken[] =  obj.takeinput();
	  if(!queryToken[0].equals("use") ) {
    	System.out.println("No database selected. Select a database first.");
    	Application();
    }
    if(queryToken[0].equals("use")) {
    	 
    	 String store = "databases/" + queryToken[1].replace(";", "");
         File checkFolder = new File(store);
         if (!checkFolder.exists()) {
           System.out.println("The schema doesn't exist");
         }
         else {
        	 Database.setDatabase(store);
        	 Database db = Database.instance();
        	 db.setDatabaseName(store);
         }
    }

    String queryToken2[] = obj.takeinput();
    String query = "";
    switch (queryToken[0].toLowerCase()){
        case "select":
            SelectParser parser = new SelectParser();
            parser.parsingAttributes(queryToken2);
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
//            deletequeryValidity delete = new deletequeryValidity();
//            deletequeryParser dparser = new deletequeryParser();
//            System.out.println("Delete query parser: "+dparser.parsingAttributes((query).toLowerCase()));
//            break;



    }
  }

}
