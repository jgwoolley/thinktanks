package display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;

import csv.Input;
import csv.Output;
import datastructures.Table;
import random.RandomTable;
import runner.Helper;

public class FileFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private static final Font TextFont = new Font("Courir",Font.PLAIN,25);
	private static final Font ButtonFont = new Font("Courir",Font.PLAIN,25);
	
	private static final File standardFile = new File(new SimpleDateFormat("yyyy.MM.dd").format(new Date()) + " MENA_Report.csv");			
	private File file;
		
	public FileFrame(){
		this(standardFile);
	}
	
	public FileFrame(File file){
		super();
		this.setTitle("MENA Querry: Introduction");
		this.setSize(new Dimension(800,600));
		this.setLayout(new GridLayout(2,1));
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.file = file;
		
		String str = "Welcome to the Middle East and North Africa Data Team Querry!";
		
		JPanel buttonPanel = new JPanel();
		
		if(!file.exists()){
			str+= "\nYou may either read in a File of your choice, or read in an example file.";
			
			buttonPanel.add(new FindButton(this,file,ButtonFont));
			buttonPanel.add(new ExampleButton(this,file,ButtonFont));
		} else{
			str+="\nYou have the file " + file.getName() + " would you like to read it, or delete it, or read in a new file?";			
			buttonPanel.add(new ReadButton(this,standardFile,ButtonFont));
			buttonPanel.add(new DeleteButton(this,standardFile,ButtonFont));
			buttonPanel.add(new FindButton(this,standardFile,ButtonFont));
		}
		
		add(Helper.createTextArea(str,TextFont));
		add(buttonPanel);		
	}
	
	class FindButton extends JButton{
		JFrame frame;
		
		FindButton(JFrame frame, File file,Font font){
			super("Find a new File");
			this.frame = frame;
			this.setBackground(Color.cyan);
			this.setFont(font);
			this.addActionListener(new FindButtonActionListener());
		}
		
		class FindButtonActionListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.setFileFilter(new FileFilter(){
					@Override
					public boolean accept(File file) {
						String FileName = file.getName();
						return FileName.endsWith(".csv");
					}
					@Override
					public String getDescription() {
						return ".csv";
					}
				
				});
				int returnVal = fc.showOpenDialog(fc);
				if(returnVal == JFileChooser.APPROVE_OPTION){
					File file = fc.getSelectedFile();
					if(file.exists()){
						Input input = new Input(file);
						Table table = input.getTable();
						Output output = new Output(standardFile,table);							
						QueryFrame other = new QueryFrame(table);
						other.setVisible(true);
						frame.dispose();	
					}					
				}
			} 			
		}
	}
	
	class ExampleButton extends JButton{
		JFrame frame;
		
		ExampleButton(JFrame frame, File file, Font font){
			super("Read in Example File");
			this.frame = frame;
			this.setBackground(Color.yellow);
			this.setFont(font);
			this.addActionListener(new ExampleButtonActionListener());
		}
		
		class ExampleButtonActionListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				Table table = new RandomTable();				
				Output output = new Output(standardFile,table);			
				QueryFrame other = new QueryFrame(table);
				other.setVisible(true);
				frame.dispose();
			} 			
		}
	}
	
	class ReadButton extends JButton{
		JFrame frame;
		File file;

		ReadButton(JFrame frame, File file, Font font){
			super("Read " + file.getName());
			this.frame = frame;
			this.file = file;
			this.setBackground(Color.green);
			this.setFont(font);
			this.addActionListener(new ReadButtonActionListener());
		}
		class ReadButtonActionListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				Input input = new Input(file);	
				Output output = new Output(standardFile,input.getTable());	
				QueryFrame other = new QueryFrame(input.getTable());
				other.setVisible(true);
				frame.dispose();
			} 			
		}
	}
	
	class DeleteButton extends JButton{
		JFrame frame;
		File file;

		DeleteButton(JFrame frame, File file, Font font){
			super("Delete" + file.getName());
			this.frame = frame;
			this.file = file;
			this.setBackground(Color.red);	
			this.setFont(font);
			this.addActionListener(new DeleteButtonActionListener());
		}
		class DeleteButtonActionListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				file.delete();
				
				FileFrame other = new FileFrame();
				other.setVisible(true);
				frame.dispose();
			} 			
		}
	}
}
