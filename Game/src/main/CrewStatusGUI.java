package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class CrewStatusGUI {

	private JFrame frmE;
	private String status;
	
	public CrewStatusGUI(String crewStatus) {
		status = crewStatus;
		initialize();
		frmE.setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrewStatusGUI window = new CrewStatusGUI();
					window.frmE.setVisible(true);
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
		frmE = new JFrame();
		frmE.setTitle("Crew member status");
		frmE.setBounds(100, 100, 487, 361);
		frmE.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmE.getContentPane().setLayout(null);
		
		JTextArea crewStatusTextArea = new JTextArea();
		crewStatusTextArea.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		crewStatusTextArea.setEditable(false);
		crewStatusTextArea.setText(status);
		crewStatusTextArea.setBounds(10, 11, 451, 246);
		frmE.getContentPane().add(crewStatusTextArea);
		
		JButton btnExit = new JButton("Quit");
		btnExit.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmE.dispose();
			}
		});
		btnExit.setBounds(190, 268, 89, 23);
		frmE.getContentPane().add(btnExit);
	}
}
