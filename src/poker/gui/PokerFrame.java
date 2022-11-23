package poker.gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PokerFrame extends JFrame {
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	
	public PokerFrame(JPanel panel) {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.add(panel);
	}
}
