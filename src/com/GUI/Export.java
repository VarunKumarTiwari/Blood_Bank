package com.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.BorderFactory;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Export {

	JFrame frame;
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Gender", "Male", "Female", "Rather not say"}));
		panel.add(comboBox);
		
		
		
		JButton button = new JButton("Details by Donor's Gender");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = DBConnection.initiate_db_conn();
				String insertQuery = "select * from donor where gender ='"  +comboBox.getSelectedItem().toString()+"';";
				try {
					PreparedStatement pstmt = con.prepareStatement(insertQuery);
					ResultSet rs = pstmt.executeQuery();
					writeToFile(rs,"Details_by_Donor_Name.csv");
					rs.close();
					pstmt.close();
				}catch (Exception e1) {
					System.out.println("fail "+e1);
				}
			}
		});
		panel.add(button);
		
		
		textField_1 = new JTextField(12);
		panel.add(textField_1);
		
		JButton button_1 = new JButton("Details By Blood Group");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = DBConnection.initiate_db_conn();
				String insertQuery = "select * from donor where bgroup ='"  +textField_1.getText()+"';";
				try {
					PreparedStatement pstmt = con.prepareStatement(insertQuery);
					ResultSet rs = pstmt.executeQuery();
					writeToFile(rs,"Details_By_Blood_Group.csv");
					rs.close();
					pstmt.close();
				}catch (Exception e1) {
					System.out.println("fail "+e1);
				}
			}
		});
		panel.add(button_1);
		
		
		
		JButton button_2 = new JButton("All Donor Names");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = DBConnection.initiate_db_conn();
				String insertQuery = "Select fName from donor";
				try {
					PreparedStatement pstmt = con.prepareStatement(insertQuery);
					ResultSet rs = pstmt.executeQuery();
					writeToFile(rs,"All_Donor_Names.csv");
					rs.close();
					pstmt.close();
				}catch (Exception e1) {
					System.out.println("fail "+e1);
				}
			}
		});
		panel.add(button_2);
		
		JButton button_3 = new JButton("Blood Groups Available");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = DBConnection.initiate_db_conn();
				String insertQuery = "select bgroup,count(bgroup) as Available from donor group by bgroup";
				try {
					PreparedStatement pstmt = con.prepareStatement(insertQuery);
					ResultSet rs = pstmt.executeQuery();
					writeToFile(rs,"Blood_Groups_Available.csv");
					rs.close();
					pstmt.close();
				}catch (Exception e1) {
					System.out.println("fail "+e1);
				}
			}
		});
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

	public void writeToFile(ResultSet rs,String fileName){
		try{
			System.out.println("All of the data is saved in Blood_Donor.csv file");
			FileWriter outputFile = new FileWriter(fileName);
			PrintWriter printWriter = new PrintWriter(outputFile);
			ResultSetMetaData rsmd = rs.getMetaData();
			int numColumns = rsmd.getColumnCount();

			for(int i=0;i<numColumns;i++){
				printWriter.print(rsmd.getColumnLabel(i+1)+",");
			}
			printWriter.print("\n");
			while(rs.next()){
				for(int i=0;i<numColumns;i++){
					printWriter.print(rs.getString(i+1)+",");
				}
				printWriter.print("\n");
				printWriter.flush();
			}
			printWriter.close();
		}
		catch(Exception e){e.printStackTrace();}
	}
}
