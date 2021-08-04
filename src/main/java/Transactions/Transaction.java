package Transactions;

import parser.selectExecutioner;
import user.application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Transaction {

  public void transactionProcess() throws IOException {

    Scanner scanner = new Scanner(System.in);
    List<String> list = new ArrayList<>();
    System.out.println("Start Transaction");
    while(true){
      String str=scanner.next();
      if(str.equals("commit")) {
        break;
      }
      list.add(str);
    }

    System.out.println(list);
    for(int i = 0;i<list.size();i++) {
      application app = new application();
      String[] value = list.get(i).split(" ");
//      app.Application();
    }
  }


}
