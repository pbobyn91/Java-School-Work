import java.util.Scanner;
/************************************************************************************************************
Purpose:  Is the individual Block in the chain.
Author:  Linda Crane and Patrick Bobyn
Course: F2018 - CST8130
Lab Section: CST8130 - 303
Data members:  date: MyDate - the date of the block
			   studentNumber: int - the students unique number 
			   grade: int - the students course grades
			   previousHash: float - the value of the previous block
			   currentHash: float - the value of this current block
			   nextOne: Block - a pointer to the next block
Methods: constructor() - adds a default value to each instance variable
		 calculateHash(): float - Calculates a number to return as the current hash value
		 toString(): String - returns a printed version of all the student data
		 next(): Block - returns the next block
		 getCurrentHash(): float - returns the hash value of this current block
		 isEqual(Block): boolean - called from a the block before and compares it to the block as a parameter. Makes sure the hashes match
		 updateNext(Block): void - Updates the value to the next block
		 updatePreviousHash(float): void - Updates the previous hash value
		 addInfoToBlock(Scanner, float): boolean - Adds a new block. Takes in the scanner and the previous hash value. Gets user input.
		 

*************************************************************************************************************/
public class Block {
	private MyDate date;  // part of data - in month day year format  (eg) 2152018
	private int studentNumber; // part of data
	private int grade;  // part of data
	private float previousHash;
	private float currentHash;
	private Block nextOne;
	
	public Block() {
		// create the Genesis block
		date = new MyDate(11,11,2018);
		studentNumber = 0;
		grade = 100;
		previousHash = 0f;
		currentHash = calculateHash();
		nextOne = null;
		
	}
	
	public float calculateHash() {
		return (date.toInt()+studentNumber+grade)/88;   
	}
	
	public String toString() {
		return "" + studentNumber + " " + grade + " " + date +  " current: " + currentHash + " previous: " + previousHash ;
	}
	
	public Block next() {
		return nextOne;
	}
	
	public float getCurrentHash() {
		return currentHash;
	}
	
	public boolean isEqual (Block temp) {
		return (previousHash == temp.currentHash);
	}
	public void updateNext(Block newOne) {
		nextOne = newOne;
	}
	
	public void updatePreviousHash(float prevHash) {
		previousHash = prevHash;
	}
	
	public boolean addInfoToBlock(Scanner keyboard, float previousHash) {
		System.out.print ("Enter date: "); // Enter in the date values
		date.inputDate(keyboard);
		
		System.out.print ("Enter student number: ");	// enter the student number
		while (!keyboard.hasNextInt())  {
			System.out.print ("Invalid...enter an int for student number: ");
			keyboard.next();
		}
		studentNumber = keyboard.nextInt();
		
		
		System.out.println ("Enter grade: "); // enter a grade
		while (!keyboard.hasNextInt())  {
			System.out.print ("Invalid...enter an int for grade: ");
			keyboard.next();
		}
		grade = keyboard.nextInt();
		
		currentHash = calculateHash(); // calculate the current hash value
		this.previousHash = previousHash; // update the previous hash value
		return true;
	}
	
}
