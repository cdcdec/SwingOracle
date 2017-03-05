package com.cdc.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SelectUserFrame {

	private JFrame jFrame;
	private JPanel topJpanel;
	private JPanel bottomJpanel;
	
	private String[] items1=new String[]{"local","root"};
	private String[] items2=new String[]{"user","mac","short","long"};
	
	public SelectUserFrame() {
		jFrame=new JFrame("查询用户");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(new Dimension(800, 600));
		jFrame.add(createTopJPanel(),BorderLayout.NORTH);
		jFrame.setVisible(true);
	}
	
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
		JTextField jtField=new JTextField(20);
		jtField.setPreferredSize(new Dimension(10, 30));
		topJpanel.add(jtField);
		topJpanel.add(Box.createVerticalStrut(15));
		JButton jButton=new JButton("查询");
		jButton.setPreferredSize(new Dimension(100, 30));
		topJpanel.add(jButton);
		topJpanel.add(Box.createVerticalStrut(15));
		return topJpanel;
		
	}
	
	

}
