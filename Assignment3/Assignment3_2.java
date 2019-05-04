//********************************************************************
// Assignment3_2.java
// 
// @author: Michael MacKay
// Reads a string and outputs the number of vowels and non-vowel chars
//********************************************************************
package comp1131_Assignment3;

import java.util.Scanner;

public class Assignment3_2 {
	// Declare Scanner
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
		System.out.println("Welcome to Assignment 3 - 2: String Breakdown");
		
		// Start the program loop
		userInterface();
	}
	
	//-----------------------------------------------------------------
	// A loopable user interface that guides the user through the 
	// process.
	// 
	// Public in case we want an external call someday
	//-----------------------------------------------------------------
	public static void userInterface() {
		// User input storage
		String userInput = new String();
		
		// Primitives to keep track of chars
		int numberOfVowels = 0;
		int numberOfConsonants = 0;
		int numberOfNumbers = 0;
		int numberOfSpaces = 0;
		
		// Instantiate some strings to store collections
		String allVowels = new String();
		String allConsonants = new String();
		String allNumbers = new String();
		
		// Simple Instructions
		System.out.println("\tEnter the string you would like to breakdown:");
		
		// Get the user input
		userInput = getUserInput();
		
		// User a for loop to run through the string
		for (int i = 0; i < userInput.length(); i++) {
			// Get the char
			char c = userInput.charAt(i);

			if (Character.isDigit(c)) { // Check if it is a digit
				numberOfNumbers++;
				allNumbers += c;
			} else if ( Character.isLetter(c) ) { // Check if it is a letter
				// Use switch/case conditional to check if vowel, consonant or space
				switch (Character.toLowerCase(c)) {
					case 'a':
					case 'e':
					case 'i':
					case 'o':
					case 'u':
						numberOfVowels++;
						allVowels += c;
						break;
					default:
						// We assume it is a consonant
						numberOfConsonants++;
						allConsonants += c;
				}
			} else if (Character.isSpaceChar(c)) {
				numberOfSpaces++;
			}
		}
		
		// Display the totals
		System.out.println("Number of Vowels: " + numberOfVowels);
		System.out.println("Number of Consonants: " + numberOfConsonants);
		System.out.println("Number of Numerics: " + numberOfNumbers);
		System.out.println("Number of Spaces: " + numberOfSpaces);
		
		// Print out all stored vowels
		System.out.println("\nAll Vowels");
		for (int i = 0; i < allVowels.length(); i++) {
			System.out.println("\t" + allVowels.charAt(i));
		}
		
		// Print out all stored consonant
		System.out.println("\nAll Consonats");
		for (int i = 0; i < allConsonants.length(); i++) {
			System.out.println("\t" + allConsonants.charAt(i));
		}
		
		// Print out all store numbers
		System.out.println("\nAll Numerics");
		for (int i = 0; i < allNumbers.length(); i++) {
			System.out.println("\t" + allNumbers.charAt(i));
		}
		
		// Spacer
		System.out.println("\n");
		
		userInterface();
	}
	
	//-----------------------------------------------------------------
	// Attempts to get the user input, will close the program 
	// 'gracefully' of an exception occurs.
	//	
	//	return : A validated string
	//
	// No need to be public
	//-----------------------------------------------------------------
	private static String getUserInput() {
		String userInputBuffer = new String();
		// Noticed that in CMD Paste commands would throw an exception
		// Added this to more gracefully close the program.
		try {
			// Get the user input.
			userInputBuffer = scan.nextLine();
		} catch (Exception e){
			System.out.println("> Uh oh! Seems like something when wrong closing program <");
			System.exit(1);
		}
		
		return userInputBuffer;
	}
}
