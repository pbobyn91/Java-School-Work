/*	Class: BankAccount.java
 * 	Created by Patrick Bobyn, 040889706
 *  Course: Object Oriented (CST 8132-310)
 *  Lab Section: 312
 *  Assignment: Lab 4
 *  Date: Feb 12th 2018
 *  Professor: Angela Giddings
 */

/**
 * This is an abstract class called BankAccount. It leads to SavingsAccount and ChequingAccount.
 * 
 * @author Pat
 * @version 1.0
 * 
 * @param balance Sets the balance for each account.
 */

public abstract class BankAccount {
	// instance of BankAccount 
	public double balance;
	
	/**
	 * The Constructor for BankAccount. 
	 * 
	 * @param balance Sets the balance for each account.
	 */
	
	// constructor to initialize balance
	public BankAccount(double balance) {
		this.balance = balance;
	}
	
	/**
	 * A method to get the Balance of each account
	 * 
	 * @return Returns the balance
	 */
	
	// method to return Balance
	public double getBalance() {
		return balance;
	}
	
	/**
	 * An abstract method that gets overridden in other classes
	 * 
	 * @return Returns an updated balance
	 */
	
	// abstract method to update Balance
	public abstract double calculateAndUpdateBalance();
}
