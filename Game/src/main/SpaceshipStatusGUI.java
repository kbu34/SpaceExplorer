package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SpaceshipStatusGUI {

	private JFrame frame;
	private String status;
	private Game game;
	
	public SpaceshipStatusGUI(String shipStatus, Game mainGame) {
		status = shipStatus;
		game = mainGame;
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
					SpaceshipStatusGUI window = new SpaceshipStatusGUI();
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
	public SpaceshipStatusGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 674, 364);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea txtSpaceshipStatus = new JTextArea();
		txtSpaceshipStatus.setEditable(false);
		txtSpaceshipStatus.setText(status + "\n" + "Transporter Pieces: " + game.getPartsAquired() + "out of " + game.getTotalParts());
		txtSpaceshipStatus.setBounds(10, 11, 638, 254);
		frame.getContentPane().add(txtSpaceshipStatus);
		
		JButton btnQuit = new JButton("quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnQuit.setBounds(257, 276, 101, 39);
		frame.getContentPane().add(btnQuit);
	}

}
