/* Class: SavingsAccount.java
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
 * A subclass of Bank Account. Creates a savings account.
 * 
 * @author Pat
 * @version 1.2
 */
public class SavingsAccount extends BankAccount {
	
	// Instance variables
	protected double monthlyInterestRate;
	protected double minBalance;
	
	/**
	 * A method to create the savings account.
	 * 
	 * @return Returns a boolean to determine whether account will be created or not.
	 */
	
	public boolean addBankAccount () {
		
		// try catch for the whole class
		try {
			
			// create scanner
			Scanner input = new Scanner ( System.in );
			
			accType = "Savings Account";
			boolean trueFalse = super.addBankAccount();
			
			// go to super, avoid rewriting code
			if ( trueFalse ) {
				
				System.out.print("What is the monthly interest rate: ");
				monthlyInterestRate = input.nextDouble();
			
				System.out.print("What is the minimum balance: ");
				minBalance = input.nextDouble();
			}
			
			// Exception arguments
			if (monthlyInterestRate <= 0 || monthlyInterestRate >= 1)
				throw new IllegalArgumentException();
			if (minBalance <= 5 || minBalance >= 100)
				throw new IllegalArgumentException();
			
		} catch (IllegalArgumentException iae) {
			System.out.println("Sorry, either your interest rate or your minimum balance isn't to standards!");
			return false;
		} catch (Exception e) {
			System.out.println("Sorry, something went wrong.");
			return false;
		}
		
		Bank.numAccounts++;
		return true;
	}
	
	/**
	 * A method to calculate all savings accounts monthly updates
	 */
	
	@Override
	public void calculateAndUpdateBalance () {
		if (balance > minBalance) {
			balance += (balance * monthlyInterestRate);
		} else {
			System.out.print("Savings Account: Sorry, not enough money in the acccount to add the monthly interest rate.");
		}
	}
	
	/**
	 * A method to return all account information
	 * 
	 * @return Returns a string with all the account information
	 */
	
	public String toString () {
		DecimalFormat dollar = new DecimalFormat("$,000.00");
		
		// return string of all account info
		return String.format("%s %d\nBalance: %s\n%s\n",
				accType, accNumber, dollar.format(balance), accHolder.toString() );
	}
}
