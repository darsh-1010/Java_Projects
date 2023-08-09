package final_notes;
import java.util.Scanner;
public class Pass_check
 { 
    /**
     * @param args
     */
    public static void main (String[] args)
    {
    int pass=1010;
    int enter_pass;
    try (Scanner Sc = new Scanner(System.in)) {
        System.out.println (" Enter your password");
        enter_pass=Sc.nextInt();
    }

    if( enter_pass == pass)
    {
        System.out.println ("Your password is verified ");
    }
    else
    {
        System.out.println (" Wrong passsword");
    } 
  }
 }
