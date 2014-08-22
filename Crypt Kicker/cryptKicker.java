/*
* Kevin Borling
* CSCD 316 | Practical Problem Solving
* Chapter 1 | Problem 2.8.4 - Crypt Kicker
* 01/25/2014
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class cryptKicker{

public static void main(String [] args){

Scanner fin;

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


      }
      catch (FileNotFoundException e) {
         e.printStackTrace();
      }// End catch
}
 }