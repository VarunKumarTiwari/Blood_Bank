package com.GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Search_Name {

	JFrame frame;
	private JTable table;
	private JTextField name;
	private JButton btnCancel;
	private JScrollPane scrollPane;
	private TableFillData tfd = new TableFillData();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Search_Name() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 622, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label_1 = new JLabel("Blood Donation");
		label_1.setForeground(new Color(107, 142, 35));
		label_1.setFont(new Font("Nirmala UI", Font.BOLD, 21));
		label_1.setBounds(149, 39, 167, 37);
		frame.getContentPane().add(label_1);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 165, 586, 226);
		frame.getContentPane().add(scrollPane);

		table = new JTable();

		scrollPane.setViewportView(table);
		table.setBackground(Color.PINK);

		JLabel lblDonorName = new JLabel("Donor Name");
		lblDonorName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDonorName.setBounds(10, 140, 98, 14);
		frame.getContentPane().add(lblDonorName);

		name = new JTextField();
		name.setColumns(10);
		name.setBounds(102, 137, 211, 20);
		frame.getContentPane().add(name);

		JButton button = new JButton("Find");
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = DBConnection.initiate_db_conn();
				String insertQuery = "Select * from donor where fName = ?;";
				try {
					String[] tableColumnsName = { "Id", "Name", "Blood Group", "Gender", "Age" };
					DefaultTableModel aModel = (DefaultTableModel) table.getModel();
					aModel.setColumnIdentifiers(tableColumnsName);
					PreparedStatement pstmt = con.prepareStatement(insertQuery);
					pstmt.setString(1, name.getText());
					ResultSet rs = pstmt.executeQuery();
					java.sql.ResultSetMetaData rsmd = rs.getMetaData();
					int colNo = rsmd.getColumnCount();
					while (rs.next()) {
						Object[] objects = new Object[colNo];
						// tanks to umit ozkan for the bug fix!
						for (int i = 0; i < colNo; i++) {
							objects[i] = rs.getObject(i + 1);
						}
						aModel.addRow(objects);
					}
					table.setModel(aModel);
					rs.close();
					pstmt.close();
					System.out.println("success");
				} catch (SQLException sqle) {
					System.err.println("Error with  insert:\n" + sqle.toString());
				}

			}
		});
		button.setBounds(346, 136, 105, 23);
		frame.getContentPane().add(button);

		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Search_Select b = new Search_Select();
				b.frame.setVisible(true);
			}
		});
		btnCancel.setBounds(477, 137, 105, 23);
		frame.getContentPane().add(btnCancel);
		
		JLabel lblbloodIcon = new JLabel("");
		lblbloodIcon.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("logo.png")).getImage().getScaledInstance(123, 99, Image.SCALE_SMOOTH)));
		lblbloodIcon.setBounds(10, 11, 123, 99);
		frame.getContentPane().add(lblbloodIcon);
		
		JLabel lblbackground = new JLabel("");
		lblbackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("background.jpg")));
		lblbackground.setBounds(0, 0, 639, 391);
		frame.getContentPane().add(lblbackground);

	}
}
