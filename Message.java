/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author oarat
 */
import java.util.Scanner;

public class Message 
{
    Scanner input = new Scanner(System.in);
    
    private String messageID;
    private int messageNum;
    private String recipientNum;
    private String messageBody;
    
    private static int totalMessagesSent = 0;
       
    public void textMessage()
    {
      this.messageID = messageID;
      this.messageNum = messageNum;
      this.recipientNum = recipientNum;
      this.messageBody = messageBody;
    }
    
    public static boolean isValidmessageID(String messageID)
    {
        if(messageID == null) 
        {
            System.out.println("Message ID must not be null.");
            return false;
        }
        
        if(messageID.length() > 10)
        {
            System.out.println("Invalid Message ID. Must not exceed 10 characters");
            return false;
        }
        
        System.out.println("Message ID is valid: "+ messageID);
        return true;
    }
    
    public static boolean checkRecipientCell(String recipientNum)
    {
       if(recipientNum.length() > 10 && recipientNum.startsWith("+27"))
       {
         System.out.println("Invalid recipient cell number. Must have corrct country code and not more than 10 digits ");
         return false;
       } 
       
       System.out.println("Recipient cell number is valid: "+ recipientNum);
       return true;
    }
    
    public static boolean checkMessageLength(String message)
    {
        if(message ==null)
        {
            System.out.print("Message cannot be empty.");
            return false;
        }
        
        if(message.length()>=250)
        {    
           System.out.println("Message exceeds 250 characters, please reduce number of characters.");
           return false ;
        }
        
        System.out.println("Message ready to send.");
        return true;
    }
    
    public static void createMessageHash(String messageID, String messageBody)
    {
        if(messageID == null && messageID.length()<2 && messageBody == null && messageBody.trim().isEmpty())
        {
            System.out.println("00:0:UNKNOWN");
            
        }
    }
    
    public static void sentMessage(int choice)
    {          
        switch (choice)
        {
            case 1:
                totalMessagesSent++;
                System.out.println("Message successfully sent.");
                return;

            case 2:
                System.out.println("Press 0 to delete the message.");
                return;

            case 3:
                System.out.println("Message successfully stored.");
                
            default:
                System.out.println("Invalid selection.");
        }           
    }
    
    public void printMessages()
    {
        System.out.println("\nMessageID: "+ messageID + "\nRecipient: " + recipientNum + "\nMessage: " + messageBody);
    }
    
    public static int returnTotalMessages()
    {
        return totalMessagesSent;
    }
    
    public void storeMessage()
    {
        System.out.println("{\n"+ 
                " \"messageID\": \"" + messageID + "\",\n" +
                "\"recipient\": \""+ recipientNum + "\",\n" +
                "\"message\": \""+ messageBody.replace("\"", "\\\"") + "\"\n"+
                "}");
    }
}
