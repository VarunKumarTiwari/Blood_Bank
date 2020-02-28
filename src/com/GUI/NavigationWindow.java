package com.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NavigationWindow  {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Create the application.
	 */
	public NavigationWindow() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnBloodDonor = new JButton("Blood Donor");
		btnBloodDonor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
		        BloodDonor b = new BloodDonor();
		        b.frame.setVisible(true);
			}
		});
		btnBloodDonor.setBounds(56, 44, 123, 23);
		frame.getContentPane().add(btnBloodDonor);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
		        Search_Select b = new Search_Select();
		        b.frame.setVisible(true);
			}
		});
		btnSearch.setBounds(56, 110, 123, 23);
		frame.getContentPane().add(btnSearch);
		
		JButton btnExportD = new JButton("Export Details");
		btnExportD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
		        Export b = new Export();
		        b.frame.setVisible(true);
			}
		});
		btnExportD.setBounds(56, 182, 123, 23);
		frame.getContentPane().add(btnExportD);
	}


}
