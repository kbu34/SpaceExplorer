package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Font;

public class EndGameGUI {

	private JFrame frmGameOver;
	private Game game;
	private Spaceship mySpaceship;
	private int score;
	
	public EndGameGUI(Game mainGame, Spaceship spaceship) {
		game = mainGame;
		mySpaceship = spaceship;
		score = game.getPartsAquired() * 100;
		initialize();
		frmGameOver.setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EndGameGUI window = new EndGameGUI();
					window.frmGameOver.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EndGameGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGameOver = new JFrame();
		frmGameOver.setTitle("Game Over");
		frmGameOver.setBounds(100, 100, 271, 231);
		frmGameOver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGameOver.getContentPane().setLayout(null);
		
		JTextArea txtrGameOver = new JTextArea();
		txtrGameOver.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		txtrGameOver.setText("       Game Over\nShip name: " + mySpaceship.getName() + "\nTransporter Pieces: " + game.getPartsAquired() + "/" + game.getTotalParts() + "\nDays taken: " + game.getTurnNum() + "\nscore: " + score);
		txtrGameOver.setBounds(10, 11, 235, 181);
		frmGameOver.getContentPane().add(txtrGameOver);
	}

}
