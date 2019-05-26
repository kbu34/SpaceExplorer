package main;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class GameGUI {

	private JFrame frmVeryCoolGame;
	private JTextField daysField;
	private Game game;
	private JTextField crewNumField;

	public GameGUI(Game mainGame) {
		game = mainGame;
		initialize();
		frmVeryCoolGame.setVisible(true);
	}
	
	public void closeWindow() {
		frmVeryCoolGame.dispose();
	}
	
	public void finishedWindow() {
		game.closeOpeningScreen(this);
	}
	
	/**
	 * Launch the application.
	 */
	
	 public static void main(String[] args) {
	 	EventQueue.invokeLater(new Runnable() {
	 		public void run() {
				try {
					GameGUI window = new GameGUI();
					window.frmVeryCoolGame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GameGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVeryCoolGame = new JFrame();
		frmVeryCoolGame.setTitle("Very cool game");
		frmVeryCoolGame.setBounds(100, 100, 677, 448);
		frmVeryCoolGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVeryCoolGame.getContentPane().setLayout(null);
		
		JButton btnGamestart = new JButton("Enter");
		//event handler for enter button
		btnGamestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String daysStr = daysField.getText();
				String crewStr = crewNumField.getText();
				int days = Integer.parseInt(daysStr);
				int crewNum = Integer.parseInt(crewStr);
				System.out.println(days);
				System.out.println(crewNum);
				closeWindow();
				CrewCreationGUI crewGUI = new CrewCreationGUI(game, days, crewNum);
			}
		});
		btnGamestart.setFont(new Font("Malgun Gothic", Font.PLAIN, 11));
		btnGamestart.setBounds(255, 310, 89, 23);
		frmVeryCoolGame.getContentPane().add(btnGamestart);
		
		daysField = new JTextField();
		daysField.setBounds(59, 205, 120, 32);
		frmVeryCoolGame.getContentPane().add(daysField);
		daysField.setColumns(10);
		
		JLabel lblDaysInstruction = new JLabel("Please enter the duration of the game.");
		lblDaysInstruction.setBounds(31, 147, 246, 32);
		frmVeryCoolGame.getContentPane().add(lblDaysInstruction);
		
		JLabel lblCrewNum = new JLabel("Please enter the number of crew members(2 ~ 4)");
		lblCrewNum.setBounds(370, 163, 281, 23);
		frmVeryCoolGame.getContentPane().add(lblCrewNum);
		
		crewNumField = new JTextField();
		crewNumField.setBounds(438, 205, 120, 32);
		frmVeryCoolGame.getContentPane().add(crewNumField);
		crewNumField.setColumns(10);
		
		JLabel lblWarning = new JLabel("");
		lblWarning.setBounds(370, 259, 262, 32);
		frmVeryCoolGame.getContentPane().add(lblWarning);
	}
}
