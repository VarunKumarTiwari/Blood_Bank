package com.GUI;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class TableFillData {

	public TableModel refreshFromDB()
	{

		DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Name", "Blood Group", "Gender", "Age"}, 0);
		Connection con= DBConnection.initiate_db_conn(); 
		try {			
			Statement stmt11=con.createStatement();
			ResultSet rs=stmt11.executeQuery("select * from donor"); 
			
			while(rs.next()) {  
				String id = rs.getString(1);
				String name = rs.getString(2);
				String bgroup = rs.getString(3);
				String gender =rs.getString(4);
				String age = rs.getString(5);
				model.addRow(new Object[]{id, name, bgroup, gender, age});
				
			}
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return model;
		
		
	
		
	}
}
