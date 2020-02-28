package com.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;


import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class BloodDonor {

	JFrame frame;
	private JTextField no;
	private JTextField name;
	private JTextField age;
	private JTable table;
	private TableFillData tfd = new TableFillData();

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public BloodDonor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 655, 319);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblDonorName = new JLabel("Donor No.");
		lblDonorName.setBounds(23, 35, 86, 14);
		frame.getContentPane().add(lblDonorName);
		
		JLabel lblDonorName_1 = new JLabel("Donor Name");
		lblDonorName_1.setBounds(23, 77, 86, 14);
		frame.getContentPane().add(lblDonorName_1);
		
		JLabel lblBloodGroup = new JLabel("Blood Group");
		lblBloodGroup.setBounds(23, 119, 86, 14);
		frame.getContentPane().add(lblBloodGroup);
		
		JLabel lblSex = new JLabel("Gender");
		lblSex.setBounds(23, 158, 86, 14);
		frame.getContentPane().add(lblSex);
		
		JComboBox bgroup = new JComboBox();
		bgroup.setModel(new DefaultComboBoxModel(new String[] {"Select Blood Group", "O-", "O+", "A-", "A+", "B-", "B+", "AB-", "AB+"}));
		bgroup.setBounds(109, 115, 116, 22);
		frame.getContentPane().add(bgroup);
		
		JComboBox gender = new JComboBox();
		gender.setModel(new DefaultComboBoxModel(new String[] {"Select Gender", "Male", "Female", "Rather Not Say"}));
		gender.setBounds(109, 154, 116, 22);
		frame.getContentPane().add(gender);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(23, 194, 86, 14);
		frame.getContentPane().add(lblAge);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(23, 11, 46, 14);
		frame.getContentPane().add(lblDate);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = DBConnection.initiate_db_conn();
				String insertQuery ="insert into donor (id,fName,bgroup,gender,age)" + "values(?,?,?,?,?)";
				
				
						try {
							PreparedStatement pstmt =con.prepareStatement(insertQuery);
							pstmt.setString(1, null);
							pstmt.setString(2, name.getText());
							pstmt.setString(3, bgroup.getSelectedItem().toString());
							pstmt.setString(4, gender.getSelectedItem().toString());
							pstmt.setInt(5, Integer.parseInt(age.getText()));
							pstmt.executeUpdate();
							pstmt.close();
							System.out.println("success");
						}
				catch (SQLException sqle)
				{
					System.err.println("Error with  insert:\n"+sqle.toString());
				}
				finally
				{
					table.setModel(tfd.refreshFromDB());
				}
			}
		});
		btnAdd.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(btnAdd);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(248, 36, 370, 171);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(tfd.refreshFromDB());
		scrollPane.setViewportView(table);
		table.setBackground(Color.PINK);
		
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = DBConnection.initiate_db_conn();
				String insertQuery ="UPDATE donor SET fName = ? , bgroup = ?, gender = ?, age = ? where id = ?";

				
						try {
							PreparedStatement pstmt =con.prepareStatement(insertQuery);
							pstmt.setString(1, name.getText());
							pstmt.setString(2, bgroup.getSelectedItem().toString());
							pstmt.setString(3, gender.getSelectedItem().toString());
							pstmt.setInt(4, Integer.parseInt(age.getText()));
							pstmt.setInt(5, Integer.parseInt(no.getText()));
							pstmt.executeUpdate();
							pstmt.close();
							System.out.println("success");
						}
				catch (SQLException sqle)
				{
					System.err.println("Error with  insert:\n"+sqle.toString());
				}
				finally
				{
					table.setModel(tfd.refreshFromDB());
				}
			
				
			}
		});
		btnUpdate.setBounds(109, 227, 89, 23);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = DBConnection.initiate_db_conn();
				String insertQuery ="delete from donor where id = ?";

				
						try {
							PreparedStatement pstmt =con.prepareStatement(insertQuery);
							pstmt.setInt(1, Integer.parseInt(no.getText()));
							pstmt.executeUpdate();
							pstmt.close();
							System.out.println("success");
						}
				catch (SQLException sqle)
				{
					System.err.println("Error with  insert:\n"+sqle.toString());
				}
				finally
				{
					table.setModel(tfd.refreshFromDB());
				}
			}
		});
		btnDelete.setBounds(208, 227, 89, 23);
		frame.getContentPane().add(btnDelete);
		
		JLabel lblDonorDetailForm = new JLabel("Donor Detail Form");
		lblDonorDetailForm.setBounds(277, 11, 105, 14);
		frame.getContentPane().add(lblDonorDetailForm);
		
		JLabel label = new JLabel("");
		label.setBounds(114, 11, 111, 14);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(104, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		no = new JTextField();
		no.setBounds(114, 32, 111, 20);
		frame.getContentPane().add(no);
		no.setColumns(10);
		
		name = new JTextField();
		name.setBounds(112, 74, 113, 20);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		age = new JTextField();
		age.setBounds(112, 191, 113, 20);
		frame.getContentPane().add(age);
		age.setColumns(10);
		
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
		        NavigationWindow b = new NavigationWindow();
		        b.frame.setVisible(true);
			}
		});
		btnCancel.setBounds(316, 227, 89, 23);
		frame.getContentPane().add(btnCancel);
		
		
	}
	

}
