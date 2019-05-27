package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PilotSelectionGUI {

	private JFrame frame;
	private JTextField coPilotTextField;
	private Spaceship mySpaceship;
	private Crew member;
	private Game game;
	
	public PilotSelectionGUI(Spaceship spaceship, Crew crew, Game mainGame) {
		member = crew;
		mySpaceship = spaceship;
		game = mainGame;
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
					PilotSelectionGUI window = new PilotSelectionGUI();
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
	public PilotSelectionGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 480, 352);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea txtrCoPilot = new JTextArea();
		txtrCoPilot.setEditable(false);
		txtrCoPilot.setText(mySpaceship.getCrew());
		txtrCoPilot.setBounds(44, 29, 171, 201);
		frame.getContentPane().add(txtrCoPilot);
		
		JLabel lblCoPilot = new JLabel("Please choose a co-pilot");
		lblCoPilot.setBounds(259, 68, 171, 34);
		frame.getContentPane().add(lblCoPilot);
		
		coPilotTextField = new JTextField();
		coPilotTextField.setBounds(259, 123, 171, 34);
		frame.getContentPane().add(coPilotTextField);
		coPilotTextField.setColumns(10);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String coPilotStr = coPilotTextField.getText();
				int coPilotInt = Integer.parseInt(coPilotStr);
				Crew coPilot = mySpaceship.crewGetter(coPilotInt);
				member.pilot(coPilot, game);
				frame.dispose();
			}
		});
		btnEnter.setBounds(285, 168, 116, 34);
		frame.getContentPane().add(btnEnter);
		
		JButton btnQuit = new JButton("quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnQuit.setBounds(285, 256, 116, 34);
		frame.getContentPane().add(btnQuit);
	}

}
