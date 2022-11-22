package poker.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> cards;

	public Deck() {
		List<Card> cards = new ArrayList<Card>();
		String[] color = Card.getAllCardColors();
		for (int i = 2; i <= 14; i++) {
			for (int j = 0; j < color.length; j++) {
				cards.add(new Card(i, color[j], ""));
			}
		}
		this.setCards(cards);
	}
	
	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
	public void shuffle() {
		Collections.shuffle(this.cards);
 	}
	
}
