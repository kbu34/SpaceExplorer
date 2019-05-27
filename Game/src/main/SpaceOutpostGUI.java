package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SpaceOutpostGUI {

	private JFrame frame;
	private JTextField outpostTextField;
	private JLabel lblCurrentMoney;
	private JLabel lblOutpost;
	private Spaceship mySpaceship;
	private int money;
	private String moneyStr;
	private JTextArea txtCurrentInventory;
	
	public SpaceOutpostGUI(Spaceship spaceship) {
		mySpaceship = spaceship;
		money = mySpaceship.getMoney();
		moneyStr = Integer.toString(money);
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
					SpaceOutpostGUI window = new SpaceOutpostGUI();
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
	public SpaceOutpostGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 957, 547);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea outpostTextArea = new JTextArea();
		outpostTextArea.setText("                             Items for sale\r\n\r\n1. Pizza (Effect: reduces hunger by 20. Price: 20)\r\n2. Diazepam (Effect: heals user by 20. Price: 20)\r\n3. Plague Medicine (Effect: cures space plague. Price: 50\");\r\n");
		outpostTextArea.setEditable(false);
		outpostTextArea.setBounds(10, 11, 560, 220);
		frame.getContentPane().add(outpostTextArea);
		
		lblOutpost = new JLabel("PLease enter the number of item you wish to purchae");
		lblOutpost.setBounds(126, 242, 347, 33);
		frame.getContentPane().add(lblOutpost);
		
		outpostTextField = new JTextField();
		outpostTextField.setBounds(164, 351, 117, 33);
		frame.getContentPane().add(outpostTextField);
		outpostTextField.setColumns(10);
		
		JButton btnPurchase = new JButton("purchase");
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String itemNumStr = outpostTextField.getText();
				int itemNum = Integer.parseInt(itemNumStr);
				mySpaceship.outpost(itemNum);
				money = mySpaceship.getMoney();
				moneyStr = Integer.toString(money);
				lblCurrentMoney.setText("Current money: " + moneyStr);
				txtCurrentInventory.setText(mySpaceship.getInventory());
			}
		});
		btnPurchase.setBounds(164, 408, 132, 33);
		frame.getContentPane().add(btnPurchase);
		
		JButton btnQuit = new JButton("quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnQuit.setBounds(412, 408, 125, 33);
		frame.getContentPane().add(btnQuit);
		
		lblCurrentMoney = new JLabel("Current money: " + moneyStr);
		lblCurrentMoney.setBounds(58, 285, 211, 44);
		frame.getContentPane().add(lblCurrentMoney);
		
		txtCurrentInventory = new JTextArea();
		txtCurrentInventory.setText(mySpaceship.getInventory());
		txtCurrentInventory.setBounds(592, 11, 339, 486);
		frame.getContentPane().add(txtCurrentInventory);
	}

}
