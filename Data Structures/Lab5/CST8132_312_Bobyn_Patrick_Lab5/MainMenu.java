/* Class: MainMenu.java
 * Created by: Patrick Bobyn, 040889706
 * Course: Object Oriented (CST 8132-310)
 * Lab Section: 312
 * Assignment: Lab 5
 * Date: March 27th, 2018
 * Professor: Angela Giddings
 */

package lab5;

import java.util.Scanner;

/**
 * The Main Class for this bank application. Offers a menu to users and then sends the program to where it needs to go.
 * 
 * @author Pat
 * @version 1.1
 */

public class MainMenu {
	
	/**
	 * The main method. This calls the display menu function that prints off a menu that the user gets to choose from. 
	 * 
	 * @param args The main methods args
	 */
	
	// MAIN
	public static void main(String[] args) {
		
		// create local variables
		Scanner input = new Scanner(System.in);
		char option = 'x';
		
		// create bank
		Bank bank;
		
		// get the name of bank
		System.out.print("Enter the name of the bank: ");
		String bankName = input.nextLine();
		
		// give bank a name
		bank = new Bank(bankName);
		
		// do loop to get what the user wants to do with bank
		do {
			
			// display menu and get option from user
			displayMenu();
			option = input.next().toLowerCase().charAt(0); 
			
			// switch statement to select what option is to be done
			switch (option) {
			
				case 'a':
					System.out.println("\nAdding an Account: ");
					bank.addBankAccount();
					break;
					
				case 'd':
					System.out.println("\nDisplaying Account Details: ");
					bank.displayAccount();
					break;
					
				case 'u':
					System.out.println("\nUpdating Account: ");
					bank.updateAccount();
					break;
					
				case 'm':
					System.out.println("Monthly Updates: ");
					bank.monthlyUpdate();
					break;
					
				case 'q':
					break;
					
				default:
					
					System.out.println("Please enter a valid option.");
			}
			
			// while the option is not q
		} while (option != 'q');
		
		input.close();
		
		System.out.println("Have a good day!");
		
	}
	
	/**
	 * The Display menu method. This prints off a menu so the user knows what options there are. 
	 */
	
	// method to display menu
	public static void displayMenu() {
	
		System.out.println("\nEnter your choice:");
		System.out.println("a: Add new account");
		System.out.println("d: Display account details");
		System.out.println("u: Update account balance");
		System.out.println("m: Month-end update");
		System.out.println("q: Quit");
		
	}
	
}
