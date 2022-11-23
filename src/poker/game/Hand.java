package poker.game;

import java.math.BigInteger;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import poker.card.Card;

public class Hand implements Comparable<Hand> {
	private List<Card> cards;
	private Map<Integer, Integer> mappedCard;
	private int value;
	
	public static final int ROYAL_FLUSH = 1000000000;
	public static final int STRAIGHT_FLUSH = 100000000;
	public static final int FOUR_OF_A_KIND = 10000000;
	public static final int FULL_HOUSE = 1000000;
	public static final int FLUSH = 100000;
	public static final int STRAIGHT = 10000;
	public static final int THREE_OF_A_KIND = 1000;
	public static final int TWO_PAIR = 100;
	public static final int ONE_PAIR = 10;
	public static final int HIGHEST = 0;
	

	public Hand(List<Card> cards) {
		Collections.sort(cards);
		Collections.reverse(cards);
		this.setCards(cards);
	}

	public List<Card> getCards() {
		return cards;
	}
	
	public Map<Integer, Integer> getMappedCard() {
		return this.mappedCard;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
		this.mappedCard = this.getCardsOccurrences();
	}
	
	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean checkRankOccurrences(int occurrences, int startIndex) {
		Card firstCard = this.cards.get(startIndex);
		for (int i = startIndex+1; i < occurrences-1; i++) {
			if (!firstCard.hasSameRank(cards.get(i))) {
				return false;
			}
		}
		return true;
	}

	public boolean checkRankOccurrencesByStartIndexes(int occurences) {
		int cardSize = this.cards.size() - occurences;
		for (int i = 0; i <= cardSize; i++) {
			if (this.checkRankOccurrences(occurences, i)) {
				return true;
			}
		}
		return false;
	}

	public boolean checkStraightFlush() {
		if (this.cards.size() < 5) {
			return false;
		}
		for (int i = 0; i < cards.size()-1; i++) {
			if (!cards.get(i).isStraightAndHasSameColor(cards.get(i + 1), true)) {
				return false;
			}
		}
		this.setValue(STRAIGHT_FLUSH);
		return true;
	}

	public boolean checkRoyalFlush() {
		if (this.cards.size() < 5) {
			return false;
		}
		if (this.getCards().get(0).getRank() == Card.getPrimeCardRanks()[12] && this.checkStraightFlush()) {
			this.setValue(ROYAL_FLUSH);
			return true;
		}
		return false;
	}

	public boolean checkFourOfAKind() {
		if (this.cards.size() < 4) {
			return false;
		}
		if (this.mappedCard.size() == 2 && this.getMappedCardValue() == 4) {
			this.setValue(FOUR_OF_A_KIND);
			return true;
		}
		return false;
	}

	public boolean checkFullHouse() {
		if (cards.size() < 5) {
			return false;
		}
		
		if (this.mappedCard.size() == 2 && this.getMappedCardValue() == 6) {
			this.setValue(FULL_HOUSE);
			return true;
		}
		
		return false;
	}
	
	public boolean checkFlush() {
		if (cards.size() < 5) {
			return false;
		}
		for (int i = 0; i < cards.size()-1; i++) {
			if (!cards.get(i).hasSameColor(cards.get(i + 1))) {
				return false;
			}
		}
		this.setValue(FLUSH);
		return true;
	}
	
	public boolean checkStraight() {
		if (cards.size() < 5) {
			return false;
		}
		for (int i = 0; i < cards.size()-1; i++) {
			if (!cards.get(i).isStraight(cards.get(i + 1), true)) {
				return false;
			}
		}
		this.setValue(STRAIGHT);
		return true;
	}

	public boolean checkThreeOfAKind() {
		if (!this.checkRankOccurrencesByStartIndexes(3)) {
			return false;
		}
		this.setValue(THREE_OF_A_KIND);
		return true;
	}
	
	public boolean checkTwoPairs() {
		if (cards.size() < 4) {
			return false;
		}
		if (this.mappedCard.size() == 3 && this.getMappedCardValue() == 4) {
			this.setValue(TWO_PAIR);
			return true;
		}
		return false;
	}
	
	public boolean checkOnePair() {
		if (!this.checkRankOccurrencesByStartIndexes(2)) {
			return false;
		}
		this.setValue(ONE_PAIR);
		return true;
	}
	
	private Map<Integer, Integer> getCardsOccurrences() {
		Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		for (Card card: this.cards) {
			Integer occurrence = hashMap.get(card.getRank());
			hashMap.put(card.getRank(), (occurrence == null) ? 1 : occurrence+1);
		}
		return hashMap;
	}
	
	public int getMappedCardValue() {
		int result = 1;
		for (Map.Entry<Integer, Integer> val : this.mappedCard.entrySet()) {
			result *= val.getValue();
		}
		return result;
	}
	
	public long getHandValue() {
		int result = 1;
		for (Map.Entry<Integer, Integer> val : this.mappedCard.entrySet()) {
			result += Math.pow(val.getKey(), val.getValue());
		}
		return result + (this.value);
	}
	
	@Override
	public int compareTo(Hand h) {
		return Long.compare(this.getHandValue(), h.getHandValue());
	}
	
	public boolean winOver(Hand h) {
		return this.compareTo(h) > 0;
	}
	
	public long check() {
		if (
			checkRoyalFlush() || 
			checkStraightFlush() || 
			checkFourOfAKind() ||
			checkFullHouse() ||
			checkFlush() ||
			checkStraight() ||
			checkThreeOfAKind() ||
			checkTwoPairs() ||
			checkOnePair()
		) {}
		return this.getHandValue(); 
	}

}
