/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prog5121poe1;

import java.util.Scanner;

public class UserApp 
{

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) 
    {
        System.out.println("---USERAPP SYSTEM---");
        mainMenu();
    }

    public static void mainMenu() 
    {

        while (true) 
        {
            System.out.println("\n1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            int choice = input.nextInt();
            input.nextLine(); // clear buffer

            switch (choice)// switch for main menu options 
            {

                case 1:
                    Register();
                    break;

                case 2:
                    Login();
                    break;

                case 3:
                    System.out.println("Goodbye from The UserApp!");
                    return;

                default:
                    System.out.println("Invalid option; Please try again.");
            }
        }
    }

    //Registration method
    public static void Register() 
    {

        System.out.println("---REGISTER---");
        
        System.out.print("First Name: ");
        String firstName = input.nextLine();

        System.out.print("Last Name: ");
        String lastName = input.nextLine();
        
        System.out.println("==Username Rules=="); 
        System.out.println("*Must not be more than 5 characters*"); 
        System.out.println("*Must have an underscore(_)*");

        System.out.print("Username: ");
        String username = input.nextLine();
        
        System.out.println("==Password Rules=="); 
        System.out.println("*At least 8 characters long*"); 
        System.out.println("*Contains a capital letter*"); 
        System.out.println("*Contains a number*"); 
        System.out.println("*Contains a special character*");

        System.out.print("Password: ");
        String password = input.nextLine();

        System.out.print("Phone Number: ");
        String phone = input.nextLine();

        boolean success = Register.registerUser(firstName, lastName, username, password, phone);

        if (success) 
        {
            System.out.println("Registration successful!");
        } else 
        {
            System.out.println("Registration is not correctly formatted.");
        }
    }

    //Login for returning users
    public static void Login() 
    {

        System.out.println("---LOGIN---");  
        
        System.out.print("First Name: ");
        String firstName = input.nextLine();

        System.out.print("Last Name: ");
        String lastName = input.nextLine();

        System.out.print("Username: ");
        String username = input.nextLine();

        System.out.print("Password: ");
        String password = input.nextLine();

        boolean success = Login.authenticate(firstName, lastName, username, password);

        if (success) 
        {
            System.out.println("Login successful! Welcome back, " + firstName + ".");
        } else 
        {
            System.out.println("Login failed. First name, last name, username or password incorrect.");
        }
    }
}