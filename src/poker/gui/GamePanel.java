package poker.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

import poker.card.Card;
import poker.game.Game;
import poker.game.Player;
import util.Position;

public class GamePanel extends JPanel {
	private Game game;
	private Player player;
	private Player cpu;
	
	public GamePanel(Game game) {
		this.setGame(game);
		this.setBackground(new Color(20, 20, 20));
		this.setVisible(true);
	}
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
		initPlayers();
	}
	
	public void initPlayers() {
		this.cpu = this.game.getCPU();
		this.player = this.game.getPlayer();
	}

	public void paint(Graphics g) {
		super.paint(g);
		List<CardGUI> cardGUI_CPU = this.cpu.makeCardsGUI(g, 10);
		List<CardGUI> cardGUI_Player = this.player.makeCardsGUI(g, 300);
		drawCards(cardGUI_CPU);
		drawCards(cardGUI_Player);
	}
	
	protected void drawCards(List<CardGUI> cardsGUI) {
		for (CardGUI cardGUI : cardsGUI) {
			cardGUI.draw();
		}
	}
}
