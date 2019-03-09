import java.util.ArrayList;
import java.util.Scanner;
/************************************************************************************************************
Purpose:  This class is meant to create a College. It has an ArrayList of Courses and a name for the college
Author:  Linda Crane and Patrick Bobyn
Course: F2018 - CST8130
Lab Section: CST8130 - 303
Data members:   courses: ArrayList<BlockChain> - this is the arraylist of all the courses listed in the school
				collegeName: String - This is the name of the college
Methods: Constructor (String) - this method just creates the instance of the college
		 printBlockChain(): void - This method takes the college's courses and it prints them out using the BlockChain print method.
		 addCourse (Scanner): boolean - This method adds in a new course to the school. It takes in a Scanner to get user input.
         addBlock (Scanner): boolean - Adds a student to the select course. Asks to pick which course to input the student into then asks whether the user wants a good or 
         							  or bad input.
         verifyChain (): boolean - Calls the verifyChain method from class BlockChain to make sure its worked correctly. Prints out if the course is verified or not.
         fixChain (Scanner): boolean - In this method the user selects a course and then the course is fixed assuming it needs to be fixed. 

*************************************************************************************************************/
public class College {
	private ArrayList<BlockChain> courses = new ArrayList<BlockChain>();
	private String collegeName;
	
	// constructor
	public College ( String collegeName ) {
		this.collegeName = collegeName;
	}
	
	// print all the courses
	public void printBlockChain() {
		
		System.out.println("For College: " + collegeName);
		
		if ( courses.size() == 0 ) { 	// if the course size is set to zero, cant print anything
			
		} else {	// when the courses size is set to larger than 0
			for (int i = 0; i < courses.size(); i++) {
				courses.get(i).printBlockChain();
			}
		}
	}
	
	// add a course to the school
	public boolean addCourse ( Scanner in ) {
		
		System.out.println("Enter name of course to add: ");
		BlockChain temp = new BlockChain( in.next() );
		courses.add( temp );
		return true;
	}
	
	// add a grade to the selected course
	public boolean addBlock ( Scanner in ) {
		
		int course = -1;
		
		if ( courses.size() == 0 ) { // if there are no courses 
			System.out.println("No courses to choose from!");
		} else { // if there are courses
			do { // make sure the selected course index is valid
				System.out.println("Enter which course to add to: ");
			
				for (int i = 0; i < courses.size(); i++ ) {	// print out the courses with an index
					System.out.println("[" + i +"] " + courses.get(i).getName() );
				}
				if ( in.hasNextInt() ) {
					course = in.nextInt();
				} else {
					in.nextLine();
				}
			} while ( course < 0 || course > courses.size()-1  );
			
			char block = ' ';
			do { // select whether to add a good or bad block
				System.out.println("Add good or bad block (g for good, b for bad):");
				block = in.next().toLowerCase().charAt(0);
				
				switch (block) {	
					case 'g': 	courses.get(course).addBlock( in );		// add a good block
								break;
					case 'b':	courses.get(course).addBadBlock( in );	// add a bad block
								break;
					default:	System.out.println("Not a Valid Option!");	// no option picked
								break;
				}
			} while ( block != 'g' && block != 'b');
		}
		return true;
	}
	
	// makes sure each course is valid
	public boolean verifyChain () {
		
		if ( courses.size() == 0 ) {	// if there are no courses
			System.out.println("There are no courses!");
		} else {	// there are courses call the verifyChain method in class BlockChain to get validity
			for (int i = 0; i < courses.size(); i++) {
				if ( courses.get(i).verifyChain() ) {	// get validity for each course
					System.out.println(courses.get(i).getName() + " is verified!");
				} else {
					System.out.println(courses.get(i).getName() + " is NOT verified!");
				}
			}
		}
		return true;
	}
	
	// fixes the selected course assuming it needs to be fixed
	public boolean fixChain ( Scanner in ) {
		
		if ( courses.size() == 0 ) {	// if there are no courses to check 
			System.out.println("No courses to check!");
		} else {	// there are courses to check
			int index = -1;
			
			do {	// make sure the user enters in a valid course to choose from 
				System.out.println("Enter which course to fix: ");
				for (int i = 0; i < courses.size(); i++) {	// print out the courses
					System.out.println("[" + i +"] " + courses.get(i).getName() );
				}
				if ( in.hasNextInt() ) {
					index = in.nextInt();
				} else {
					in.nextLine();
				}
			} while ( index < 0 || index > courses.size()-1 );
			
			courses.get( index ).fixBlocks(); // call the method from BlockChain class to fix it
			
			System.out.println("Course is fixed!");
		}	
		return true;
	}
}
