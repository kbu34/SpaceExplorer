package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AstroidAlertGUI {

	private JFrame frame;
	private JTextArea txtrAstroid;
	private int damage;
	private Spaceship mySpaceship;
	
	public AstroidAlertGUI(int totalDamage, Spaceship spaceship) {
		damage = totalDamage;
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
					AstroidAlertGUI window = new AstroidAlertGUI();
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
	public AstroidAlertGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtrAstroid = new JTextArea();
		txtrAstroid.setText("    WARNING\n Your ship has encountered an astroid belt.\nTotal damage: " + damage + "\nCurrent spaceship health: " + mySpaceship.getHealth());
		txtrAstroid.setEditable(false);
		txtrAstroid.setBounds(10, 11, 414, 184);
		frame.getContentPane().add(txtrAstroid);
		
		JButton btnQuit = new JButton("confirm");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnQuit.setBounds(145, 206, 126, 32);
		frame.getContentPane().add(btnQuit);
	}
}
