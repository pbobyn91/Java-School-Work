/* Class: Dessert.java
 * Created by: Patrick Bobyn, 040889706
 * Course: Object Oriented (CST 8132-310)
 * Lab Section: 312
 * Assignment: Lab 6
 * Date: April 26th, 2018
 * Professor: Angela Giddings
 */

package dateNight;

import cst8132.restaurant.MenuItem;

/**
 * This is the Dessert class. It creates an object to be a dessert item in the MenuItem class
 * 
 * @author Pat
 * @version 1.0
 */

public class Dessert extends MenuItem {
	
	/**
	 * The Constructor for Dessert. Sends 2 variables to the super class (MenuItem).
	 * 
	 * @param name The name of the dessert.
	 * @param price The price of the dessert.
	 */
	
	public Dessert (String name, double price) {
		super (name, price);
	}
}
