//********************************************************************
// DeckOfCards.java
// 
// @author: Michael MacKay
// Creates a deck of cards using the an array from the Card class.
// Allows the user to shuffle the deck to randomize the cards.
//********************************************************************
package A5_2;

import java.util.Random;

public class DeckOfCards {
	private Card[] _deckOfCards;
	
	//-----------------------------------------------------------------
	// CONSTRUCTOR
	//
	// Creates a full deck of cards
	//-----------------------------------------------------------------
	DeckOfCards() {
		// Create the array of cards
		_deckOfCards = new Card[52];
		
		// Loop through the suits of the cards
		for (int i = 0; i < 4; i++) {
			
			// Select a suit based on the value of [i] in the loop
			Card.SUIT suit = Card.SUIT.values()[i];
			
			// Loop through the faces (values) of the cards
			for (int j = 0; j < 13; j++) {
				
				// Calculating the current index
				// Formula: SuitValue * 13 + FaceValue
				int index = i * 13 + j;
				
				// Create the card at the index
				// Offset the face value because we started at 0 while the
				// first card, the ace, has a value of one.
				_deckOfCards[index] = new Card(suit, Card.FACE.values()[j + 1]);
			}
		}
	}
	
	//-----------------------------------------------------------------
	// Pseudo GETTER / ACCESSOR
	//
	// Get the length of the array
	//-----------------------------------------------------------------
	public int length() {
		return _deckOfCards.length;
	}
	
	//-----------------------------------------------------------------
	// Shuffles the deck
	//-----------------------------------------------------------------
	public void shuffle() {
		// Declare and instantiate a random element
		Random rdn = new Random();
		
		// Loop through the whole deck
		for (int i = 0; i < _deckOfCards.length; i++) {
			// Get two random integers to serve as random indexes to swap
			int tIndex1 = rdn.nextInt(_deckOfCards.length);
			int tIndex2 = rdn.nextInt(_deckOfCards.length);
			
			// Create a temporary Card to store the value of the cards 
			// as we swap them
			Card tCard2 = _deckOfCards[tIndex2];
			
			// Swap the cards
			_deckOfCards[tIndex2] = _deckOfCards[tIndex1];
			_deckOfCards[tIndex1] = tCard2;
		}
	}
	
	//-----------------------------------------------------------------
	// Returns a card at a specific index as a string
	// Used to simulate that a card is being dealt.
	//-----------------------------------------------------------------
	public String cardToString(int index) {
		// We want to make sure the index exists in our deck
		if (0 > index || index > _deckOfCards.length) {
			return new String("ERROR: Index outside range of cards.");
		}
		
		// Return the specific card's string.
		return new String("Deal number " + (index + 1) + ":\t" + _deckOfCards[index].toString() );
	}
	
	//-----------------------------------------------------------------
	// Returns all items of the array as a string
	//-----------------------------------------------------------------
	public String toString() {
		// Declare and instantiate the string
		String str = new String("[ \n");
		
		// Loop through the array concatenating all items to the string
		for (int i = 0; i <_deckOfCards.length; i++) {
			str = str.concat("\tIndex [" + i + "]\t" + _deckOfCards[i].toString() + ",\n");
		}
		
		// Let the user know the array is closed
		str = str.concat("]");
		
		return str;
	}
}
