/*	Class: Customer.java
 * 	Created by Patrick Bobyn, 040889706
 *  Course: Object Oriented (CST 8132-310)
 *  Lab Section: 312
 *  Assignment: Lab 3
 *  Date: Feb 6th 2018
 *  Professor: Angela Giddings
 */

/**
 * This is a class meant to instantiate the Banks accounts.
 * 
 * @author Pat
 * @version 1.0
 */

public class Account {
	// declare instance variables 
	private long accNumber;
	private Customer accHolder;
	private double balance = 0;
	
	/**
	 * A Constructor meant to create the Account instance with
	 * a Customer and number field
	 * 
	 * @param accNumber The Customers account Number.
	 * @param accHolder An instance of class Customer.
	 */
	
	// constructor to initialize accNumber and accHolder
	public Account (long accNumber, Customer accHolder) {
		// initialize the accNumber and accHolder instances
		this.accNumber = accNumber;
		this.accHolder = accHolder;
	}
	
	/**
	 * A method meant to deposit money into an account
	 * 
	 * @param amount The amount to be deposited
	 */
	
	// method for deposits
	public void deposit (double amount) {
		// add amount to balance
		this.balance += amount;
	}
	
	/**
	 * A method to take money out of the account
	 * 
	 * @param amount The amount being withdrawn
	 */
	
	// method for withdrawals
	public void withdraw (double amount) {
		// withdraw amount from balance
		this.balance -= amount;
	}
	
	/**
	 * A method to retrieve the Accounts Number
	 * 
	 * @return Returns the account number
	 */
	
	// method to get accNumber
	public long getAccNumber () {
		// return the objects accNumber
		return this.accNumber;
	}
	
	/**
	 * A method to retrieve the Account holder which is of class Customer
	 * 
	 * @return Returns a Customer account
	 */
	
	// method to get accHolder
	public Customer getAccHolder () {
		// return the accHolder
		return this.accHolder;
	}
	
	/**
	 * A method to return the balance of each account
	 * 
	 * @return Returns the balance in each account
	 */
	
	// method to get balance
	public double getBalance() {
		// return the balance
		return this.balance;
	}
}
