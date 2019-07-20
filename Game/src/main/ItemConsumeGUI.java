package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ItemConsumeGUI {

	private JFrame frmSpaceExplorerItems;
	private JTextField itemTextField;
	private String items;
	private Crew member;
	private Spaceship mySpaceship;
	private JButton btnEnter;
	private JButton btnQuit;
	private JLabel lblWarning;
	
	public ItemConsumeGUI(Crew crewMember, Spaceship spaceship) {
		mySpaceship = spaceship;
		member = crewMember;
		initialize();
		frmSpaceExplorerItems.setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ItemConsumeGUI window = new ItemConsumeGUI();
					window.frmSpaceExplorerItems.setVisible(true);
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
		frmSpaceExplorerItems = new JFrame();
		frmSpaceExplorerItems.setTitle("Space Explorer Items");
		frmSpaceExplorerItems.setBounds(100, 100, 613, 562);
		frmSpaceExplorerItems.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmSpaceExplorerItems.getContentPane().setLayout(null);
		
		JTextArea itemTextArea = new JTextArea();
		itemTextArea.setText(mySpaceship.getInventory());
		itemTextArea.setEditable(false);
		itemTextArea.setBounds(10, 11, 328, 501);
		frmSpaceExplorerItems.getContentPane().add(itemTextArea);
		
		itemTextField = new JTextField();
		itemTextField.setBounds(348, 280, 228, 29);
		frmSpaceExplorerItems.getContentPane().add(itemTextField);
		itemTextField.setColumns(10);
		
		JLabel lblPleaseEnterThe = new JLabel("Please enter the item's number.");
		lblPleaseEnterThe.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblPleaseEnterThe.setBounds(348, 212, 228, 35);
		frmSpaceExplorerItems.getContentPane().add(lblPleaseEnterThe);
		
		btnEnter = new JButton("Enter");
		btnEnter.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String itemNumStr = itemTextField.getText();
				int itemNum = Integer.parseInt(itemNumStr);
				if (itemNum > 0 && mySpaceship.lenInventory() >= itemNum) {
					member.consumeItem(mySpaceship.inventoryGetter(itemNum - 1), mySpaceship);
					frmSpaceExplorerItems.dispose();
				} else {
					lblWarning.setText("Please enter a valid item number.");
				}
			}
		});
		btnEnter.setBounds(402, 329, 108, 29);
		frmSpaceExplorerItems.getContentPane().add(btnEnter);
		
		btnQuit = new JButton("Quit");
		btnQuit.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSpaceExplorerItems.dispose();
			}
		});
		btnQuit.setBounds(402, 438, 108, 29);
		frmSpaceExplorerItems.getContentPane().add(btnQuit);
		
		lblWarning = new JLabel("");
		lblWarning.setBounds(348, 369, 239, 35);
		frmSpaceExplorerItems.getContentPane().add(lblWarning);
	}

}
