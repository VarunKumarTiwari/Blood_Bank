package com.GUI;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.BorderFactory;
import java.awt.GridLayout;
import java.awt.Image;

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
import javax.swing.ImageIcon;

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
		frame.setBounds(100, 100, 659, 490);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label_1 = new JLabel("Blood Donation");
		label_1.setForeground(new Color(107, 142, 35));
		label_1.setFont(new Font("Nirmala UI", Font.BOLD, 21));
		label_1.setBounds(149, 39, 167, 37);
		frame.getContentPane().add(label_1);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
		        NavigationWindow b = new NavigationWindow();
		        b.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(253, 396, 124, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton DoctorList = new JButton("Doctor List");
		DoctorList.setFont(new Font("Tahoma", Font.BOLD, 13));
		DoctorList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = DBConnection.initiate_db_conn();
				String insertQuery = "SELECT donor.id,donor.fName,donor.bgroup,doctor.Docid , doctor.DocName FROM donor Inner JOIN doctor ON donor.id = doctor.id;";
				try {
					PreparedStatement pstmt = con.prepareStatement(insertQuery);
					ResultSet rs = pstmt.executeQuery();
					writeToFile(rs,"Doctor_List.csv");
					rs.close();
					pstmt.close();
					JOptionPane.showMessageDialog(null,"Data saved in Doctor_List.csv");

				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"fail "+e1);
				}
			}
		});
		DoctorList.setBounds(253, 362, 124, 23);
		frame.getContentPane().add(DoctorList);
		
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(116, 187, 167, 37);
		frame.getContentPane().add(comboBox);
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Gender", "Male", "Female", "Rather not say"}));
		
		
		
		JButton button = new JButton("Details by Donor's Gender");
		button.setBounds(350, 187, 179, 37);
		frame.getContentPane().add(button);
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
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
					JOptionPane.showMessageDialog(null,"Data saved in Details_by_Donor_Name.csv");

				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"fail "+e1);
				}
			}
		});

		JLabel lblExportDetails = new JLabel("EXPORT DETAILS");
		lblExportDetails.setBackground(Color.WHITE);
		lblExportDetails.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblExportDetails.setBounds(237, 125, 179, 14);
		frame.getContentPane().add(lblExportDetails);
		
		JButton button_1 = new JButton("Details By Blood Group");
		button_1.setBounds(350, 289, 179, 37);
		frame.getContentPane().add(button_1);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		
		
		JButton button_2 = new JButton("All Donor Names");
		button_2.setBounds(116, 289, 167, 37);
		frame.getContentPane().add(button_2);
		button_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton button_3 = new JButton("Blood Groups Available");
		button_3.setBounds(350, 235, 179, 37);
		frame.getContentPane().add(button_3);
		button_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		
		textField_1 = new JTextField(12);
		textField_1.setBounds(116, 235, 167, 37);
		frame.getContentPane().add(textField_1);
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
					JOptionPane.showMessageDialog(null,"Data saved in Blood_Groups_Available.csv");

				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"fail "+e1);
				}
			}
		});
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
					JOptionPane.showMessageDialog(null,"Data saved in All_Donor_Names.csv");

				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"fail "+e1);
				}
			}
		});
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
					JOptionPane.showMessageDialog(null,"Data saved in Details_By_Blood_Group.csv");

				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"fail "+e1);
				}
			}
		});
		
		JLabel lblbloodIcon = new JLabel("");
		lblbloodIcon.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("logo.png")).getImage().getScaledInstance(123, 99, Image.SCALE_SMOOTH)));
		lblbloodIcon.setBounds(10, 11, 123, 99);
		frame.getContentPane().add(lblbloodIcon);
		
		JLabel lblbackground = new JLabel("");
		lblbackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("background.jpg")));
		lblbackground.setBounds(0, 0, 639, 451);
		frame.getContentPane().add(lblbackground);
		
	
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
