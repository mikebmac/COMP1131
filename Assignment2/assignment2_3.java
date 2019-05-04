//********************************************************************
// assignment2_3.java
// 
// @author: Michael MacKay
// Calculates the volume and surface area of a sphere given its radius
//********************************************************************
package comp1131_Assignment2;

import java.text.DecimalFormat;
import java.util.Scanner;

public class assignment2_3 {
	// Set call vars
	
	// Let's reduce the number of external calls for Pi
	static final double pi = Math.PI;
	
	// Should only instantiate it once
	// Needed to achieve four decimal places in all instances
	static DecimalFormat decimalFormat;
	
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
		
		// Instantiate the formatter
		// Added commas (though I would use spaces instead normally) to
		// increase the readability of large numbers
		decimalFormat = new DecimalFormat("###,###,###.0000");
		
		// Welcome message
		System.out.println("Welcome to Assignment 2 - 3: Cylinder Calcuations");
		
		// Start the user interface loop
		userInterface();
	}
	
	//-----------------------------------------------------------------
	// A loopable user interface that guides the user through the 
	// process.
	// 
	// Public in case we want an external call someday
	//-----------------------------------------------------------------
	public static void userInterface() {
		// Declare vars
		double radius;
		double volume;
		String volumeFormatted;
		double surfaceArea;
		String surfaceAreaFormatted;
		
		// Instructions to help the user.
		System.out.println("\nThis program takes in the radius of a sphere and calculates the volume and surface area.");
		
		radius = getUserInput();
		
		volume = sphereVolume(radius);
		volumeFormatted = new String(decimalFormat.format(volume));
		
		surfaceArea = sphereSurfaceArea(radius);
		surfaceAreaFormatted = new String(decimalFormat.format(surfaceArea));
		
		System.out.println("\nA sphere with the radius of " + radius + " has:");
		System.out.println("\tA volume of: " + volumeFormatted);
		System.out.println("\tA surface area of: " + surfaceAreaFormatted);
		
		// Restart the method for more sphere calculations
		userInterface();
	}
	
	//-----------------------------------------------------------------
	// Uses the Scanner to get user input, validate it and return it
	// as a double, loops through the user input code in case the user
	// has issues.
	//	
	//	return : A validated double
	//
	// No need to be public
	//-----------------------------------------------------------------
	private static double getUserInput() {
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
			System.out.println("\nWhat is the radius of the sphere?");
			
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
		
		// We can't have a negative radius, change it and notify the user
		if (userInputParsed < 0) {
			System.out.print("\tWARNING: Your input of " + userInputParsed);
			userInputParsed = Math.abs(userInputParsed);
			System.out.println(" has been changed to " + userInputParsed);
		}
		
		return userInputParsed;
	}
	
	
	//-----------------------------------------------------------------
	// Calculate the sphere volume given the radius
	//
	// Formula: (4/3)PI x r^3 = sphereVolume
	// Make sure we state that (4/3) is a double (float should be fine,
	// but less accurate)
	//
	// return : Sphere's Volume
	//
	// No need for this to be public
	//-----------------------------------------------------------------
	private static double sphereVolume(double radius) {
		
		// Volume of a sphere calculation
		double volume = (4d/3d) * pi * Math.pow(radius, 3);
		return volume;
	}
	
	//-----------------------------------------------------------------
	// Calculate the sphere surface area given the radius
	//
	// Formula: 4PI x r^2 = sphereSurfaceArea
	// I state 4d but in the formula below but it should be convert by
	// the complier, I just like it to be as clear as possible.
	//
	// return : Sphere's Surface Area
	//
	// No need for this to be public
	//-----------------------------------------------------------------
	private static double sphereSurfaceArea(double radius) {
		
		// Surface area of a sphere calculation
		double surfaceArea = 4d * pi * Math.pow(radius, 2);
		return surfaceArea;
	}
	
	//-----------------------------------------------------------------
	// Validates the user input by trying to parse the string as a
	// double
	//	
	//	return true  : 	is double
	//	return false :	is not a double
	//
	// No need to be public
	//-----------------------------------------------------------------
	private static boolean validateInput(String input) {
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
