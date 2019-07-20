package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class MainGameGUI {

	private JFrame frmSpaceExplorer;
	private CrewStatusGUI status;
	private Game game;
	private Spaceship mySpaceship;
	private JLabel lblDayCount;
	private JLabel lblWarning;
	
	public MainGameGUI(Game mainGame, Spaceship spaceship) {
		game = mainGame;
		mySpaceship = spaceship;
		initialize();
		frmSpaceExplorer.setVisible(true);
	}
	
	public void closeWindow() {
		frmSpaceExplorer.dispose();
	}
	
	public void wrongCrew() {
		lblWarning.setText("That crew member does not exist.");
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGameGUI window = new MainGameGUI();
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
	public MainGameGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSpaceExplorer = new JFrame();
		frmSpaceExplorer.setTitle("Space Explorer");
		frmSpaceExplorer.setBounds(100, 100, 803, 552);
		frmSpaceExplorer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSpaceExplorer.getContentPane().setLayout(null);
		
		JButton btnSpaceshipStatus = new JButton("Spaceship status");
		btnSpaceshipStatus.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		btnSpaceshipStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SpaceshipStatusGUI spaceshipGUI = new SpaceshipStatusGUI(mySpaceship.getStatus(), game);
			}
		});
		btnSpaceshipStatus.setBounds(24, 32, 173, 44);
		frmSpaceExplorer.getContentPane().add(btnSpaceshipStatus);
		
		JButton btnCrewStatus1 = new JButton("Crew member 1 status");
		btnCrewStatus1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		btnCrewStatus1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrewStatusGUI crew1Status = new CrewStatusGUI(mySpaceship.getCrewMember(0).viewStatus());
			}
		});
		btnCrewStatus1.setBounds(24, 87, 173, 44);
		frmSpaceExplorer.getContentPane().add(btnCrewStatus1);
		
		JButton btnNewButton = new JButton("Crew member 2 status");
		btnNewButton.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mySpaceship.crewLen() >= 2) {
					CrewStatusGUI crew2Status = new CrewStatusGUI(mySpaceship.getCrewMember(1).viewStatus());
				} else {
					wrongCrew();
				}
			}
		});
		btnNewButton.setBounds(24, 142, 173, 44);
		frmSpaceExplorer.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Crew member 3 status");
		btnNewButton_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mySpaceship.crewLen() >= 3) {
					CrewStatusGUI crew3Status = new CrewStatusGUI(mySpaceship.getCrewMember(2).viewStatus());
				} else {
					wrongCrew();
				}
			}
		});
		btnNewButton_1.setBounds(24, 197, 173, 44);
		frmSpaceExplorer.getContentPane().add(btnNewButton_1);
		
		JButton btnCrewMember = new JButton("Crew member 4 status");
		btnCrewMember.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		btnCrewMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mySpaceship.crewLen() == 4) {
					CrewStatusGUI crew4Status = new CrewStatusGUI(mySpaceship.getCrewMember(3).viewStatus());
				} else {
					wrongCrew();
				}
			}
		});
		btnCrewMember.setBounds(24, 252, 173, 51);
		frmSpaceExplorer.getContentPane().add(btnCrewMember);
		
		JButton btnAction1 = new JButton("Set member 1 action");
		btnAction1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		btnAction1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrewActionGUI actionGUI1 = new CrewActionGUI(mySpaceship.getCrewMember(0), mySpaceship, game);
			}
		});
		btnAction1.setBounds(239, 92, 173, 39);
		frmSpaceExplorer.getContentPane().add(btnAction1);
		
		JButton btnAction2 = new JButton("Set member 2 action");
		btnAction2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		btnAction2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mySpaceship.crewLen() >= 2) {
					CrewActionGUI actionGUI2 = new CrewActionGUI(mySpaceship.getCrewMember(1), mySpaceship, game);
				} else {
					wrongCrew();
				}
			}
		});
		btnAction2.setBounds(239, 142, 173, 44);
		frmSpaceExplorer.getContentPane().add(btnAction2);
		
		JButton btnAction3 = new JButton("Set member 3 action");
		btnAction3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		btnAction3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mySpaceship.crewLen() >= 3) {
					CrewActionGUI actionGUI3 = new CrewActionGUI(mySpaceship.getCrewMember(2), mySpaceship, game);
				} else {
					wrongCrew();
				}
			}
		});
		btnAction3.setBounds(239, 202, 173, 47);
		frmSpaceExplorer.getContentPane().add(btnAction3);
		
		JButton btnAction4 = new JButton("Set member 4 action");
		btnAction4.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		btnAction4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mySpaceship.crewLen() == 4) {
					CrewActionGUI actionGUI4 = new CrewActionGUI(mySpaceship.getCrewMember(3), mySpaceship, game);
				} else {
					wrongCrew();
				}
			}
		});
		btnAction4.setBounds(239, 260, 173, 35);
		frmSpaceExplorer.getContentPane().add(btnAction4);
		
		JButton btnSpaceOutpost = new JButton("Space Outpost");
		btnSpaceOutpost.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		btnSpaceOutpost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SpaceOutpostGUI outpost = new SpaceOutpostGUI(mySpaceship);
			}
		});
		btnSpaceOutpost.setBounds(62, 402, 153, 58);
		frmSpaceExplorer.getContentPane().add(btnSpaceOutpost);
		
		JButton btnNextDay = new JButton("Next Day");
		btnNextDay.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		btnNextDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.nextTurn();
				lblDayCount.setText("Day " + game.getTurnNum() + " out of " + game.getGameLen());
			}
		});
		btnNextDay.setBounds(479, 356, 143, 51);
		frmSpaceExplorer.getContentPane().add(btnNextDay);
		
		lblDayCount = new JLabel("Day " + game.getTurnNum() + " out of " + game.getGameLen());
		lblDayCount.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		lblDayCount.setBounds(547, 55, 212, 44);
		frmSpaceExplorer.getContentPane().add(lblDayCount);
		
		lblWarning = new JLabel("");
		lblWarning.setFont(new Font("Verdana", Font.BOLD, 16));
		lblWarning.setBounds(38, 325, 431, 35);
		frmSpaceExplorer.getContentPane().add(lblWarning);
	}
}
