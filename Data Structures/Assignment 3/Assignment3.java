import java.util.Scanner;
/************************************************************************************************************
Purpose:  This is the main class for the entire application. 
Author:  Linda Crane and Patrick Bobyn
Course: F2018 - CST8130
Lab Section: CST8130 - 303
Data members:  --
Methods: main (String): void - This method is just the main menu for the entire application. It prints off the menu and then runs the correct part of the program depending on user input.
         

*************************************************************************************************************/
public class Assignment3 {

	public static void main(String[] args) {
		
		// create local variables
		Scanner keyboard = new Scanner (System.in);
		College college = new College("Algonquin");
		String menuChoice = "a";
		
		// print menu 
		while (menuChoice.charAt(0) != '6') {
			System.out.println ("\nEnter 1 to display the college courses: ");
			System.out.println ("2 to add a new course: ");
			System.out.println ("3 to add a block: ");
			System.out.println ("4 to verify chain: ");
			System.out.println ("5 to fix a chain:");
			System.out.println ("6 to quit: ");
			menuChoice = keyboard.next();
			
			switch (menuChoice.charAt(0)) {
			case '1': 	college.printBlockChain();		// Print whats in the list
					  	break;
					  	
			case '2': 	college.addCourse( keyboard );	// add a new course to the list
						break;
			          
			case '3': 	college.addBlock( keyboard );	// add a block to the one of the courses
			  		  	break;
			  		  	
			case '4': 	college.verifyChain();			// make sure the list is correct
						break;
						
			case '5': 	college.fixChain( keyboard );	// correct the a specific course if its broken
						break;
						
			case '6': 	System.out.println ("Goodbye");	// quit
					  	break;
					  	
			default:  	System.out.println ("Invalid choice...");
			}
		}
		

	}

}