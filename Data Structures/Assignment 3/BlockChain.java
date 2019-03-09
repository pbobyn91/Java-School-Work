import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
/************************************************************************************************************
Purpose: This class is a LinkedList of specified blocks. This use is meant to resemble courses at a college.
Author:  Linda Crane and Patrick Bobyn
Course: F2018 - CST8130
Lab Section: CST8130 - 303
Data members:  blockChain: LinkedList<Block> - This is a list of all the registers students in this course
			   courseName: String - This is the name of the course.
Methods: Constructor (String) - Takes in a String that is the courseName
		 printBlockChain(): void - prints the list of students in this course. Called from the college class. 
         verifyChain(): boolean - returns a boolean of TRUE if the list is valid. Otherwise it says the course is invalid
         fixBlocks(): void - called from the College class. This fixes the selected course by checking the values of each link and making sure they are correct.
         addBlock (Scanner): void - Add a new good block to the chain
         addBadBlock (Scanner): void - Add a bad block to the chain
         getName(): String - return the courseName

*************************************************************************************************************/
public class BlockChain {
	private LinkedList<Block> blockChain = new LinkedList<Block>();
	private String courseName = "NotEntered";
	
	// Constructor 
	public BlockChain ( String courseName) {
		this.courseName = new String (courseName);
	}
	
	// print the students
	public void printBlockChain() {
		
		if ( blockChain.size() == 0 ) { // if there are no students to print
			System.out.println("For Course: " + courseName + "\n" );
		} else {	// there are students to print
			// create a temporary block
			Block temp = blockChain.get(0);
			
			// print out the title and then the blocks
			System.out.println("For Course: " + courseName );
			do {
				System.out.println( temp.toString() );
				temp = temp.next(); // after printing out, get next block and check to make sure its not null
			} while (temp != null);
		}
	}
	
	// check the validity of the chain
	public boolean verifyChain() {
		
		if ( blockChain.size() == 0 ) { // if there are no students
			
		} else { // there are students
			Block temp = blockChain.get(0);
		
			while ( temp.next() != null ) {
				if ( !temp.next().isEqual( temp ) ) // call the method from class Block
					return false;
			
				temp = temp.next(); // change to the next block
			}
		}
		return true;
	}
	
	// fix the list
	public void fixBlocks () {
		
		if ( blockChain.size() == 0 || blockChain.size() == 1 ) { // if the block has a size of 1 or 0 it cant be fixed
			
		} else { // the block has at least 2 values 
			Block current = blockChain.get(1); // get the first 2 blocks
			Block prev = blockChain.get(0);
			
			while ( current != null ) {	// check to make sure the values arent equal then fix the list
				 if ( !current.isEqual( prev ) ) {
					current.updatePreviousHash( prev.getCurrentHash() ); 
				 }
				 current = current.next(); // update both blocks to the next block
				 prev = prev.next();
			}
		}
	}
	
	// add a new block 
	public void addBlock(Scanner keyboard) {
		
		Block newOne = new Block (); // create new block then add the info
		if ( blockChain.size() == 0 ) { // if the size of the list is 0 add the first value into the first location
			newOne.addInfoToBlock( keyboard, 0 );
			blockChain.add( newOne );
		} else if ( newOne.addInfoToBlock( keyboard, blockChain.get( blockChain.size()-1 ).getCurrentHash() ) ) { // otherwise add it into the end 
			blockChain.get( blockChain.size()-1 ).updateNext( newOne ); // update tail
			blockChain.add( newOne );
		}	
	}
	
	// add a bad block
	public void addBadBlock(Scanner keyboard) {
		Random random = new Random();
		Block newOne = new Block();
		if (blockChain.size() == 0 ) {
			newOne.addInfoToBlock( keyboard, random.nextFloat() );
			blockChain.add( newOne );
		} else if (newOne.addInfoToBlock(keyboard, random.nextFloat())){
			// add to chain at tail
			blockChain.get( blockChain.size()-1 ).updateNext(newOne);
			blockChain.add( newOne );			
		}
	}
	
	// return the name of the course
	public String getName() {
		return this.courseName;
	}
}
