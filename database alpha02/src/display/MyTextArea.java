package display;

import java.awt.Font;

import javax.swing.JTextArea;

import runner.Runner;

public class MyTextArea {
	private JTextArea textArea;
	
	public MyTextArea(String str){
		this(str, Runner.TextFont);
	}
	
	public MyTextArea(String str, Font font){
        textArea = new JTextArea(str, 6, 6);
        textArea.setFont(font);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setOpaque(true);
        textArea.setEditable(false);
        textArea.setForeground(Runner.colors[1]);        
	}
	
	public JTextArea get(){
		return textArea;
	}

}
