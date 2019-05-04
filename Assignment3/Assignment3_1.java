//********************************************************************
// Assignment3_1.java
// 
// @author: Michael MacKay
// A simple Hi-Lo game, the user must guess and randomly generated
// number.
//********************************************************************
package comp1131_Assignment3;

import java.util.Random;
import java.util.Scanner;

public class Assignment3_1 {
	// Declare Scanner
	static Scanner scan;
	
	// Declare primitives
	static int min = 0; // min value it could be
	static int max = 100; // max value it could be
	static int wonGames = 0; // used for stats at end of game
	static int lostGames = 0; // used for stats at end of game
	
	//-----------------------------------------------------------------
	// Called by the the program, give introduction and start program
	//
	// I use it as a Init() type of method
	//-----------------------------------------------------------------
	public static void main(String[] args) {
		// Instantiate the scanner
		scan = new Scanner(System.in);
		
		// Welcome message
		System.out.println("Welcome to Assignment 3 - 1: Hi-Lo Guessing Game");
		
		// Start the game loop
		gameLoop();
	}
	
	//-----------------------------------------------------------------
	// A loopable user interface that guides the user through the 
	// process.
	// 
	// Public in case we want an external call someday
	//-----------------------------------------------------------------
	public static void gameLoop() {
		
		// Instantiate Objects
		Random rand = new Random();
		
		// Declare vars
		int currentNumber = rand.nextInt(101); // 101 to include 100 as 0 counts as a number
		int userGuess = -1; // Should start never true
		int numberGuesses = 0; // Feature to add more replayability
		
		// Instructions for user at the start
		System.out.println("\tI am going to pick a number between 0 and 100.");
		
		// Run this loop while the user has the incorrect number
		while (userGuess != currentNumber) {
			
			// Get the user guess
			userGuess = processUserInput();
			
			// Increment the number of guesses
			numberGuesses++;
			
			// Check the user input and respond based on input
			if (currentNumber == userGuess) {
				System.out.println("\tCongratulations! You win! It took you " + numberGuesses + " guesses.");
				// Increment the won games
				wonGames++;
			} else if (currentNumber > userGuess) {
				System.out.println("\t\tMy number is higher than " + userGuess);
			} else if (currentNumber < userGuess) {
				System.out.println("\t\tMy number is lower than " + userGuess);
			}
			
		}
		
		// Inform the user of their stats.
		displayStats();
		
		// Instructions prompting user to play again or quit
		System.out.println("Would you like to play again? Type [new] or [restart] to start a new game.");
		System.out.println("\tLikewise you can type [quit] or [exit] to quit the program.");
		
		// Instructions to be passed along in case the user's input is invalid
		String[] instructions = {
				"Type [new] or [restart] to start a new game.",
				"\tLikewise you can type [quit] or [exit] to quit the program."
		};
		
		// Check the user's input for commands and loop if invalid input is detected
		checkCommands(getUserInput(), true, instructions);
		
	}
	
