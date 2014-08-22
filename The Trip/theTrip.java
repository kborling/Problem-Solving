/*
* Kevin Borling
* CSCD 316 | Practical Problem Solving
* Chapter 1 | Problem 1.6.3 - The Trip
* 01/14/2014
* The edge cases include 1 student spending 0.00, up to 1000 students spending 10,000.00
* Also check for negative input because the text doesn't specify if the students can spend a negative amount.
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.math.RoundingMode;
   
public class theTrip
{

   public static void main(String [] args)
   {
      Scanner fin;
      DecimalFormat df = new DecimalFormat("0.00");
      df.setRoundingMode(RoundingMode.DOWN);
      int students;
   
   
      try
      {
         if(args.length == 0)
         {
            fin = new Scanner(new File("input.txt"));
         }
         else
         {
            fin = new Scanner(new File(args[0]));
         }
              
      
         while(fin.hasNext())
         { 
            double total = 0;
            double div = 0;
            double exchange = 0;
               
            students = fin.nextInt();
               
            if(students == 0)// Exit at 0
               System.exit(1);
               
         
            double amount [] = new double[students];
            for(int x = 0; x < students; x++)// Add students inital amounts into array
            {
               amount[x] = fin.nextDouble();
               
               if(amount[x] < 0)// Handles unspecified negative amount possibility?
                  amount[x] = 0.00;  
            
            }// End for
         
         
            for(int x = 0; x < students; x++)
            {
               total += amount[x];// Sum total amount spent
            }
               
            div = total/students;
         
               
            for(int x = 0; x < students; x++)
            {
               if(amount[x] < div) // Finds owed difference
               
                  exchange += div - amount[x];
            }
            System.out.println("$" + df.format(exchange));
               
         
         }// End while
      }
      catch (FileNotFoundException e) {
         e.printStackTrace();
      }// End catch
   
   
   }// End Main
}// End theTrip