import java.util.Scanner;
/************************************************************************************************************
Purpose:  This class will model a simple date by keeping day, month and year information.   Leap years are NOT
               accommodated in this class.
Author:  Linda Crane and Patrick Bobyn
Course: F2018 - CST8130
Lab Section: CST8130-303
Date: 01/10/2018
Data members:  day : int - value between 1 and 31 inclusive (depending on value in month)
               month: int - value between 1 and 12 inclusive
               year: int - positive value
Methods: default constructor - sets date to Jan 1, 2018
         toString (): String - prints date in year/month/day format
         inputDate(Scanner): boolean - reads a valid date from the Scanner parameter and returns through
                                       boolean success or not
         addOne(): void - adds one to the day field and then adjusts month and year as needed.   
         isEqual (MyDate): boolean - Returns true if the 2 resources are equal. Otherwise it returns false.
         isGreaterThan (MyDate): boolean - Returns false if the product is greater than the date given to it. 
                                           Otherwise it returns false.
         

*************************************************************************************************************/
public class MyDate {
		
	// Create private instance variables
	private int day = 1;
	private int month = 1;
	private int year = 2018;
		
	// default constructor
	public MyDate() {
	}
	
	public MyDate ( MyDate date ) {
		this.day = date.day;
		this.month = date.month;
		this.year = date.year;
	}
		
	// A method to create a string
	public String toString() {   return new String ("" + year + "/" + month + "/" + day);}
		
	// Collect the input from the user
	public boolean inputDate(Scanner in) {
			
		// initialize each instance variable
		month = 0;
		day = 0; 
		year = 0;
			
		// get information for the month
		do {
					
			System.out.print ("Enter month - between 1 and 12: ");
			if (in.hasNextInt())
				this.month = in.nextInt();
			else {
				System.out.println ("Invalid month input");
				in.next();
			}
		} while (this.month <= 0 || this.month > 12);
			
		// get information for day
		do {
			System.out.print ("Enter day - between 1 and 31: ");
			if (in.hasNextInt())
				this.day = in.nextInt();
			else {
				System.out.println ("Invalid day input");
				in.next();
			}
		} while (this.day <= 0 || this.day > 31 || (this.month == 2 && this.day > 29) || (this.day > 30 && (this.month == 9 ||this.month == 4 ||this.month == 6 ||this.month == 11) ) );
			
		// get information for year
		do {
			System.out.print ("Enter year: ");
			if (in.hasNextInt())
				this.year = in.nextInt();
			else {
				System.out.println ("Invalid day input");
				in.next();
			}
		} while (this.year <= 0);
			
		return true;		
	}
		
	// add one to each date
	public void addOne (){
			
		if (this.month == 2 && this.day == 29) {
			this.month++;
			this.day = 1;
		} else if (this.day == 30 && (this.month == 9 || this.month == 4 || this.month == 6 || this.month == 11) ) {
			this.month++;
			this.day = 1;
		} else if (this.day == 31 && this.month == 12) {
			this.year++;
			this.month = 1;
			this.day = 1;
		} else if (this.day == 31) {
			this.month++;
			this.day = 1;
		} else {
			this.day++;
		}
	}	
	
	// compares 2 objects of class MyDate and returns true if their equal 
	public boolean isEqual ( MyDate date ) {
		if ( (this.year == date.year) && (this.month == date.month) && (this.day == date.day) ) {
			return true;
		} else {
			return false;
		}
	}
	
	// compares 2 objects of class MyDate and returns true if the one calling this is greater
	public boolean isGreaterThan (MyDate date ) {
		if (this.year > date.year) {
			return false;
		} else if ( (this.year == date.year) && (this.month > date.month) ) {
			return false;
		} else if ( (this.year == date.year) && (this.month == date.month) && (this.day > date.day) ) {
			return false;
		} else {
			return true;
		}
	}
}

