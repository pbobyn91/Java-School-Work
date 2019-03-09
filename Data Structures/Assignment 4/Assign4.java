import java.util.Scanner;
/************************************************************************************************************
Purpose:  This Program implements a simple library resource management system.  The menu processing is in main
Author:  Linda Crane and xxxxxxxxxx
Course: F2018 - CST8130
Lab Section: xxxxxxxx
Data members: todayDate : MyDate - represents today's date

*************************************************************************************************************/
public class Assign4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Library library = new Library();
		Scanner keyboard = new Scanner (System.in);
		MyDate todayDate = new MyDate(16,9,2018);
		
		String choice = new String("0");
		
		while (choice.charAt(0) != '7') {
			System.out.print ("\n\nEnter 1 to add to resources borrowed, \n    2 to display overdue items, \n    3 to display all resources borrowed, \n    4 to delete a resource, \n    5 to change today date\n    ");
			System.out.print ("6 to view a specific resource, \n    7 to quit:");
			choice = keyboard.next();
			
			switch (choice.charAt(0)) {
				case '1': 	library.inputResource(keyboard, todayDate);
							break;
				case '2': 	System.out.println (library.itemsOverDue(todayDate));
							break;
				case '3': 	System.out.println (library);
							break;
				case '4':   library.deleteResource(keyboard, todayDate);					// NOT WORKING
							break;
				case '5':   System.out.println ("Enter a new date for today's date");
							todayDate.inputDate(keyboard);
							break;
				case '6':   library.displaySpecific(keyboard);
					        break;
				case '7': 	System.out.println ("goodbye");
			} // end switch
		}// end menu loop
		
	}// end main
}
