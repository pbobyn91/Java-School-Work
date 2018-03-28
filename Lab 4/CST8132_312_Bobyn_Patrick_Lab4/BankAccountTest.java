/*	Class: BankAccountTest.java
 * 	Created by Patrick Bobyn, 040889706
 *  Course: Object Oriented (CST 8132-310)
 *  Lab Section: 312
 *  Assignment: Lab 4
 *  Date: Feb 12th 2018
 *  Professor: Angela Giddings
 */

/**
 * The Main class for lab 4. Creates an object and runs a few processes. 
 * 
 * @author Pat
 * @version 1.0
 */

public class BankAccountTest {
	// create an instance variable of BankAccount
	private BankAccount[] bankAccount = new BankAccount[4];
	
	/**
	 * A constructor for BankAccountTest. Creates 4 instance of Bank Accounts, 2 chequing
	 * and 2 savings
	 */
	
	// Constructor to create 4 bank Accounts, 2 chequing and 2 savings
	public BankAccountTest() {
		// initialize 4 accounts, 2 Savings and 2 Chequings
		for (int i = 0; i < 4; i++) {
			if (i % 2 == 0) {
				bankAccount[i] = new ChequingAccount(Math.random()*100);
			} else {
				bankAccount[i] = new SavingsAccount(Math.random()*100);
			}
		}
	}
	
	/**
	 * Runs a monthly process for each account
	 * 
	 * @param accounts An array of each account in the Bank
	 */
	
	// run a process each month
	public static void monthlyProcess(BankAccount[] accounts) {
		// enhanced for loop for each account and
		// call the method update
		for (BankAccount account : accounts) {
			account.calculateAndUpdateBalance();
		}
	}
	
	/**
	 * The method to display each account
	 * 
	 * @param accounts An array of each account in the Bank
	 */
	
	// Display the accounts
	public static void display(BankAccount[] accounts) {		
		// for loop to print each account 
		int i = 1;
		for (BankAccount account : accounts) {
			System.out.printf("Account type: %s \t%d\tBalance: %.2f%n", 
					account.getClass().getName(), 
					i++,
					account.getBalance());
		}
	}
	
	/** 
	 * The Main function
	 * 
	 * @param args the mains arguments
	 */
	
	// MAIN
	public static void main(String[] args) {
		// create object of BankAccountTest
		BankAccountTest bank = new BankAccountTest();
		
		// display first month
		System.out.println("Month: 0");
		display(bank.bankAccount);
		
		// for loop to run 12 months and 
		// call methods to perform monthly process and display the accounts
		for (int i = 1; i <= 12; i++) {
			monthlyProcess(bank.bankAccount);
			System.out.println("\nMonth: " + i);
			display(bank.bankAccount);
		}
	}
}