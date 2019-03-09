import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
/************************************************************************************************************
Purpose:  This class will model a dynamically allocated array of Resource objects to represent the resources
           that have been borrowed from a Library
Author:  Linda Crane and xxxxxxxxxx
Course: F2018 - CST8130
Lab Section: xxxxxxxx
Data members:  resourcesBorrowed: ArrayList<Resource> - the array
               numResources: int - how many resources are currently stored in array (borrowed)
               max: int - maximum number of resources in the array (Optional - could just use array length)
Methods: default constructor - uses intitialization at declaration of 1000 spaces in array
         initial constructor (int) - initializes array to size in parameter 
         toString (): String - contents of array
         inputResource(Scanner, MyDate): boolean - reads a valid data from the Scanner parameter and the date
                           in paramter is today's date and returns through the boolean success or not
         itemsOverdue (MyDate): String - displays resources that are overdue
         deleteResource (Scanner, MyDate): - displays a list of resources and prompts user to select which to delete, then deletes it

*************************************************************************************************************/

public class Library {
	private ArrayList<LinkedList<Resource>> resourcesBorrowed = new ArrayList<LinkedList<Resource>>(1000);
	
	public Library () {
		for (int i = 0; i < 1000; i++) {
			resourcesBorrowed.add( new LinkedList<Resource>() );
		}
	}
	
	public Library (int max) {
		if (max > 0) {
			resourcesBorrowed = new ArrayList<LinkedList<Resource>>(max);
			for (int i = 0; i < max; i++) {
				resourcesBorrowed.add( new LinkedList<Resource>() );
			}
		}
		// note this defaults to 1000 by initialization if paramter max <= 0
	}
	
	public String toString() {
		String out = "\nItems currently borrowed from library are:\n";
		for (int i = 0; i < resourcesBorrowed.size(); i++)
			if (resourcesBorrowed.get(i).size() != 0)
				out += (i+1) + ": " + resourcesBorrowed.get(i).toString();
		return out;
	}
	
	public boolean inputResource(Scanner in, MyDate today) {
		
		String type = new String();
		char choice = 'k';
		while (! (choice == 'D' || choice == 'M' || choice == 'B')) {
			System.out.print ("Enter type of resource being borrowed - D for DVD, M for Magazine and B for book:");
			type  = in.next();
			type = type.toUpperCase();
			choice = type.charAt(0);
		}
		
		Resource temp;
		if (choice == 'D')
			temp= new DVD();
		else if (type.charAt(0) == 'M')
			temp = new Magazine();
		else temp = new Book();
		
		temp.inputResource(in, today);
		
		int hash = temp.getHash( 1000 );
				
		resourcesBorrowed.get(hash).add( temp );
		return true;
			
	}
	
	public String itemsOverDue(MyDate todayDate) {
		String out = "Items currently borrowed from library that are overdue as of " + todayDate.toString() + " are:\n";
		for (int i = 0; i < resourcesBorrowed.size(); i++)
			for (int j=0; j < resourcesBorrowed.get(i).size(); j++) 
				if (resourcesBorrowed.get(i).get(j).isOverDue(todayDate))
					out += (i+1) + ": " + resourcesBorrowed.get(i).toString();
		return out;
	}
	
	public void deleteResource (Scanner in, MyDate todayDate ) {
		System.out.println("Enter the title to delete: ");
		String title = in.next();
		
		Resource temp = new Resource (title);
		int hash = temp.getHash( 1000 );
		
		for (int i = 0; i < resourcesBorrowed.get(hash).size(); i++) {
			if ( resourcesBorrowed.get(hash).get(i).isEqual( temp ) ) {
				if ( resourcesBorrowed.get(hash).get(i).isOverDue( todayDate ))
					resourcesBorrowed.get(hash).get(i).displayOverDue();
				resourcesBorrowed.get(hash).remove( i );
			}
		}
	}
	
	public void displaySpecific (Scanner in) {
		System.out.print ("Enter the title to search for: ");
		String title = in.next();
		
		Resource temp = new Resource (title);
		int hash = temp.getHash( 1000 );
				
		boolean found = true;
		for (int i = 0; i < resourcesBorrowed.get(hash).size(); i++) {
			if ( resourcesBorrowed.get(hash).get(i).isEqual( temp ) ) {
				System.out.println("["+(hash+1)+"/"+i+"]: "+resourcesBorrowed.get(hash).get(i) );
				found = false;
			}
		}
		if (found)
			System.out.println("Resource with this title is not found");
	}
}
