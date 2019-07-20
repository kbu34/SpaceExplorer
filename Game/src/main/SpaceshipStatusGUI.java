package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class SpaceshipStatusGUI {

	private JFrame frmSpaceshipStatus;
	private String status;
	private Game game;
	
	public SpaceshipStatusGUI(String shipStatus, Game mainGame) {
		status = shipStatus;
		game = mainGame;
		initialize();
		frmSpaceshipStatus.setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpaceshipStatusGUI window = new SpaceshipStatusGUI();
					window.frmSpaceshipStatus.setVisible(true);
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
		frmSpaceshipStatus = new JFrame();
		frmSpaceshipStatus.setTitle("Spaceship Status");
		frmSpaceshipStatus.setBounds(100, 100, 674, 364);
		frmSpaceshipStatus.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmSpaceshipStatus.getContentPane().setLayout(null);
		
		JTextArea txtSpaceshipStatus = new JTextArea();
		txtSpaceshipStatus.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		txtSpaceshipStatus.setEditable(false);
		txtSpaceshipStatus.setText(status + "\n" + "Transporter Pieces: " + game.getPartsAquired() + " out of " + game.getTotalParts());
		txtSpaceshipStatus.setBounds(10, 11, 638, 254);
		frmSpaceshipStatus.getContentPane().add(txtSpaceshipStatus);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSpaceshipStatus.dispose();
			}
		});
		btnQuit.setBounds(257, 276, 101, 39);
		frmSpaceshipStatus.getContentPane().add(btnQuit);
	}

}
