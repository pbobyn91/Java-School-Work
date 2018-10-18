import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;
/************************************************************************************************************
Purpose:  This class is the method main for Lab 1 
Author:  Linda Crane and Patrick Bobyn
Course: F2018 - CST8130
Lab Section: CST8130-303
                                             
         

*************************************************************************************************************/


public class Lab4 {

	public static void main(String[] args) {
		
		// create a scanner variable
		Scanner keyboard = new Scanner (System.in);
		
		// create an instance of class DueDates
		DueDates lab1 = new DueDates();
		
		do {
			boolean pass;
			do {
				pass = false;
				// create a new instance of class DueDates using number gained from user
				String path = getFilePath( keyboard );
				if (path.equals("null") ) { // if the input is null then skip over all of these steps
					System.out.println("You chose to bypass this step .... continuing");
				} else { // if input is not null check for file type
					try (Scanner file = new Scanner (Paths.get( path ) ) ) {
						lab1 = new DueDates( file.nextInt() );
						if (file.hasNextInt() ) 
							lab1.inputDueDates(file);
						
						// print the string 
						System.out.print( lab1.toString() );
						System.out.println();
					
					} catch (IOException ioe) { // file isnt found
						System.out.println("Invalid Input:" );
						pass = true;
					} catch (Exception e ) { // everything else
						System.out.println("Error 404: Not Found");
						pass = true;
					}
				}
			} while (pass);
			
			// create lab1 with an input from user
			lab1 = new DueDates( getNum(keyboard) );
			
			// get the dates to be entered into the array in class DueDates
			lab1.inputDueDates(keyboard);
			lab1.insertionSort();
			
			// print the dates and add one to them after and reprint them
			System.out.print("The due dates are:");
			System.out.println( lab1.toString() );
			lab1.addOne();
			System.out.print("The due dates with one day added are: \nThe due dates are:");
			System.out.println( lab1.toString() );
			
		} while ( Continue (keyboard) );
		
		keyboard.nextLine();
		
		// Create String for file and get user input as to what to call it
		String file = "abc";
		System.out.println("Enter name of file to write to: ");
		if (keyboard.hasNextLine() ) {
			file = keyboard.nextLine();
		} else {
			keyboard.next();
		}
		
		// print to file
		try (PrintWriter writer = new PrintWriter ( file, "UTF-8") ){ // create a new file or overwrite old one
			writer.print( lab1.length() );
			writer.print( lab1.toString() );
			writer.close();
		} catch (IOException ioe) { // handle the file not being available
			System.out.println("Error");
			ioe.printStackTrace();
		} catch (Exception e) { // every other error
			System.out.println("Error 404: Not Found:");
			e.printStackTrace();
		}
	}
	
	public static int getNum(Scanner in) {
		// create local variables
		boolean pass;
		int num = 0;
		
		// use do while to determine if this is valid
		do {
			try { 
				// ask for how many assessments are done
				pass = false;
				System.out.println("How many assessments in this course - must be greater than 0? ");
				if (in.hasNextInt()) {
					num = in.nextInt();
				} else {
					in.next();
				}
					
				// if the number of assessments is 0 or less throw an exception
				if (num <= 0)
					throw new Exception();
				
			// handle any exception
			} catch (Exception e) {
				System.out.println("Error: Please enter a number that is greater than 0!!");
				pass = true;
			}
		} while (pass);
		return num;
	}
	
	public static boolean Continue ( Scanner in ) {
		
		boolean pass;
		char cont = 'a';
		
		// ask user if they wish to do another account
		do {
			pass = false;
			System.out.println("Do another try? y/n");
			if (in.hasNext()) {
				cont = in.next().toLowerCase().charAt(0);
			} else {
				System.out.println("Invalid Input");
				in.next();
				pass = true;
			}
						
			if ( (cont == 'y' || cont == 'n') ) {
				if (cont == 'y') {
					return true;
				} else {
					return false;
				}
			} else {
				pass = true;
			}
						
		} while (pass);
		return pass;
	}
	
	public static String getFilePath (Scanner in) {
		
		// initialize variables
		String path = "";
		
		// get user input
		System.out.println("Enter name of file to import or the word null to bypass: ");
		if ( in.hasNext() ) {
			path = in.nextLine();
		} else {
			in.next();
		}
		return path; // return the path
	}
}