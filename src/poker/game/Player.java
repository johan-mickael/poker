package poker.game;

import java.util.ArrayList;
import java.util.List;
import poker.card.Card;

public class Player {
	private String name;
	private List<Card> cards;
	private List<Card> chosenCards;
	
	public Player(String name) {
		super();
		this.setName(name);
		this.setCards(new ArrayList<Card>());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
	public List<Card> getChosenCards() {
		return chosenCards;
	}

	public void setChosenCards(List<Card> chosenCards) {
		this.chosenCards = chosenCards;
	}

	public void give(Card card) {
		if (this.cards.size() < 5) {
			this.cards.add(card);
		} else {
			// Throw error here
			System.out.println("Cannot give more than 5 cards to the player.");
		}
	}
	
	public void ungiveAllCards() {
		this.cards.clear();
	}
	
	public void chooseCard(Card card) {
		if (this.cards.contains(card)) {
			this.chosenCards.add(card);
		}
		// Throw error here
		System.out.println(String.format("The chosen card does not appear on %s hand.", this.name));
	}
	
	public void undoCard(Card card) {
		this.chosenCards.remove(card);
	}
		
}
