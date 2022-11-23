import java.util.List;

import poker.card.Card;
import poker.game.Game;
import poker.game.Hand;
import poker.game.Player;
import poker.gui.PokerFrame;

public class Main {

	public static void main(String[] args) {
		Game poker = new Game(true);
		
		Player p1 = new Player("Johan");
		
		List<Card> cards = poker.getDeck().getCards();
		
		
		poker.addPlayer(p1);
		
		poker.distributeCards(5);
		
//		Card c1 = new Card(13, "heart", "");
//		Card c2 = new Card(13, "heart", "");
//		Card c3 = new Card(14, "heart", "");
//		Card c4 = new Card(14, "heart", "");
//		Card c5 = new Card(14, "heart", "");
//		
//		Card c6 = new Card(2, "spades", "");
//		Card c7 = new Card(2, "heart", "");
//		Card c8 = new Card(2, "heart", "");
//		Card c9 = new Card(2, "heart", "");
//		Card c10 = new Card(3, "heart", "");
		
//		
//
//	
//		Hand hand1 = new Hand(p1.getChosenCards());
//		Hand hand2 = new Hand(poker.getCPU().getCards());
//		
//		for (Card card : p1.getCards()) {
//			System.out.println("P1: " + card.getLabel());
//		}
////		
//		hand1.check();
//		hand2.check();
////		
//		System.out.println(hand1.getValue() + " " + hand1.getHandValue());
//		System.out.println(hand2.getValue() + " " + hand2.getHandValue());
////	
//		System.out.println(hand1.winOver(hand2));
		
		new PokerFrame(poker);
		
	}

}
