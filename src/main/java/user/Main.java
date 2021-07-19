package user;

import parser.queryParser;
import parser.queryValidity;

public class Main {

	public static void main(String[] args) {
		queryValidity obj = new queryValidity();
		String query1 = "Select * from users where id = 1";
		String query2 = "Select * from Deeksha";
		String query3 = "Select from Deeksha";
		String query4 = "Select * from Deeksha where id = 1 and id = 2";
		String query5 = "Select * from Deeksha where";
		queryParser parser = new queryParser();
		 
	    System.out.println(parser.parsingAttributes((query5).toLowerCase()));

	}

}
