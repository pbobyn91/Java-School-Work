/*	Class: SavingAccount.java
 * 	Created by Patrick Bobyn, 040889706
 *  Course: Object Oriented (CST 8132-310)
 *  Lab Section: 312
 *  Assignment: Lab 4
 *  Date: Feb 12th 2018
 *  Professor: Angela Giddings
 */

/**
 * This is SavingsAccount class which is an extension of BankAccount.
 * 
 * @author Pat
 * @version 1.0
 */

public class SavingsAccount extends BankAccount {
	// declare and initialize the Interest Rate
	private double annualInterestRate = 0.1;
	
	/**
	 * The constructor that sets the balance through BankAccounts constructor 
	 * 
	 * @param balance Sets the balance for this Savings Account
	 */
	
	// Constuctor to set up Savings Account
	public SavingsAccount (double balance) {
		super(balance);
	}
	
	/**
	 * An overridden method to calculate and update the balance
	 * 
	 * @return Returns the updated balance
	 */
	
	// Override method to change the balance
	@Override
	public double calculateAndUpdateBalance() {
		
		// add interest for every month
		double InterestRate = annualInterestRate / 12;
		balance = getBalance() + (getBalance() * InterestRate);
		return balance;
	}
}
