package final_notes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class notes_and_passwords
{
    
    static Scanner Sc = new Scanner(System.in);
    
    
    //program to create a new note
    static void new_note()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the title for new note : ");
        String fileName = scanner.nextLine();
        System.out.print("Enter the message to write in the note : ");
        String message = scanner.nextLine();
        scanner.close();
        
        try {
            FileWriter fileWriter = new FileWriter(fileName + ".txt");
            fileWriter.write(message);
            fileWriter.close();
            System.out.println("File created successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }
    // end of new notes

     //program to read notes
    static void read_notes()
    {
        System.out.println("Enter the Title of the desired note:");
        String fileName = Sc.nextLine();

        try {
            File file = new File(fileName);
            Scanner fileInput = new Scanner(file);

            while (fileInput.hasNextLine()) {
                String line = fileInput.nextLine();
                System.out.println(line);
            }

            fileInput.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }   
    }
    //End of read notes

    //program to write notes
    static void write_notes()
    {  
        System.out.println("Please enter the title of the note you'd like to write to:");
        String fileName = Sc.nextLine();

        try {
            FileWriter writer = new FileWriter(fileName, true);

            System.out.println("Please enter your message:");
            String message = Sc.nextLine();

            writer.write(message + "\n");
            writer.close();

            System.out.println("Message saved successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
    // End of write notes

    //Start of reset password
    static void reset_pass(int enter_pass)
    {
        int x,temp;
        int y;
        System.out.println(" Hii , to confirm that you want to change your password enter 1 ");
        System.out.print("Enter your choice here:");
        x=Sc.nextInt();
        if(x==1){
            System.out.print("Enter your new 4 digit password :");
            y=Sc.nextInt();
            temp=enter_pass;
            enter_pass=y;
            System.out.println("Your old password is :"+temp);
            System.out.println("Your New password is:"+enter_pass);}
        else {
            System.out.print("Invaild Choice Made by the User");
        }  
    }
    // End of reset password
   
    public static void main (String[] args)
    {
       int a,pass=1234,enter_pass,ch1;
       for(int j=0; j<10;j++)
       {
        System.out.println("Hii , Welcome to notes and passwords ");
        System.out.println("Choose From the following operations \n 1.Normal notes \n 2.Password Protected Notes \n 3.Exit");
        System.out.print("Enter your choice here:");
        a=Sc.nextInt();
        //Normal notes 
        switch(a){
            case 1:
            {
                System.out.println("Welcome to notes");
                //selecting from the basic operations i.e. read or write
                while (true) {

                    System.out.println("Select an option:");
                    System.out.println("1. Create a new note");
                    System.out.println("2. Read a message");
                    System.out.println("3. Write a message");
                    System.out.println("4. Exit");
        
                    int option = Sc.nextInt();
        
                    switch (option) {
                        case 1:
                        new_note();
                        break;
                        //reading the notes
                        case 2:
                            read_notes();
                            break;
                        //writing the notes
                        case 3:
                            write_notes();
                            break;
                        //exiting the function
                        case 4:
                            System.out.println("Exiting MessageApp...");
                            System.exit(0);
                        default:
                            System.out.println("Invalid option. Please try again.");
                    }
                }
            }
        //Password protected notes
        case 2:
        {
            System.out.println("Welcome to Password Protected Notes");
            System.out.print("Enter Your Password:");
            enter_pass=Sc.nextInt();
                if(enter_pass==pass)
                {
                    System.out.println("Password verified \n Welcome to your secret notes");
                    System.out.print("A>To open notes enter 1\nB>To reset password enter 2 \nEnter your choice here:");
                    ch1=Sc.nextInt();
                    //Using basic functions of password protected notes
                    if (ch1 == 1)
                    {
                       System.out.print("Welcome to your protected notes:");
                       while (true) {

                        System.out.println("Select an option:");
                        System.out.println("1. Create a new note");
                        System.out.println("2. Read a message");
                        System.out.println("3. Write a message");
                        System.out.println("4. Exit");
            
                        int option = Sc.nextInt();
            
                        switch (option) {
                            case 1:
                                new_note();
                                break;
                            //reading the notes
                            case 2:
                                read_notes();
                                break;
                            //writing the notes
                            case 3:
                                write_notes();
                                break;
                            //exiting the function
                            case 4:
                                System.out.println("Exiting MessageApp...");
                                System.exit(0);
                            default:
                                System.out.println("Invalid option. Please try again.");
                        }
                    }

                    }
                    //Reset the password for password protected notes
                    else if (ch1 == 2 )
                    {
                        reset_pass(enter_pass);
                    }
                }
                else
                {
                    System.out.println("WRONG PASSWORD");
                }
        }
        //Exit the program 
      case 3:
        {
            System.out.println("Exiting MessageApp...");
            System.exit(0);
        }
        //defaut output incase no other option is left
       default :
        {
            System.out.println("Invalid Input");
        }
      }    
    } 
}

}