import java.io.File;
import java.io.FileNotFoundException;
import java.util.TreeSet;
import java.util.Scanner;
import java.util.Iterator;

public class Anagram {
	
	static String previous = "";
	static TreeSet<String> set = new TreeSet<String>(); 
	public static void main(String [] args) {

		int wordCount = 0;
		String word;
		Scanner fin;

	 try
      {
         if(args.length == 0)
         {
            fin = new Scanner(new File("a.in")); // Read from input
         }
         else
         {
            fin = new Scanner(new File(args[0])); // Read from command line
         }

         while(fin.hasNext()) 
         {
         	if(wordCount == 0)
         	wordCount = fin.nextInt();

         	for(int i = 0; i < wordCount; i++)
         	{
         	word = fin.next();
         	Anagram("", word);
         	}
         }// End while

      		Iterator iterator = set.iterator(); 
            while ( iterator.hasNext() )
         		System.out.println( iterator.next());
	
         fin.close();

      }// End try
      catch (FileNotFoundException e) {
         e.printStackTrace();
      }// End catch

	}// End main()

	private static void Anagram (String wordStart, String wordEnd) {
		String anagram = "";
		if(set.contains(wordStart + wordEnd))
			return;
		if (wordEnd.length() < 2)
			set.add(wordStart + wordEnd);
		else
			for (int x = 0; x < wordEnd.length(); x++)
			{
				anagram = wordEnd.substring(0,x) + wordEnd.substring(x+1);
				Anagram(wordStart + wordEnd.charAt(x), anagram);
			}
	}// End Anagram()

}// End class