package com.GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Result;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Search_ID {

	JFrame frame;
	private JTextField id;
	private JTable table;
	private TableFillData tfd = new TableFillData();
	private JScrollPane scrollPane;


	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public Search_ID() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 594, 401);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label_1 = new JLabel("Blood Donation");
		label_1.setForeground(new Color(107, 142, 35));
		label_1.setFont(new Font("Nirmala UI", Font.BOLD, 21));
		label_1.setBounds(149, 39, 167, 37);
		frame.getContentPane().add(label_1);
		
		JLabel lblNewLabel = new JLabel("Donor ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(25, 133, 76, 14);
		frame.getContentPane().add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 158, 524, 226);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		
		scrollPane.setViewportView(table);
		table.setBackground(Color.PINK);
		
		id = new JTextField();
		id.setBounds(97, 130, 206, 20);
		frame.getContentPane().add(id);
		id.setColumns(10);
		
		JButton btnFind = new JButton("Find");
		btnFind.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = DBConnection.initiate_db_conn();
				String insertQuery ="Select * from donor where id = ?;";
				
				
						try {
							String[] tableColumnsName = {"Id","Name","Blood Group","Gender","Age"}; 
							DefaultTableModel aModel = (DefaultTableModel) table.getModel();
							aModel.setColumnIdentifiers(tableColumnsName);
							PreparedStatement pstmt = con.prepareStatement(insertQuery);
							pstmt.setInt(1, Integer.parseInt(id.getText()));
							ResultSet rs= pstmt.executeQuery();
							java.sql.ResultSetMetaData rsmd = rs.getMetaData();
							int colNo = rsmd.getColumnCount();
							while(rs.next()){
							 Object[] objects = new Object[colNo];
							 // tanks to umit ozkan for the bug fix!
							 for(int i=0;i<colNo;i++){
							  objects[i]=rs.getObject(i+1);
							  }
							 aModel.addRow(objects);
							}
							rs.close();
							pstmt.close();
							table.setModel(aModel);
						}
				catch (SQLException sqle)
				{
					System.err.println("Error with  insert:\n"+sqle.toString());
				}finally {
					DBConnection.closeConnection(con);
				}
				
			}
		});
		btnFind.setBounds(313, 129, 111, 23);
		frame.getContentPane().add(btnFind);
		
	
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
		        Search_Select b = new Search_Select();
		        b.frame.setVisible(true);
			}
		});
		btnCancel.setBounds(434, 129, 115, 23);
		frame.getContentPane().add(btnCancel);
		
		JLabel lblbloodIcon = new JLabel("");
		lblbloodIcon.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("logo.png")).getImage().getScaledInstance(123, 99, Image.SCALE_SMOOTH)));
		lblbloodIcon.setBounds(10, 11, 123, 99);
		frame.getContentPane().add(lblbloodIcon);
		
		JLabel lblbackground = new JLabel("");
		lblbackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("background.jpg")));
		lblbackground.setBounds(0, 0, 639, 362);
		frame.getContentPane().add(lblbackground);

	}
}
