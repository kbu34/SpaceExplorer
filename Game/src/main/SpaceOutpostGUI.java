package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class SpaceOutpostGUI {

	private JFrame frmSpaceOutpost;
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
		frmSpaceOutpost.setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpaceOutpostGUI window = new SpaceOutpostGUI();
					window.frmSpaceOutpost.setVisible(true);
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
		frmSpaceOutpost = new JFrame();
		frmSpaceOutpost.setTitle("Space Outpost");
		frmSpaceOutpost.setBounds(100, 100, 957, 547);
		frmSpaceOutpost.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmSpaceOutpost.getContentPane().setLayout(null);
		
		JTextArea outpostTextArea = new JTextArea();
		outpostTextArea.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		outpostTextArea.setText("                             Items for sale\r\n\r\n1. Pizza (Effect: reduces hunger by 20. Price: 20)\r\n2. Diazepam (Effect: heals user by 20. Price: 20)\r\n3. Plague Medicine (Effect: cures space plague. Price: 50\");\r\n");
		outpostTextArea.setEditable(false);
		outpostTextArea.setBounds(10, 11, 560, 220);
		frmSpaceOutpost.getContentPane().add(outpostTextArea);
		
		lblOutpost = new JLabel("PLease enter the number of item you wish to purchae");
		lblOutpost.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblOutpost.setBounds(126, 242, 347, 33);
		frmSpaceOutpost.getContentPane().add(lblOutpost);
		
		outpostTextField = new JTextField();
		outpostTextField.setBounds(164, 351, 117, 33);
		frmSpaceOutpost.getContentPane().add(outpostTextField);
		outpostTextField.setColumns(10);
		
		JButton btnPurchase = new JButton("Purchase");
		btnPurchase.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String itemNumStr = outpostTextField.getText();
				int itemNum = Integer.parseInt(itemNumStr);
				mySpaceship.outpost(itemNum);
				money = mySpaceship.getMoney();
				moneyStr = Integer.toString(money);
				lblCurrentMoney.setText("Current money: " + moneyStr);
				txtCurrentInventory.setText("Current Inventory: \n" + mySpaceship.getInventory());
			}
		});
		btnPurchase.setBounds(164, 408, 132, 33);
		frmSpaceOutpost.getContentPane().add(btnPurchase);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSpaceOutpost.dispose();
			}
		});
		btnQuit.setBounds(412, 408, 125, 33);
		frmSpaceOutpost.getContentPane().add(btnQuit);
		
		lblCurrentMoney = new JLabel("Current money: " + moneyStr);
		lblCurrentMoney.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblCurrentMoney.setBounds(58, 285, 211, 44);
		frmSpaceOutpost.getContentPane().add(lblCurrentMoney);
		
		txtCurrentInventory = new JTextArea();
		txtCurrentInventory.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		txtCurrentInventory.setText("Current Inventory: \n" + mySpaceship.getInventory());
		txtCurrentInventory.setBounds(592, 11, 339, 486);
		frmSpaceOutpost.getContentPane().add(txtCurrentInventory);
	}

}
