package com.cdc.ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.cdc.model.UserMac;

public class UserMacModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2334071842851124667L;
	
	private String[] columnNames;
	
	private List<UserMac> lists=new ArrayList<>();
	
	public UserMacModel(String[] columnNames) {
		this.columnNames=columnNames;
		
	}
	
	public void  setData(List<UserMac> lists){
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
		String columnName = this.getColumnName(columnIndex);
		if (lists != null) {
			UserMac user = lists.get(rowIndex);
			if ("账号".equals(columnName)) {
				return user.getUserno();
			} else if ("密码".equals(columnName)) {
				return user.getPassword();
			} else if ("mac".equals(columnName)) {
				return user.getMacno();
			} else if ("terminalid".equals(columnName)) {
				return user.getTerminalid();
			}else if("ter_loginno".equals(columnName)){
				return user.getTer_loginno();
			}else if("usercode".equals(columnName)){
				return user.getUsercode();
			}else if("username".equals(columnName)){
				return user.getUsername();
			}else if("c_platlevel".equals(columnName)){
				return user.getC_platlevel();
			}else if("t_platlevel".equals(columnName)){
				return user.getT_platlevel();
			}
		}
		return null;
	}

}
