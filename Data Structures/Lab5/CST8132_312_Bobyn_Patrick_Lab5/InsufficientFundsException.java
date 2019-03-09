/* Class: InsufficientFundsException.java
 * Created by: Patrick Bobyn, 040889706
 * Course: Object Oriented (CST 8132-310)
 * Lab Section: 312
 * Assignment: Lab 5
 * Date: March 27th, 2018
 * Professor: Angela Giddings
 */

package lab5;

/**
 * Creates an extension of class Exception so that this bank applicaton can use it.
 * 
 * @author Pat
 * @version 1.0
 */

public class InsufficientFundsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * A constructor that doesn't except any arguments
	 */
	
	public InsufficientFundsException() {
		super("Insufficient funds available.");
	}
	
	/**
	 * A 2nd constructor that accepts arguments.
	 * 
	 * @param message An argument passed to this constructor which is a message.
	 */
	
	public InsufficientFundsException(String message) {
		super(message);
	}

}
