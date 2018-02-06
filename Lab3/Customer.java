/*	Class: Customer.java
 * 	Created by Patrick Bobyn, 040889706
 *  Course: Object Oriented (CST 8132-310)
 *  Lab Section: 312
 *  Assignment: Lab 3
 *  Date: Feb 6th 2018
 *  Professor: Angela Giddings
 */

/** 
 * This class is designed to create a customer for 
 * the account class.
 * 
 * @author Pat
 * @ version 1.0
 */

public class Customer {
	// Declare the instance variables
	private String firstName;
	private String lastName;
	private long phoneNum;
	private String emailAddress;
	
	/**
	 * Constructor for Customer
	 * 
	 * @param firstName Customers first name
	 * @param lastName Customers last name
	 */
	
	// Constructor to initialize first and last names
	public Customer (String firstName, String lastName) {
		// initialize objects first name and last name to parameters
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	/**
	 * Get method designed to return the customers full name
	 * 
	 * @return Returns Customers full name (First Name & Last Name)
	 */
	
	// method to get names
	public String getName() {
		String name = (this.firstName + " " + this.lastName);
		return name;
	}
	
	/**
	 * Get method designed to return customers phone number
	 * 
	 * @return Returns Customers Phone Number
	 */
	
	// method to get phoneNumber
	public long getPhoneNumber() {
		// return phone number of this object
		return this.phoneNum;
	}
	
	/**
	 * Sets the phone number for each instance of Customer
	 * 
	 * @param phoneNum Is the phone number for each customer
	 */
	
	// method to set phoneNumber
	public void setPhoneNumber(long phoneNum) {
		// set objects phonesNum = parameter
		this.phoneNum = phoneNum;
	}
	
	/**
	 * Gets the Customers email address
	 * 
	 * @return Returns email address
	 */
	
	// method to get email address
	public String getEmailAddress() {
		// return objects email
		return this.emailAddress;
	}
	
	/**
	 * Sets the Customers email address
	 * 
	 * @param emailAddress Is the Customers email address
	 */
	
	// method to set email
	public void setEmailAddress (String emailAddress) {
		// set objects emailAddress = parameter
		this.emailAddress = emailAddress;
	}
}
