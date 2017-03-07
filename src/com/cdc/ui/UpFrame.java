package com.cdc.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.cdc.model.OrderAddress;

public class UpFrame extends JFrame implements ActionListener,ItemListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1944211170507227023L;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		

	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jComboBox){
			System.out.println(((OrderAddress)jComboBox.getSelectedItem()).getUrlPath());
		}
	}
	
	
	private JPanel containJPanel;
	private JPanel leftJPanel;
	private JPanel middleJPanel;
	private JPanel rightJPanel;
	private JComboBox<OrderAddress> jComboBox;
	private JButton jButton;
	
	public UpFrame(){
		this.setTitle("");
		this.setSize(new Dimension(800, 600));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		containJPanel=createContainJPanel();
		this.add(containJPanel);
		this.setVisible(true);
		
	}
	
	private JPanel createContainJPanel(){
		containJPanel=new JPanel(new GridBagLayout());
		GridBagConstraints g1=new GridBagConstraints();
		g1.gridx=0;
		g1.gridy=0;
		g1.weightx=0.2;
		g1.weighty=1.00;
		g1.fill=GridBagConstraints.BOTH;
		
		leftJPanel=createLeftJPanel();
		
		containJPanel.add(leftJPanel, g1);
		
		GridBagConstraints g2=new GridBagConstraints();
		g2.gridx=1;
		g2.gridy=0;
		g2.weightx=0.6;
		g2.weighty=1.00;
		g2.fill=GridBagConstraints.BOTH;
		middleJPanel=createMiddleJPanel();
		
		containJPanel.add(middleJPanel, g2);
		
		
		GridBagConstraints g3=new GridBagConstraints();
		g3.gridx=2;
		g3.gridy=0;
		g3.weightx=0.2;
		g3.weighty=1.00;
		g3.fill=GridBagConstraints.BOTH;
		
		rightJPanel=createRightJPanel();
		containJPanel.add(rightJPanel, g3);
		
		
		 
		 
		 return containJPanel;
		
	}
	
	private JPanel createLeftJPanel(){
		 leftJPanel=new JPanel();
		 return leftJPanel;
	}
	
	
	private JPanel createMiddleJPanel(){
		middleJPanel=new JPanel();
		Box vbox = Box.createVerticalBox();
		vbox.add(Box.createVerticalStrut(20));
		JTextField  jTextField1=createJTextField("用户名",30);
		vbox.add(jTextField1);
		vbox.add(Box.createVerticalStrut(20));
		JTextField  jTextField2=createJTextField("mac",30);
		vbox.add(jTextField2);
		vbox.add(Box.createVerticalStrut(20));
		JTextField  jTextField3=createJTextField("平台级别",30);
		vbox.add(jTextField3);
		vbox.add(Box.createVerticalStrut(20));
		List<OrderAddress> lists=getOrderAddress();
		jComboBox=new JComboBox<OrderAddress>(new OrderAddressComboBoxModel(lists));
		jComboBox.setPreferredSize(new Dimension (100,35));
		jComboBox.addItemListener(this);
		vbox.add(jComboBox);
		vbox.add(Box.createVerticalStrut(20));
		JPanel jPanelJButton=new JPanel(null);
		jButton=new JButton("确定");
		jButton.setBounds(0, 0, 200, 35);
		jPanelJButton.add(jButton);
		jButton.addActionListener(this);
		vbox.add(jPanelJButton);
		vbox.add(Box.createVerticalStrut(20));
		middleJPanel.add(vbox,BorderLayout.CENTER);
		return middleJPanel;
	}
	
	private JTextField createJTextField(String text,int num){
		JTextField  jTextField=new JTextField(text,num);
		jTextField.setPreferredSize(new Dimension (100,35)); 
		return jTextField;
	}
	private JPanel createRightJPanel(){
		rightJPanel=new JPanel();
		return rightJPanel;
		
	}
	
	private List<OrderAddress>  getOrderAddress(){
		List<OrderAddress> lists=new ArrayList<OrderAddress>();
		lists.add(new OrderAddress("应急", "url1"));
		lists.add(new OrderAddress("个性", "url2"));
		lists.add(new OrderAddress("普通", "url3"));
		lists.add(new OrderAddress("直播", "url4"));
		return lists;
	}
	
	public static void main(String[] args) {
		new UpFrame();
	}

	
	
	
	
	
	

}
