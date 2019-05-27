package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrewStatusGUI {

	private JFrame frame;
	private String status;
	
	public CrewStatusGUI(String crewStatus) {
		status = crewStatus;
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
					CrewStatusGUI window = new CrewStatusGUI();
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
	public CrewStatusGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 487, 361);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea crewStatusTextArea = new JTextArea();
		crewStatusTextArea.setEditable(false);
		crewStatusTextArea.setText(status);
		crewStatusTextArea.setBounds(10, 11, 451, 246);
		frame.getContentPane().add(crewStatusTextArea);
		
		JButton btnExit = new JButton("quit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnExit.setBounds(190, 268, 89, 23);
		frame.getContentPane().add(btnExit);
	}
}
