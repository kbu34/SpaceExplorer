package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PirateAlertGUI {

	private JFrame frame;
	private Item item;
	
	public PirateAlertGUI(Item stolen) {
		item = stolen;
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
					PirateAlertGUI window = new PirateAlertGUI();
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
	public PirateAlertGUI() {
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
		
		JTextArea txtrPirates = new JTextArea();
		txtrPirates.setText("                      WARNING\nAlien pirates boarded the ship and stole an item!\nItem stolen: " + item.getName());
		txtrPirates.setBounds(10, 11, 414, 177);
		frame.getContentPane().add(txtrPirates);
		
		JButton btnQuit = new JButton("confirm");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnQuit.setBounds(146, 199, 129, 37);
		frame.getContentPane().add(btnQuit);
	}

}
