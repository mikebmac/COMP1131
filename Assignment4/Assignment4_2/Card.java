//********************************************************************
// Card.java
// 
// @author: Michael MacKay
// The card class that can create a random or specific card.
//********************************************************************
package Assignment4_2;

// Used to select a random card
import java.util.Random;

public class Card {
	// Enum to organize the suit of the card
	public static enum SUIT {SPADES, HEARTS, DIAMONDS, CLUBS};
	// Enum to organize the face (value) of the card
	public static enum FACE {JOKER, ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING};
	
	// Private (Encapsulate these)
	private SUIT _suit;
	private FACE _face;
	
	//-----------------------------------------------------------------
	// CONSTRUCTOR
	//
	// Creates a random card
	//-----------------------------------------------------------------
	public Card() {
		Random rand = new Random();
		
		int i = rand.nextInt(SUIT.values().length);
		this._suit = SUIT.values()[i];
		
		
		int j = rand.nextInt(FACE.values().length - 1) + 1;
		this._face = FACE.values()[j];
		
	}
	
	//-----------------------------------------------------------------
	// CONSTRUCTOR
	//
	// Creates a specific card
	//-----------------------------------------------------------------
	public Card(SUIT suit, FACE face) {
		this._suit = suit;
		this._face = face;
	}
	
	//-----------------------------------------------------------------
	// GETTER
	//
	// Gets the suit of the card.
	//-----------------------------------------------------------------
	public SUIT getSuit() {
		return _suit;
	}
	
	//-----------------------------------------------------------------
	// GETTER
	//
	// Gets the face or value of the card.
	//-----------------------------------------------------------------
	public FACE getFace() {
		return _face;
	}
	
	//-----------------------------------------------------------------
	// GETTER
	//
	// Gets the face or value of the card and returns it as a string.
	//-----------------------------------------------------------------
	public String getFaceString() {
		return getFace().toString();
	}
	
	//-----------------------------------------------------------------
	// GETTER
	//
	// Gets the suit value of the card and returns it as a string.
	//-----------------------------------------------------------------
	public String getSuitString() {
		return getSuit().toString();
	}
	
	//-----------------------------------------------------------------
	// SETTER / MUTATOR
	//
	// Sets the suit value.
	//-----------------------------------------------------------------
	public void setFace(FACE face) {
		_face = face;
	}
	
	//-----------------------------------------------------------------
	// SETTER / MUTATOR
	//
	// Sets the suit value.
	//-----------------------------------------------------------------
	public void setSuit(SUIT suit) {
		_suit = suit;
	}
	
	//-----------------------------------------------------------------
	// Gets the face or value of the card.
	//-----------------------------------------------------------------
	public String toString() {
		String str = new String(getFace() + " of " + getSuit());
		return str;
	}
}
