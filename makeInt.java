/*
 * @author Kevin Borling
 * CSCD 316 | Practical Problem Solving
 * Simple program to convert a string to an int without use of API.
 */
public class makeInt{
	
	public static void main(String [] args){
		int results = 0;

		String digits = "-54321"; // Test Positive or Negative
		results = stringToInt(digits);
		System.out.println(results);

	}

		public static int stringToInt(String digits){
			
			/*
			if(digits == null || digits.length() == 0 || (digits.length() == 1 && digits.charAt(0) == '-'))
				throw new IllegalArgumentException("Your String" + digits + " is effed up..");

			int i = 0;

			if(digits.charAt(0) == '-')// Check for leading -
				i = 1;

			for(; i < digits.length(); i++){
				if(digits.charAt(i) < '0' || digits.charAt('i') > '9')
					throw new IllegalArgumentException("Not a digit!");


			}

			*/



			int result = 0;
			int negative = 1;
			int x = 0;

			for(; x < digits.length(); x++){
				if(digits.charAt(x) == '-'){
					negative = -1;
					x = 1;
				}
				result *= 10; // Add trailing zero
				result += (digits.charAt(x) - '0');// Give int value
			}


			return result * negative;
		}
}