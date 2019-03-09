import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
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

Methods: default constructor - sets the number of resourcesBorrowed to the max value, which is set to 1000.
		 inputResources(Scanner, MyDate): void - This adds a resource to the resourcesBorrowed array. It gets user input by asking which
		 										 type of resource is being borrowed and then goes to that subsequent class to input the 
		 										 correct resource.
 		 linearSearch (String): int - searches through the arraylist to find where to place an input. It returns an int where the new
 										information should be stored.
		 toString(): String - Prints a string of the resources currently being borrowed from the library.
		 resourcesOverDue (MyDate): String - prints out a list of only the resources that are overdue from the library.
		 deleteResource (MyDate, Scanner): void - displays all the resources being borrowed with a corresponding number to the user and asks 
		 										  the user to select a resource to delete. Once the resource is deleted it moves all the next 
		 										  resources down the array and decrements the number of the resources borrowed.
 		 search (Scanner): void - This method searches through all of the data in an array list to find a string matching one that the user
 									entered in. If there is more than 1 of that data type it will print off all of them
 		 readFile (Scanner): boolean - This method reads in data from a file. It prompts the user for a file name and then inputs the data.
 		 toFile (): String - This is an output method that returns a string with the correct formatting to a file.
 		 saveFile (Scanner): boolean - This is the method that calls toFile and it prints the data to a file


*************************************************************************************************************/
public class Library {

	// private instance variables
	private ArrayList<Resource> resourcesBorrowed;
	
	// default constructor
	public Library () {
		resourcesBorrowed = new ArrayList<Resource>();
	}
	
	// adds a resource to resourcesBorrowed, uses polymorphism to call inputMethod 
	// to add a resource
	public void inputResource( Scanner in, MyDate date ) {
		
		// create local variables
		char resource = 'a';
		boolean pass;
		
		// check if the account is too large and then input data
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
		
		Resource temp = new Resource();	// temp value to be inserted into the arraylist
		
		switch ( resource ) { // switch case to create a new Resource
			case 'd':
				temp = new DVD();
				break;
			case 'm':
				temp = new Magazine();
				break;
			case 'b':
				temp = new Book();
				break;
		}

		temp.inputResource( in, date ); 
		
		int i = linearSearch ( temp.title );
		resourcesBorrowed.add( i, temp); // insert temp into the arraylist
	}

	// is given a string that then seaches for the correct location to place into the arraylist so its in alphabetical order
	public int linearSearch ( String title ) {
		
		int i = 0; // create value to represent the index in the arraylist
		while ( i < resourcesBorrowed.size() ){ // search through array until the temp value is less than that index's value
			if ( title.compareToIgnoreCase( resourcesBorrowed.get(i).title ) < 0 ){
				return i;
			}
			i++;
		}
		return i;
	}
	
	public String toString() {
		
		// create and return the string with all the resources in library
		String output = "Items currently borrowed from library are:";
		for (int i = 0; i < resourcesBorrowed.size(); i++) {
			output = output + "\n[" + (i+1) + "]: " + resourcesBorrowed.get(i).toString();
		}
		return output;
	}
	
	// returns the list of resources that are overdue
	public String resourcesOverDue ( MyDate today ) {
		
		// print string stating that these resources are overdue then check items
		String output = String.format("Items currently borrowed from the library that are overdue as of %s are:", today.toString() );
		for (int i = 0; i < resourcesBorrowed.size(); i++) { // check resources
			
			if (resourcesBorrowed.get(i).isOverDue( today )) { // if resource is overdue add it to the output
				output = output + "\n[" + (i+1) + "]: " + resourcesBorrowed.get(i).toString();
			}
		}
		return output;
	}
	
	// displays a numbered list of resources currently in array and prompts user to 
	// enter number correlating to the resource to delete
	public void deleteResource ( MyDate date, Scanner in ) {
		
		if (resourcesBorrowed.size() == 0) { // if there are no resources
			System.out.println("No resources have been taken out");
			
		} else { // delete a resource
			// create local variables
			boolean pass = true;
			boolean cont = true;
			int delete = -1;
		
			// print a list of all resources checked out
			System.out.println("List of resources checked out in the library: ");
			for (int i = 0; i < resourcesBorrowed.size(); i++) {
				System.out.printf("[%d]: ", i+1);
				resourcesBorrowed.get(i).displayDueDate();
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
			
				if ( (delete >= 0) && (delete <= resourcesBorrowed.size() )) { // make sure the account is valid to delete
					cont = false;
				}
			} while (cont); // if the input is within range
			
			resourcesBorrowed.remove(delete);
		}
	}

	// a search method to find a specific title in the data
	public void search ( Scanner in ) {
		
		if ( resourcesBorrowed.size() == 0 ) {
			System.out.println("No Resources available!");
		} else {
			// Get user to enter in name of resource to search up
			System.out.println("Enter the title to search for: ");
			String name = in.next().toLowerCase();
			Boolean check = false;

			int index = resourcesBorrowed.size();
			int first = 0;
			int last = resourcesBorrowed.size() - 1;

			while ( first <= last ){
				int mid = (first + last) /2;
				if ( name.compareToIgnoreCase( resourcesBorrowed.get(mid).title ) > 0 ){
					first = mid + 1;
		 		} else if ( name.equals ( resourcesBorrowed.get(mid).title ) ){
					index = mid;
					check = true;
					break;
				} else {
					last = mid - 1;
				}
				index++;
			}

			if ( !check ) {
				System.out.println("Resource with this title is not found!");
			} else {
				System.out.println( resourcesBorrowed.get(index).toString() );

			}
		}
	}

	// this reads from a file by asking the user to enter a file in, It then calls the corresponding data type and gets the user input
	public boolean readFile ( Scanner in ) {
		
		System.out.println("Enter name of file to process: ");
		String path = in.next();
		
		try (Scanner file = new Scanner (Paths.get( path ) ) ) {
			while ( file.hasNextLine() ) {
				char type = file.next().charAt(0);
				Resource temp = new Resource();
				
				switch (type) {
					case 'd':
						temp = new DVD();
						break;
					case 'm':
						temp = new Magazine();
						break;
					case 'b':
						temp = new Book();
						break;
				}
				
				temp.addFromFile( file );
				int i = linearSearch ( temp.title );
				resourcesBorrowed.add( i, temp); // insert temp into the arraylist
			}
		} catch (IOException ioe) { // file isnt found
			System.out.println("Invalid Input:" );
		} catch (Exception e ) { // everything else
			System.out.println("Error 404: Not Found");
		}
		
		return true;
	}

	// sends an output to a file of all the data in the arraylist
	public String toFile() {
		// create and return the string to be printed to a file
		String output = resourcesBorrowed.get(0).toFile();
		for (int i = 1; i < resourcesBorrowed.size(); i++) {
			output = output + "\n" + resourcesBorrowed.get(i).toFile();
		}
		return output;
	}

	// saves to a file using the output from toFile
	public boolean saveFile ( Scanner in ) {
		
		// get name of file to print to
		System.out.println("Enter name of file to write to: ");
		String file = in.next();
		
		try (PrintWriter writer = new PrintWriter ( file, "UTF-8") ){ // create a new file or overwrite old one
			writer.print( this.toFile() );
			writer.close();
		} catch (IOException ioe) { // handle the file not being available
			System.out.println("Error");
		} catch (Exception e) { // every other error
			System.out.println("Error 404: Not Found:");
		}
		return true;
	}
}