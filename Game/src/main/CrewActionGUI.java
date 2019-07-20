package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class CrewActionGUI {

	private JFrame frmSpaceExplorer;
	private Crew member;
	private Spaceship mySpaceship;
	private Game game;
	private JLabel lblEvent;
	
	public CrewActionGUI(Crew crewMember, Spaceship spaceship, Game mainGame) {
		member = crewMember;
		mySpaceship = spaceship;
		game = mainGame;
		initialize();
		frmSpaceExplorer.setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrewActionGUI window = new CrewActionGUI();
					window.frmSpaceExplorer.setVisible(true);
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
		frmSpaceExplorer = new JFrame();
		frmSpaceExplorer.setTitle("Crew Member " + mySpaceship.crewIndex(member) + " action");
		frmSpaceExplorer.setBounds(100, 100, 784, 493);
		frmSpaceExplorer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmSpaceExplorer.getContentPane().setLayout(null);
		
		JButton btnUseItem = new JButton("Use Item");
		btnUseItem.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		btnUseItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ItemConsumeGUI itemGUI = new ItemConsumeGUI(member, mySpaceship);
			}
		});
		btnUseItem.setBounds(47, 110, 131, 40);
		frmSpaceExplorer.getContentPane().add(btnUseItem);
		
		JButton btnSleep = new JButton("Sleep");
		btnSleep.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		btnSleep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				member.sleep();
			}
		});
		btnSleep.setBounds(203, 110, 124, 40);
		frmSpaceExplorer.getContentPane().add(btnSleep);
		
		JButton btnRepairShield = new JButton("Repair Shield");
		btnRepairShield.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		btnRepairShield.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				member.repair(mySpaceship);
			}
		});
		btnRepairShield.setBounds(359, 110, 131, 40);
		frmSpaceExplorer.getContentPane().add(btnRepairShield);
		
		JButton btnPilot = new JButton("Pilot");
		btnPilot.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		btnPilot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PilotSelectionGUI pilotSelection = new PilotSelectionGUI(mySpaceship, member, game);
			}
		});
		btnPilot.setBounds(515, 110, 138, 40);
		frmSpaceExplorer.getContentPane().add(btnPilot);
		
		JButton btnQuit = new JButton("quit");
		btnQuit.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSpaceExplorer.dispose();
			}
		});
		btnQuit.setBounds(299, 347, 124, 40);
		frmSpaceExplorer.getContentPane().add(btnQuit);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String found = member.search(mySpaceship, game);
				lblEvent.setText(found);
				System.out.println(mySpaceship.getInventory());
			}
		});
		btnSearch.setBounds(288, 177, 153, 40);
		frmSpaceExplorer.getContentPane().add(btnSearch);
		
		lblEvent = new JLabel("");
		lblEvent.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblEvent.setBounds(203, 249, 433, 67);
		frmSpaceExplorer.getContentPane().add(lblEvent);
	}

}
