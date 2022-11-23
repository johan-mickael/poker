package poker.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import poker.card.Card;
import util.Position;

public class CardGUI {
	private Card card;
	private Position position;
	private Graphics2D g2d;
	
	private static final int WIDTH = 100;
	private static final int HEIGHT = 120;
	public static final int FONT_SIZE = 20;
	
	public CardGUI(Card card, Position position, Graphics g) {
		this.setCard(card);
		this.setPosition(position);
		this.setGraphics((Graphics2D) g);
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}
	
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Graphics getGraphics() {
		return g2d;
	}

	public void setGraphics(Graphics2D graphics) {
		this.g2d = graphics;
	}

	public void draw() {
		
		this.g2d.setColor(Card.LIGHT);
		this.g2d.fillRect(this.position.getX(), this.position.getY(), WIDTH, HEIGHT);
		this.g2d.setColor(this.card.getColorGUI());
		this.g2d.setFont(new Font("TimesRoman", Font.BOLD, FONT_SIZE));
		
		String label = this.card.getNormalizedRankLabel();
		int labelSize = label.length();
		
		this.g2d.drawString(
			label, 
			this.position.getX() + 5, 
			this.position.getY() + 20
		);
		this.g2d.drawString(
			label, 
			this.position.getX() + WIDTH-20*labelSize, 
			this.position.getY() + HEIGHT-8
		);
		
		int iconColorSize = FONT_SIZE * 3;
		this.g2d.setFont(new Font("TimesRoman", Font.BOLD, iconColorSize));
		
		this.g2d.drawString(
			this.card.getIconColor(), 
			this.getPosition().getX() + (WIDTH/2) - ((iconColorSize/2)-5), 
			this.position.getY()+(HEIGHT/2) + ((iconColorSize/2)-10) 
		);
	}
	
}	
