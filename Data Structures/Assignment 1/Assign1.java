import java.util.Scanner;
/************************************************************************************************************
Purpose:  This is the main class for the entire library. This class prints out a menu for the user to select from. It then proceeds
		  to the required aspect within class Library to work perform the user request. Every class links back to this one.
Author:  Patrick Bobyn
Course: F2018 - CST8130
Lab Section: CST8130-303
Date: 01/10/2018
Data members:  --

Methods: main (String[]): void - The main method for all of the library system. It prints off a menu for the user to pick an option from
				 				 and then the library runs through that process. The entire program handles all problems that can arise.
         

*************************************************************************************************************/
public class Assign1 {
	
	// menu for processing which contains the field todayDate
	public static void main (String [] args) {
		
		// bring in new options
		Scanner keyboard = new Scanner (System.in);
		int option;
		
		// create instances of other classes
		Library library = new Library( keyboard );
		MyDate today = new MyDate();
		
		System.out.println("What is today's date:");
		today.inputDate(keyboard);
		
		do {
			System.out.println();
			option = 0;
			// Output the menu
			System.out.println("Enter 1 to add to resources,\n2 to display overdue items,\n"
						 + "3 to display all resources borrowed,\n4 to delete a resource,\n"
						 + "5 to change todays date,\n6 to quit: ");
		
			// get user input
			if (keyboard.hasNextInt()) {
				option = keyboard.nextInt();
			} else {
				keyboard.next();
			}
			
			
			// test options from user
			if (option == 1) { // adds a resource													-- DONE
				library.inputResource( keyboard, today );
				
			} else if (option == 2) { // display overdue items										-- DONE
				System.out.println( library.resourcesOverDue(today) );
				
			} else if (option == 3) { // display all borrowed resources								-- DONE
				System.out.println( library.toString() );
				
			} else if (option == 4) { // delete a resource											-- DONE
				library.deleteResource( today, keyboard );
				
			} else if (option == 5) { // change todays date											-- DONE
				System.out.println("Enter a new date for today's date:");
				today.inputDate( keyboard );
				
			} else if (option == 6) { // quit   													-- DONE
				System.out.println("Quitting");
			
			} else {											// 									-- DONE		
				System.out.println("Invalid Option!!");
			}
			
		} while (option != 6);
		
		keyboard.close();
	}
}
