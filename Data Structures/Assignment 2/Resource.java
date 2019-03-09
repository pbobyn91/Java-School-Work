import java.util.Scanner;
/************************************************************************************************************
Purpose:  This is the super class for all types of resources. The sub classes are Book, DVD, and Magazine.
Author:  Patrick Bobyn
Course: F2018 - CST8130
Lab Section: CST8130-303
Date: 01/10/2018
Data members:  title: String - the title of the resource being borrowed.
			   borrower: String - the name of the person borrowing the resource.
			   dueDate: MyDate - the date that the resource is due back to the library. 
			   					 (Different for each type of resource)
			   overDueCost: float - this is the cost of the resource if its overdue. (depends
			   						on type of resource).

Methods: default constructor - does nothing
     	 inputResource (Scanner, MyDate): boolean - This is the super class for all resources. It gets called
     	 											by each subclass of Resource. Gets user input for each resource
     	 											and then returns to the subclass which calls this method.
 		 addFromFile (Scanner): boolean - accepts this type of data from a file, this is called from the subclasses
     	 toString(): String - prints a string of the resource. This is called by each subclass as well.
     	 isOverDue (MyDate): boolean - Checks to see if the resource is over due. Returns true if this resource is over 
     	 							   due. Otherwise it returns false.
     	 displayDueDate (): void - prints out the resource by calling the classes toString.
 		 toFile (): String - prints this as a correctly formatted string to a file, this is called from its subclasses


*************************************************************************************************************/	
public class Resource {
	
	// create protected instance variables
	protected String title;
	protected String borrower;
	protected MyDate dueDate;
	protected float overDueCost;
	
	// default constructor
	public Resource () {
	}
	
		
	// reads the scanner past in and uses MyDate as todays date
	// and fills the proper fields with the correct data
	// returns true if successful
	public boolean inputResource ( Scanner in, MyDate date) {
		
		// get the title of the resource
		System.out.println("Enter title being borrowed: (No Spaces)");
		if ( in.hasNext() ) {
			this.title = in.next();
		} else {
			in.nextLine();
		}
		
		// get the name of the borrower
		System.out.println("Enter borrower name: (No Spaces)");
		if ( in.hasNext() ) {
			this.borrower = in.next();
		} else {
			in.nextLine();
		}
		
		this.dueDate = new MyDate( date ); // set the due date equal to the date being passed in
		
		return true;
	}

	// gets input from a file and saves each value into the correct location
	public boolean addFromFile ( Scanner in ) {
		
		this.title = in.next();
		this.borrower = in.next();
		this.dueDate = new MyDate ();
		this.dueDate.inputDate( in );
		this.overDueCost = in.nextFloat();
		return true;
	}
	
	// a to String function
	public String toString() {
		// create and return an instance of each resource
		String output = String.format("%s has %s due on %s and if late %.2f", borrower, title, dueDate.toString(), overDueCost);
		return output;
	}
	
	// returns true if the DueDate is greater than the parameter todays date
	public boolean isOverDue ( MyDate date ) {
		
		if ( this.dueDate.isGreaterThan( date )) { // check if the resource is overdue
			return true;
			
		} else { // otherwise return false
			return false;
		}
	}
	
	// displays the borrower and cost for overdue resource 
	public void displayDueDate() {
		System.out.println( this.toString() );
	}

	// sends a String back for the correct output to a file
	public String toFile() {
		
		String output = String.format("%s %s %s %.1f", title, borrower, dueDate.toFile(), overDueCost);
		return output;
	}
}
