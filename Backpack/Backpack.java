/*
 * @author Kevin Borling
 * CSCD 316 | Practical Problem Solving
 * Backpack Problem
 * The Backpack problem with find the best possible benefit given a certain weight restriction.
 * I was unable to implement a correct method towards calculating the loaded weight for each solution.
 * I understood how to do solve the loaded weight on paper, but implementing it seemed harder than expected.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Backpack {
	
   static int loaded = 0;
   
	public static void main(String [] args) {

		Scanner fin;
		int datasets = 0;
		int weight = 0;
		int provisions = 0;
      int[] itemWeight = null;
      int[] itemBenefit = null;
      int benefit = 0;

	 try
      {
         if(args.length == 0)
         {
            fin = new Scanner(new File("backpack.in")); // Read from input
         }
         else
         {
            fin = new Scanner(new File(args[0])); // Read from command line
         }

         while(fin.hasNext()) 
         {
         	datasets = fin.nextInt();// First number

         	if(!(datasets > 0))
         		throw new InputMismatchException("Dataset must be greater than zero.");
            
            for(int x = 0; x < datasets; x++) // Iterate through datasets
            {
         	weight = fin.nextInt();// Second number
         	provisions = fin.nextInt();// Third number

            
         	if(!(provisions > 0))
         		throw new InputMismatchException("Provisions must be greater than zero.");

            itemWeight = new int[provisions];
            itemBenefit = new int[provisions];

            for(int i = 0; i < provisions; i++)
            {
              itemWeight[i] = fin.nextInt();
              itemBenefit[i] = fin.nextInt();
            }
            
             loaded = 0;
             benefit = yumYumYumYumYum_Delicioso(weight, provisions, itemWeight, itemBenefit);
             printBackpack(weight, loaded, benefit);
            }// End for

         }// End while
         fin.close();

      }// End try
      catch (FileNotFoundException e) {
         e.printStackTrace();
      }// End catch

	}// End main()
   

   private static int yumYumYumYumYum_Delicioso(int W, int P, int [] wt, int [] ben)
   {

   int [][] backpack = new int [P+1][W+1];// Set size to # of provisions.
      if(W == 0 || P == 0)
         return 0;

      for (int w = 0; w <= W; w++)
        backpack[0][w] = 0;
      for (int i = 0; i <= P; i++)
        backpack[i][0] = 0;
   
      for (int i = 0; i <= P; i++)
      {
       for (int w = 0; w <= W; w++)
       {
           if (i==0 || w==0)
               backpack[i][w] = 0;
           else if (wt[i-1] <= w)
           {

           backpack[i][w] = max(ben[i-1] + backpack[i-1][w-wt[i-1]],  backpack[i-1][w]);

          } else
          {
                 backpack[i][w] = backpack[i-1][w];
       }
       
       }
       // Loop through bottom row of Backpack to sum the loaded weights.
       for(int l = W; l >= 0; l--)
       {
        if(loaded <= W)
        {
          if(loaded+backpack[P-1][l] <= W)
             loaded += backpack[P-1][l];
        }
       }
   }
   return backpack[P][W];

   }
  
   private static void printBackpack(int weight, int loaded, int benefit)
   {
   System.out.println("Backpack weight: " + weight + ", Loaded weight: " + loaded + ", Benefit: " + benefit);
   }
   
   private static int max(int a, int b) 
   { 
   return (a > b)? a : b; 
   }
}// End Class