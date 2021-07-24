package user;

import java.io.IOException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class getInput 
{
    public static void main( String[] args ) throws IOException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("================Relational Database Management System===============");
        System.out.println("Press 1 to login\nPress 2 to register");

        String userInput = scanner.nextLine();

        if(userInput.equals("1")){
            System.out.println("======Enter details to login======");
            login login = new login();
            login.login();
        } else if (userInput.equals("2")) {
            System.out.println("======Provide details to Register======");
            login login = new login();
            login.register();
        } else {
            System.out.println("Please select correct option!");
        }

    }
}
