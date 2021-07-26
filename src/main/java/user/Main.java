package user;

import parser.CreateTable;
import parser.createParser;
import parser.deletequeryParser;
import parser.deletequeryValidity;
import parser.queryParser;
import parser.queryValidity;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
	  
//		queryValidity obj = new queryValidity();
//		String query1 = "Select * from users where id = 1";
//		String query2 = "Select * from Deeksha";
//		String query3 = "Select from Deeksha";
//		String query4 = "Select * from Deeksha where id = 1 and id = 2";
//		String query5 = "Select * from Deeksha where";
//		queryParser parser = new queryParser();
//
//	    System.out.println("Select query parser: "+parser.parsingAttributes((query5).toLowerCase()));
//
//		deletequeryValidity delete = new deletequeryValidity();
//
//		String dquery1 = "delete * from users where id = 7";
//		String dquery2 = "delete * from Yashvi";
//		String dquery3 = "delete from Yashvi";
//		String dquery4 = "delete * from Yashvi where id = 1 and id = 2";
//		String dquery5 = "delete * from Yashvi where";
//
//		deletequeryParser dparser = new deletequeryParser();
//        
//		System.out.println("Delete query parser: "+dparser.parsingAttributes((dquery2).toLowerCase()));
//
//    System.out.println(parser.parsingAttributes((query4).toLowerCase()));
    String query= "CREATE TABLE student (id INT PRIMARY KEY,name VARCHAR(100),last_name VARCHAR(100) FOREIGN KEY REFERENCES T1(last_name);";
   // Matcher createTableSQL = CREATE_TABLE_PATTERN.matcher(query);
    
    CreateTable obj = new CreateTable(query);
    obj.tableCreationCheck();
  }

}
