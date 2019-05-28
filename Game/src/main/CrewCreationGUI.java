package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CrewCreationGUI {

	private JFrame frame;
	private JTextField crewTypeField1;
	private JTextField memberNameField1;
	private Game game;
	private int days;
	private int crewNum;
	private JTextField crewTypeField2;
	private JTextField crewTypeField3;
	private JTextField crewTypeField4;
	private JTextField memberNameField2;
	private JTextField memberNameField3;
	private JTextField memberNameField4;
	private JLabel lblSpaceshipName;
	private JTextField spaceshipNameField;
	private JLabel lblWarning;
	
	public CrewCreationGUI(Game mainGame, int mainDays, int memberNum) {
		game = mainGame;
		days = mainDays;
		crewNum = memberNum;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrewCreationGUI window = new CrewCreationGUI();
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
	public CrewCreationGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 857, 533);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCrewType = new JLabel("Please enter the type of crew you want.\r\n");
		lblCrewType.setBounds(10, 11, 339, 34);
		frame.getContentPane().add(lblCrewType);
		
		JLabel lblTank = new JLabel("1. Tank (Has more health)");
		lblTank.setBounds(10, 36, 303, 34);
		frame.getContentPane().add(lblTank);
		
		JLabel lblConsumer = new JLabel("2. Consumer (benefits more from items)");
		lblConsumer.setBounds(10, 64, 339, 34);
		frame.getContentPane().add(lblConsumer);
		
		JLabel lblRepairExpert = new JLabel("3. Repair expert (better at repairing the ship)");
		lblRepairExpert.setBounds(10, 91, 324, 34);
		frame.getContentPane().add(lblRepairExpert);
		
		JLabel lblSearchExpert = new JLabel("4. Search expert (better at searching)");
		lblSearchExpert.setBounds(10, 119, 303, 25);
		frame.getContentPane().add(lblSearchExpert);
		
		JLabel lblGnome = new JLabel("5. Gnome (immune to plague)");
		lblGnome.setBounds(10, 136, 303, 34);
		frame.getContentPane().add(lblGnome);
		
		JLabel lblInsomiac = new JLabel("6. Insomniac (doesn't get tired easily)");
		lblInsomiac.setBounds(10, 164, 303, 34);
		frame.getContentPane().add(lblInsomiac);
		
		crewTypeField1 = new JTextField();
		crewTypeField1.setText("member 1");
		crewTypeField1.setBounds(43, 209, 176, 25);
		frame.getContentPane().add(crewTypeField1);
		crewTypeField1.setColumns(10);
		
		JLabel lblPleaseEnterThe = new JLabel("Please enter the name for the crew member.");
		lblPleaseEnterThe.setBounds(461, 164, 324, 34);
		frame.getContentPane().add(lblPleaseEnterThe);
		
		memberNameField1 = new JTextField();
		memberNameField1.setText("member 1");
		memberNameField1.setBounds(499, 220, 202, 25);
		frame.getContentPane().add(memberNameField1);
		memberNameField1.setColumns(10);
		
		JButton btnCrewCreation = new JButton("Enter");
		btnCrewCreation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Integer> typeList = new ArrayList<Integer>();
				ArrayList<String> nameList = new ArrayList<String>();
				try
				{
					if (crewNum == 2) {
						String crewType1 = crewTypeField1.getText();
						String crewName1 = memberNameField1.getText();
						String crewType2 = crewTypeField2.getText();
						String crewName2 = memberNameField2.getText();
						int type1 = Integer.parseInt(crewType1);
						int type2 = Integer.parseInt(crewType2);
						System.out.println(type1);
						if (type1 < 0 || type1 > 7 || type2 < 0 || type2 > 7) {
							lblWarning.setText("Please enter valid crew type.(0~6)");
						} else {
							typeList.add(type1);
							typeList.add(type2);
							nameList.add(crewName1);
							nameList.add(crewName2);
						}
					} else if (crewNum == 3) {
						String crewType1 = crewTypeField1.getText();
						String crewName1 = memberNameField1.getText();
						String crewType2 = crewTypeField2.getText();
						String crewName2 = memberNameField2.getText();
						String crewType3 = crewTypeField3.getText();
						String crewName3 = memberNameField3.getText();
						int type1 = Integer.parseInt(crewType1);
						int type2 = Integer.parseInt(crewType2);
						int type3 = Integer.parseInt(crewType3);
						if (type1 < 0 || type1 > 7 || type2 < 0 || type2 > 7 || type3 < 0 || type3 > 7) {
							lblWarning.setText("Please enter valid crew type.(0~6)");
						} else {
							typeList.add(type1);
							typeList.add(type2);
							typeList.add(type3);
							nameList.add(crewName1);
							nameList.add(crewName2);
							nameList.add(crewName3);
						}
					} else if (crewNum == 4) {
						String crewType1 = crewTypeField1.getText();
						String crewName1 = memberNameField1.getText();
						String crewType2 = crewTypeField2.getText();
						String crewName2 = memberNameField2.getText();
						String crewType3 = crewTypeField3.getText();
						String crewName3 = memberNameField3.getText();
						String crewType4 = crewTypeField4.getText();
						String crewName4 = memberNameField4.getText();
						int type1 = Integer.parseInt(crewType1);
						int type2 = Integer.parseInt(crewType2);
						int type3 = Integer.parseInt(crewType3);
						int type4 = Integer.parseInt(crewType4);
						if (type1 < 0 || type1 > 7 || type2 < 0 || type2 > 7 || type3 < 0 || type3 > 7 || type4 < 0 || type4 > 7) {
							lblWarning.setText("Please enter valid crew type.(0~6)");
						} else {
							typeList.add(type1);
							typeList.add(type2);
							typeList.add(type3);
							typeList.add(type4);
							nameList.add(crewName1);
							nameList.add(crewName2);
							nameList.add(crewName3);
							nameList.add(crewName4);
						}
					}
					System.out.println(typeList.size());
					if (typeList.size() != 0) {
						String shipName = spaceshipNameField.getText();
						closeWindow();
						game.startGame(days, crewNum, typeList, nameList, shipName);
					}
				}
				catch(IllegalArgumentException e1)
				{
					lblWarning.setText("Please enter valid values.");
				}
			}
		});
		btnCrewCreation.setBounds(345, 406, 166, 40);
		frame.getContentPane().add(btnCrewCreation);
		
		crewTypeField2 = new JTextField();
		crewTypeField2.setText("member 2");
		crewTypeField2.setBounds(43, 245, 176, 25);
		frame.getContentPane().add(crewTypeField2);
		crewTypeField2.setColumns(10);
		
		crewTypeField3 = new JTextField();
		crewTypeField3.setText("member 3");
		crewTypeField3.setBounds(43, 281, 176, 25);
		frame.getContentPane().add(crewTypeField3);
		crewTypeField3.setColumns(10);
		
		crewTypeField4 = new JTextField();
		crewTypeField4.setText("member 4");
		crewTypeField4.setBounds(43, 317, 176, 25);
		frame.getContentPane().add(crewTypeField4);
		crewTypeField4.setColumns(10);
		
		memberNameField2 = new JTextField();
		memberNameField2.setText("member 2");
		memberNameField2.setBounds(499, 261, 202, 25);
		frame.getContentPane().add(memberNameField2);
		memberNameField2.setColumns(10);
		
		memberNameField3 = new JTextField();
		memberNameField3.setText("member 3");
		memberNameField3.setBounds(499, 297, 202, 25);
		frame.getContentPane().add(memberNameField3);
		memberNameField3.setColumns(10);
		
		memberNameField4 = new JTextField();
		memberNameField4.setText("member 4");
		memberNameField4.setBounds(499, 333, 202, 25);
		frame.getContentPane().add(memberNameField4);
		memberNameField4.setColumns(10);
		
		lblSpaceshipName = new JLabel("Please enter the name of your spaceship");
		lblSpaceshipName.setBounds(430, 16, 386, 24);
		frame.getContentPane().add(lblSpaceshipName);
		
		spaceshipNameField = new JTextField();
		spaceshipNameField.setBounds(451, 68, 294, 27);
		frame.getContentPane().add(spaceshipNameField);
		spaceshipNameField.setColumns(10);
		
		lblWarning = new JLabel("");
		lblWarning.setBounds(116, 353, 324, 34);
		frame.getContentPane().add(lblWarning);
	}
}
