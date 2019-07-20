package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class PlagueAlertGUI {

	private JFrame frame;
	private int crew;
	private Spaceship mySpaceship;
	
	public PlagueAlertGUI(int member, Spaceship spaceship) {
		crew = member;
		mySpaceship = spaceship;
		initialize();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlagueAlertGUI window = new PlagueAlertGUI();
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
	public PlagueAlertGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea txtrPlague = new JTextArea();
		txtrPlague.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		txtrPlague.setText("     WARNING\nSpace plague encountered.\n" + mySpaceship.crewGetter(crew).getName() + " was infected.");
		txtrPlague.setBounds(10, 11, 414, 161);
		frame.getContentPane().add(txtrPlague);
		
		JButton btnQuit = new JButton("Confirm");
		btnQuit.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnQuit.setBounds(143, 194, 111, 36);
		frame.getContentPane().add(btnQuit);
	}
}
