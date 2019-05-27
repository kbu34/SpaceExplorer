package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class MainGameGUI {

	private JFrame frame;
	private CrewStatusGUI status;
	private Game game;
	private Spaceship mySpaceship;
	private JLabel lblDayCount;
	
	public MainGameGUI(Game mainGame, Spaceship spaceship) {
		game = mainGame;
		mySpaceship = spaceship;
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
					MainGameGUI window = new MainGameGUI();
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
	public MainGameGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 803, 552);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnSpaceshipStatus = new JButton("Spaceship status");
		btnSpaceshipStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SpaceshipStatusGUI spaceshipGUI = new SpaceshipStatusGUI(mySpaceship.getStatus(), game);
			}
		});
		btnSpaceshipStatus.setBounds(24, 32, 116, 35);
		frame.getContentPane().add(btnSpaceshipStatus);
		
		JButton btnCrewStatus1 = new JButton("Crew member 1 status");
		btnCrewStatus1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrewStatusGUI crew1Status = new CrewStatusGUI(mySpaceship.getCrewMember(0).viewStatus());
			}
		});
		btnCrewStatus1.setBounds(24, 78, 143, 35);
		frame.getContentPane().add(btnCrewStatus1);
		
		JButton btnNewButton = new JButton("Crew member 2 status");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrewStatusGUI crew2Status = new CrewStatusGUI(mySpaceship.getCrewMember(1).viewStatus());
			}
		});
		btnNewButton.setBounds(24, 124, 143, 28);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Crew member 3 status");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrewStatusGUI crew3Status = new CrewStatusGUI(mySpaceship.getCrewMember(2).viewStatus());
			}
		});
		btnNewButton_1.setBounds(24, 163, 143, 31);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnCrewMember = new JButton("Crew member 4 status");
		btnCrewMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrewStatusGUI crew4Status = new CrewStatusGUI(mySpaceship.getCrewMember(3).viewStatus());
			}
		});
		btnCrewMember.setBounds(24, 205, 143, 35);
		frame.getContentPane().add(btnCrewMember);
		
		JButton btnAction1 = new JButton("Set member 1 action");
		btnAction1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrewActionGUI actionGUI1 = new CrewActionGUI(mySpaceship.getCrewMember(0), mySpaceship, game);
			}
		});
		btnAction1.setBounds(201, 78, 148, 35);
		frame.getContentPane().add(btnAction1);
		
		JButton btnAction2 = new JButton("Set member 2 action");
		btnAction2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrewActionGUI actionGUI2 = new CrewActionGUI(mySpaceship.getCrewMember(1), mySpaceship, game);
			}
		});
		btnAction2.setBounds(201, 127, 143, 28);
		frame.getContentPane().add(btnAction2);
		
		JButton btnAction3 = new JButton("Set member 3 action");
		btnAction3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrewActionGUI actionGUI3 = new CrewActionGUI(mySpaceship.getCrewMember(2), mySpaceship, game);
			}
		});
		btnAction3.setBounds(201, 167, 148, 35);
		frame.getContentPane().add(btnAction3);
		
		JButton btnAction4 = new JButton("Set member 4 action");
		btnAction4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrewActionGUI actionGUI4 = new CrewActionGUI(mySpaceship.getCrewMember(3), mySpaceship, game);
			}
		});
		btnAction4.setBounds(201, 211, 148, 28);
		frame.getContentPane().add(btnAction4);
		
		JButton btnSpaceOutpost = new JButton("Space outpost");
		btnSpaceOutpost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SpaceOutpostGUI outpost = new SpaceOutpostGUI(mySpaceship);
			}
		});
		btnSpaceOutpost.setBounds(24, 345, 135, 44);
		frame.getContentPane().add(btnSpaceOutpost);
		
		JButton btnNextDay = new JButton("next day");
		btnNextDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.nextTurn();
				lblDayCount.setText("day " + game.getTurnNum() + " Out of " + game.getGameLen());
			}
		});
		btnNextDay.setBounds(479, 356, 143, 51);
		frame.getContentPane().add(btnNextDay);
		
		lblDayCount = new JLabel("day " + game.getTurnNum() + " out of " + game.getGameLen());
		lblDayCount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDayCount.setBounds(479, 53, 212, 44);
		frame.getContentPane().add(lblDayCount);
	}
}
