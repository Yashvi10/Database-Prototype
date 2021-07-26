package user;

import java.io.IOException;
import java.util.Scanner;

/**
 * File: Menu.java
 * @author Yashvi Lad
 * Purpose: It provides menu
 * Description: This class offers menu to user for login and register
 */
public class Menu
{
    public void menu() throws IOException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("================Relational Database Management System===============");
        System.out.println("Press 1 to login\nPress 2 to register\nPress 3 to exit");

        String userInput = scanner.nextLine();

        if(userInput.equals(" ") || userInput.isEmpty()) {
            System.exit(0);
        } else if(userInput.equals("1")){
            System.out.println("======Enter details to login======");
            login login = new login();
            login.login();
        } else if (userInput.equals("2")) {
            System.out.println("======Provide details to Register======");
            login login = new login();
            login.register();
        }
        else if (userInput.equals("3")) {
            System.out.println("Exited");
            System.exit(0);
        }
        else {
            System.out.println("Please select correct option!");
        }

    }
}
