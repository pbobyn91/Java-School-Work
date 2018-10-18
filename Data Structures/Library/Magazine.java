import java.util.Scanner;
/************************************************************************************************************
Purpose:  Creates an instance of Magazine. This is an extension of class Resource.
Author:  Patrick Bobyn
Course: F2018 - CST8130
Lab Section: CST8130-303
Date: 01/10/2018
Data members:  edition: MyDate - sets the date that this magazine was created

Methods: default constructor - does nothing
		 inputResource (Scanner,MyDate): boolean - Adds a resource using class Magazine as a template. Returns true if 
		 											it works correctly.
		 toString (): String - prints out a string with all the Magazine class data.  

*************************************************************************************************************/
public class Magazine extends Resource {

	// protected instance variables
	protected MyDate edition = new MyDate();
	
	// default constructor
	public Magazine () {
	}
	
	public boolean inputResource ( Scanner in, MyDate date ) {
	
		super.inputResource( in, date ); // pass values to resource class
		this.overDueCost = 1;
		
		// add 7 days for a due date
		for (int i = 0; i < 7; i++) {
			this.dueDate.addOne();
		}
		
		System.out.println("Enter the edition date: ");
		edition.inputDate( in );
		
		return true;
	}
	
	// prints out a magazine 
	public String toString() {
		String output = String.format("edition %s. %s", edition.toString(), super.toString() );
		return output;
	}
}
