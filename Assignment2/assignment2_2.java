//********************************************************************
// assignment2_2.java
// 
// @author: Michael MacKay
// Calculates the distance between two point on a 2D Cartesian plane. 
//********************************************************************
package comp1131_Assignment2;

import java.util.Scanner;

public class assignment2_2 {

	// Set class globals
	static Scanner scan;
	
	//-----------------------------------------------------------------
	// Called by the the program, give introduction and start program
	//
	// I use it as a Init() type of method
	//-----------------------------------------------------------------
	public static void main(String[] args) {
		// Instantiate the scanner
		scan = new Scanner(System.in);
		
		// Welcome message
		System.out.println("Welcome to Assignment 2 - 2: Distance Calculation.");
		
		// Start the user interface loop
		userInterface();
	}
	
	//-----------------------------------------------------------------
	// A loopable user interface that guides the user through the 
	// process.
	//-----------------------------------------------------------------
	public static void userInterface() {
		// Set up vars
		double x1;
		double y1;
		double x2;
		double y2;
		double distance;
		
		// Instructions to help the user.
		System.out.println("\nThis program takes two 2D vectors for a total of four inputs (x, y) and calculates the distance.");
		
		
		// Get the user input for x1
		x1 = getUserDouble("\tWhat is the first vector's X coordinate?");
		
		// Get the user input for y1
		y1 = getUserDouble("\tWhat is the first vector's Y coordinate?");
		
		// Get the user input for x2
		x2 = getUserDouble("\tWhat is the second vector's X coordinate?");
		
		// Get the user input for y2
		y2 = getUserDouble("\tWhat is the second vector's Y coordinate?");
		
		// Calculate the distance between two points
		// D = SQRT( (x2 - x1)^2 + (y2 - y1)^2 )
		// Seems java has no operator for exponents so have to use a method
		distance = Math.sqrt(Math.pow( (x2 - x1), 2d) + Math.pow( (y2 - y1), 2d));
		
		
		// Notify the user of the distance
		System.out.println("\nThe distance between [" + x1 + ", " + y1 + "] and ["+ x2 + ", " + y2 + "] is:");
		System.out.println("\t\t" + distance);
		
		// Restart the method for more distance calculation
		userInterface();
	}
	
	//-----------------------------------------------------------------
	// Uses the Scanner to get user input, validate it and return it
	// as a double, loops through the user input code in case the user
	// has issues.
	//	
	//	return : A validated double
	//
	//-----------------------------------------------------------------
	public static Double getUserDouble(String question) {
		String userInputBuffer = new String();
		double userInputParsed;
		int i = 0;
		boolean isValid = false;
		
		// A loop that checks if the user has given appropriate data
		// after 10 failures it will exit the loop and restart the program
		while (!isValid) {
			// Incrementing attempts
			i++;
			
			// Exit loop and restart program in case we have an issue
			if (i > 10) {
				System.out.println("\n\tToo many attempts, breaking out for safety.");
				userInterface();
				break;
			}
			
			// As the question to the user
			System.out.println(question);
			
			// Noticed that in CMD Paste commands would throw an exception
			// Added this to more gracefully close the program.
			try {
				// Get the user input.
				userInputBuffer = scan.nextLine();
			} catch (Exception e){
				System.out.println("> Uh oh! Seems like something when wrong closing program <");
				System.exit(1);
			}
			
			// Check that it only contain Alphanumeric Chars
			isValid = validateInput(userInputBuffer);
			
			// Notify the user if it contains invalid chars
			if (!isValid) {
				System.out.println("\tSorry, you must enter valid data. Only numerical characters will be accepted.");
			}
			
		}
		
		// Parse the user input into a Double
		userInputParsed = Double.parseDouble(userInputBuffer);
		
		return userInputParsed;
	}
	
	//-----------------------------------------------------------------
	// Validates the user input by trying to parse the string as a
	// double
	//	
	//	return true  : 	is double
	//	return false :	is not a double
	//
	//-----------------------------------------------------------------
	public static boolean validateInput(String input) {
		// Set base return value as false
		boolean isDouble = false;
		
		// Attempt to parse the string as an double, if it works we can
		// assume that the user input is an double otherwise we leave it
		// as false
		try {
			Double.parseDouble(input);
			
			isDouble = true;
		} catch (Exception e) {
			// Silence (leave as false)
		}
		
		return isDouble;
	}

}
