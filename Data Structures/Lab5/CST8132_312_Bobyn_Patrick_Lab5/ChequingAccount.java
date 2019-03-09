/* Class: ChequingAccount.java
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
 * The subclass of Bank Account. This creates a Chequing Account.
 * 
 * @author Pat
 * @version 1.4
 */

public class ChequingAccount extends BankAccount {
	
	// Instance variable
	protected double monthlyFee;
	
	/**
	 * A method to add a chequing account to the bank.
	 * 
	 * @return Returns a boolean to determine whether account was created.
	 */
	
	public boolean addBankAccount () {
		try {
			
			accType = "Chequing Account";
			boolean trueFalse = super.addBankAccount();
			// go to super class, avoid rewriting code
			 if ( trueFalse ) {
				
				Scanner input = new Scanner (System.in);
				
				System.out.print("What is the monthly fee: ");
				monthlyFee = input.nextDouble();
				
			} else {
			 	return false;
			}
			
			
			if (monthlyFee < 5 || monthlyFee > 10)
				throw new IllegalArgumentException();
	
		} catch (IllegalArgumentException iae) {
			System.out.println("Sorry, that is an invalid monthly fee.");
			return false;
		} catch (Exception e) {
			System.out.println("Sorry, something went wrong.");
			return false;
		}
		
		Bank.numAccounts++;
		return true;
	}
	
	/**
	 * A method to update each account with its monthly fees
	 */
	
	@Override
	public void calculateAndUpdateBalance () {
		
		try {
			balance -= monthlyFee;
			
			if (balance <= 0)
				throw new OverdrawnAccountException();
		} catch (OverdrawnAccountException oae) {
			System.out.println("Chequing Account: Sorry, you don't have the correct amount of funds.");
		} catch (Exception e) {
			System.out.println("Sorry, something happened. We are not sure what but we will help you.");
		}
	}
	
	/**
	 * A method to return all the account information
	 * 
	 * @return Returns a string with all the account information
	 */
	
	public String toString () {
		DecimalFormat dollar = new DecimalFormat("$,000.00");
		
		// return string of all account info
		return String.format("%s %d\nBalance: %s\n%s\n",
				accType, accNumber, dollar.format(balance), accHolder.toString());
	}
}
