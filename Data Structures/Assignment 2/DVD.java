import java.util.Scanner;
/************************************************************************************************************
Purpose:  Creates an instance of DVD. this is an extension of Magazine.
Author:  Patrick Bobyn
Course: F2018 - CST8130
Lab Section: CST8130-303
Date: 01/10/2018
Data members:  type: String - This is the type of DVD (Bluray, DVD, etc.)

Methods: default constructor - does nothing
         inputResource (Scanner, MyDate): boolean - gets input from the user which then adds a DVD to 
         											an array. Calls the super class and then asks for type
         											of DVD.
         toString(): String - prints out a String with all DVD information.
 		 toFile(): String - prints a correctly formatted string of this type to a file
 		 addFromFile (Scanner): boolean - accepts this type from a file, it is called from library class
         

*************************************************************************************************************/
public class DVD extends Resource {

	// protected instance variables
	protected String type;
	
	// default constructor
	public DVD () {	
	}
	
	public boolean inputResource ( Scanner in, MyDate date ) {
		
		super.inputResource( in, date ); // pass values to resource class
		this.overDueCost = 1;

		// add 3 days for a due date
		for (int i = 0; i < 3; i++) {
			this.dueDate.addOne();
		}
		
		System.out.println("Enter the type of DVD (no spaces): "); // get value for type from user
		if ( in.hasNext() ) {
			this.type = in.next();
		} else {
			in.nextLine();
		}
		
		return true;
	}
	
	// prints out a DVD
	public String toString () {
		String output = String.format("Type of DVD: %s. %s", type, super.toString() );
		return output;
	}

	// sends the correctly formatted string to a file
	public String toFile() {
		String output = String.format("d %s %s", super.toFile(), type);
		return output;
	}
	
	public boolean addFromFile ( Scanner in ) {
		
		super.addFromFile( in );
		this.type = in.next();
		return true;
	}
}
