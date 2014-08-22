  /*
  	* Kevin Borling
	* CSCD 327 | Practical Problem Solving
	* 1.6.1 The 3n + 1 Problem
	*/
  
   import java.io.File;
   import java.io.FileNotFoundException;
   import java.util.Scanner;

   public class ThreeNplusOne {
      
    
      
      public static void main(String[] args) {
         int min, max, result;
         
         if(args.length > 0)
            {
            try {
               Scanner fin = new Scanner(new File(args[0]));
               while(fin.hasNext())
                  {
                  min = fin.nextInt();
                  max = fin.nextInt();
                  System.out.printf("%d %d ",min, max);
                  int occurence = 0;
                  for (; min < max; min++)
                     {
                     int count = 0;
                     result = min;
                     while (result > 1) 
                        {
                        count++;
                        if (result % 2 == 1)
                           result = 3 *result + 1;
                        else
                           result /= 2;
                        }// end while
                  
                     count++;
                     if (count > occurence)
                        occurence = count;
                  
                     }// End for
                  System.out.printf("%d\n", occurence);
                  }// End while
               }// End try
               catch (FileNotFoundException e) {
                  e.printStackTrace();
                  }// End catch
            }
         else
            {
            System.out.println("Not Enough Arguments Passed In!");
            System.exit(-1);
            }
         }// End Main
      }// End Class