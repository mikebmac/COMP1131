//********************************************************************
// Driver.java
// 
// @author: Michael MacKay
// Driver class that creates a deck of cards, displays the data,
// shuffles the deck and, finally, deals each card.
//********************************************************************
package A5_2;

public class Driver {

	public static void main(String[] args) {
		DeckOfCards cards = new DeckOfCards();
		
		System.out.println("Creating Deck\n===========");
		
		System.out.println(cards.toString());
		
		System.out.println("\nShuffling Deck...\n");
		cards.shuffle();
		
		System.out.println("Dealing Deck\n===========");
		for(int i = 0; i < cards.length(); i++) {
			System.out.println(cards.cardToString(i));
		}

	}

}
