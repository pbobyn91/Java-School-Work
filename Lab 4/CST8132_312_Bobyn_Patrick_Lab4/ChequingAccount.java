/*	Class: ChequingAccount.java
 * 	Created by Patrick Bobyn, 040889706
 *  Course: Object Oriented (CST 8132-310)
 *  Lab Section: 312
 *  Assignment: Lab 4
 *  Date: Feb 12th 2018
 *  Professor: Angela Giddings
 */

/** 
 * An extension of class BankAccount called ChequingAccount
 * 
 * @author Pat
 * @version 1.0
 */

public class ChequingAccount extends BankAccount {
	private double monthlyFee = 0.50;
	
	/**
	 * The constructor for Chequing Account. Calls the constructor for Bank Account
	 * 
	 * @param balance Sets the balance
	 */
	
	// Constructor to set up a Chequing Account
	public ChequingAccount (double balance) {
		super(balance);
	}
	
	/**
	 * The overridden method to calculate and update the bank account
	 * 
	 * @return Returns the updated balance
	 */
	
	// Overridden method to update the balance 
	@Override 
	public double calculateAndUpdateBalance() {
		// subtract the fee
		balance = getBalance() - monthlyFee;
		return balance;
	}
}
