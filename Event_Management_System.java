package event_management;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class event2 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        
        // Loop until user chooses to exit
        while (choice != 3) {
            // Display options to user
            System.out.println("Event Management Menu:");
            System.out.println("1. Create new event");
            System.out.println("2. View existing event details");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            // Get user's choice
            choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    createEvent();
                    break;
                case 2:
                    viewEvent();
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please choose again.");
                    break;
            }
        }
        
        scanner.close();
    }
    
    // Method to create a new event
    private static void createEvent() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the name of the event: ");
        String eventName = scanner.nextLine();
        
        System.out.print("Enter the number of participants: ");
        int numParticipants = scanner.nextInt();
        scanner.nextLine();
        
        // Create a new file for the event
        File file = new File(eventName + ".txt");
        
        try {
            // Write event details to file
            FileWriter writer = new FileWriter(file);
            writer.write("Event: " + eventName + "\n");
            writer.write("Number of participants: " + numParticipants + "\n");
            
            System.out.print("Enter the number of sponsors: ");
            int numSponsors = scanner.nextInt();
            scanner.nextLine();
            writer.write("Number of sponsors: " + numSponsors + "\n");
            
            // Write sponsor details to file
            for (int i = 1; i <= numSponsors; i++) {
                System.out.print("Enter sponsor " + i + " name: ");
                String sponsorName = scanner.nextLine();
                
                System.out.print("Enter sponsor " + i + " advertisement: ");
                String sponsorAd = scanner.nextLine();
                
                writer.write("Sponsor " + i + ": " + sponsorName + "\n");
                writer.write("Advertisement: " + sponsorAd + "\n");
            }
            
            writer.close();
            System.out.println("Event details saved to file.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
        
        scanner.close();
    }
    
    // Method to view an existing event's details
    private static void viewEvent() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the name of the event to view: ");
        String eventName = scanner.nextLine();
        
        // Try to open the file for the event
        try {
            File file = new File(eventName + ".txt");
            Scanner fileScanner = new Scanner(file);
            
            // Print the contents of the file
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
            
            fileScanner.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        
        scanner.close();
    }
}
