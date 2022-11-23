package poker.card;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

public class Card implements Comparable<Card> {
	private int rank;
	private String color;
	private String label;
	private Color colorGUI;
	private String iconColor;

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
	
	public static final String I_HEART = "♥";
	public static final String I_DIAMOND = "♦";
	public static final String I_SPADE = "♠";
	public static final String I_CLUB = "♣";
	
	public static final Color RED = new Color(255, 0, 0);
	public static final Color BLACK = new Color(0, 0, 0);
	public static final Color WHITE = new Color(255, 255, 255);
	public static final Color LIGHT = new Color(240, 240, 240);

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
		this.rank = Card.getPrimeCardRanks()[rank - 2];
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
		switch (color) {
			case HEART:
				setColorGUI(RED);
				setIconColor(I_HEART);
				break;
			case DIAMOND:
				setColorGUI(RED);
				setIconColor(I_DIAMOND);
				break;
			case SPADE:
				setColorGUI(BLACK);
				setIconColor(I_SPADE);
				break;
			case CLUB:
				setColorGUI(BLACK);
				setIconColor(I_CLUB);
				break;
			default:
				// throw error here
				System.out.println("Invalid card colour found");
		}
	}

	public String getLabel() {
		return label;
	}
	
	public String getText() {
		return this.getNormalizedRankLabel() + "" + this.getIconColor();
	}

	public void setLabel(String label) {
		if (label.length() == 0) {
			label = this.getNormalizedRankLabel() + " of " + this.color;
		}
		this.label = label;
	}

	public Color getColorGUI() {
		return colorGUI;
	}

	public void setColorGUI(Color colorGUI) {
		this.colorGUI = colorGUI;
	}

	public String getIconColor() {
		return iconColor;
	}

	public void setIconColor(String iconColor) {
		this.iconColor = iconColor;
	}

	public static String[] getAllCardColors() {
		String[] colors = { HEART, DIAMOND, SPADE, CLUB, };
		return colors;
	}

	public String getNormalizedRankLabel() {
		List<Integer> list = Arrays.asList(Card.getPrimeCardRanks());
		return Card.getCardLabels()[list.indexOf(this.rank)];
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
			return Arrays.binarySearch(Card.getPrimeCardRanks(), this.rank) == Arrays.binarySearch(Card.getPrimeCardRanks(), card.rank)+ 1;
		}
		return Arrays.binarySearch(Card.getPrimeCardRanks(), this.rank) == Arrays.binarySearch(Card.getPrimeCardRanks(), card.rank)- 1;
	}

	public boolean isStraightAndHasSameColor(Card card, boolean descending) {
		return hasSameColor(card) && isStraight(card, descending);
	}

	@Override
	public int compareTo(Card c) {
		return Integer.compare(this.getRank(), c.getRank());
	}
	
	public static String[] getCardColors() {
		String[] values = { HEART, DIAMOND, SPADE, CLUB };
		return values;
	}
	
	public static String[] getCardIconColors() {
		String[] values = { I_HEART, I_DIAMOND, I_SPADE, I_CLUB };
		return values;
	}
	
	public static String[] getCardLabels() {
		String[] values = { TWO_LBL, THREE_LBL, FOR_LBL, FIVE_LBL, SIX_LBL, SEVEN_LBL, EIGHT_LBL,
				NINE_LBL, TEN_LBL, JACK_LBL, QUEEN_LBL, KING_LBL, AS_LBL };
		return values;
	}

	public static Color[] cardsIconsColorsGUI() {
		Color[] values = { RED, RED, BLACK, BLACK };
		return values;
	}
	public static Integer[] getPrimeCardRanks() {
		Integer[] values = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41 };
		return values;
	}
	
	
}
