/** 	Created by Patrick Bobyn
 *  	Course: Object Oriented (CST 8132-310)
 *  	Lab Section: 312
 */
public class ExerciseOne {
	// declare array
	private int[] myArray;
	
	// constructor that initializes array to 10
	public ExerciseOne () {
		myArray = new int[10];
		
		// initialize each value
		for (int i = 1; i <= myArray.length; i++) {
			myArray[i-1] = i;
		}
	}
	
	// print values in the array
	public void printArrayValues() {
		// print out beginning of line
		System.out.print("myArray = {");
		// print out the values
		for (int i = 0; i < myArray.length; i++)
			// if statement to end line
			if (myArray[i] == 10) {
				System.out.print(myArray[i]);
			} else {
				System.out.print(myArray[i] + ", ");
			}
		// end line
		System.out.print("};\n");
	}
	
	// display the produt
	public void displayArrayProduct() {
		// declare and initialize total
		int total = 1;
		// use enhanced for loop to add to total
		for (int i : myArray) 
			total *= i;
		// print out sentence with total
		System.out.println("The product of all elements of myArray is " + total);
	}
	
	// MAIN
	public static void main(String[] args) {
		
		// declare object
		ExerciseOne one = new ExerciseOne();
		
		// call each method
		one.printArrayValues();
		one.displayArrayProduct();
	}
}
