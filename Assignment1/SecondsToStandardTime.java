//********************************************************************
// SecondsToStandardTime.java
// 
// @author: Michael MacKay
// Convert seconds to HH:MM:SS
//********************************************************************

import java.util.Scanner;

public class SecondsToStandardTime {
	// Set class constants (Java constant declaration is weird...)
	static final int SEC_IN_HOUR = 3600;
	static final int SEC_IN_MIN = 60;
	
	// Set class globals
	static Scanner scan;
	
	//-----------------------------------------------------------------
	// Called by the the program, give introduction and start program
	//-----------------------------------------------------------------
	public static void main(String[] args) {
		// Instantiate the scanner
		scan = new Scanner(System.in);
		
		// Welcome message
		System.out.println("Welcome to Assignment 1 - 2: Seconds to Formatted Time.");
		
		// Start the user interface loop
		userInterface();
	}
	
	//-----------------------------------------------------------------
	// A loopable user interface that guides the user through the 
	// process.
	//-----------------------------------------------------------------
	public static void userInterface() {
		String userInputBuffer;
		System.out.println("\nPlease enter the number of seconds you would like to convert to formatted time:");
		
		// Get the user input.
		userInputBuffer = scan.nextLine();
		
		// Check if the user input is an int
		if (validateInput(userInputBuffer)) {
			// Preparing the seconds input data to be parsed by the convertToStandardTime method
			int userInputParsed = Integer.parseInt(userInputBuffer);
			String formatted = convertToStandardTime(userInputParsed);
			
			// Notify the user of the formatted time
			System.out.println("\t" + userInputParsed + " seconds formatted is " + formatted + " (HH:MM:SS).");
		} else {
			// We assume the user enter non-numerical chars, let's tell them
			System.out.println("\tSorry, you must enter valid data. Only integers will be accepted.");			
		}
		
		// Restart the method for more conversions
		userInterface();
	}
	
	//-----------------------------------------------------------------
	// Takes in a total number of seconds and converts them to HH:MM:SS
	// format for easier human digestion.
	//-----------------------------------------------------------------
	public static String convertToStandardTime(int totalSeconds) {
		// Find the number of hours
		int hours = totalSeconds / SEC_IN_HOUR;
		
		// Formatting the hours int to always have two digits.
		String hoursFormatted = String.format("%02d", hours);
		
		// Use modulus operator to find remaining seconds
		int mod = totalSeconds % SEC_IN_HOUR;
		
		// Find the number of seconds after hours have been found
		int mins = mod / SEC_IN_MIN;
		
		// Formatting the mins int to always have two digits.
		String minsFormatted = String.format("%02d", mins);
		
		// Use modulus operator to find final remain seconds
		mod %= SEC_IN_MIN;
		
		// Formatting the mod (seconds) int to always have two digits.
		String secondsFormatted = String.format("%02d", mod);
		
		// Return the formatted text
		return hoursFormatted + ":" + minsFormatted + ":" + secondsFormatted;
		
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
