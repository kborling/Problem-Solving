/*
 * @author Kevin Borling
 * CSCD 316 | Practical Problem Solving
 * Assignment 4 | Pig Latin Converter
 * Given an input of English text, convert to Pig Latin.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PigLatin{
	
   public static void main(String [] args){
   
      Scanner fin;
      
      try
      {
         if(args.length == 0)
         {
            fin = new Scanner(new File("robustinput.txt"));
         }
         else
         {
            fin = new Scanner(new File(args[0]));
         }
         while (fin.hasNext())
         {
            fin.useDelimiter("\r\n ");// To print one sentance per line
            String word = fin.next();
            String translatedWord = PigLatin (word);
            System.out.print(translatedWord);
            System.out.println();
         }
         fin.close();
      
      }// End try
      catch (FileNotFoundException e) {
         e.printStackTrace();
      }// End catch
   }// End Main()
   

   private static String PigLatin(String input) {
      String Output = "";
      int x = 0;
      while (x < input.length()) {
      
         while (x < input.length() && !isLetter(input.charAt(x))) {
            Output += input.charAt(x);
            x++;
         }// Add punctuation at end of sentence to the translated sentence.
      
         if (x >= input.length()) 
            break; // This will stop the method if there are not any words left.
         
         int begin = x;
         while (x < input.length() && isLetter(input.charAt(x))) {
            x++;
         }
         
         int end = x;
         Output += makeWords(input.substring(begin, end));
      }
      return Output;
   } // End Piglatin
   
      /*
       * Checks if the letter is alphabetical, or containing punctuation.
       */
   private static boolean isLetter(char d) {
      return ( (d >='A' && d <='Z') || (d >='a' && d <='z') || d =='\'' || d == '-' || d == '`' || d == '"');
   } // End isLetter()
   
      /*
       * Checks if word contains uppercase letter, therefore capitalizing the translated word.
       */
   private static boolean uppercase(String word) {
      for(int i = 0; i < word.length(); i++)
      {
         if(Character.isUpperCase(word.charAt(i)))
            return true;
      }
      return false;
   } // End isUppercase()
      
   private static String makeWords(String text) {
      int cut = firstVowel(text);
   
      if(cut != 0)
         text = text.substring(cut)+ text.substring(0, cut)+"ay";// First letter isn't a vowel
      else
         text = text.substring(cut)+ text.substring(0, cut)+"yay";// First letter is a vowel
         // Convert first letter of translated word to uppercase.
      if(uppercase(text))
      {
         text = text.toLowerCase();
         text = text.substring(0,1).toUpperCase() + text.substring(1);
      }
      return text;
   }// End makeWords()
   
      /*
       * Checks if first letter contains a vowel.
       */
   private static int firstVowel(String word) {
      word = word.toLowerCase();
      for (int f = 0; f < word.length(); f++)
         if (word.charAt(f)=='a' || word.charAt(f)=='e' ||word.charAt(f)=='i' || word.charAt(f)=='o' || word.charAt(f)=='u')
            return f;
      return 0;
   } // End firstVowel()

}// End Class