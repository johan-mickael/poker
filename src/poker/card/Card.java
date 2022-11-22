package poker.card;

import java.util.Arrays;
import java.util.List;

public class Card implements Comparable<Card> {
	private int rank;
	private String color;
	private String label;

	public static final String TWO_LBL = "2";
	public static final String THREE_LBL = "3";
	public static final String FOR_LBL = "4";
	public static final String FIVE_LBL = "5";
	public static final String SIX_LBL = "6";
	public static final String SEVEN_LBL = "7";
	public static final String EIGHT_LBL = "8";
	public static final String NINE_LBL = "9";
	public static final String TEN_LBL = "10";
	public static final String JACK_LBL = "J";
	public static final String QUEEN_LBL = "Q";
	public static final String KING_LBL = "K";
	public static final String AS_LBL = "A";

	public static final String HEART = "heart";
	public static final String DIAMOND = "diamond";
	public static final String SPADE = "spade";
	public static final String CLUB = "club";

	public static final String[] cardsLabels = { TWO_LBL, THREE_LBL, FOR_LBL, FIVE_LBL, SIX_LBL, SEVEN_LBL, EIGHT_LBL,
			NINE_LBL, TEN_LBL, JACK_LBL, QUEEN_LBL, KING_LBL, AS_LBL, };

	public static final Integer[] primeCardRank = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41 };
//	public static final Integer[] primeCardRank = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };

	public Card(int rank, String color, String label) {
		super();
		this.setRank(rank);
		this.setColor(color);
		this.setLabel(label);
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = Card.primeCardRank[rank - 2];
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		if (label.length() == 0) {
			label = this.getNormalizedRankLabel() + " of " + this.color;
		}
		this.label = label;
	}

	public static String[] getAllCardColors() {
		String[] colors = { HEART, DIAMOND, SPADE, CLUB, };
		return colors;
	}

	protected String getNormalizedRankLabel() {
		List<Integer> list = Arrays.asList(Card.primeCardRank);
		return Card.cardsLabels[list.indexOf(this.rank)];
	}

	public boolean hasSameColor(Card card) {
		return this.color.equals(card.color);
	}

	public boolean hasSameRank(Card card) {
		return this.rank == card.rank;
	}

	public boolean hasSameRankAndColor(Card card) {
		return hasSameRank(card) && hasSameColor(card);
	}

	public boolean isStraight(Card card, boolean descending) {
		if (descending) {
			return Arrays.binarySearch(Card.primeCardRank, this.rank) == Arrays.binarySearch(Card.primeCardRank, card.rank)+ 1;
		}
		return Arrays.binarySearch(Card.primeCardRank, this.rank) == Arrays.binarySearch(Card.primeCardRank, card.rank)- 1;
	}

	public boolean isStraightAndHasSameColor(Card card, boolean descending) {
		return hasSameColor(card) && isStraight(card, descending);
	}

	@Override
	public int compareTo(Card c) {
		return Integer.compare(this.getRank(), c.getRank());
	}

}
