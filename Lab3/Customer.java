/** 	Created by Patrick Bobyn
 *  	Course: Object Oriented (CST 8132-310)
 *  	Lab Section: 312
 */
public class Customer {
	// Declare the instance variables
	private String firstName;
	private String lastName;
	private long phoneNum;
	private String emailAddress;
	
	// Constructor to initialize first and last names
	public Customer (String firstName, String lastName) {
		// initialize objects first name and last name to parameters
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	// method to get names
	public String getName() {
		String name = (this.firstName + " " + this.lastName);
		return name;
	}
	
	// method to get phoneNumber
	public long getPhoneNumber() {
		// return phone number of this object
		return this.phoneNum;
	}
	
	// method to set phoneNumber
	public void setPhoneNumber(long phoneNum) {
		// set objects phonesNum = parameter
		this.phoneNum = phoneNum;
	}
	
	// method to get email address
	public String getEmailAddress() {
		// return objects email
		return this.emailAddress;
	}
	
	// method to set email
	public void setEmailAddress (String emailAddress) {
		// set objects emailAddress = parameter
		this.emailAddress = emailAddress;
	}
}
