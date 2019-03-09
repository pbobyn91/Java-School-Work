import java.util.Scanner;
/************************************************************************************************************
Purpose: This is the library. It holds records of each resource taken out. It only has a maximum amount of resources that 
  		 can be taken out, which is set when the library is first booted up before the main menu in the main method.
Author:  Patrick Bobyn
Course: F2018 - CST8130
Lab Section: CST8130-303
Date: 01/10/2018
Data members:  resourcesBorrowed: Resource[] - This is an array of each resource taken out of the library. It can hold references to 
											   Resource, Book, DVD, and Magazine. Size is initialized at the beginning of the program.
			   numResources: int - This is the number of Resources that has been taken out of the library. Can be less than the size 
			   					   of the array.
			   max: int - This is a static class variable meant to keep track of how many total resources can be used inside the array.

Methods: default constructor - sets the number of resourcesBorrowed to the max value, which is set to 1000.
		 Library (Scanner) - another constructor that can set the total value of resourcesBorrowed to another value. This is called
		 					 when the entire library is first booted up.
		 inputResources(Scanner, MyDate): void - This adds a resource to the resourcesBorrowed array. It gets user input by asking which
		 										 type of resource is being borrowed and then goes to that subsequent class to input the 
		 										 correct resource. 
		 toString(): String - Prints a string of the resources currently being borrowed from the library.
		 resourcesOverDue (MyDate): String - prints out a list of only the resources that are overdue from the library.
		 deleteResource (MyDate, Scanner): void - displays all the resources being borrowed with a corresponding number to the user and asks 
		 										  the user to select a resource to delete. Once the resource is deleted it moves all the next 
		 										  resources down the array and decrements the number of the resources borrowed.


*************************************************************************************************************/
public class Library {

	// private instance variables
	private Resource resourcesBorrowed[];
	private int numResources = 0;
	private static int max = 1000;
	
	// default constructor
	public Library () {
		resourcesBorrowed = new Resource[max];
	}
	
	// overloaded constructor
	public Library ( Scanner in ) {
		
		boolean pass;
		do { // get user input to set how many resources this library can lend
			pass = true;
			System.out.println("What is the max amount of resources: ");
			if ( in.hasNextInt() ) {
				max = in.nextInt();
				pass = false;
			} else {
				in.nextLine();
			}
		} while (pass);
		
		resourcesBorrowed = new Resource[max];
	}
	
	// adds a resource to resourcesBorrowed, uses polymorphism to call inputMethod 
	// to add a resource
	public void inputResource( Scanner in, MyDate date ) {
		
		// create local variables
		char resource = 'a';
		boolean pass;
		
		// check if the account is too large and then input data
		if (this.numResources == max ) { // if too many resources are allocated print it
			System.out.println("We have maxed out our resources");
			
		} else { // otherwise input a new resource
			do {
				pass = true;
				// ask user for input
				System.out.println("Enter type of resource being borrowed - D for DVD, M for Magazine and B for Book: ");
				if ( in.hasNext() ) {
					resource = in.next().toLowerCase().charAt(0);
				} else {
					in.nextLine();
				}
			
				if ( resource == 'd' || resource == 'm' || resource == 'b' ) { // check to make sure correct values
					pass = false;
				} else {
					System.out.println("Please enter a valid answer");
				}
			} while (pass); // allow the user to continue from valid input
		
			switch ( resource ) { // switch case to create a new Resource
				case 'd':
					resourcesBorrowed[numResources] = new DVD();
					break;
				case 'm':
					resourcesBorrowed[numResources] = new Magazine();
					break;
				case 'b':
					resourcesBorrowed[numResources] = new Book();
					break;
				default:
					System.out.println("Error 404: Not Found!!");
					break;
			}

			resourcesBorrowed[numResources].inputResource( in , date ); // enter input and add 1 to the number of resources
			this.numResources++; 
		}
	}
	
	public String toString() {
		
		// create and return the string with all the resources in library
		String output = "Items currently borrowed from library are:";
		for (int i = 0; i < numResources; i++) {
			output = output + "\n[" + (i+1) + "]: " + resourcesBorrowed[i].toString();
		}
		return output;
	}
	
	// returns the list of resources that are overdue
	public String resourcesOverDue ( MyDate today ) {
		
		// print string stating that these resources are overdue then check items
		String output = String.format("Items currently borrowed from the library that are overdue as of %s are:", today.toString() );
		for (int i = 0; i < numResources; i++) { // check resources
			
			if (resourcesBorrowed[i].isOverDue( today )) { // if resource is overdue add it to the output
				output = output + "\n[" + (i+1) + "]: " + resourcesBorrowed[i].toString();
			}
		}
		return output;
	}
	
	// displays a numbered list of resources currently in array and prompts user to 
	// enter number correlating to the resource to delete
	public void deleteResource ( MyDate date, Scanner in ) {
		
		if (numResources == 0) { // if there are no resources
			System.out.println("No resources have been taken out");
			
		} else { // delete a resource
			// create local variables
			boolean pass = true;
			boolean cont = true;
			int delete = -1;
		
			// print a list of all resources checked out
			System.out.println("List of resources checked out in the library: ");
			for (int i = 0; i < numResources; i++) {
				System.out.printf("[%d]: ", i+1);
				resourcesBorrowed[i].displayDueDate();
			}
			do {
				cont = true;
				do {
					pass = true;
					// ask user which resource to delete
					System.out.println("Which resource to delete:");
					if ( in.hasNextInt() ) {
						delete = in.nextInt() - 1;
						pass = false;
					} else {
						in.nextLine();
					}
				} while (pass); // if the input is a number
			
				if ( (delete >= 0) && (delete <= numResources)) { // make sure the account is valid to delete
					cont = false;
				}
			} while (cont); // if the input is within range
				
			for (int i = delete; i < numResources - 1; i++) {
				
				resourcesBorrowed[i] = resourcesBorrowed[(i+1)];
			}
		
			numResources--;
		}
	}
}
