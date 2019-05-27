package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class EndGameGUI {

	private JFrame frame;
	private Game game;
	private Spaceship mySpaceship;
	
	public EndGameGUI(Game mainGame, Spaceship spaceship) {
		game = mainGame;
		mySpaceship = spaceship;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EndGameGUI window = new EndGameGUI();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 271, 231);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea txtrGameOver = new JTextArea();
		txtrGameOver.setText("       game over\n" + "Ship name: " + mySpaceship.getName() + "\nTransporter Pieces: " + game.getPartsAquired() + "/" + game.getTotalParts() +"\nDays taken: " + game.getTurnNum() + "\nscore: " + game.getPartsAquired() * 100);
		txtrGameOver.setBounds(10, 11, 414, 239);
		frame.getContentPane().add(txtrGameOver);
	}

}
