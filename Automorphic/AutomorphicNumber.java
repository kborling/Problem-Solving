/*
* Kevin Borling
* CSCD 316 | Practical Problem Solving
* Problem 4b
* 06/01/2013
* Given a list of numbers, only print the Automorphic Numbers.
*/
   import java.io.File;
   import java.io.FileNotFoundException;
   import java.util.*;

   class AutomorphicNumber {
      static int div = 10;
   
      public static void main(String args[]) {
         if(args.length > 0)
            {
            try
               {
               Scanner fin = new Scanner(new File(args[0]));
               System.out.println("Automorphic Numbers:\n_____________________\n");
               while(fin.hasNextInt()) 
                  {
                  int num = fin.nextInt();
                  if (div >= num) 
                     {
                     if ((num * num) % div == num) 
                        {
                        System.out.println(num);
                        } 
                     } 
                     
                  else if (div <= num) 
                     {
                     div = div * 10;
                     if ((num * num) % div == num) 
                        {
                        System.out.println(num);
                        } 
                     }
                  }
               }
               catch(FileNotFoundException e)
                  {
                  System.out.println("Not enough arguments passed in!");
                  }
            }
         }
      }
