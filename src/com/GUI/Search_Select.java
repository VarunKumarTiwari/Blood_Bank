package com.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JRadioButton rdbtnNo = new JRadioButton("Blood Donor ID");
		rdbtnNo.setBounds(68, 106, 132, 23);
		frame.getContentPane().add(rdbtnNo);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Blood Donor Name");
		rdbtnNewRadioButton.setBounds(218, 106, 141, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);

		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNo);
		group.add(rdbtnNewRadioButton);
		

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
		        NavigationWindow b = new NavigationWindow();
		        b.frame.setVisible(true);
			}
		});
		btnCancel.setBounds(257, 194, 89, 23);
		frame.getContentPane().add(btnCancel);
		
		JLabel lblSearchBy = new JLabel("Search By ");
		lblSearchBy.setBounds(51, 39, 81, 14);
		frame.getContentPane().add(lblSearchBy);
		
		JButton btnSearch = new JButton("Search");
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
		btnSearch.setBounds(37, 194, 89, 23);
		frame.getContentPane().add(btnSearch);
	}
}