	//-----------------------------------------------------------------
	// A loop that validates the user input. Whether it be a int or
	// command.
	//	
	//	return : A validated int || exit if command detected
	//
	// No need to be public
	//-----------------------------------------------------------------
	private static int processUserInput() {
		String userInputBuffer = new String();
		int userInputParsed;
		int j = 0;
		boolean isValid = false;
		boolean isCommand = false;
		
		// A loop that checks if the user has given appropriate data
		// after 10 failures it will exit the loop and restart the program
		while (!isValid) {
			// Incrementing attempts
			j++;
			
			// Exit loop and restart program in case we have an issue
			if (j > 10) {
				System.out.println("\n\tWell seems like you don't want to play... Let's start a new game.");
				gameLoop();
				break;
			}
			
			// As the question to the user
			System.out.println("\t\tWhat is your next guess?");
			
			// Refactored from previous projects to allow other methods to call it
			userInputBuffer = getUserInput();
			
			// Check for Commands
			isCommand = checkCommands(userInputBuffer);
			
			// Check that it only contain Alphanumeric Chars
			isValid = validateInput(userInputBuffer);
			
			// Notify the user if it contains invalid chars
			if (!isValid && !isCommand) {
				System.out.println("\tSorry, you must enter valid data. Only integers between the range of 0 to 100 are accept.");
			} else if (isCommand) {
				// Command was called don't count towards loop limit
				j--;
			}
			
		}
		
		// Parse the user input into a Double
		userInputParsed = Integer.parseInt(userInputBuffer);
		
		return userInputParsed;
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
	
	//-----------------------------------------------------------------
	// Checks the user inputs for commands and performance appropriate 
	// actions if found.
	//	
	//	commands : 
	//			{ 
	//				new = restart game 
	//				restart = restart game 
	//				exit = quit game 
	//				quit = quit game
	//			}
	//
	//	return : true - stats was called
	//	return : false - no command detected
	//  
	//
	// No need to be public
	//-----------------------------------------------------------------
	private static boolean checkCommands(String command) {
		// Using a switch/case because it allows for multiple
		// inputs having the same code
		
		// We make sure the command is lower case to stop issues with
		// casing
		switch (command.toLowerCase()) {
			case "new":
			case "restart":
				System.out.println("Restart the game...");
				
				// Increment lost games
				lostGames++;
				
				gameLoop();
				break;
			case "quit":
			case "exit":
				System.out.println("Quiting program...");
				quitGame();
				break;
			case "stats":
				displayStats();
				return true;
			default:
				// silence
		}
		
		// We use this return value allow external methods know we did
		// not find any commands
		return false;
	}
	
	//-----------------------------------------------------------------
	// An overload of checkCommands that allows the user to loop it for
	// end game scenarios (won game).
	//
	// Checks the user inputs for commands and performance appropriate 
	// actions if found.
	//	
	//	return : false - no command detected
	//  
	// Note: I decided to use this overload because it something I 
	// didn't know java could do. Not the most elegant way of doing
	// things but an interesting first attempt.
	//
	// No need to be public
	//-----------------------------------------------------------------
	private static boolean checkCommands(String command, boolean loop, String[] instructions) {
		
		switch (command.toLowerCase()) {
			case "new":
			case "restart":
				System.out.println("Restart the game...");
				gameLoop();
				break;
			case "quit":
			case "exit":
				System.out.println("Quiting program...");
				quitGame();
				break;
			default:
				// Check to see if the user wants to loop
				if (loop) {
					// Notify the user their input was wrong
					System.out.println("WARNING: Incorrect input...");
					
					// Display the based instructions
					for (int i = 0; i < instructions.length; i++) {
						System.out.println(instructions[i]);
					}
					
					// Start the method again, hoping for valid input
					checkCommands(getUserInput(), true, instructions);
				}
		}
		
		return false;
	}
	
	//-----------------------------------------------------------------
	// Display statistics of the game.
	//
	// No need to be public
	//-----------------------------------------------------------------
	private static void displayStats() {
		// Simple check to make sure we don't divide by 0
		if (wonGames + lostGames < 1) {
			return;
		}
		float totalGames = wonGames + lostGames;
		float percentWon = (float)wonGames / totalGames * 100;
		
		System.out.println("\nStatistics of Games played");
		System.out.println("=============================");
		System.out.println("\tTotal Games: " + (int)totalGames);
		System.out.println("\tWon Games: " + wonGames);
		System.out.println("\tLost Games: " + lostGames);
		System.out.println("\n\tWin Percent: " + String.format("%.0f", percentWon) + "%\n\n");
		
	}
	
	//-----------------------------------------------------------------
	// Quits the program.
	//
	// No need to be public
	//-----------------------------------------------------------------
	private static void quitGame() {
		System.exit(0);
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
		boolean isInt = false;
		
		// Attempt to parse the string as an double, if it works we can
		// assume that the user input is an double otherwise we leave it
		// as false
		try {
			int temp = Integer.parseInt(input);
			
			// Added the range check here since it is where the input is
			// validated
			if (temp >= min && temp <= max) {
				isInt = true;
			}
		} catch (Exception e) {
			// Silence (leave as false)
		}
		
		return isInt;
	}

}