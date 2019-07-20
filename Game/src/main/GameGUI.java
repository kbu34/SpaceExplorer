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
import javax.swing.ImageIcon;


public class GameGUI {

	private JFrame frmVeryCoolGame;
	private JTextField daysField;
	private Game game;
	private JTextField crewNumField;
	private JLabel lblWarning;

	public GameGUI(Game mainGame) {
		game = mainGame;
		initialize();
		frmVeryCoolGame.setVisible(true);
	}
	
	public void closeWindow() {
		frmVeryCoolGame.dispose();
	}
	
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
		frmVeryCoolGame.setTitle("Space Explorer");
		frmVeryCoolGame.setBounds(100, 100, 710, 469);
		frmVeryCoolGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVeryCoolGame.getContentPane().setLayout(null);
		
		JButton btnGamestart = new JButton("Enter");
		//event handler for enter button
		btnGamestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String daysStr = daysField.getText();
					String crewStr = crewNumField.getText();
					int days = Integer.parseInt(daysStr);
					int crewNum = Integer.parseInt(crewStr);
					System.out.println(days);
					System.out.println(crewNum);
					if (crewNum > 4 || crewNum < 2) {
						lblWarning.setText("The number of crew members must be between 2 and 4.");
					} else if (days < 3 || days > 10) {
						lblWarning.setText("The number of days shuld be between 3 and 10.");
					} else {
						closeWindow();
						CrewCreationGUI crewGUI = new CrewCreationGUI(game, days, crewNum);
					}
				}
				catch(IllegalArgumentException e1)
				{
					lblWarning.setText("Please enter a valid value.");
				}
			}
		});
		btnGamestart.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		btnGamestart.setBounds(57, 322, 120, 32);
		frmVeryCoolGame.getContentPane().add(btnGamestart);
		
		daysField = new JTextField();
		daysField.setBounds(45, 113, 120, 32);
		frmVeryCoolGame.getContentPane().add(daysField);
		daysField.setColumns(10);
		
		JLabel lblDaysInstruction = new JLabel("Please enter the duration of the game.");
		lblDaysInstruction.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblDaysInstruction.setBounds(22, 60, 313, 32);
		frmVeryCoolGame.getContentPane().add(lblDaysInstruction);
		
		JLabel lblCrewNum = new JLabel("Please enter the number of crew members(2 ~ 4)");
		lblCrewNum.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblCrewNum.setBounds(22, 186, 357, 23);
		frmVeryCoolGame.getContentPane().add(lblCrewNum);
		
		crewNumField = new JTextField();
		crewNumField.setBounds(57, 236, 120, 32);
		frmVeryCoolGame.getContentPane().add(crewNumField);
		crewNumField.setColumns(10);
		
		lblWarning = new JLabel("");
		lblWarning.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblWarning.setBounds(10, 279, 357, 32);
		frmVeryCoolGame.getContentPane().add(lblWarning);
		
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon(GameGUI.class.getResource("/images/space.jpg")));
		lblImage.setBounds(341, 220, 300, 178);
		frmVeryCoolGame.getContentPane().add(lblImage);
		
		JLabel lblSpaceExplorer = new JLabel("Space Explorer");
		lblSpaceExplorer.setFont(new Font("Lucida Sans", Font.PLAIN, 25));
		lblSpaceExplorer.setBounds(404, 81, 239, 85);
		frmVeryCoolGame.getContentPane().add(lblSpaceExplorer);
	}
}
