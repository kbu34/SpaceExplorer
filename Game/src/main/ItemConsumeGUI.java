package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ItemConsumeGUI {

	private JFrame frame;
	private JTextField itemTextField;
	private String items;
	private Crew member;
	private Spaceship mySpaceship;
	private JButton btnEnter;
	private JButton btnQuit;
	
	public ItemConsumeGUI(Crew crewMember, Spaceship spaceship) {
		mySpaceship = spaceship;
		member = crewMember;
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
					ItemConsumeGUI window = new ItemConsumeGUI();
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
	public ItemConsumeGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 613, 562);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea itemTextArea = new JTextArea();
		itemTextArea.setText(mySpaceship.getInventory());
		itemTextArea.setEditable(false);
		itemTextArea.setBounds(10, 11, 328, 501);
		frame.getContentPane().add(itemTextArea);
		
		itemTextField = new JTextField();
		itemTextField.setBounds(348, 280, 228, 29);
		frame.getContentPane().add(itemTextField);
		itemTextField.setColumns(10);
		
		JLabel lblPleaseEnterThe = new JLabel("Please enter the item's number.");
		lblPleaseEnterThe.setBounds(348, 212, 228, 35);
		frame.getContentPane().add(lblPleaseEnterThe);
		
		btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String itemNumStr = itemTextField.getText();
				int itemNum = Integer.parseInt(itemNumStr);
				member.consumeItem(mySpaceship.inventoryGetter(itemNum - 1), mySpaceship);
				frame.dispose();
			}
		});
		btnEnter.setBounds(402, 329, 108, 29);
		frame.getContentPane().add(btnEnter);
		
		btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnQuit.setBounds(402, 438, 108, 29);
		frame.getContentPane().add(btnQuit);
	}

}
