import java.util.Random;
import java.util.Scanner;

public class BlockChain {
	private Block head = new Block (); // start the chain with the Genesis block
	private Block tail = head;
	private String courseName = "NotEntered";
	
	public BlockChain ( String courseName) {
		this.courseName = new String (courseName);
	}
	
	public void printBlockChain() {
		
		// create a temporary block
		Block temp = head;
		
		// print out the title and then the blocks
		System.out.println("Chain for " + courseName );
		do {
			System.out.println( temp.toString() );
			temp = temp.next(); // after printing out, get next block and check to make sure its not null
		} while (temp != null);
	}
	
	public boolean verifyChain() {
		
		Block temp = head;
		
		while ( temp.next() != null ) {
			if ( !temp.next().isEqual( temp ) )
				return false;
			
			temp = temp.next();
		}
		return true;
	}
	
	public void addBlock(Scanner keyboard) {
		
		Block newOne = new Block (); // create new block then add the info
		if ( newOne.addInfoToBlock( keyboard, tail.getCurrentHash() ) ) {
			tail.updateNext( newOne ); // update tail
			tail = newOne;
		}	
	}
	
	public void addBadBlock(Scanner keyboard) {
		Random random = new Random();
		Block newOne = new Block();
		if (newOne.addInfoToBlock(keyboard, random.nextFloat())){
			// add to chain at tail
			tail.updateNext(newOne);
			tail = newOne;			
		}
	}
}
