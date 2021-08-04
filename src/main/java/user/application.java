package user;

import java.io.File;
import java.io.IOException;
import Resources.Database;
import Resources.regex;
import parser.*;

/**
 * @author Deeksha Sareen: This class is responsible for executing the queries
 *         according to the type entered
 *
 */
public class application {

	syntaxValidation syntax = new syntaxValidation();

	public void Application(String query) throws IOException {

		if (query.toLowerCase().equals("exit")) {
			System.exit(0);
		}
		logs.readTable.print(query);
		String[] Token = query.split(" ");

		if (Token[0].toLowerCase().equals("create") && Token[1].toLowerCase().equals("database")) {
			if (syntax.validateQuerySyntax(query, regex.CREATEDB)) {
				createDatabase create = new createDatabase();
				create.createDatabases(query);
			} else {
				System.err.println("Syntax Error");
				System.err.println("The expected format is... CREATE DATABASE <DATABASENAME>;");
			}

		}
		if (Token[0].toLowerCase().equals("use")) {
			if (syntax.validateQuerySyntax(query, regex.DATABASE)) {
				String dbName = Token[1].substring(0, Token[1].length() - 1);
				String store = "databases/" + dbName;
				File checkFolder = new File(store);
				if (!checkFolder.exists()) {
					System.err.println("The schema doesn't exist");
				} else {
					Database.setDatabase(store);
					Database db = Database.instance();
					db.setDatabaseName(store);
					logs.readTable.print(query);
				}

			} else {
				System.err.println("Syntax Error");
				System.err.println("The expected format is... USE <DATABASENAME>;");
			}

		}
		if (Token[0].toLowerCase().equals("select")) {
			if (Database.getDatabase() != null) {
				if (syntax.validateQuerySyntax(query, regex.SELECT)) {
					selectExecutioner exec = new selectExecutioner();
					exec.executeSelect(query);
				} else {
					System.err.println("Syntax Error");
					System.err.println(
							"The expected format is... SELECT * FROM <TABLENAME> or SELECT <COL1,COL2..COLN> FROM TABLENAME;");
				}
			} else {
				System.err.println("No database selected");
			}
		}
		if (Token[0].toLowerCase().equals("create") && Token[1].toLowerCase().equals("table")) {
			if (Database.getDatabase() != null) {

				if (syntax.validateQuerySyntax(query.toLowerCase(), regex.CREATETABLE)) {
					CreateTable create = new CreateTable();
					create.createTable(query);
				} else {
					System.err.println("Syntax Error");
					System.err.println(
							"The expected format is... CREATE TABLE <TABLENAME>(COLUMN1 <INT|VARCHAR(digit)>, COLUMN2 <INT|VARCHAR(digit)>);");
				}

			} else {
				System.err.println("No database selected");
			}
		}
		if (Token[0].toLowerCase().equals("update")) {
			if (Database.getDatabase() != null) {
				updateValidate up = new updateValidate();
				up.update(query);
			} else {
				System.err.println("No database selected");
			}
		}
		if (Token[0].toLowerCase().equals("delete")) {
			if (Database.getDatabase() != null) {
				deleteValidate delete = new deleteValidate();
				delete.deleteSyntax(query);
			} else {
				System.err.println("No database selected");
			}
		}
		if (query.toLowerCase().equals("exit")) {
			System.exit(0);
		}

	}

}
