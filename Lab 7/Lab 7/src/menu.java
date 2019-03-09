import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class menu {

	public static void main(String[] args) {
		
		// local variables
		Dictionary dictionary = new Dictionary();
		char option = ' ';
		Scanner keyboard = new Scanner( System.in );
		
		do {	// print menu until the exit option is given
			System.out.println("[1] to clear dictionary\n[2] add text from keyboard\n"
						 	 + "[3] add text from file\n[4] search for a word count\n"
						 	 + "[5] Display number of nodes\n[6] quit:");
			option = keyboard.next().charAt(0);
			
			switch (option) {
			case '1':	dictionary.clear();
						System.out.println("Dictionary is cleared!");
						break;
			case '2': 	dictionary.addFromKeyboard( keyboard );
						break;
			case '3':	System.out.println("Enter name of file to process: ");
						String file = keyboard.next();
						
						try (Scanner infile = new Scanner (Paths.get( file ))){
							dictionary.addFromFile ( infile );
						} catch (IOException ioe) {
							System.out.println("File doesnt exist!");
						} catch (Exception e) {
							System.out.println("Error 404: Not Found!");
						}
						
						break;
			case '4':	dictionary.checkWord( keyboard );
						break;
			case '5':	System.out.println("There are " + dictionary.getCount() + " nodes");
						break;
			case '6':	System.out.println("Quit!");
						break;
			default:	System.out.println("Invalid! Try Again...");
						break;
			}
			
		} while ( option != '6' );
		keyboard.close();
	}

}
