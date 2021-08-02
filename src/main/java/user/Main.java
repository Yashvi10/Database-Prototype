package user;
import parser.CreateTable;
import parser.queryParser;
import parser.queryValidity;

import java.io.IOException;

import logs.readTable;
import parser.*;
import tables.CreateDatabase;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		Menu menu = new Menu();
		menu.menu();

		readTable readTable = new readTable();

		System.out.println("Please Enter the query for parsing:");
		Scanner scanner = new Scanner(System.in);
		String query = scanner.nextLine();
		logs.readTable.print(query);
		String[] queryToken = query.split(" ");
		System.out.println(queryToken[1].toLowerCase());

		switch (queryToken[0].toLowerCase()){

			case "select":
				queryValidity obj = new queryValidity();
				queryParser parser = new queryParser();
				System.out.println("Select query parser: "+parser.parsingAttributes((query).toLowerCase()));
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
				DeleteValidity delete = new DeleteValidity();
				delete.deleteQuery(query);
				break;

		}
	}
}
