package com.cdc.ui;

import java.util.List;

import javax.swing.DefaultComboBoxModel;

import com.cdc.model.OrderAddress;

public class OrderAddressComboBoxModel extends DefaultComboBoxModel<OrderAddress> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 410797803156042165L;
	
	private List<OrderAddress> lists;
	
	private OrderAddress  orderAddress;
	public OrderAddressComboBoxModel(List<OrderAddress> lists) {
		// TODO Auto-generated constructor stub
		this.lists=lists;
		
		for (int i = 0; i < lists.size(); i++) {
			addElement(lists.get(i));
		}
	}
	
	@Override
	public void setSelectedItem(Object anObject) {
		// TODO Auto-generated method stub
		orderAddress=(OrderAddress) anObject;
	}
	
	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return lists.size();
	}
	
	@Override
	public OrderAddress getElementAt(int index) {
		// TODO Auto-generated method stub
		orderAddress=lists.get(index);
		return orderAddress;
	}
	
	
	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
		
		return orderAddress;
	}
	
	
	
	
	
	

}
