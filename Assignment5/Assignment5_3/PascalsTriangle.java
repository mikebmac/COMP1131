package A5_3;

import java.util.Scanner;

public class PascalsTriangle {
	// Scanner
	protected static Scanner scanner;
	
	//-----------------------------------------------------------------
	// Called by the the program, give introduction and start program
	//
	// I use it as a Init() type of method
	//-----------------------------------------------------------------
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		System.out.println("Welcome to Assignment 5-3: Pascal's Triangle");
		System.out.println("============================================\n");
		
		userInput();
	}
	
	//-----------------------------------------------------------------
	// Loopable user interface that allows the user to select the
	// number of rows they want in Pascal's Triangle
	//-----------------------------------------------------------------
	private static void userInput() {
		// Instructions
		System.out.println("How many lines of Pascal's Triangle do you want?");
		
		// Integer to store user input
		int i = 0;
		
		// User Input
		try {
			i = scanner.nextInt();
		} catch (Exception e) {
			System.out.println("Seems something went wrong, closing...");
			System.exit(1);
		}
		
		// Create the triangle
		createTriangle(i);
		
		// Run again for more Pascal's Triangles!
		userInput();
		
	}

	//-----------------------------------------------------------------
	// Creates Pascal's Triangle
	//
	// Loops through the triangle's rows and columns attempting to 
	// properly space out the triangle's values.
	//-----------------------------------------------------------------
	private static void createTriangle(int n) {
		// Get the max value that will be seen in the triangle
		String maxValue = new String( Integer.toString(getPascalValue(n, n / 2)) );
		
		// Find the number of digits of the maximum value
		int maxLength = maxValue.length();
		
		// Loop through the rows of the triangle
		for (int i = 0; i < n; i++) {
			
			// Create the correct spacing to create the triangle
			for (int s = 0; s < (n - i - 1); s++) {
				for (int sp = 0; sp < maxLength; sp++) {
					System.out.print(" ");
				}
			}
			
			// Loop through the columns or individual digits in each row
			for (int j = 0; j <= i; j++) {
				// Get the value and store it as a string
				String tempString = Integer.toString(pascalsTriangleRecursive(i, j));
				
				// Find the length of the string
				int digitLength = tempString.length();
				
				// Adjust the spacing of the next value based on the number of digits the
				// current number is.
				// ie: Numbers with more digits have less spacing, while numbers with
				// less digits have more spacing.
				for (int x = 0; x < (maxLength + 2 - digitLength); x++) {
					tempString = tempString.concat(" ");
				}
				
				// Print out the digit to the console
				if (i != j) {
					System.out.print(tempString);
				} else {
					// End of the row move to the next line
					System.out.println(tempString);
				}
			}
		}
	}
	
	//-----------------------------------------------------------------
	// Recursive method that discovers the value of a digit based on  
	// the value of the digits above it.
	// 
	// Uses the formula stated in the Hints of the assignment
	// T(n, 0) = T(n, n) = 1
	// T(n, d) = T(n - 1, d - 1) + T(n - 1, d)
	// T = pascalsTriangleRecursive
	// n = row
	// d = column
	//-----------------------------------------------------------------
	private static int pascalsTriangleRecursive(int row, int column) {
	   
	   if (column == 0) { 			// T(n, 0) = 1 || Left side of the triangle
		   return 1;
	   } else if (row == column) { 	// T(n, n) = 1 || Right side of the triangle
		   return 1;
	   } else {
		   // T(n, d) = T(n-1, d-1) + T(n - 1, d)
		   return 	pascalsTriangleRecursive(row - 1, column - 1) // Up one row, back one column
				   + pascalsTriangleRecursive(row - 1, column);  // Up one row, same column
	   }
	}
	
	//-----------------------------------------------------------------
	// A supportive recursive method that can solve factorial.
	//
	// Formula:
	// F! = F x (F - 1) X (F - 2)... until F = 1 
	//-----------------------------------------------------------------
	private static int factorial(int value) {
		if (value <= 1) { // F = 1
			return 1;
		} else {
			return value * factorial(value - 1); // F x (F - 1)
		}
	}
	
	//-----------------------------------------------------------------
	// A supportive method used to find the value of any digit in a
	// Pascal's Triangle.
	//
	// It is specifically used to find the maximum value of the 
	// the currently created triangle and adjust spacing.
	//
	// Formula:
	// Row! / ( Column! x (Row - Column)! )
	//  
	// Row = the specific row of the triangle
	// Column = how deep or the specific column of the triangle
	//-----------------------------------------------------------------
	private static int getPascalValue(int row, int column) {
		// Row! / ( Column! x (Row - Column)! )
		// Broke it up for easier understanding
		double calculation = 
				(double)factorial(row) /
				((double)factorial(column) * (double)factorial(row - column));
		
		// Return the calculation casted as an int
		return (int)calculation;
	}

}
