/* Class: Customer.java
 * Created by: Patrick Bobyn, 040889706
 * Course: Object Oriented (CST 8132-310)
 * Lab Section: 312
 * Assignment: Lab 5
 * Date: March 27th, 2018
 * Professor: Angela Giddings
 */

package lab5;

/**
 * This is the customer class. It creates an instance of accHolder in the bank account classes.
 * 
 * @author Pat
 * @version 1.0
 */

public class Customer implements Comparable<Customer>{

	private String firstName;
	private String lastName;
	private String email;
	private long phoneNum;
	
	/**
	 * A constructor for the class customer.
	 * 
	 * @param firstName The first name of the customer
	 * @param lastName The last name of the customer
	 * @param email	The email of the customer
	 * @param phoneNum The phone number of the customer
	 */
	
	public Customer ( String firstName, String lastName, String email, long phoneNum ) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNum = phoneNum;
		
	}
	
	/**
	 * A method to give the name of account holder
	 * 
	 * @return Returns a string of the first and last names
	 */
	
	public String getName() {
		return String.format("%s %s", firstName, lastName);
	}
	
	/**
	 * A method to return a string composed of the account holders email
	 * 
	 * @return Returns the email of the account holder
	 */
	
	public String getEmail() {
		return String.format("%s", email);
	}
	
	/**
	 * A method to return a string made of the account holders phone number
	 * 
	 * @return Returns the phone number of the account holder
	 */
	
	public String getPhoneNumber() {
		return String.format("%d", phoneNum);
	}
	
	/**
	 * A method to return a string made up of all the account holders information
	 * 
	 * @return Returns a string made up of all the account holders information
	 */
	
	public String toString() {
		
		return String.format("Name: %s\nEmail: %s\nPhone: %s",
				getName(), getEmail(), getPhoneNumber()); 
	}

	/**
	 * A method meant to compare the customers information to another customers information
	 * 
	 * @returns Returns an integer 
	 */
	
	public int compareTo(Customer customer) {
		
		return getName().compareTo(customer.getName());
		
	}	
}
