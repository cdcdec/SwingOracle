package com.cdc.ui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.cdc.model.UserMac;

public class UserMacModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2334071842851124667L;
	
	private String[] columnNames;
	
	private List<UserMac> lists;
	
	public UserMacModel(String[] columnNames,List<UserMac> lists) {
		this.columnNames=columnNames;
		this.lists=lists;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lists.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columnNames[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
