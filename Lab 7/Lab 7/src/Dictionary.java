import java.util.Scanner;
import java.util.TreeMap;

public class Dictionary {
	// instance variable
	private TreeMap<String, Integer> dictionary = new TreeMap<String, Integer>();
	
	// constructor
	public Dictionary(){}
	
	// clear all words in dictionary
	public void clear() {
		dictionary.clear();
	}
	
	// get the number of nodes 
	public int getCount() {
		return dictionary.size();
	}
	
	// add a value from the keyboard
	public boolean addFromKeyboard ( Scanner in ) {
		
		// get word and create temp Word
		System.out.println("Enter a word to add: ");
		String word = in.next().toLowerCase().replaceAll("\\W", "");
			
		// if the size is 0 add it to the first instance
		if ( dictionary.containsKey( word ) ) {
			int count = dictionary.get(word) + 1;
			dictionary.put(word, count);
			return true;
		}
		// add the word if it wasnt there
		dictionary.put( word, 1 );
		
		return true;
	}
	
	public void checkWord( Scanner in ) {
		
		System.out.println("Enter word to search for: ");
		String word = in.next().toLowerCase();
		
		if ( dictionary.containsKey( word ) ) {
			System.out.println(word + " occurs " + dictionary.get(word).intValue() + " time(s)");
			return;
		}
		System.out.println("There is no word in the dictionary");
	}
	
	public void addFromFile( Scanner in ) {
		
		while ( in.hasNext() ) {
			String word = in.next().toLowerCase().replaceAll("\\W", "");
			
			// if the size is 0 add it to the first instance
			if ( dictionary.containsKey( word ) ) {
				int count = dictionary.get(word) + 1;
				dictionary.put( word, count );
			} else {
				dictionary.put( word, 1 );
			}
		}
	}
}