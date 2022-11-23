package poker.gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import poker.game.Game;

public class PokerFrame extends JFrame {
	
	public static final int WIDTH = 580;
	public static final int HEIGHT = 490;
	
	private GamePanel gamePanel;
	
	public PokerFrame(Game game) {
		this.setTitle("🃏 Low cost poker :)");
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
		
		GamePanel gp = new GamePanel(game);
		
		this.add(gp);
	}

	public GamePanel getGamePanel() {
		return gamePanel;
	}

	public void setGamePanel(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
}
