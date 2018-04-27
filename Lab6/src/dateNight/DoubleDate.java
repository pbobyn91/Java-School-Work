/* Class: DoubleDate.java
 * Created by: Patrick Bobyn, 040889706
 * Course: Object Oriented (CST 8132-310)
 * Lab Section: 312
 * Assignment: Lab 6
 * Date: April 26th, 2018
 * Professor: Angela Giddings
 */

package dateNight;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import cst8132.restaurant.Menu;
import cst8132.restaurant.Restaurant;

/**
 * This is the main class. It runs the entire date.
 * @author Pat
 * @version 1.0
 */

public class DoubleDate extends JFrame {
	
	ArrayList<String> guests = new ArrayList<String>();
	String[] movies;
	String movieTitle;
	int movieTime;
	Restaurant restaurant;
	Menu menu;
	Bill bill;
	
	Random random;
	
	JPanel inputPanel;
	JPanel guestList;
	JLabel addGuestPrompt;
	JLabel guestListHeader;
	JTextField newGuestName;
	JButton addGuest;
	JButton letsGo;
	
	/**
	 * The default constructor for date night. It creates the gui and selects the menu.
	 */
	
	public DoubleDate () {
		
		super("Double Date");
		this.setLayout( new GridLayout(2, 2) );
		
		addGuestPrompt = new JLabel ( "Enter a guest name: " );
		this.add(addGuestPrompt);
		
		guestListHeader = new JLabel ( "Guest List: " );
		this.add(guestListHeader);
		
		inputPanel = new JPanel();
		inputPanel.setLayout( new FlowLayout() );
		
		newGuestName = new JTextField(20);
		inputPanel.add(newGuestName);
		
		addGuest = new JButton ( "Add Guest to List" );
		inputPanel.add( addGuest );
		
		letsGo = new JButton ( "Let's Go" );
		inputPanel.add(letsGo);
		letsGo.setVisible( false );
		this.add(inputPanel);
		
		guestList = new JPanel( new FlowLayout() );
		this.add(guestList);
		
		setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
		setSize (500, 250);
		
		addGuest.addActionListener( new AddGuestHandler() );
		
		letsGo.addActionListener( new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				goOnDate( ( DoubleDate ) SwingUtilities.getRoot( ( Component ) e.getSource() ) ); 
				setVisible(false);
				dispose();
			}
		});
		
		restaurant = Restaurant.getInstance("The Blue Lagoon");
		menu = restaurant.getMenu();
		addMenuItems();
		
		bill = new Bill();
		
		movies = new String[3];
		movies[0] = "Indiana Jones";
		movies[1] = "James Bond";
		movies[2] = "Jason Bourne";
	}
	
	/**
	 * The method to pick the movie
	 * @param movies An array of all the movie choices.
	 * @return Returns the movie selected
	 */
	
	public String pickAMovie ( String[] movies ) {
		int num = (int) Math.random() * 3;
		return movies[num];
	}
	
	/**
	 * A method to determine what time the movie is at.
	 * @return Returns a random number between 6 and 10 for movie time
	 */
	
	public int getShowing() {
		return ((int) (Math.random() * 4 + 6) );
	}
	
	/**
	 * A method to get the menu from a text file
	 */
	
	public void addMenuItems() {
		
		try (Scanner input = new Scanner (Paths.get("menu.txt") ) ) {
			
			while (input.hasNextLine() ) {
				
				menu.addMenuItem( input.next(), input.next(), input.nextDouble() );
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		menu.addMenuItem("Drinks", "Beer", 5.99);
		menu.addMenuItem("Drinks", "Wine", 6.99);
		menu.addMenuItem("Drinks", "Coffee", 5.99);
		menu.addMenuItem("Desserts", "Cheesecake", 4.00);
		menu.addMenuItem("Desserts", "Tiramisu", 2.00);
		menu.addMenuItem("Desserts", "Ice Cream", 2.00);
		menu.addMenuItem("Appetizers", "Shrimp on the Barbie", 10.00);
		menu.addMenuItem("Appetizers", "Bruschetta", 8.00);
		menu.addMenuItem("Appetizers", "Scallops", 12.00);
		menu.addMenuItem("Entrees", "Walk-the-Plank Salmon", 15.99);
		menu.addMenuItem("Entrees", "Linguini Pescatore", 17.99);
		menu.addMenuItem("Entrees", "Pad Thai with Shrimp", 14.99);
	*/
	}
	
	/**
	 * A method to place the guest and meal on the bill
	 * 
	 * @param guest What guest is ordering this meal
	 * @param itemType What the guest has ordered
	 * @return returns the bill
	 */
	
	public boolean placeOrder (String guest, String itemType) {
		
		return bill.addOrderItem( guest, menu.getRandomMenuItem(itemType) );
	}
	
	/**
	 * The main method. Creates an instance of double date and makes the gui visible
	 * @param args A command line argument. Does nothing.
	 */
	
	public static void main (String[] args) {
		
		DoubleDate doubledate = new DoubleDate();
		doubledate.setVisible( true );
		
	}
	
	/**
	 * a method to create the entire date
	 * @param date the instance of DoubleDate
	 */
	
	public void goOnDate ( DoubleDate date ) {

		date.movieTitle = date.pickAMovie(date.movies);
		date.movieTime = date.getShowing();
		if (date.movieTime >= 5 && date.movieTime <= 7) {
			date.bill.setHappyHour(true);
		}
		
		date.placeOrder(date.guests.get(0),  "Appetizers");
		
		for (int i = 0; i <= date.guests.size()-1; i++) {
			date.placeOrder(date.guests.get(i), "Drinks");
			date.placeOrder(date.guests.get(i), "Entrees");
			
			if ((i % 2) == 0) {
				date.placeOrder(date.guests.get(i), "Desserts");
			}
		}
		
		System.out.println(date);
	}
	
	/**
	 * Paints the gui
	 */
	
	public void paint (Graphics g) {
		super.paint(g);
	}
	
	/**
	 * A method to print off the events of the night
	 */
	
	@Override
	public String toString() {
		System.out.print("Movies: ");
		for (int i = 0; i < movies.length; i++) {
			if (i != 2) {
				System.out.print(movies[i] + ", ");
			} else {
				System.out.print(movies[i]);
			}
		}
		
		System.out.printf("%nRestaurant: %s%nShowtime: %d%n", restaurant.getName(), this.movieTime);
		if (bill.getHappyHour()) {
			System.out.println("Its happy hour! $2 off drinks, and 1/2 price appetizers");
		} else {
			System.out.println("We'll be missing happy hour, but we'll still be happy");
		}
		
		menu.toString();
		printBill();
		return bill.toString();
	}
	
	/**
	 * A method to print the night to a textfile
	 */
	
	public void printBill () {
		try (Formatter output = new Formatter ("bill.txt") ) {
			output.format("%s",  bill.toString() );
			
		} catch (IOException ioe) {
			System.err.println("File can't be created.");
		}
	}
	
	/**
	 * A class to create an event handler
	 * 
	 * @author Pat
	 * @version 1.0
	 */
	
	private class AddGuestHandler implements ActionListener {
		
		public void actionPerformed (ActionEvent e) {
			String name = newGuestName.getText();
			guests.add( name );
			newGuestName.setText("");
			guestList.add(new JLabel (name) );
			letsGo.setVisible(true);
			
			if (guests.size() < 4) {
				addGuest.setVisible(true);
			} else {
				addGuest.setVisible(false);
			}
			
			guestList.validate();
			guestList.repaint();
		}
	}
}
