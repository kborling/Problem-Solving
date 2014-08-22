/*
 * Kevin Borling
 * CSCD 316 | Practical Problem Solving
 * Chapter 2 | Problem 2.8.1 - Jolly Jumper
 * 01/26/2014
 */
   import java.io.File;
   import java.io.FileNotFoundException;
   import java.util.Scanner;
   import java.util.HashSet;
   
   public class JollyJumper 
      {
   
      public static void main(String[] args)
         {
         Scanner fin;
         int n;
         int [] s;
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
         
            while(fin.hasNextInt()) 
                  {
                  n = fin.nextInt();
                  s = new int[n];
                  for(int i = 0; i < n; i++)
                     s[i] = fin.nextInt();
               
                  System.out.println(isValid(s)?"Jolly":"Not jolly");
               
                  }
               }
       catch (FileNotFoundException e) 
            {
         e.printStackTrace();
            }// End catch
      
            
         }// End Main
   
      public static boolean isValid(int[] s) 
         {
         HashSet<Integer> hashset = new HashSet<Integer>();
         int start = s[0];
         for(int i = 1; i < s.length; i++)
            {
            if(Math.abs(start - s[i]) > 0 && Math.abs(start - s[i]) < s.length)
               if(!hashset.add(Math.abs(start - s[i])))
                  return false;
                  
            start = s[i];
            }
         return true;
         }// End isValid
   
   
   
      }// End Class
