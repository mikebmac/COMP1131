//********************************************************************
// Driver.java
// 
// @author: Michael MacKay
// A driver scripts that moves the Bug - used for Assignment 4 - 1 of
// COMP 1131
//********************************************************************
package Assignment4_1;

public class Driver {
	
	//-----------------------------------------------------------------
	// Called by the the program, give introduction and start program
	//
	// I use it as a Init() type of method
	//-----------------------------------------------------------------
	public static void main(String[] args) {
		// Welcome message
		System.out.println("Welcome to Assignment 4 - 1: Bug Walking");
		
		// Call Methods to demonstrate programs
		oneBug();
		twoBugs();
		oneBugPosition();
	}
	
	//-----------------------------------------------------------------
	// Sequence for one bug
	//-----------------------------------------------------------------
	public static void oneBug() {
		System.out.println("\nONE BUG");
		System.out.println("=======\n");
		Bug bug = new Bug();

		System.out.println(bug.toString());
		
		for (int i = 0; i < 5; i++) {
			bug.moveForward();
			System.out.println(bug.toString());
		}

		bug.changeDirection(Bug.DIRECTION.LEFT);
		
		for (int i = 0; i < 10; i++) {
			bug.moveForward();
			System.out.println(bug.toString());
		}
		
		bug.changeDirection(Bug.DIRECTION.RIGHT);
		
		for (int i = 0; i < 5; i++) {
			bug.moveForward();
			System.out.println(bug.toString());
		}
	}
	
	//-----------------------------------------------------------------
	// Sequence for two bugs, demonstrating how bugs can overlap
	//-----------------------------------------------------------------
	public static void twoBugs() {
		System.out.println("\nTWO BUGs");
		System.out.println("=======\n");
		Bug bug1 = new Bug();
		Bug bug2 = new Bug(Bug.DIRECTION.LEFT);

		System.out.println(bug1.toString() + "\t" + bug2.toString());
		
		for (int i = 0; i < 5; i++) {
			bug1.moveForward();
			bug2.moveForward();
			System.out.println(bug1.toString() + "\t" + bug2.toString());
		}

		bug1.changeDirection(Bug.DIRECTION.LEFT);
		bug2.changeDirection(Bug.DIRECTION.RIGHT);
		
		for (int i = 0; i < 10; i++) {
			bug1.moveForward();
			bug2.moveForward();
			System.out.println(bug1.toString() + "\t" + bug2.toString());
		}
		
		bug1.changeDirection(Bug.DIRECTION.RIGHT);
		bug2.changeDirection(Bug.DIRECTION.LEFT);
		
		for (int i = 0; i < 5; i++) {
			bug1.moveForward();
			bug2.moveForward();
			System.out.println(bug1.toString() + "\t" + bug2.toString());
		}
	}
	
	//-----------------------------------------------------------------
		// Sequence for one bug
		//-----------------------------------------------------------------
		public static void oneBugPosition() {
			System.out.println("\nONE BUG AT POSITION 271");
			System.out.println("=======\n");
			Bug bug = new Bug(271);

			System.out.println(bug.toString());
			
			for (int i = 0; i < 7; i++) {
				bug.moveForward();
				System.out.println(bug.toString());
			}

			bug.changeDirection(Bug.DIRECTION.LEFT);
			
			for (int i = 0; i < 19; i++) {
				bug.moveForward();
				System.out.println(bug.toString());
			}
			
			bug.changeDirection(Bug.DIRECTION.RIGHT);
			
			for (int i = 0; i < 12; i++) {
				bug.moveForward();
				System.out.println(bug.toString());
			}
		}

}
