package runner;

import display.MainFrame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTable;

public class Runner {
	public static final Font TextFont = new Font("Courir",Font.PLAIN,20);
	public static final Font ButtonFont = new Font("Courir",Font.PLAIN,15);
	public static final Color[] colors = {new Color(153,27,30),new Color(28,39,89), Color.WHITE};	
	
	public static void main(String[] args) {	
		//JTable table = new JTable();
		//JFrame frame = new JFrame();
		//frame.add(table);
		//frame.setVisible(true);
		MainFrame display = new MainFrame();
	    display.setVisible(true);
	    
	    JFrame frame = new JFrame("hi");
	}
}
