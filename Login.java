/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog5121poe1;

import java.util.Scanner;
import java.util.ArrayList;

class User {
    private String firstName;
    private String lastName;
    private String username;
    private String password;

    public User(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public String getFirstName() { return firstName; }
    public String getLastName()  { return lastName; }
    public String getUsername()  { return username; }
    public String getPassword()  { return password; }
}

public class Login {

    // Shared user list (important!)
    private static ArrayList<User> userList = new ArrayList<>();

    // Add a test user (simulate registration)
    static {
        userList.add(new User("John", "Doe", "jdoe", "1234"));
    }

    public static boolean authenticate(String firstName, String lastName,
                                       String username, String password) {

        for (User user : userList) {
            if (user.getFirstName().equals(firstName) &&
                user.getLastName().equals(lastName) &&
                user.getUsername().equals(username) &&
                user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void loginSystem() {
        Scanner input = new Scanner(System.in);

        System.out.println("---LOGIN---");

        System.out.print("Enter first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter last name: ");
        String lastName = input.nextLine();

        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        if (authenticate(firstName, lastName, username, password)) {
            System.out.println("Login successful! Welcome back, " + firstName + ".");
        } else {
            System.out.println("Login failed. Incorrect first name, last name,username or password.");
        }
    }
}