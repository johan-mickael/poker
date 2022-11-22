package poker.game;

import java.util.ArrayList;
import java.util.List;

import poker.card.Card;
import poker.card.Deck;

public class Game {
	private Deck deck;
	private List<Player> players;
	private boolean shuffle;
	
	public Game(boolean shuffle) {
		super();
		if (this.players == null) {
			this.players = new ArrayList<Player>();
		}
		this.shuffle = shuffle;
		this.initGame();
	}

	public void initGame() {
		this.initDeck();
	}
	
	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public boolean isShuffle() {
		return shuffle;
	}

	public void setShuffle(boolean shuffle) {
		this.shuffle = shuffle;
	}

	public void addPlayer(Player player) {
		this.players.add(player);
	}
	
	public void giveCard(Player player) {
		Card card = deck.getCards().remove(0);
		player.give(card);
	}
	
	public void distributeCards(int numberOfCards) {
		for (int i = 0; i < numberOfCards; i++) {
			for (Player player : this.players) {
				giveCard(player);
			}
		}
	}
	
	public void initDeck() {
		Deck deck = new Deck();
		this.setDeck(deck);
		if (this.shuffle) {
			this.deck.shuffle();
		}
	
		for (Player player : this.players) {
			player.ungiveAllCards();
		}
	}
	
	public void restart() {
		this.initDeck();
	}
	
}
