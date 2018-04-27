/* Class: Bill.java
 * Created by: Patrick Bobyn, 040889706
 * Course: Object Oriented (CST 8132-310)
 * Lab Section: 312
 * Assignment: Lab 6
 * Date: April 26th, 2018
 * Professor: Angela Giddings
 */

package dateNight;

import java.util.ArrayList;
import java.util.HashMap;

import cst8132.restaurant.Appetizer;
import cst8132.restaurant.Drink;
import cst8132.restaurant.MenuItem;

/**
 * The Bill class is meant to calculate the final price of the date night.
 * 
 * @author Pat
 * @version 1.0
 */

public class Bill {

	private HashMap<String,ArrayList<MenuItem>> orders = new HashMap<String,ArrayList<MenuItem>>(4);
	
	private boolean isHappyHour = false;
	private double subtotal;
	private double hstRate = 0.15;
	private final int MAX_MENU_ITEM_LENGTH = 30;
	
	/**
	 * A method meant to determine if its happy hour
	 * 
	 * @return Returns a boolean to determine happy hour.
	 */
	
	public boolean getHappyHour() {
		return isHappyHour;
	}
	
	/**
	 * A method meant to set happy hour.
	 * 
	 * @param isHappyHour Takes a boolean to determine happy hour.
	 */
	
	public void setHappyHour (Boolean isHappyHour) {
		this.isHappyHour = isHappyHour;
	}
	
	/**
	 * A list of the meals ordered for the night
	 * 
	 * @return Returns the orders.
	 */
	
	public HashMap<String, ArrayList<MenuItem>> getOrders () {
		return orders;
	}
	
	/**
	 * Gets the total before taxes for the meal.
	 * 
	 * @return Returns the total before taxes.
	 */
	
	public double getSubtotal () {
		return subtotal;
	}
	
	/**
	 * Determines the taxes for the meal
	 * 
	 * @return Returns the tax for the meal.
	 */
	
	public double getHst () {
		return ((subtotal - getHappyHourDiscount()) * hstRate);
	}
	
	/**
	 * Gets the tax rate.
	 * 
	 * @return Returns the tax rate for the night.
	 */
	
	public double getHstRate () {
		return hstRate;
	}
	
	/**
	 * A method to return the full total for the night.
	 * 
	 * @return Returns the total with taxes.
	 */
	
	public double getTotal() {
		return (subtotal - getHappyHourDiscount() + getHst() );
	}
	
	/**
	 * A method to create the bill based off the meals for the night
	 * 
	 * @param guest The person who ordered the meal
	 * @param item The meal the person ordered
	 * @return returns a boolean
	 */
	
	public boolean addOrderItem(String guest, MenuItem item) {
		
		ArrayList<MenuItem> o = orders.getOrDefault(guest, new ArrayList<MenuItem>(4));
		o.add(item);
		
		orders.put(guest, o);
		
		subtotal += item.getPrice();

		return true;
	}
	
	/** 
	 * A method to determine if happy hour is in effect
	 * 
	 * @return Returns a number to determine if its happy hour
	 */
	public double getHappyHourDiscount() {
		
		double happyHourDiscount = 0;
		
		if (!isHappyHour)
			return 0;
		
		for (ArrayList<MenuItem> a : orders.values()) {
			
			for (MenuItem m : a) {
		
				if (m instanceof Drink) {
					happyHourDiscount += 2;
				}
				
				if (m instanceof Appetizer) {
					happyHourDiscount += m.getPrice() / 2;
				}
	
			}
			
		}
		
		return happyHourDiscount;
	}
	
	/**
	 * A method to print off the menu items.
	 */
	
	public String toString() {
		
		String s = "";
		String format = "\t%-" + MAX_MENU_ITEM_LENGTH + "s \t $%6.2f\n";
		
		for (String o : orders.keySet()) {
			
			s += "Dinner Guest: " + o + "\n";
			
			for (MenuItem item : orders.get(o)) {
				s += String.format(format, item.getName(), item.getPrice());
			}
			
			s += "\n";
			
		}

		s += String.format(format, "Subtotal", getSubtotal());
		s += String.format(format, "Happy Hour Discount", getHappyHourDiscount());
		s += String.format(format, "HST " + (int) (hstRate * 100) + "%", getHst());
		
		s += String.format(format, "Total", getTotal());
		
		return s;
	}
	
}