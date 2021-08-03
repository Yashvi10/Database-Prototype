package user;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import Resources.Database;
import Resources.regex;
import parser.CreateTable;
import parser.UpdateQueryValidity;
import parser.createDatabase;
import parser.selectExecutioner;
import parser.syntaxValidation;

/**
 * @author Deeksha Sareen
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
		
		if (Token[1].toLowerCase().equals("database")) {
			if (syntax.validateQuerySyntax(query, regex.CREATEDB)) {
				createDatabase create = new createDatabase();
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
					System.out.println("The schema doesn't exist");
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
				System.out.println("No database selected");
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
				System.out.println("No database selected");
			}
		}
		if (Token[0].toLowerCase().equals("update")) {
			if (Database.getDatabase() != null) {
				UpdateQueryValidity update = new UpdateQueryValidity();
				update.updateQuery(query);
			} else {
				System.out.println("No database selected");
			}
		}
		if (Token[0].toLowerCase().equals("delete")) {
			if (Database.getDatabase() != null) {
				// do stuff
			} else {
				System.out.println("No database selected");
			}
		}
		if (query.toLowerCase().equals("exit")) {
			System.exit(0);
		}

	}

}
