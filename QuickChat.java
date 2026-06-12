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
        
        for (int i = 0; i < messageCount; i++)
        {
            String generatedID = String.format("%010d",(long) (Math.random() * 10000000000L));

            System.out.println("\n---Processing Message [" + (i + 1) + " of " + messageCount + "] ---");
            
            System.out.println("Message ID generated: " + generatedID);

            System.out.print("Enter Recipient Cell Number: ");
            String recipientNum = input.nextLine();

            System.out.print("Enter Message (Max 250 characters): ");
            String messageBody = input.nextLine();

            // Create message object
            Message currentMsg;
            currentMsg = new Message(generatedID, i, recipientNum, messageBody);
            System.out.println("Message Hash: "+ currentMsg.getMessageHash());

            // Check message length
            String lengthCheck = currentMsg.checkMessageLength(messageBody);

            if (lengthCheck.contains("exceeds"))
            {
                System.out.println(lengthCheck);
                i--;
                continue;
            }
            
            System.out.println("\nSelect an action for this message:");
            System.out.println("1 - Send Message");
            System.out.println("2 - Delete Message");
            System.out.println("3 - Store message to send later");
            System.out.println("4 - Stored messages");
            System.out.print("Action Choice: ");
            
            int choice = input.nextInt();
            input.nextLine();
            
            switch (choice)
            {
                case 1:
                    System.out.println("\n---Full Message Details---");
                    System.out.println(currentMsg.printMessages());
                    break;
                    
                case 2:
                    System.out.println("\n---JSON File Storage Preview---");
                    System.out.println(currentMsg.storeMessage());
                    break;
                
                case 3:
                    storedMessagesMenu();
                                     
            }
        }
            System.out.println("\nTotal successful messages sent during session: " + Message.returnTotalMessages());
    } 
    
    public void StoredMessages() 
    {
        static String[] sender = {"Alice", "Bob", "Charlie", "Dana"};
        static String[] recipient = {"Eve", "Frank", "Eve", "George"};
        static String[] message = {
            "Hello Eve, how are you?",
            "Meeting at 3 PM.",
            "Don't forget the report!",
            "Happy Birthday George!"};
        
        static String[] messageID = {"M001", "M002", "M003", "M004"};
        static String[] messageHash = {"H001", "H002", "H003", "H004"};

        private static void  storedMessagesMenu()
        {
            Scanner input = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\n--- Stored Messages Menu ---");
                System.out.println("1. Display sender and recipient of all messages");
                System.out.println("2. Display the longest stored message");
                System.out.println("3. Search by message ID");
                System.out.println("4. Search messages by recipient");
                System.out.println("5. Delete message by hash");
                System.out.println("6. Display full report");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = input.nextInt();
                input.nextLine(); // newline

                switch (choice) {
                    case 1:
                        displaySendersAndRecipients();
                        break;
                    case 2:
                        displayLongestMessage();
                        break;
                    case 3:
                        searchByMessageID(input);
                        break;
                    case 4:
                        searchByRecipient(input);
                        break;
                    case 5:
                        deleteByHash(input);
                        break;
                    case 6:
                        displayFullReport();
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            } while (choice != 0);
        }

        static void displaySendersAndRecipients() {
            System.out.println("\nSender → Recipient");
            for (int i = 0; i < sender.length; i++) {
                System.out.println(sender[i] + " → " + recipient[i]);
            }
        }

        static void displayLongestMessage() {
            int longestIndex = 0;
            for (int i = 1; i < message.length; i++) {
                if (message[i].length() > message[longestIndex].length()) {
                    longestIndex = i;
                }
            }
            System.out.println("\nLongest Message:");
            System.out.println("Sender: " + sender[longestIndex]);
            System.out.println("Recipient: " + recipient[longestIndex]);
            System.out.println("Message: " + message[longestIndex]);
        }

        static void searchByMessageID(Scanner input) {
            System.out.print("Enter Message ID: ");
            String id = input.nextLine();
            boolean found = false;
            for (int i = 0; i < messageID.length; i++) {
                if (messageID[i].equalsIgnoreCase(id)) {
                    System.out.println("Recipient: " + recipient[i]);
                    System.out.println("Message: " + message[i]);
                    found = true;
                    break;
                }
            }
            if (!found) System.out.println("Message ID not found.");
        }

        static void searchByRecipient(Scanner input) {
            System.out.print("Enter Recipient Name: ");
            String name = input.nextLine();
            boolean found = false;
            for (int i = 0; i < recipient.length; i++) {
                if (recipient[i].equalsIgnoreCase(name)) {
                    System.out.println("Sender: " + sender[i]);
                    System.out.println("Message: " + message[i]);
                    found = true;
                }
            }
            if (!found) System.out.println("No messages found for recipient " + name);
        }

        static void deleteByHash(Scanner input) {
            System.out.print("Enter Message Hash to delete: ");
            String hash = input.nextLine();
            boolean deleted = false;
            for (int i = 0; i < messageHash.length; i++) {
                if (messageHash[i].equalsIgnoreCase(hash)) {
                    sender[i] = recipient[i] = message[i] = messageID[i] = messageHash[i] = null;
                    deleted = true;
                    System.out.println("Message deleted successfully.");
                    break;
                }
            }
            if (!deleted) System.out.println("Message hash not found.");
        }

        static void displayFullReport() {
            System.out.println("\n--- Full Message Report ---");
            for (int i = 0; i < sender.length; i++) {
                if (sender[i] != null) {
                    System.out.println("ID: " + messageID[i] + " | Hash: " + messageHash[i]);
                    System.out.println("Sender: " + sender[i]);
                    System.out.println("Recipient: " + recipient[i]);
                    System.out.println("Message: " + message[i]);
                    System.out.println("---------------------------");
                }
            }
        }
    }

}




 