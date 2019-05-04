//********************************************************************
// FractionConversion.java
// 
// @author: Michael MacKay
// Converts two separate integers to a fraction
//********************************************************************

import java.util.Scanner;

public class FractionConversion {
	// Set class globals
	static Scanner scan;
	
	//-----------------------------------------------------------------
	// Called by the the program, give introduction and start program
	//-----------------------------------------------------------------
	public static void main(String[] args) {
		// Instantiate the scanner
		scan = new Scanner(System.in);
		
		// Welcome message
		System.out.println("Welcome to Assignment 1 - 3: Fraction Generation.");
		
		userInterface();
	}
	
	//-----------------------------------------------------------------
	// A loopable user interface that guides the user through the 
	// process.
	//-----------------------------------------------------------------
	public static void userInterface() {
		int userInputNumerator;
		int userInputDenominator;
		
		// Instructions to help the user.
		System.out.println("\nThis program will take two integers and create a fraction.");
		
		// Gets the user input in and sets it as the numerator
		userInputNumerator = getUserInt("numerator");
		
		// Gets the user input in and sets it as the denominator
		userInputDenominator = getUserInt("denominator");
		
		// Calculate the fraction making sure to cast the ints as doubles
		double fraction = (double)userInputNumerator / (double)userInputDenominator;
		
		// Notify the user of the calculation
		System.out.println("\tThe numerator " + userInputNumerator + " and the denominator " + userInputDenominator + " create the fraction " + fraction);
		
		// Restart the method for more calculations
		userInterface();
	}
	
	//-----------------------------------------------------------------
	// A method that return user int data.
	// 
	// @param String type = name to pass to user for type of data.
	//-----------------------------------------------------------------
	public static int getUserInt(String type) {
		// Set up var to run the method
		String userInputBuffer = new String();
		int userInputParsed;
		int i = 0;
		boolean isInt = false;
		
		// A loop that checks if the user has given appropriate data
		// after 10 failures it will exit the loop and restart the program
		while (!isInt) {
			// Incrementing attempts
			i++;
			
			// Exit loop and restart program in case we have an issue
			if (i > 10) {
				System.out.println("\n\tToo many attempts, breaking out for safety.");
				userInterface();
				break;
			}
			
			System.out.println("What is the " + type + "?");
			
			// Get the user input.
			userInputBuffer = scan.nextLine();
			
			// Validate it is an int
			isInt = validateInput(userInputBuffer);
			
			// Notify the user if it is not an int and give instructions
			if (!isInt) {
				System.out.println("\tSorry, you must enter valid data. Only integers will be accepted.");
			}
			
		}
		
		// Parsing the user input for returning as an int
		userInputParsed = Integer.parseInt(userInputBuffer);
		
		return userInputParsed;
	}
	
	//-----------------------------------------------------------------
	// Validates the user input by trying to parse the string as an int
	//	
	//	return true  : 	is int
	//	return false :	is not a int
	//
	//-----------------------------------------------------------------
	public static boolean validateInput(String input) {
		// Set base return value as false
		boolean isInt = false;
		
		// Attempt to parse the string as an int, if it works we can
		// assume that the user input is an int otherwise we leave it
		// as false
		try {
			Integer.parseInt(input);
			
			isInt = true;
		} catch (Exception e) {
			// Silence (leave as false)
		}
		
		return isInt;
	}

}
