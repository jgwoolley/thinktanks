package display;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;

import runner.Runner;

public class Panel_File{
	private MainFrame myFrame;		
	private JPanel panel;
	private MyTextArea textarea_main;
	private JButton button_Thinktank;
	private JButton button_City;
	private JButton button_Country;
	private JButton button_go;
	private JButton button_load;
	private JButton button_random;
	
	public File thinktanks;
	public File cities;
	public File countries;
		
	Panel_File(MainFrame frame){
		myFrame = frame;
		panel = new JPanel();
		panel.setLayout(new GridLayout(2,1));
		panel.setBackground(Runner.colors[2]);
			
		textarea_main = new MyTextArea("Load in each required file, and click go once all three are ready.");
		panel.add(textarea_main.get());

		//Read Files	
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(3,1));
		panel2.setBackground(Runner.colors[2]);
			
		JPanel buttons_Go = new JPanel();
		buttons_Go.setBackground(Runner.colors[2]);
		JButton label_file = new JButton("file");
		label_file.setToolTipText("Load in the three t");
		label_file.setBackground(Runner.colors[2]);
		label_file.setForeground(Runner.colors[1]);
		label_file.setFont(Runner.ButtonFont);
		button_Thinktank = new JButton("ThinkTanks.csv");
		button_Thinktank.setBackground(Runner.colors[0]);
		button_Thinktank.setForeground(Runner.colors[2]);
		button_Thinktank.setFont(Runner.ButtonFont);
		button_Thinktank.addActionListener(new LoadCSV(this,button_Thinktank,0));
		button_City = new JButton("City.csv");
		button_City.setBackground(Runner.colors[0]);
		button_City.setForeground(Runner.colors[2]);
		button_City.setFont(Runner.ButtonFont);
		button_City.addActionListener(new LoadCSV(this,button_City,1));
		button_Country = new JButton("Country.csv");
		button_Country.setBackground(Runner.colors[0]);
		button_Country.setForeground(Runner.colors[2]);
		button_Country.setFont(Runner.ButtonFont);
		button_Country.addActionListener(new LoadCSV(this,button_Country,2));
		button_go = new JButton("Go!");
		button_go.setBackground(Runner.colors[0]);
		button_go.setForeground(Runner.colors[2]);		
		button_go.setFont(Runner.ButtonFont);
		button_go.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(thinktanks == null | cities == null | countries == null){
					Panel_File other = new Panel_File(myFrame);
					myFrame.setPanel(other.get());
				}
				else{
					Panel_Query other = new Panel_Query(myFrame);
					myFrame.setPanel(other.get());
				}
				
			}			
		});
		buttons_Go.add(label_file);
		buttons_Go.add(button_Thinktank);
		buttons_Go.add(button_City);
		buttons_Go.add(button_Country);
		buttons_Go.add(button_go);
		panel2.add(buttons_Go);
				
		//Create Random Files
		JPanel buttons_Random = new JPanel();
		buttons_Random.setBackground(Runner.colors[2]);
		JButton label_random = new JButton("random");
		
		label_random.setBackground(Runner.colors[2]);
		label_random.setForeground(Runner.colors[1]);
		label_random.setFont(Runner.ButtonFont);
		button_random = new JButton("Go!");
		button_random.setBackground(Runner.colors[0]);
		button_random.setForeground(Runner.colors[2]);
		button_random.setFont(Runner.ButtonFont);
		button_random.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}			
		});
		buttons_Random.add(label_random);			
		buttons_Random.add(button_random);
		//panel2.add(buttons_Random);//UNSUPORTED
		
		//Load in Previous Files
		JPanel buttons_Load = new JPanel();
		buttons_Load.setBackground(Runner.colors[2]);
		JButton label_load = new JButton("load");
		
		label_load.setBackground(Runner.colors[2]);
		label_load.setForeground(Runner.colors[1]);
		label_load.setFont(Runner.ButtonFont);
		button_load = new JButton("Go!");
		button_load.setBackground(Runner.colors[0]);
		button_load.setForeground(Runner.colors[2]);
		button_load.setFont(Runner.ButtonFont);
		button_load.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}			
		});
		buttons_Load.add(label_load);
		buttons_Load.add(button_load);
		//panel2.add(buttons_Load);//UNSUPPORTED
		
		panel.add(panel2);
			
	}
		
	JPanel get(){
		return panel;
	}
	
	public class LoadCSV implements ActionListener{
		Panel_File panel_file;
		JButton myButton;		
		int index;
		
		public LoadCSV(Panel_File file, JButton button, int index){
			panel_file = file;
			myButton = button;
			this.index = index;
		}
		
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
					myButton.setText(file.getName());
					myButton.setBackground(Runner.colors[2]);
					myButton.setForeground(Runner.colors[0]);
					if(index ==0){
						thinktanks = file;
					}
					else if(index ==1){
						cities = file;
					}
					else if(index ==2){
						countries = file;
					}
				}
				else{

				}
			}
		}		
	}
}	
