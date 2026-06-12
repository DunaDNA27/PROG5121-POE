/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author oaratwa
 */
import java.util.Scanner;

public class Message 
{
    Scanner input = new Scanner(System.in);
    
    private String messageID;
    private String messageNum;
    private String recipientNum;
    private String messageBody;
    private String messageHash;
    
    private static int totalMessagesSent = 0;
       
    public Message(String messageID, String messageNum, String recipientNum, String messageBody)
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
    
    public String checkMessageLength(String messageBody)
    {
        
        if(messageBody.length()>=250)
        {    
           System.out.println("Message exceeds 250 characters, please reduce number of characters.");
           return messageBody;
        }
        
        System.out.println("Message ready to send.");
        return messageBody;
    }
    
    public static String createMessageHash(String messageID, String messageBody, String messageNum )
    {
        if(messageID == null && messageID.length()<2 && messageBody == null && messageBody.trim().isEmpty())
        {
            System.out.println("00:0:UNKNOWN");           
        }
            String[] words = messageBody.trim().split("\\s+");
            String firstWord = words[0].toUpperCase();
            String lastWord = words[words.length - 1].toUpperCase();
            return messageID.substring(0,2) +":"+ messageNum +":"+ firstWord + lastWord;          
    }
    
    public String getMessageHash()
    {
        return messageHash;
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
    
    public String printMessages()
    {
        return("\nMessageID: "+ messageID + "\nRecipient: " + recipientNum + "\nMessage: " + messageBody);
    }
    
    public static int returnTotalMessages()
    {
        return totalMessagesSent;
    }
    
    public String storeMessage()
    {
        return("{\n"+ " \"messageID\": \"" + messageID + "\",\n" + "\"recipient\": \""+ recipientNum + "\",\n" +
                "\"message\": \""+ messageBody.replace("\"", "\\\"") + "\"\n"+ "}");
    }
}
