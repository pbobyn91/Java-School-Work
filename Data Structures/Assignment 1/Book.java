import java.util.Scanner;
/************************************************************************************************************
Purpose:  An instance of Book. This is an extension of Resource.
Author:  Patrick Bobyn
Course: F2018 - CST8130
Lab Section: CST8130-303
Data members:  author: String - who is the author of this instance of book.

Methods: default constructor - does nothing
		 inputResource (Scanner, MyDate): boolean - gets input from the user to create an instance of Book.
		 											Sends the user to the super class and then gets additional 
		 											information.
         toString (): String - prints out information for the book.
         

*************************************************************************************************************/
public class Book extends Resource {
	
	// create additional variables
	protected String author;
	
	// default constructor
	public Book () {
	}
	
	public boolean inputResource ( Scanner in, MyDate date ) {
		
		super.inputResource( in, date ); // pass values to resource class
		this.overDueCost = 2;
		
		// add 14 days for a due date
		for (int i = 0; i < 14; i++) {
			this.dueDate.addOne();
		}
		
		System.out.println("Enter name of author (no spaces): "); // get value for type from user
		if ( in.hasNext() ) {
			this.author = in.next();
		} else {
			in.nextLine();
		}
		
		return true;
	}
	
	// prints out a book
	public String toString() {
		String output = String.format("author %s. %s", author, super.toString() );
		return output;
	}
}
