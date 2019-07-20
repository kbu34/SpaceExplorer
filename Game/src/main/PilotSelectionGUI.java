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

public class PilotSelectionGUI {

	private JFrame frmPilotSelection;
	private JTextField coPilotTextField;
	private Spaceship mySpaceship;
	private Crew member;
	private Game game;
	private JLabel lblWarning;
	private JLabel lblTransporter;
	private JLabel lblPlanetNum;
	
	public PilotSelectionGUI(Spaceship spaceship, Crew crew, Game mainGame) {
		member = crew;
		mySpaceship = spaceship;
		game = mainGame;
		initialize();
		frmPilotSelection.setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PilotSelectionGUI window = new PilotSelectionGUI();
					window.frmPilotSelection.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PilotSelectionGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPilotSelection = new JFrame();
		frmPilotSelection.setTitle("Pilot Selection");
		frmPilotSelection.setBounds(100, 100, 535, 386);
		frmPilotSelection.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmPilotSelection.getContentPane().setLayout(null);
		
		JTextArea txtrCoPilot = new JTextArea();
		txtrCoPilot.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		txtrCoPilot.setEditable(false);
		txtrCoPilot.setText(mySpaceship.getCrew());
		txtrCoPilot.setBounds(44, 29, 171, 201);
		frmPilotSelection.getContentPane().add(txtrCoPilot);
		
		JLabel lblCoPilot = new JLabel("Please choose a co-pilot");
		lblCoPilot.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblCoPilot.setBounds(259, 68, 195, 34);
		frmPilotSelection.getContentPane().add(lblCoPilot);
		
		coPilotTextField = new JTextField();
		coPilotTextField.setBounds(259, 123, 171, 34);
		frmPilotSelection.getContentPane().add(coPilotTextField);
		coPilotTextField.setColumns(10);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String coPilotStr = coPilotTextField.getText();
				int coPilotInt = Integer.parseInt(coPilotStr);
				if (coPilotInt <= 0 || coPilotInt > mySpaceship.crewLen()) {
					lblWarning.setText("Invalid crew number.");
				} else {
					Crew coPilot = mySpaceship.crewGetter(coPilotInt - 1);
					if (member != coPilot) {
						member.pilot(coPilot, game);
						frmPilotSelection.dispose();
					} else {
						lblWarning.setText("A crew member can't be the pilot and the co-pilot at once.");
					}
				}
				lblPlanetNum.setText("Planet num: " + game.getSpaceshipLocation());
			}
		});
		btnEnter.setBounds(285, 168, 116, 34);
		frmPilotSelection.getContentPane().add(btnEnter);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPilotSelection.dispose();
			}
		});
		btnQuit.setBounds(338, 302, 116, 34);
		frmPilotSelection.getContentPane().add(btnQuit);
		
		lblWarning = new JLabel("");
		lblWarning.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblWarning.setBounds(10, 241, 444, 28);
		frmPilotSelection.getContentPane().add(lblWarning);
		
		lblTransporter = new JLabel("");
		if (game.getPartFound() == true) {
			lblTransporter.setText("Transporter piece already found here.");
		} else {
			lblTransporter.setText("Transporter piece not yet found here.");
		}
		lblTransporter.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblTransporter.setBounds(44, 291, 284, 34);
		frmPilotSelection.getContentPane().add(lblTransporter);
		
		lblPlanetNum = new JLabel("Planet num: " + game.getSpaceshipLocation());
		lblPlanetNum.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblPlanetNum.setBounds(233, 11, 202, 34);
		frmPilotSelection.getContentPane().add(lblPlanetNum);
	}

}
