/** 	Created by Patrick Bobyn
 *  	Course: Object Oriented (CST 8132-310)
 *  	Lab Section: 312
 */
public class ExerciseTwo {
	// declare and initialize myArray
	private int[][] myArray = new int[8][10];
	
	public ExerciseTwo() {
		// initialize the value in myArray
		for (int i = 0; i < myArray.length; i++) {
			for (int j = 0; j < myArray[i].length; j++) {
				myArray[i][j] = i*10 + j;
			}
		}
	}
	
	// print the values
	public void printArrayValues() {
		// print first line
		System.out.println("myArray = {");
		// go through first values and then print new line
		for (int i = 0; i < myArray.length; i++) {
			System.out.print("(");
			// go through 2nd dimension of array and print
			for (int j = 0; j < myArray[i].length; j++) {
				if (j == 9) {
					System.out.print(myArray[i][j]);
				} else {
					System.out.print(myArray[i][j] + ", ");
				}
			}
			if (i == 7) {
				System.out.println(") }");
			} else {
				// print end of line and start new
				System.out.println("),");
			}
		}
	}
	
	// method to calculate average
	public double getArrayAverage(int[] a) {
		// declare and initialize average
		double ave = 0;
		// add to average
		for (int i : a) {
			ave += i;
		}
		// get average and return
		ave /= a.length;
		return ave;
	}
	
	// method to display Averages
	public void displayArraySumOfAverages() {
		// declare and initilize total
		double total = 0;
		// add the average for each row to the total
		for (int[] i : myArray) {
			total += getArrayAverage(i);
		}
		// print out the total of the averages
		System.out.println("The sum of the average value of each array in myArray is " + total);
		
		// reset total to 0 
		total = 0;
		
		// use nested for loop to add all values
		for (int[] i : myArray) {
			for (int j : i) {
				total += j;
			}
		}
		// print sum of all values
		System.out.println("The total sum of all elements is " + total);
	}
	
	// MAIN
	public static void main(String[] args) {
		// declare object two
		ExerciseTwo two = new ExerciseTwo();
		
		// call each method
		two.printArrayValues();
		two.displayArraySumOfAverages();
	}
}
