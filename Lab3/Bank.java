/*	Class: Customer.java
 * 	Created by Patrick Bobyn, 040889706
 *  Course: Object Oriented (CST 8132-310)
 *  Lab Section: 312
 *  Assignment: Lab 3
 *  Date: Feb 6th 2018
 *  Professor: Angela Giddings
 */

import java.util.Scanner;

/**
 * This is the main class. It instantiates the Bank itself an creates individual Customers 
 * and Accounts for each Customer.
 * 
 * @author Pat
 * @version 1.0
 */

public class Bank {
	// declare instance variables
	private String bankName;
	private Account[] accounts;
	
	/**
	 * A constructor to create a bank with a name
	 * 
	 * @param bankName The banks name
	 */
	
	// constructor for bank with bankName parameter
	public Bank (String bankName) {
		// give bank its name
		this.bankName = bankName;
	}
	
	/**
	 * Returns the Banks name.
	 * 
	 * @return Returns the Banks name
	 */
	
	// method to get banks name
	public String getBankName() {
		// return the banks name
		return this.bankName;
	}
	
	/**
	 * Prints out the individual detail of each account called.
	 * 
	 * @param accounts An array of class Account
	 * @param i The variable (int) to know which Account is being called
	 */
	
	// method to print the accounts with details
	public void printAccountDetails(Account[] accounts, int i) {
		System.out.printf("Account Number: %d Name: %s Phone Number: %d Email Address: %s Balance: %.2f%n",
						accounts[i].getAccNumber(), accounts[i].getAccHolder().getName(), 
						accounts[i].getAccHolder().getPhoneNumber(), 
						accounts[i].getAccHolder().getEmailAddress(), accounts[i].getBalance());
	}
	
	/**
	 * The main method of the Bank, Account, and Customer classes. This is where 
	 * the entire bank is managed from. It initializes the banks name and creates the
	 * accounts for each customer. It then gives you options to deposit, withdraw, or
	 * print out data for each individual account.
	 * 
	 * @param args The mains argument
	 */
	
	// MAIN
	public static void main (String[] args) {
		
		// declare & initilize Scanner
		Scanner input = new Scanner (System.in);
		
		// ask for name of bank
		System.out.print("Enter your name: ");
		String name = input.nextLine();
		Bank newBank = new Bank(name);

		// ask for amount of accounts
		System.out.print("How many account holders are there in your bank system: ");
		int numAcc = input.nextInt();
		newBank.accounts = new Account[numAcc];
		
		// initialize each account
		for (int i = 0; i < numAcc; i++) {
			// ask questions
			int j = i;
			System.out.println("Enter details of account holder " + ++j);
			System.out.println("===================================");
			
			// ask for account info
			System.out.print("Enter account number: ");
			long num = input.nextLong();
			System.out.print("Enter first name of account holder: ");
			input.nextLine();
			String fName = input.nextLine();
			System.out.print("Enter last name of account holder: ");
			String lName = input.nextLine();
			System.out.print("Enter phone number: ");
			long phoneNum = input.nextLong();
			System.out.print("Enter email address: ");
			input.nextLine();
			String email = input.nextLine();
			System.out.print("Enter opening balance: ");
			double balance = input.nextDouble();
			
			// Use account holders first name and last name, then initialize
			// the other variables in customer
			Customer c = new Customer (fName, lName);
			c.setPhoneNumber(phoneNum);
			c.setEmailAddress(email);
			
			// using customer create new account
			newBank.accounts[i] = new Account(num, c);
			newBank.accounts[i].deposit(balance);
		}
		
		// print new line & account info
		System.out.println();
		// print name of bank
		System.out.println(newBank.bankName + " Banking System \n **********************");
		
		// print each account
		for (int i = 0; i < newBank.accounts.length; i++) {
			newBank.printAccountDetails(newBank.accounts, i);
		}
		input.nextLine();
		
		char option = ' ';
		do {
			// ask for user options
			System.out.print("\nd - Deposit\nw - Withdraw\np - Print\nq - Quit\nEnter your option: ");
			option = input.nextLine().charAt(0);
			
			// switch statement to go to methods
			switch (option) {
				case 'd':
					{
						// get account to deposit into
						System.out.print("Enter account index: ");
						int acc = input.nextInt();
						
						// get deposit amount
						System.out.print("Enter deposit amount: ");
						double money = input.nextDouble();
						// perform deposit
						
						newBank.accounts[acc].deposit(money);
					}
					break;
				case 'w':
					// variables
					boolean overdraw = false;
					double money = 0;
					
					// get account info and amount
					System.out.print("Enter account index: ");
					int acc = input.nextInt();
					double amount = newBank.accounts[acc].getBalance();
					
					// while statement for overdrawing
					while (!overdraw) {
						System.out.print("Enter withdrawal amount: ");
						money = input.nextDouble();
						if (money <= amount)
							overdraw = true;
					}
					
					// adjust account
					newBank.accounts[acc].withdraw(money);
					break;
				case 'p':
					// ask for which account to print
					System.out.println("Which account do you want to print: ");
					int i = input.nextInt();
					// print out account details
					System.out.println();
					newBank.printAccountDetails(newBank.accounts, i);
					break;
				case 'q':
					break;
				default:
					// no value actually declared
					System.out.println("\nEnter a valid input!!");
					break;
			}
			input.nextLine();
		} while (option != 'q');
		
			// close scanner
		input.close();
	}
}
