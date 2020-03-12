package com.GUI;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

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
		frame = new JFrame("Blood Donation");
		frame.setBounds(100, 100, 617, 371);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBloodDonation = new JLabel("Blood Donation");
		lblBloodDonation.setFont(new Font("Nirmala UI", Font.BOLD, 27));
		lblBloodDonation.setForeground(new Color(107, 142, 35));
		lblBloodDonation.setBounds(40, 28, 239, 37);
		frame.getContentPane().add(lblBloodDonation);
		
		JButton btnBloodDonor = new JButton("Blood Donor");
		btnBloodDonor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
		        BloodDonor b = new BloodDonor();
		        b.frame.setVisible(true);
			}
		});
		btnBloodDonor.setBounds(67, 91, 123, 37);
		frame.getContentPane().add(btnBloodDonor);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
		        Search_Select b = new Search_Select();
		        b.frame.setVisible(true);
			}
		});
		btnSearch.setBounds(67, 175, 123, 37);
		frame.getContentPane().add(btnSearch);
		
		JButton btnExportD = new JButton("Export Details");
		btnExportD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
		        Export b = new Export();
		        b.frame.setVisible(true);
			}
		});
		btnExportD.setBounds(67, 258, 123, 37);
		frame.getContentPane().add(btnExportD);
		
		JLabel lblbloodIcon = new JLabel("");
		lblbloodIcon.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("logo.png")).getImage().getScaledInstance(335, 275, Image.SCALE_SMOOTH)));
		//	lblNewLabel.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("news.png")).getImage().getScaledInstance(200, 50, Image.SCALE_SMOOTH)));
			lblbloodIcon.setBounds(256, 28, 335, 275);
			frame.getContentPane().add(lblbloodIcon);
			
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("background.jpg")));
		lblNewLabel.setBounds(0, 0, 601, 332);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		
	}
	
	

}
