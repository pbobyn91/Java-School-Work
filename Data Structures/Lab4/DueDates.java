import java.util.Scanner;
/************************************************************************************************************
Purpose:  This class will model a due dates for assessments in a course
Author:  Linda Crane and Patrick Bobyn
Course: F2018 - CST8130
Lab Section: CST8130-303
Data members:  

Methods:                                             
         

*************************************************************************************************************/

public class DueDates {
	
	// create an array of class MyDates
	private MyDate[] dueDates ;
	
	// default constructor that is set to 10
	public DueDates() {
		this.dueDates = new MyDate[10];
	}
	
	// overloaded constructor that takes an input from users
	public DueDates(int max) {
		this.dueDates = new MyDate[max];
	}
	
	// adds dates to the array
	public boolean inputDueDates(Scanner in) {
		for (int i = 0; i < dueDates.length; i++) {
			dueDates[i] = new MyDate();
			dueDates[i].inputDate(in);
		}
		return true;
	}
	
	// adds 1 to each date in array
	public void addOne () {
		for (MyDate date : dueDates) {
			date.addOne();
		}
	}
	
	// prints a string
	public String toString() {
		String output = "";
		for (MyDate date : dueDates) {
			output = output + "\n" + date.toString(); 
		}
		return output;
	}
	
	public int length () {
		return dueDates.length;
	}
	
	public boolean insertionSort () { // method to return a boolean if the insertion sort works
		
		for (int i = 1; i < dueDates.length; i++) { // loop through every element of dueDates to check insertion sort
			MyDate temp = dueDates[i]; // save the dueDate to a temp location;
			int j = i-1;
			
			while ( j >= 0 && dueDates[j].isGreaterThan(temp) ) { // check to make sure the array has a value and check to see if the date is greater than the other one
				dueDates[j+1] = dueDates[j];
				j--;
			}
			dueDates[j+1] = temp;
		}
		return true;
	}

}

