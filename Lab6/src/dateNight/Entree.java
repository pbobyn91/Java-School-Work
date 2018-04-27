/* Class: Entree.java
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
 * This class instantiates an entree, it has a price and a name
 * 
 * @author Pat
 * @version 1.0
 */

public class Entree extends MenuItem {
	
	/**
	 * The Constructor for Entree. Sends the entrees to a its super (MenuItem.java)
	 * 
	 * @param name The name of the meal.
	 * @param price The price of the meal.
	 */
	
	public Entree (String name, double price) {
			super (name, price);
	}
}
