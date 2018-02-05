/** 	Created by Patrick Bobyn
 *  	Course: Object Oriented (CST 8132-310)
 *  	Lab Section: 312
 */
public class Account {
	// declare instance variables 
	private long accNumber;
	private Customer accHolder;
	private double balance = 0;
	
	// constructor to initialize accNumber and accHolder
	public Account (long accNumber, Customer accHolder) {
		// initialize the accNumber and accHolder instances
		this.accNumber = accNumber;
		this.accHolder = accHolder;
	}
	
	// method for deposits
	public void deposit (double amount) {
		// add amount to balance
		this.balance += amount;
	}
	
	// method for withdrawals
	public void withdraw (double amount) {
		// withdraw amount from balance
		this.balance -= amount;
	}
	
	// method to get accNumber
	public long getAccNumber () {
		// return the objects accNumber
		return this.accNumber;
	}
	
	// method to get accHolder
	public Customer getAccHolder () {
		// return the accHolder
		return this.accHolder;
	}
	
	// method to get balance
	public double getBalance() {
		// return the balance
		return this.balance;
	}
}
