//********************************************************************
// Driver.java
// 
// @author: Michael MacKay
// The class that deals cards 5 random cards and two specific cards
//********************************************************************
package Assignment4_2;

public class Driver {

	//-----------------------------------------------------------------
	// Called by the the program, give introduction and start program
	//
	// I use it as a Init() type of method
	//-----------------------------------------------------------------
	public static void main(String[] args) {
		
		// Instructions
		System.out.println("Five Random Cards\n==========");
		// Create 5 random cards and print them to the console
		Card card1 = new Card();
		System.out.println("FACE: " + card1.getFaceString() + "\tSUIT: " + card1.getSuitString() + "\n" + card1.toString());
		Card card2 = new Card();
		System.out.println("FACE: " + card2.getFaceString() + "\tSUIT: " + card2.getSuitString() + "\n" + card2.toString());
		Card card3 = new Card();
		System.out.println("FACE: " + card3.getFaceString() + "\tSUIT: " + card3.getSuitString() + "\n" + card3.toString());
		Card card4 = new Card();
		System.out.println("FACE: " + card4.getFaceString() + "\tSUIT: " + card4.getSuitString() + "\n" + card4.toString());
		Card card5 = new Card();
		System.out.println("FACE: " + card5.getFaceString() + "\tSUIT: " + card5.getSuitString() + "\n" + card5.toString());
		
		// Instructions
		System.out.println("\n\nSelected Cards\n==========");
		// Create 2 specific cards and print them to the console
		Card card6 = new Card(Card.SUIT.HEARTS, Card.FACE.QUEEN);
		System.out.println("FACE: " + card6.getFaceString() + "\tSUIT: " + card6.getSuitString() + "\n" + card6.toString());
		Card card7 = new Card(Card.SUIT.SPADES, Card.FACE.ACE);
		System.out.println("FACE: " + card7.getFaceString() + "\tSUIT: " + card7.getSuitString() + "\n" + card7.toString());
	}

}
