import java.util.ArrayList;
import java.util.List;

import poker.card.Card;
import poker.game.Game;
import poker.game.Hand;
import poker.game.Player;

public class Main {

	public static void main(String[] args) {
		Game poker = new Game(true);
		
		Player p1 = new Player("Nancy");
		Player p2 = new Player("Johan");
		
		List<Card> cards = poker.getDeck().getCards();
		
		
		poker.addPlayer(p1);
		poker.addPlayer(p2);
		
		poker.distributeCards(5);
		
//		Card c1 = new Card(4, "heart", "");
//		Card c2 = new Card(3, "heart", "");
//		Card c3 = new Card(7, "heart", "");
//		Card c4 = new Card(8, "heart", "");
//		Card c5 = new Card(10, "heart", "");
//		
//		Card c6 = new Card(2, "spades", "");
//		Card c7 = new Card(2, "heart", "");
//		Card c8 = new Card(2, "heart", "");
//		Card c9 = new Card(2, "heart", "");
//		Card c10 = new Card(5, "heart", "");
//		
//		p1.give(c1);
//		p1.give(c2);
//		p1.give(c3);
//		p1.give(c4);
//		p1.give(c5);
//		
//		p2.give(c6);
//		p2.give(c7);
//		p2.give(c8);
//		p2.give(c9);
//		p2.give(c10);
		
//		
//
//	
		Hand hand1 = new Hand(p1.getCards());
		Hand hand2 = new Hand(p2.getCards());
//		
		hand1.check();
		hand2.check();
//		
//		System.out.println(hand2.getMappedCard());
//		
//		System.out.println(hand1.getValue() + " " + hand1.getHandValue());
//		System.out.println(hand2.getValue() + " " + hand2.getHandValue());
//	
		System.out.println(hand2.winOver(hand1));
		
	}

}
