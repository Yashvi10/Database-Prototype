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
    String query6 = "CREATE TABLE CUSTOMERS(ID INT NOT NULL,NAME VARCHAR (20)NOT NULL,AGE INT NOT NULL,ADDRESS CHAR (25),PRIMARY KEY (ID))";
    queryParser parser = new queryParser();

    System.out.println(parser.parsingAttributes((query4).toLowerCase()));

  }

}
