//********************************************************************
// ConvertMilesToKms.java
// 
// @author: Michael MacKay
// Convert miles to kilometers using a text based interface.
//********************************************************************

import java.util.Scanner;

public class ConvertMilesToKms {
	// Set class globals
	static Scanner scan;
	
	//-----------------------------------------------------------------
	// Called by the the program, give introduction and start program
	//-----------------------------------------------------------------
	public static void main(String[] args) {
		// Instantiate the scanner
		scan = new Scanner(System.in);
		
		// Welcome message
		System.out.println("Welcome to Assignment 1 - 1: Miles to kilometers.");
		
		// Start the user interface loop
		milesToKmLoop();
	}
	
	//-----------------------------------------------------------------
	// The user interface used to get miles and calculate kilometers.
	//-----------------------------------------------------------------
	public static void milesToKmLoop() {
		String userInputBuffer;
		System.out.println("\nPlease enter the number of miles you wish to convert:");
		
		// Get the user input.
		userInputBuffer = scan.nextLine();
		
		// Check if the user input is a number
		if (validateInput(userInputBuffer)) {
			// Preparing miles type and return kilometers as a double
			double userInputParsed = Double.parseDouble(userInputBuffer);
			double km = calcMilesToKm(userInputParsed);
			
			// Notify the user of the calculation
			System.out.println("\t" + userInputParsed + " miles is " + km + " kilometers.");
		} else {
			// We assume the user enter non-numerical chars, let's tell them
			System.out.println("\tSorry, you must enter valid data. Only numerical characters will be accepted.");			
		}
		
		// Restart the method for more calculations
		milesToKmLoop();
		
	}
	
	//-----------------------------------------------------------------
	// Validates the user input as a numerical value using Regex
	//	
	//	return true  : 	is number
	//	return false :	is not a number
	//
	// * Note *
	//	I am aware I could have used scan.nextDouble() instead of
	//	scan.nextLine() - but I wanted a easy way to notify the user
	//	if they enter invalid information.
	//-----------------------------------------------------------------
	public static boolean validateInput(String input) {
		// Checks if the input is not null and a number using Regex formula
		if (input != null && input.matches("[-+]?\\d*\\.?\\d+")) {
			// Return true: is a number
			return true;
		}
		// Return false: Is not a number
		return false;
	}
	
	//-----------------------------------------------------------------
	// Calculates miles to kilometers based off user input.
	//-----------------------------------------------------------------
	public static double calcMilesToKm(double miles) {
		double km = miles * 1.60935;
		return km;
	}

}
