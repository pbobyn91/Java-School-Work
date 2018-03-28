/* Class: Bank.java
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
 * The Bank class is meant to process almost all information. It takes in an input from main menu and redirects everything to where it needs to go.
 * 
 * @author Pat
 * @version 1.4
 */

public class Bank {
	
	// instance variable
	private String bankName;
	
	// class variables
	protected static Scanner input = new Scanner (System.in);
	protected static BankAccount[] accounts;
	protected static int numAccounts = 0, bankSize = 100;
	
	/**
	 * A constructor meant to initialize the bank
	 * 
	 * @param bankName The name of the bank
	 */
	
	public Bank( String bankName ) {
		
		// normal constructor
		this.bankName = bankName;
		accounts = new BankAccount [bankSize];
		
	}
	
	/**
	 * An enhanced constructor that allows the banker to input the name of the bank as well as the size of the bank.
	 * 
	 * @param bankName The name of the bank.
	 * @param bankSize The amount of accounts the bank can have
	 */
	
	public Bank(String bankName, int bankSize) {
		
		// enhanced constructor
		this.bankName = bankName;
		Bank.bankSize = bankSize;
		accounts = new BankAccount [bankSize];
		
	}
	
	/**
	 * This is the method called to add accounts to the bank. It implements the number of accounts in the bank so it knows what value it is on, it also asks the user 
	 * what type of account they want to input.
	 */
	
	public void addBankAccount() {
		
		// message for if accounts is too large
		if (numAccounts >= bankSize) {
			System.err.println("Error, a larger bank size is needed");
			return;
		}
		
		// create scanner
		Scanner input = new Scanner (System.in);
		
		// prompt for type of account
		System.out.print("Type of Account? Chequing (c) or Savings (s): ");
		char accType = input.next().toLowerCase().charAt(0);
		
		// switch case to select account type
		switch (accType) {
			case 'c':
				accounts[numAccounts] = new ChequingAccount();
				accounts[numAccounts].addBankAccount();
				break;
			case 's':
				accounts[numAccounts] = new SavingsAccount();
				accounts[numAccounts].addBankAccount();
				break;
			default:
				System.out.println("Invalid Option!");
		}
	}
	
	/**
	 * A method meant to display all accounts
	 */
	
	public void displayAccount() {
		
		// call find account method
		int account = findAccount();
		
		// prints the account
		if (account == -1) {
			System.out.println("This account does not exist.");
		} else {
			System.out.println(accounts[account].toString());
		}
	}
	
	/**
	 * A method to update the accounts
	 */
	
	public void updateAccount() {
		
		// call find account method
		int account = findAccount();
		
		// if nothing found print no account available
		if (account == -1) {
			System.out.println("There is no account to update.");
			return;
		} 
		
		// create a scanner
		Scanner input = new Scanner (System.in);
		try {
			// ask user whether they want to deposit or withdraw
			System.out.print("Enter a number to deposit/withdraw: ");
			double amount = input.nextDouble();
		
			// calls deposit or withdraw
			if (amount > 0) {
				accounts[account].deposit(amount);
			} else if (amount <= 0) {
				try {
					accounts[account].withdraw(amount);
				} catch (InsufficientFundsException ife) {
					System.out.println("Sorry you don't have the right amount of funds");
				}
			}
		} catch (Exception e) {
			System.out.println("Invalid Amount");
		}
	}
	
	/**
	 * A method to update all the accounts monthly
	 */
	
	public void monthlyUpdate() {
		// if statement to determine if there are any accounts
		// if accounts exist then calculate and update each account
		if (numAccounts == 0) {
			System.out.println("This bank has no active accounts!");
		} else {
			for (int i = 0; i < numAccounts; i++) {
				accounts[i].calculateAndUpdateBalance();
			}
		}
	}
	
	/**
	 * A method to find the accounts
	 * 
	 * @return Returns the location of the account. Returns -1 if no account exists
	 */
	
	public int findAccount() {
		
		// local variable used to search for account number
		int accountNum;
		
		try {
			
			Scanner input = new Scanner (System.in);
			
			// get input from user
			System.out.print( "Enter an account # to find: ");
			accountNum = input.nextInt();
			
		} catch (Exception e) {
			System.out.println("Invalid account.");
			return -1;
		}
		
		return searchAccounts(accountNum);
	}
	
	/**
	 * A method to sort through the accounts to find the inputed number
	 * 
	 * @param accToFind The account number to search for
	 * @return Returns the location of the number
	 */
	
	public static int searchAccounts(int accToFind) {
		
		// for statement to loop through all available accounts
		for (int i = 0; i < numAccounts; i++) {
			
			// saves the account number to a variable
			int account = accounts[i].getAccNumber();
			if (account == accToFind)
				// returns the location if the account is found
				return i;
		} 
		
		// returns -1 if account not found
		return -1;
	}
}
