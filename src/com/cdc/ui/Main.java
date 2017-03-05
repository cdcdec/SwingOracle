package com.cdc.ui;


import javax.swing.SwingUtilities;

import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NativeInterface.open();
		   UIUtils.setPreferredLookAndFeel();
		    SwingUtilities.invokeLater(new Runnable() {
		      public void run() {
		        new PersonalUpFrame();
		      }
		    });
		    
		    NativeInterface.runEventPump();
		    

	}

}
