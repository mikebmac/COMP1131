//********************************************************************
// Bug.java
// 
// @author: Michael MacKay
// A bug class that instantiates and moves the bug depending on the 
// position it is facing.
//********************************************************************
package Assignment4_1;

import java.util.Random;

public class Bug {
	// ENUM for DIRECTION the bug is facing
	public enum DIRECTION {RIGHT, LEFT};
	
	// Private
	private int _pos;
	private DIRECTION _dir;
	private String _name;
	private Random rand;
	private String[] names = {"Buggy", "Ted", "Salu", "Aioobe", "Zeus", "Aries", "Lemon", "Odin", "Kora", "Nathan", "Jacob", "Jewls"};
	
	//-----------------------------------------------------------------
	// CONSTRUCTOR
	//
	// Creates a bug with a random name and default parameters.
	//-----------------------------------------------------------------
	Bug() {
		this._pos = 0; // default
		this._dir = DIRECTION.RIGHT; // default
		
		rand = new Random();
		int i = rand.nextInt(names.length);
		this._name = "Bug-" + names[i]; // default
	}
	
	//-----------------------------------------------------------------
	// CONSTRUCTOR
	//
	// Creates at a specific position 
	//-----------------------------------------------------------------
	Bug(int pos) {
		this._pos = pos; // default
		this._dir = DIRECTION.RIGHT; // default
		
		rand = new Random();
		int i = rand.nextInt(names.length);
		this._name = "Bug-" + names[i]; // default
	}

	//-----------------------------------------------------------------
	// CONSTRUCTOR
	//
	// Creates a bug with a random name facing a specific direction
	//-----------------------------------------------------------------
	Bug(DIRECTION dir) {
		this._pos = 0; // default
		this._dir = dir;

		rand = new Random();
		int i = rand.nextInt(names.length);
		this._name = "Bug-" + names[i]; // default
	}
	
	//-----------------------------------------------------------------
	// GETTER
	//
	// Gets the position of the bug.
	//-----------------------------------------------------------------
	public int getPosition() {
		return _pos;
	}
	
	//-----------------------------------------------------------------
	// GETTER
	//
	// Gets the direction the bug is facing.
	//-----------------------------------------------------------------
	public DIRECTION getDirection() {
		return _dir;
	}
	
	//-----------------------------------------------------------------
	// GETTER
	//
	// Gets the name of the bug.
	//-----------------------------------------------------------------
	public String getName() {
		return _name;
	}
	
	//-----------------------------------------------------------------
	// Return the bugs name, position and direction on the line
	//-----------------------------------------------------------------
	public String toString() {
		String s = new String(_name + " is at " + _pos + " facing " + _dir);
		return s;
	}
	
	//-----------------------------------------------------------------
	// Controls the bug movement, forces the bug to move in unit in the
	// direction it is facing.
	//
	// Return : An int of its new position
	//-----------------------------------------------------------------
	public int moveForward() {
		switch (_dir) {
			case RIGHT:
				// Moving + 1 in the X Axis
				_pos++;
				
				break;
			case LEFT:
				// Moving + 1 in the X Axis
				_pos--;
				
				break;
			default:
				// silence
		}
		return _pos;
	}
	
	//-----------------------------------------------------------------
	// Changes the direction of the bug.
	//
	// Return : The new direction
	//-----------------------------------------------------------------
	public DIRECTION changeDirection(DIRECTION dir) {
		_dir = dir;
		return _dir;
	}

}
