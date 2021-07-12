package user;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class login {

    FileWriter storeUserDetails;

    public void register() throws IOException {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter firstname:");
        String firstname = input.nextLine();

        if(firstname.matches("^[0-9]")){
            System.out.println("Your input is not valid");
            return;
        }

        if(firstname == null || firstname.isEmpty()){
            System.out.println("Input cannot be empty!");
            return;
        }

        System.out.println("Enter lastname:");
        String lastname = input.nextLine();

        if(lastname.matches("^[0-9]")){
            System.out.println("Your input is not valid");
            return;
        }

        if(lastname == null || lastname.isEmpty()){
            System.out.println("Input cannot be empty!");
            return;
        }

        System.out.println("Enter email:");
        String email = input.nextLine();

        if(email.matches("^[0-9]")){
            System.out.println("Your input is not valid");
            return;
        }

        if(email == null || email.isEmpty()){
            System.out.println("Input cannot be empty!");
            return;
        }

        if(email.matches("[^@.]")){
        } else {
            System.out.println("Email id cannot have any other special characters except @ and .");
        }

        System.out.println("Confirm email:");
        String confirmEmail = input.nextLine();

        if(confirmEmail.matches("^[0-9]")){
            System.out.println("Your input is not valid");
            return;
        }

        if(confirmEmail == null || confirmEmail.isEmpty()){
            System.out.println("Input cannot be empty!");
            return;
        }
        String reenterEmail = null;
        if(!email.equalsIgnoreCase(confirmEmail)){
            System.out.println("Email entered does not match.");

            System.out.println("Please re-enter email:");
            reenterEmail = input.nextLine();

        }

        System.out.println("Enter password:");
        String password = input.nextLine();

        if(password.matches("^[0-9]")){
            System.out.println("Your input is not valid");
            return;
        }

        if(password == null || password.isEmpty()){
            System.out.println("Input cannot be empty!");
            return;
        }

        System.out.println("Confirm password:");
        String confirmPassword = input.nextLine();

        if(confirmPassword.matches("^[0-9]")){
            System.out.println("Your input is not valid");
            return;
        }

        if(confirmPassword == null || confirmPassword.isEmpty()){
            System.out.println("Input cannot be empty!");
            return;
        }
        String reenterPassword = null;
        if(!password.equals(confirmPassword)){
            System.out.println("Password does not match");

            System.out.println("Please re-enter proper password");
            reenterPassword = input.nextLine();
        }

        System.out.println("Provide answers to some questions for Multi Factor Authenticaton");
        System.out.println("Please remember the provided answers");

        System.out.println("Enter your favourite color");
        String color = input.nextLine();

        if(color.matches("^[0-9]")){
            System.out.println("Your input is not valid");
            return;
        }

        if(color == null || color.isEmpty()){
            System.out.println("Input cannot be empty!");
            return;
        }

        System.out.println("Enter your favourite animal");
        String animal = input.nextLine();

        if(animal.matches("^[0-9]")){
            System.out.println("Your input is not valid");
            return;
        }

        if(animal == null || animal.isEmpty()){
            System.out.println("Input cannot be empty!");
            return;
        }

        System.out.println("Enter your favourite food");
        String food = input.nextLine();

        if(food.matches("^[0-9]")){
            System.out.println("Your input is not valid");
            return;
        }

        if(food == null || food.isEmpty()){
            System.out.println("Input cannot be empty!");
            return;
        }

        storeUserDetails = new FileWriter("UserRegisteredDetails");
        storeUserDetails.write( "Firstname: " + firstname + "\n" + "Lastname: " + lastname);

        if (!email.equalsIgnoreCase(confirmEmail)) {
            storeUserDetails.write("\nEmailID: " + reenterEmail);
        } else {
            storeUserDetails.write("\nEmailID: " + confirmEmail);
        }

        System.out.println("\n");

        if (!password.equals(confirmPassword)) {
            storeUserDetails.write("\nPassword: " + reenterPassword);
        } else {
            storeUserDetails.write("\nPassword: " + confirmPassword);
        }

        storeUserDetails.write("\nFavourite color:  " + color + "\n" + "Favourite animal: " + animal + "\n"
                + "Favourite food: " + food);
        storeUserDetails.close();
    }


    public void login() throws IOException {

        Scanner input = new Scanner(System.in);
        String[] questions = new String[3];
        questions[0] = "Enter your favourite color: ";
        questions[1] = "Enter your favourite animal: ";
        questions[2] = "Enter your favourite food: ";

        Random generator = new Random();
        Integer num = generator.nextInt(questions.length);

        System.out.println("Enter EmailID: ");
        String email_id = input.nextLine();

        File file = new File("UserRegisteredDetails");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String str;
        while ((str = br.readLine()) != null) {

            if (str.contains(email_id)) {
                System.out.println("Enter password: ");
                String password = input.nextLine();

                if (str.contains(password)) {

                    System.out.println(questions[num]);
                    String answer = input.nextLine();

                    if(str.contains(answer)){
                        System.out.println("Login successfull");
                    } else {
                        System.out.println("Enter proper details to login.");
                    }
                }
            }
        }

    }
}
