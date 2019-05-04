//********************************************************************
// assignment2_1.java
// 
// @author: Michael MacKay
// Uses the users first and last name to create a user name
//********************************************************************
package comp1131_Assignment2;

import java.util.Random;
import java.util.Scanner;

public class assignment2_1 {
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
		System.out.println("Welcome to Assignment 2 - 1: User Name Generation.");
		
		// Start the user interface loop
		userInterface();
	}
	
	//-----------------------------------------------------------------
	// A loopable user interface that guides the user through the 
	// process.
	//-----------------------------------------------------------------
	public static void userInterface() {
		// Set up vars
		String username;
		String firstName;
		String firstNameParsed;
		String lastName;
		String lastNameParsed;
		Random rand = new Random();
		
		// Random range (max - min + 1) + min
		// We add plus 1 because 0 counts as a number to a computer
		int number = rand.nextInt(90) + 10;
		
		// Instructions to help the user.
		System.out.println("\nThis program will help you create a new username.");
		
		// Get the user input and set it as the first name
		firstName = new String(getUserString("What is your first name?"));
		
		// Check the length of the string and grab the first char
		// Set the first char to upper case
		if (firstName.length() > 1) {
			firstNameParsed = new String(firstName.substring(0, 1).toUpperCase());			
		} else {
			firstNameParsed = firstName.toUpperCase();
		}
		
		// Get the user input and set it as the last name
		lastName = new String(getUserString("What is your last name?"));
		
		// Check the length of the string and grab the first 5 chars
		// if string is less than 5 chars use the whole thing
		// Set the first char to upper case
		if (lastName.length() > 5) {			
			lastNameParsed = new String(lastName.substring(0, 1).toUpperCase() + lastName.substring(1, 5));
		} else {
			lastNameParsed = new String(lastName.substring(0, 1).toUpperCase() + lastName.substring(1));
		}
		
		// Construct the username
		username = new String(firstNameParsed + lastNameParsed + number);
		
		// Notify the user of their username
		System.out.println("\tYour suggested username is:");
		System.out.println("\t\t" + username);
		
		// Restart the method for more usernames
		userInterface();
	}
	
	//-----------------------------------------------------------------
	// Uses the Scanner to get user input, validate it and return it
	// as a string, loops through the user input code in case the user
	// has issues.
	//	
	//	return : A validated string
	//
	//-----------------------------------------------------------------
	public static String getUserString(String question) {
		String userInputBuffer = new String();
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
				System.out.println("\tSorry, you must enter valid data. Only alphanumeric characters will be accepted.");
			}
			
		}
		
		return userInputBuffer;
	}
	
	//-----------------------------------------------------------------
	// Validates the user input using Regex for alphanumeric chars
	//	
	//	return true  : 	string with only alphanumeric chars
	//	return false :	string is null or contains non-alphanumeric chars
	//
	//-----------------------------------------------------------------
	public static boolean validateInput(String input) {
		// Checks if the input is not null and a number using Regex pattern
		// Changed the input != null to checking length to check for 
		// returns
		if (input.length() > 0 && input.matches("^[a-zA-Z0-9]*$")) {
			// Return true: is a number
			return true;
		}
		// Return false: Is not a number
		return false;
	}
	

}
