package com.cdc.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.cdc.model.OrderAddress;

public class UpFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1944211170507227023L;

	
	
	
	
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
	
	private JTextField  jTextField1;
	private JTextField  jTextField2;
	private JTextField  jTextField3;
	private JPanel createMiddleJPanel(){
		middleJPanel=new JPanel();
		Box vbox = Box.createVerticalBox();
		vbox.add(Box.createVerticalStrut(20));
		jTextField1=createJTextField("用户名",30);
		vbox.add(jTextField1);
		vbox.add(Box.createVerticalStrut(20));
		jTextField2=createJTextField("mac",30);
		vbox.add(jTextField2);
		vbox.add(Box.createVerticalStrut(20));
		jTextField3=createJTextField("平台级别",30);
		vbox.add(jTextField3);
		vbox.add(Box.createVerticalStrut(20));
		List<OrderAddress> lists=getOrderAddress();
		jComboBox=new JComboBox<OrderAddress>(new OrderAddressComboBoxModel(lists));
		jComboBox.setPreferredSize(new Dimension (100,35));
		vbox.add(jComboBox);
		vbox.add(Box.createVerticalStrut(20));
		JPanel  jPanel=new JPanel();
		jPanel.setLayout(new BorderLayout());
		jButton=new JButton("确定");
		jButton.setPreferredSize(new Dimension(100, 35));
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				okButton();
			}
		});
		jPanel.add(jButton,BorderLayout.NORTH);
		vbox.add(jPanel);
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
		lists.add(new OrderAddress("应急1", "url1"));
		lists.add(new OrderAddress("个性1", "http://192.168.0.162:8080/IfabooMIUP/ifaboo_immediate_android.jsp"));
		lists.add(new OrderAddress("普通1", "url3"));
		lists.add(new OrderAddress("直播1", "url4"));
		return lists;
	}
	
	private void okButton(){
		String name=jTextField1.getText().replaceAll(" ", "");
		String mac=jTextField2.getText().replaceAll(" ", "");
		String platLevel=jTextField3.getText().replaceAll(" ", "");
		OrderAddress  orderAddress=(OrderAddress) jComboBox.getSelectedItem();
		String urlPath=orderAddress.getUrlPath();
		System.out.println(name+","+mac+","+platLevel+","+urlPath);
		//关闭本页面
		this.dispose();
		
		new SelectUserFrame();
	}
	
	public static void main(String[] args) {
		new UpFrame();
	}

	
	
	
	
	
	

}
