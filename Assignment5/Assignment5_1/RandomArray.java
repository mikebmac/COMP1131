package A5_1;
//********************************************************************
// RandomArray.java
// 
// @author: Michael MacKay
// Creates a random array of a specific size. Allows the user to get
// the min, max, mean values; as well as printing out all the items
// of the array as a string.
//********************************************************************
import java.util.Random;

public class RandomArray {
	private int[] _array;
	
	//-----------------------------------------------------------------
	// CONSTRUCTOR
	//
	// Creates a randomly populated array of a specific size
	//-----------------------------------------------------------------
	RandomArray(int size) {
		Random rnd = new Random();
		_array = new int[size];
		
		for (int i = 0; i < size; i++) {
			// Populate the array
			// Make sure we + 1 to the nextInt call to make sure we include the size value
			_array[i] = rnd.nextInt(size + 1);
			
		}
	}
	
	//-----------------------------------------------------------------
	// Pseudo GETTER / ACCESSOR
	//
	// Get the minimum value in the array.
	//-----------------------------------------------------------------
	public int getMin() {
		// Set the minimum value to the highest possible value to start
		int min = _array.length;
		
		// Loop through the array comparing each item to the minimum value
		for (int i = 0; i < _array.length; i++) {
			if (_array[i] < min) {
				min = _array[i];
			}
		}
		
		return min;
	}
	
	//-----------------------------------------------------------------
	// Pseudo GETTER / ACCESSOR
	//
	// Gets the maximum value in the array
	//-----------------------------------------------------------------
	public int getMax() {
		// Set the maximum value to the lowest possible value to start
		int max = 0;
		
		// Loop through the array comparing each item to the maximum value
		for (int i = 0; i < _array.length; i++) {
			if (_array[i] > max) {
				max = _array[i];
			}
		}
		
		return max;
	}
	
	//-----------------------------------------------------------------
	// Pseudo GETTER / ACCESSOR
	//
	// Gets the maximum value in the array
	//-----------------------------------------------------------------
	public double getMean() {
		// Set the minimum value to the highest possible value to start
		int items = _array.length;
		int runningTotal = 0;
		
		// Loop through the array adding each item to the running total
		for (int i = 0; i < _array.length; i++) {
			runningTotal += _array[i];
		}
		
		// Calculate the mean, casting the integers as doubles
		double mean = (double)runningTotal / (double)items;
		
		return mean;
	}
	
	//-----------------------------------------------------------------
	// Returns all items of the array as a string
	//-----------------------------------------------------------------
	public String toString() {
		// Declare and instantiate the string
		String str = new String("[ \n");
		
		// Loop through the array concatenating all items to the string
		for (int i = 0; i <_array.length; i++) {
			str = str.concat("\tIndex [" + i + "]\t" + _array[i] + ",\n");
		}
		
		// Let the user know the array is closed
		str = str.concat("]");
		
		return str;
	}
}
