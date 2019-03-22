package org.organizzation.utility;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;

import org.organizzation.model.BasketItem;
import org.organizzation.model.Receipt;

public class Utility {
	
	
	public Utility() {
	}
	
	public void generateSwingReceipt(String frameName, Receipt receipt, int offset) {
	    JFrame f= new JFrame(frameName);
	    
	    int iteration = 1;
	    for (BasketItem bi : receipt.getItems()) {
	    	JLabel jb = new JLabel(bi.toString()); 
	    	jb.setBounds(20,20*iteration, 1000,60);
	    	iteration++;
	    	f.add(jb);
		}
	    
	    JSeparator separator = new JSeparator();
	    f.add(separator);
	    
    	JLabel jTotal = new JLabel(receipt.toStringTotalCost()); 
    	jTotal.setBounds(20,20*iteration, 1000,60);
	    
	    f.add(jTotal);
	    
	    f.setSize(400,300);  
	    f.setLayout(null); 
	    centreWindow(f, offset);
	    f.setVisible(true);
	}

	public static void centreWindow(Window f, int offset) {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - f.getWidth()) / 2)-offset;
	    int y = (int) ((dimension.getHeight() - f.getHeight()) / 2);
	    f.setLocation(x, y);
	}
	
}
