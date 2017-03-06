package com.cdc.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.cdc.dao.UserMacDaoImpl;
import com.cdc.jdbc.PropertiesUtil;
import com.cdc.model.UserMac;
import com.cdc.service.UserMacServiceImpl;


public class SelectUserFrame {

	private JFrame jFrame;
	private JPanel topJpanel;
	private JPanel bottomJpanel;
	
	private String[] items1=new String[]{"local","root"};
	private String[] items2=new String[]{"user","mac"};
	private String columnNames[]=new String[]{"账号","密码","mac","terminalid","ter_loginno","usercode","username","c_platlevel","t_platlevel"};
	private UserMacServiceImpl userMacServiceImpl;
	
	public static void main(String[] args) {
		new SelectUserFrame();
	}
	
	public SelectUserFrame() {
		jFrame=new JFrame("查询用户");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(new Dimension(800, 600));
		jFrame.add(createTopJPanel(),BorderLayout.NORTH);
		jFrame.add(createBottomJPanel(),BorderLayout.CENTER);
		jFrame.setVisible(true);
	}
	 UserMacModel  userMacModel;
	 JTable  table;
	private JPanel createBottomJPanel(){
		 bottomJpanel=new JPanel();
		 bottomJpanel.setLayout(new BoxLayout(bottomJpanel, BoxLayout.Y_AXIS));
		 userMacServiceImpl=new UserMacServiceImpl(new UserMacDaoImpl());
		//设置列表
		   userMacModel=new UserMacModel(columnNames);
		   table=new JTable(userMacModel);
		// 设置此表视口的首选大小
			table.setPreferredScrollableViewportSize(new Dimension(550, 30));
			//设置表头的高度
			Dimension size = table.getTableHeader().getPreferredSize();
			size.height = 40;//设置新的表头高度40
			table.getTableHeader().setPreferredSize(size);
			//设置表格内容的高度,不包括表头的高度
			table.setRowHeight(35);
			JScrollPane scrollPane = new JScrollPane(table);// 将表格加入到滚动条组件中
		
		
		 bottomJpanel.add(scrollPane);
		 return bottomJpanel;
	}
	JTextField jtField;
	private JPanel createTopJPanel(){
		topJpanel=new JPanel();
		topJpanel.setLayout(new BoxLayout(topJpanel, BoxLayout.Y_AXIS));
		JComboBox<String>  jComboBox1=new JComboBox<>(items1);
		jComboBox1.setPreferredSize(new Dimension(10, 30));
		jComboBox1.setSelectedIndex(0);
		topJpanel.add(jComboBox1);
		topJpanel.add(Box.createVerticalStrut(15));
		JComboBox<String>  jComboBox2=new JComboBox<>(items2);
		jComboBox2.setSelectedIndex(0);
		jComboBox2.setPreferredSize(new Dimension(10, 30));
		topJpanel.add(jComboBox2);
		topJpanel.add(Box.createVerticalStrut(15));
		jtField=new JTextField(20);
		jtField.setPreferredSize(new Dimension(10, 30));
		topJpanel.add(jtField);
		topJpanel.add(Box.createVerticalStrut(15));
		JButton jButton=new JButton("查询");
		jButton.setPreferredSize(new Dimension(100, 30));
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str1=(String) jComboBox1.getSelectedItem();
				if(str1.equals("local")){
					PropertiesUtil.dataBaseNum=2;
				}else{
					PropertiesUtil.dataBaseNum=1;
				}
				String str2=(String) jComboBox2.getSelectedItem();
				String str3=(String) jtField.getText();
				System.out.println(str2);
				if(str2.equals("user")){
					List<UserMac> lists=(List<UserMac>) userMacServiceImpl.getUserMacByUser(str3);
					if(lists.size()>0){
						userMacModel.setData(lists);
					}else{
						JOptionPane.showConfirmDialog(jFrame, "没有这个用户!");
					}
					
				}else if(str2.equals("mac")){
					List<UserMac> lists=(List<UserMac>) userMacServiceImpl.getUserMacByMac(str3);
					if(lists.size()>0){
						userMacModel.setData(lists);
					}else{
						JOptionPane.showConfirmDialog(jFrame, "没有这个mac!");
					}
				}
				 
				table.updateUI();
				//userMacModel.setData(null);
				
			}
		});
		topJpanel.add(jButton);
		topJpanel.add(Box.createVerticalStrut(15));
		return topJpanel;
		
	}
	
	

}
