package user;

import parser.*;
import tables.CreateDatabase;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		System.out.println("Please Enter the query for parsing:");
		Scanner scanner = new Scanner(System.in);
		String query = scanner.nextLine();
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
				break;

			case "delete":
				deletequeryValidity delete = new deletequeryValidity();
				deletequeryParser dparser = new deletequeryParser();
				System.out.println("Delete query parser: "+dparser.parsingAttributes((query).toLowerCase()));
				break;



		}
	}

}
