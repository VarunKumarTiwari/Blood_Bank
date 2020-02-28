package com.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.BorderFactory;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Export {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public Export() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 549, 312);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder( "Export Data"));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(23, 33, 500, 200);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(3, 2));
		
		JButton button = new JButton("NumLecturesForDepartment:");
		panel.add(button);
		
		textField = new JTextField(12);
		panel.add(textField);
		
		JButton button_1 = new JButton("AvgAgeForDepartment");
		panel.add(button_1);
		
		textField_1 = new JTextField(12);
		panel.add(textField_1);
		
		JButton button_2 = new JButton("ListAllDepartments");
		panel.add(button_2);
		
		JButton button_3 = new JButton("ListAllPositions");
		panel.add(button_3);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
		        NavigationWindow b = new NavigationWindow();
		        b.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(434, 239, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
