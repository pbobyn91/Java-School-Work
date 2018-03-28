/* Class: OverdrawnAccountException.java
 * Created by: Patrick Bobyn, 040889706
 * Course: Object Oriented (CST 8132-310)
 * Lab Section: 312
 * Assignment: Lab 5
 * Date: March 27th, 2018
 * Professor: Angela Giddings
 */

package lab5;

/**
 * An extension of class Exception meant to handle specific problems that will show up.
 * 
 * @author Pat
 * @version 1.0
 */

public class OverdrawnAccountException extends Exception {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * A constructor that prints a message.
	 */
	
	public OverdrawnAccountException() {
		super("Overdrawn Funds would put the account into the negative.");
	}
	
	/**
	 * A constructor that prints off a second message if passed.
	 * 
	 * @param message The message the constructor passes.
	 */
	
	public OverdrawnAccountException(String message) {
		super(message);
	}
}
