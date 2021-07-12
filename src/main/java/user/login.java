package user;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class login {

    public void register() throws IOException {

        Scanner input = new Scanner(System.in);
        FileWriter storeUserDetails;

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

//        if(email.matches("[^@.]")){
//        } else {
//            System.out.println("Email id cannot have any other special characters except @");
//        }

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

}
