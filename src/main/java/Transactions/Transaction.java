package Transactions;

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

//    for(int i = 0;i<list.size();i++) {
//      selectExecutioner se = new selectExecutioner();
//      String[] value = list.get(i).split(" ");
//      se.executeSelect(value[0]);
//    }
  }

  public static void main(String[] args) throws IOException {
    Transaction transaction = new Transaction();
    transaction.transactionProcess();
  }


}
