import java.util.Scanner;
/************************************************************************************************************
Purpose:  This class is the method main for Lab 1 
Author:  Linda Crane and Patrick Bobyn
Course: F2018 - CST8130
Lab Section: CST8130-303
                                             
         

*************************************************************************************************************/


public class Lab1 {

	public static void main(String[] args) {
		
		// create a scanner variable
		Scanner keyboard = new Scanner (System.in);
		
		// create a few more variables
		DueDates lab1;
		
		do {
			// create a new instance of class DueDates using number gained from user 
			lab1 = new DueDates( getNum(keyboard) );
			
			// get the dates to be entered into the array in class DueDates
			lab1.inputDueDates(keyboard);
			
			// print the dates and add one to them after and reprint them
			lab1.toString();
			lab1.addOne();
			System.out.println("The due dates with one day added are:");
			lab1.toString();
			
		} while ( Continue (keyboard) );
	}
	
	private static int getNum(Scanner in) {
		// create local variables
		boolean pass;
		int num = 0;
		
		// use do while to determine if this is valid
		do {
			try { 
				// ask for how many assessments are done
				pass = false;
				System.out.println("How many assessments in this course - must be greater than 0? ");
				if (in.hasNextInt()) {
					num = in.nextInt();
				} else {
					in.next();
				}
					
				// if the number of assessments is 0 or less throw an exception
				if (num <= 0)
					throw new Exception();
				
			// handle any exception
			} catch (Exception e) {
				System.out.println("Error: Please enter a number that is greater than 0!!");
				pass = true;
			}
		} while (pass);
		return num;
	}
	
	private static boolean Continue ( Scanner in ) {
		
		boolean pass;
		char cont = 'a';
		
		// ask user if they wish to do another account
		do {
			pass = false;
			System.out.println("Do another try? y/n");
			if (in.hasNext()) {
				cont = in.next().toLowerCase().charAt(0);
			} else {
				System.out.println("Invalid Input");
				in.next();
				pass = true;
			}
						
			if ( (cont == 'y' || cont == 'n') ) {
				if (cont == 'y') {
					return true;
				} else {
					return false;
				}
			} else {
				pass = true;
			}
						
		} while (pass);
		return pass;
	}
}