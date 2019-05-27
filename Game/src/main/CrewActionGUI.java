package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class CrewActionGUI {

	private JFrame frame;
	private Crew member;
	private Spaceship mySpaceship;
	private Game game;
	private JLabel lblEvent;
	
	public CrewActionGUI(Crew crewMember, Spaceship spaceship, Game mainGame) {
		member = crewMember;
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
					CrewActionGUI window = new CrewActionGUI();
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
	public CrewActionGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 784, 493);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnUseItem = new JButton("use item");
		btnUseItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ItemConsumeGUI itemGUI = new ItemConsumeGUI(member, mySpaceship);
			}
		});
		btnUseItem.setBounds(47, 110, 146, 40);
		frame.getContentPane().add(btnUseItem);
		
		JButton btnSleep = new JButton("sleep");
		btnSleep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				member.sleep();
			}
		});
		btnSleep.setBounds(203, 110, 146, 40);
		frame.getContentPane().add(btnSleep);
		
		JButton btnRepairShield = new JButton("repair shield");
		btnRepairShield.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				member.repair(mySpaceship);
			}
		});
		btnRepairShield.setBounds(359, 110, 146, 40);
		frame.getContentPane().add(btnRepairShield);
		
		JButton btnPilot = new JButton("pilot");
		btnPilot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PilotSelectionGUI pilotSelection = new PilotSelectionGUI(mySpaceship, member, game);
			}
		});
		btnPilot.setBounds(515, 110, 153, 40);
		frame.getContentPane().add(btnPilot);
		
		JButton btnQuit = new JButton("quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnQuit.setBounds(282, 332, 146, 30);
		frame.getContentPane().add(btnQuit);
		
		JButton btnSearch = new JButton("search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String found = member.search(mySpaceship, game);
				lblEvent.setText(found);
				System.out.println(mySpaceship.getInventory());
			}
		});
		btnSearch.setBounds(288, 177, 153, 40);
		frame.getContentPane().add(btnSearch);
		
		lblEvent = new JLabel("");
		lblEvent.setBounds(234, 251, 416, 30);
		frame.getContentPane().add(lblEvent);
	}

}
