package com.GUI;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.io.*;
import java.util.*;

@SuppressWarnings("serial")
class QueryTableModel extends AbstractTableModel
{
	Vector modelData; //will hold String[] objects
	int colCount;
	String[] headers=new String[0] ;
	Connection con= DBConnection.initiate_db_conn();
	Statement stmt = null;
	String[] record;
	ResultSet rs = null;

	public QueryTableModel(){
		modelData = new Vector();
	}//end constructor QueryTableModel

	public String getColumnName(int i){
		return headers[i];
	}	
	public int getColumnCount(){
		return colCount;
	}
	
	public int getRowCount(){
		return modelData.size();
	}
	
	public Object getValueAt(int row, int col){
		return ((String[])modelData.elementAt(row))[col];
	}

	public void refreshFromDB( )
	{
		//modelData is the data stored by the table
		//when set query is called the data from the 
		//DB is queried using “SELECT * FROM myInfo” 
		//and the data from the result set is copied 
		//into the modelData. Every time refreshFromDB is
		//called the DB is queried and a new 
		//modelData is created  

		modelData = new Vector();
		
		try{
			Statement stmt = con.createStatement();
			//Execute the query and store the result set and its metadata
			rs = stmt.executeQuery("SELECT * FROM donor");
			ResultSetMetaData meta = rs.getMetaData();
		
			colCount = meta.getColumnCount(); 
			
			headers = new String[colCount];
	
			for(int h = 0; h<colCount; h++)
			{
				headers[h] = meta.getColumnName(h+1);
			}
		
			while(rs.next())
			{
				record = new String[colCount];
				for(int i = 0; i < colCount; i++)
				{
					record[i] = rs.getString(i+1);
				}//end for loop
				modelData.addElement(record);
			}// end while loop
			fireTableChanged(null); //Tell the listeners a new table has arrived.
		}//end try clause
		catch(Exception e) {
					System.out.println("Error with refreshFromDB Method\n"+e.toString());
		} // end catch clause to query table
	}//end refreshFromDB method
}// end class QueryTableModel
