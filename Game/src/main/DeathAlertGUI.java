package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class DeathAlertGUI {

	private JFrame frmDeathAlert;
	private String name;
	
	public DeathAlertGUI(String crewName) {
		name = crewName;
		initialize();
		frmDeathAlert.setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeathAlertGUI window = new DeathAlertGUI();
					window.frmDeathAlert.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DeathAlertGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDeathAlert = new JFrame();
		frmDeathAlert.setTitle("Death Alert");
		frmDeathAlert.setBounds(100, 100, 450, 300);
		frmDeathAlert.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmDeathAlert.getContentPane().setLayout(null);
		
		JTextArea txtrDeath = new JTextArea();
		txtrDeath.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		txtrDeath.setText(name + " took too much damage and died.");
		txtrDeath.setBounds(10, 77, 414, 65);
		frmDeathAlert.getContentPane().add(txtrDeath);
		
		JButton btnQuit = new JButton("Confirm");
		btnQuit.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmDeathAlert.dispose();
			}
		});
		btnQuit.setBounds(141, 167, 135, 43);
		frmDeathAlert.getContentPane().add(btnQuit);
	}

}
