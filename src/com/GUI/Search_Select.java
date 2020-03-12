package com.GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Search_Select {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public Search_Select() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 555, 327);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label_1 = new JLabel("Blood Donation");
		label_1.setForeground(new Color(107, 142, 35));
		label_1.setFont(new Font("Nirmala UI", Font.BOLD, 21));
		label_1.setBounds(149, 39, 167, 37);
		frame.getContentPane().add(label_1);
		
		JRadioButton rdbtnNo = new JRadioButton("Blood Donor ID");
		rdbtnNo.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnNo.setBounds(188, 144, 128, 23);
		frame.getContentPane().add(rdbtnNo);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Blood Donor Name");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnNewRadioButton.setBounds(184, 180, 132, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);

		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNo);
		group.add(rdbtnNewRadioButton);
		

		JButton btnCancel = new JButton("Back");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
		        NavigationWindow b = new NavigationWindow();
		        b.frame.setVisible(true);
			}
		});
		btnCancel.setBounds(270, 230, 89, 23);
		frame.getContentPane().add(btnCancel);
		
		JLabel lblSearchBy = new JLabel("Search By ");
		lblSearchBy.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSearchBy.setBounds(214, 114, 81, 23);
		frame.getContentPane().add(lblSearchBy);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			if(rdbtnNo.isSelected()==true) 
			{
				frame.setVisible(false);
	        Search_ID b = new Search_ID();
	        b.frame.setVisible(true);
		}
			if(rdbtnNewRadioButton.isSelected()==true)
			{
				frame.setVisible(false);
		        Search_Name b = new Search_Name();
		        b.frame.setVisible(true);
			}
				 
			}
		});
		btnSearch.setBounds(126, 230, 89, 23);
		frame.getContentPane().add(btnSearch);
		
		JLabel lblbloodIcon = new JLabel("");
		lblbloodIcon.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("logo.png")).getImage().getScaledInstance(123, 99, Image.SCALE_SMOOTH)));
		lblbloodIcon.setBounds(10, 11, 123, 99);
		frame.getContentPane().add(lblbloodIcon);
		
		JLabel lblbackground = new JLabel("");
		lblbackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("background.jpg")));
		lblbackground.setBounds(0, 0, 539, 288);
		frame.getContentPane().add(lblbackground);

	}
}
