package com.cdc.ui;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

public class PersonalUpFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6485558268553437869L;
	
	private  JWebBrowser webBrowser;
	
	private JPanel  topPanel;
	private JPanel  bottomPanel;
	
	private String urlPath;
	
	
	public PersonalUpFrame(String urlPath) {
		super("个性化订单上传");
		this.urlPath=urlPath;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panelContainer = new JPanel();
		panelContainer.setOpaque(true);
		this.setSize(800, 600);
		panelContainer.setLayout(new GridBagLayout());
		GridBagConstraints c1 = new GridBagConstraints();
		c1.gridx=0;
		c1.gridy=0;
		c1.weightx=1.0;
		c1.weighty=1.0;
		c1.fill=GridBagConstraints.BOTH;
		panelContainer.add(createTopJPanel(urlPath), c1);
		
		GridBagConstraints c2 = new GridBagConstraints();
		c2.gridx=1;
		c2.gridy=0;
		c2.weightx=0.3;
		c2.weighty=0;
		c2.fill=GridBagConstraints.HORIZONTAL;
		panelContainer.add(createBottomJPanel(), c2);
		this.setContentPane(panelContainer);
		this.setVisible(true);
		
		
	}
	
	private JPanel createTopJPanel(String htmlPath){
		topPanel=new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
		webBrowser=new JWebBrowser();
		webBrowser.navigate(htmlPath);
		webBrowser.setMenuBarVisible(false);
		//地址览等信息不显示
		webBrowser.setBarsVisible(false);   
		//不显示底部的加载信息状态:如完成等
	    webBrowser.setStatusBarVisible(false);
	    topPanel.add(Box.createVerticalStrut(10));
	    topPanel.add(webBrowser);
	    topPanel.add(Box.createVerticalStrut(15));
		return topPanel;
	}
	private JPanel createBottomJPanel(){
		bottomPanel=new JPanel();
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
		JPanel jPanel1=new JPanel();
		JPanel jPanel2=new JPanel();
		JPanel jPanel3=new JPanel();
		JPanel jPanel4=new JPanel();
		JPanel jPanel5=new JPanel();
		jPanel1.setLayout(new BoxLayout(jPanel1, BoxLayout.X_AXIS));
		JTextField  jtField1=new JTextField(12);
		jPanel1.add(jtField1);
		JButton jButton1=new JButton("开始时间");
		jPanel1.add(jButton1);
		bottomPanel.add(jPanel1);
		return bottomPanel;
	}

}
