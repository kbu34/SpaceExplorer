package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AstroidAlertGUI {

	private JFrame frmAstroidAlert;
	private JTextArea txtrAstroid;
	private int damage;
	private Spaceship mySpaceship;
	
	public AstroidAlertGUI(int totalDamage, Spaceship spaceship) {
		damage = totalDamage;
		mySpaceship = spaceship;
		initialize();
		frmAstroidAlert.setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AstroidAlertGUI window = new AstroidAlertGUI();
					window.frmAstroidAlert.setVisible(true);
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
		frmAstroidAlert = new JFrame();
		frmAstroidAlert.setTitle("Astroid Alert!");
		frmAstroidAlert.setBounds(100, 100, 450, 300);
		frmAstroidAlert.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAstroidAlert.getContentPane().setLayout(null);
		
		txtrAstroid = new JTextArea();
		txtrAstroid.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		txtrAstroid.setText("    WARNING\n Your ship has encountered an astroid belt.\nTotal damage: " + damage + "\nCurrent spaceship health: " + mySpaceship.getHealth());
		txtrAstroid.setEditable(false);
		txtrAstroid.setBounds(10, 11, 414, 184);
		frmAstroidAlert.getContentPane().add(txtrAstroid);
		
		JButton btnQuit = new JButton("Confirm");
		btnQuit.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAstroidAlert.dispose();
			}
		});
		btnQuit.setBounds(145, 206, 126, 32);
		frmAstroidAlert.getContentPane().add(btnQuit);
	}
}
