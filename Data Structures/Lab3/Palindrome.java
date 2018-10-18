import java.util.Scanner;

public class Palindrome {
	
	public static void main (String[] args) {
		
		// create local variables
		String word = "";
		String redacted = "";
		Scanner in = new Scanner( System.in );
		
		// get user input 
		System.out.println("Enter a string: ");
		if ( in.hasNextLine() ) {
			word = in.nextLine().toLowerCase();
		} else {
			in.nextLine();
		}
		
		for (int i = 0; i < word.length(); i++) { // get rid of spaces in words
			if (word.charAt(i) == ' ') {
				
			} else {
				redacted += word.charAt(i);
			}
		}
		
		// test if its a palindrome
		if (testPalindrome( redacted ) ) {
			System.out.println(redacted + " is a palindrome!");
		} else {
			System.out.println(redacted + " is not a palindrome!");
		}
		
		in.close();
	}
	
	public static boolean testPalindrome( String word ) {
		
		// if the String being sent in has a length of 0 or 1 the palindrome is good and returns true
		if ( word.length() == 0 || word.length() == 1 ) {
			return true;
		}
		// check to see if the chars at the beginning and end of string are the same.
		// if they are the same take them out of the string in send a new string into this method without the first and last chars
		if ( word.charAt(0) == word.charAt(word.length()-1 ) ) {
			return testPalindrome( word.substring (1, word.length() -1 ) );
		}
		
		// otherwise return false
		return false;
	}
}
