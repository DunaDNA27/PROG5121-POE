/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog5121poe1;

import java.util.ArrayList;

public class Register 
{

    // Shared user list
    public static ArrayList<User> userList = new ArrayList<>();

    // Username validation
    public static boolean isValidUsername(String username) 
    {
        return username.length() <= 5 && username.contains("_");
    }

    // Password validation 
    public static boolean isValidPassword(String password) 
    {
        if (password.length() < 8) return false;
        if (!password.matches(".*[A-Z].*")) return false;
        if (!password.matches(".*[0-9].*")) return false;
        if (!password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?].*")) return false;
        return true;
    }

    // Phone validation 
    public static boolean isValidPhone(String phoneNum) 
    {
        return phoneNum.startsWith("+27") && phoneNum.length() == 12;
    }

    // Register boolean
    public static boolean registerUser(String firstName, String lastName,String username, String password, String phoneNum) 
    {

        if (!isValidUsername(username)) return false;
        if (!isValidPassword(password)) return false;
        if (!isValidPhone(phoneNum)) return false;

        userList.add(new User(firstName, lastName, username, password));
        return true;
    }
}