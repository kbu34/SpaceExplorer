package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class PirateAlertGUI {

	private JFrame frmPirateInvasion;
	private Item item;
	
	public PirateAlertGUI(Item stolen) {
		item = stolen;
		initialize();
		frmPirateInvasion.setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PirateAlertGUI window = new PirateAlertGUI();
					window.frmPirateInvasion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PirateAlertGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPirateInvasion = new JFrame();
		frmPirateInvasion.setTitle("Pirate Invasion!");
		frmPirateInvasion.setBounds(100, 100, 450, 300);
		frmPirateInvasion.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmPirateInvasion.getContentPane().setLayout(null);
		
		JTextArea txtrPirates = new JTextArea();
		txtrPirates.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		txtrPirates.setText("                      WARNING\nAlien pirates boarded the ship and stole an item!\nItem stolen: " + item.getName());
		txtrPirates.setBounds(10, 11, 414, 177);
		frmPirateInvasion.getContentPane().add(txtrPirates);
		
		JButton btnQuit = new JButton("Confirm");
		btnQuit.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPirateInvasion.dispose();
			}
		});
		btnQuit.setBounds(146, 199, 129, 37);
		frmPirateInvasion.getContentPane().add(btnQuit);
	}

}
