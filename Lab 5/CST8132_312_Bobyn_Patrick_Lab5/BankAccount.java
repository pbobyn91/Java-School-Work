/* Class: BankAccount.java
 * Created by: Patrick Bobyn, 040889706
 * Course: Object Oriented (CST 8132-310)
 * Lab Section: 312
 * Assignment: Lab 5
 * Date: March 27th, 2018
 * Professor: Angela Giddings
 */

package lab5;

import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * Class Bank Account is a parent class meant to start all the bank account types we can have.
 * 
 * @author Pat
 * @version 1.6
 */

public abstract class BankAccount {
	
	protected int accNumber;
	protected double balance;
	protected String accType;
	protected Customer accHolder;
	
	/**
	 * A method to add accounts to the bank. This is a super class.
	 * 
	 * @return Returns true or false depending on whether the account is created or not.
	 */
	
	public boolean addBankAccount () {
		
		// Try catch for Account Information
		try {
			
			// Create Scanner
			Scanner input = new Scanner ( System.in );
			
			// Get Account Information
			System.out.print ("Enter the Account Number: ");
			accNumber = input.nextInt();
			System.out.print ("Enter the Account Balance: ");
			balance = input.nextDouble();
			
			// Get Customer Information; name, email, phone number
			System.out.print("Enter Customers first name: ");
			String fName = input.next();
			System.out.print("Enter Customers last name: ");
			String lName = input.next();
			System.out.print("Enter Customers email: ");
			String email = input.next();
			System.out.print("Enter Customers phone number: ");
			long phone = input.nextLong();
			accHolder = new Customer (fName, lName, email, phone);
			
			for (int i = 0; i < Bank.numAccounts; i++) {
				if (accNumber == Bank.accounts[i].getAccNumber()) {
					throw new Exception();
				}
			}
			
			// If statements to throw exceptions
			if (accNumber <= 100 || accNumber >= 999)
				throw new IllegalArgumentException();
			if (balance <= 0)
				throw new IllegalArgumentException();
			
			// Catch the exceptions and return false if anything caught
		} catch (IllegalArgumentException iae) {
			System.out.println("Sorry, this account had an incorrect value.");
			return false;
		} catch (Exception e) {
			System.out.println("Sorry, this is not a correct Account");
			return false;
		}
			
		// return true if nothing caught
		return true;
	}
	
	/**
	 * A string method meant to return a the account information
	 * 
	 * @return Returns a string of all the account information
	 */
	
	public String toString() {
		DecimalFormat dollar = new DecimalFormat("$,000.00"); 
		
				// Return String of all account info
		return String.format("%s %d\nBalance: %s\n%s",
				accType, accNumber, dollar.format(balance), accHolder.toString() );
	}
	
	/**
	 * A method to deposit the a given amount into the account
	 * 
	 * @param amount The amount to be deposited
	 */
	
	public void deposit (double amount) {
		balance += amount;
	}
	
	/**
	 * A method to withdraw an amount from the account
	 * 
	 * @param amount The amount to be withdrawn
	 * @throws InsufficientFundsException This throws this exception if the amount to be withdrawn is greater than the balance
	 */
	
	public void withdraw (double amount) throws InsufficientFundsException {
		if (Math.abs(amount) > balance)
			throw new InsufficientFundsException();
			
		balance -= Math.abs(amount);
	}
	
	/**
	 * An abstract class that is meant to update each account.
	 */
	
	public abstract void calculateAndUpdateBalance ();
	
	/**
	 * A method to return the account number
	 * 
	 * @return Returns the Account Number
	 */
	
	public int getAccNumber () {
		// Return the account number
		return accNumber;
	}
}
