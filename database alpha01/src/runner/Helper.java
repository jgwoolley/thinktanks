package runner;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import csv.Output;

public class Helper {

	public static double average(double[] arr){
		double temp = 0;
		double length = arr.length;
		for(int i = 0; i < length;i++){
			temp+= arr[i];
		}
		
		return temp/length;
	}
	
	public static JTextArea createTextArea(String str, Font font){
        JTextArea textArea = new JTextArea(str, 6, 20);
        textArea.setFont(font);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setOpaque(false);
        textArea.setEditable(false);
        textArea.setBackground(Color.BLACK);
        
        return textArea;
	}
	
	public static String[] getFileNames(){
		String date = new SimpleDateFormat("yyyy.MM.dd").format(new Date());
		
		String[] str = {date + " MENA_Report.csv", date + " MENA_Fail.csv"};
		return str;
	}
}
