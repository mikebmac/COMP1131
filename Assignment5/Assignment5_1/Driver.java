//********************************************************************
// Driver.java
// 
// @author: Michael MacKay
// Creates a random array, telling the user the min, max and mean.
// Finally prints out all items in the array.
//********************************************************************
package A5_1;

public class Driver {
	public static void main(String args[]) {
		// Create the Random Array
		RandomArray rndArray = new RandomArray(10);
		
		// Print out the minimum value
		System.out.println("MIN: " + rndArray.getMin());
		
		// Print out the maximum value
		System.out.println("MAX: " + rndArray.getMax());
		
		// Print out the mean value
		System.out.println("MEAN: " + rndArray.getMean());
		
		// Print out all items in the array as a string
		System.out.println("ALL VALUES:\n" + rndArray.toString());
		
	}
}
