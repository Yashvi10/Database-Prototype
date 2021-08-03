package user;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import Resources.Database;
import Resources.regex;
import parser.CreateTable;
import parser.UpdateQueryValidity;
import parser.selectExecutioner;
import parser.syntaxValidation;
import tables.CreateDatabase;

/**
 * @author Deeksha Sareen
 *
 */
public class application {

	syntaxValidation syntax = new syntaxValidation();

	public void Application() throws IOException {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter Query for Processing");
		String query = input.nextLine();
		String[] Token = query.split(" ");
		String[] queryToken = null;
		if (Token[0].toLowerCase().equals("use")) {
			if (syntax.validateQuerySyntax(query, regex.DATABASE)) {
				String dbName = Token[1].substring(0, Token[1].length() - 1);
				String store = "databases/" + dbName;
				File checkFolder = new File(store);
				if (!checkFolder.exists()) {
					System.out.println("The schema doesn't exist");
				} else {
					Database.setDatabase(store);
					Database db = Database.instance();
					db.setDatabaseName(store);
					System.out.println("Enter Query for Processing");
					query = input.nextLine();
					queryToken = query.split(" ");
				}

			} else {
				System.out.println("Syntax Error");
				System.out.println("The expected format is... USE <DATABASENAME>;");
			}
		}
		if (queryToken != null) {
			switch (queryToken[0].toLowerCase()) {

			case "select":
				if (syntax.validateQuerySyntax(query, regex.SELECT)) {
					selectExecutioner exec = new selectExecutioner();
					exec.executeSelect(query);
				} else {
					System.out.println("Syntax Error");
					System.out.println(
							"The expected format is... SELECT * FROM <TABLENAME> or SELECT <COL1,COL2..COLN> FROM TABLENAME;");
				}
				break;

			case "update":
				UpdateQueryValidity update = new UpdateQueryValidity();
				update.updateQuery(query);

				break;

			case "create":
				if (queryToken[1].toLowerCase().equals("database")) {
					System.out.println("in create");
					CreateDatabase create = new CreateDatabase();
					create.createDatabases(query);
				}
				if (queryToken[1].toLowerCase().equals("table")) {
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
		} else {
			System.out.println("No database selected");
		}

	}

}
