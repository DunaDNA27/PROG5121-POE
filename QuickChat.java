/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author oarat
 */
import java.util.Scanner;

public class QuickChat 
{
    public static void main(String[] args)
    {
        System.out.println("---Welcome To QuickChats---");
        messageMenu();
    }
        
    public static void messageMenu() 
    {
        Scanner input = new Scanner(System.in);
        while (true) 
        {
            System.out.println("\n1. Send Messages");
            System.out.println("2. Show recently sent messages");
            System.out.println("3. Quit");
            System.out.print("Choose option: ");

            int choice = input.nextInt();
            input.nextLine(); // clear buffer

            switch (choice)// switch for main menu options 
            {

                case 1:
                    processMessage();
                    break;

                case 2:
                    System.out.println("Coming Soon");
                    break;

                case 3:
                    System.out.println("Goodbye from The QuickChat!");
                    return;

                default:
                    System.out.println("Invalid option; Please try again.");
            }
        }
    } 
    
    private static void processMessage()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("How many messages do you want to send?: ");
        int messageCount;
        try
        {
            messageCount = Integer.parseInt(input.nextLine());
        }
        
        catch (NumberFormatException e)
        {
            System.out.println("invalid count format.");
            return;
        }
        
            for(int i = 0; i <messageCount; i++)
            {
                String generatedID = String.format("%010d",(long)(Math.random()*10000000000L));
                System.out.println("\n---Processing Message ["+ (i+1)+"of"+messageCount+"] ---");
                System.out.println("Message ID generated: "+ generatedID);
                
                System.out.print("Enter Recipient Cell Number: ");
                String recipient = input.nextLine();
                
                System.out.print("Enter Message (Max 250 characters): ");
                String body = input.nextLine();
                
                Message currentMsg = new Message(generatedID, i, recipient, body);  
                
                String lengthCheck = currentMsg.checkMessageLength(body);
                
                if(lengthCheck.contains("exceeds"))
                {
                    System.out.println(lengthCheck);
                    i--;
                    continue;
                }               
            }
    }   
}




 