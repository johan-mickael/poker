package poker.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import poker.card.Card;
import util.Position;

public class GamePanel extends JPanel {
	public GamePanel() {
		this.setBackground(new Color(20, 20, 20));
		this.setVisible(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		CardGUI card = new CardGUI(new Card(2, "heart", ""), new Position(10, 10), g);		
		CardGUI card2 = new CardGUI(new Card(10, "spade", ""), new Position(10, 200), g);		
		CardGUI card3 = new CardGUI(new Card(14, "diamond", ""), new Position(10, 400), g);		
		CardGUI card4 = new CardGUI(new Card(12, "club", ""), new Position(200, 200), g);		
		
		
		card.draw();
		card2.draw();
		card3.draw();
		card4.draw();
	}
}
