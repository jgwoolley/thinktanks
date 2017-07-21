package display;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import runner.Runner;

public class MainFrame {
	private JFrame myFrame;
	private MyMenuBar myMenuBar;
	private JMenuBar myMenu;
	private JPanel myPanel;
	
	public MainFrame(){
		myFrame = new JFrame("TTCSP: MENA Data Query");
		myMenuBar = new MyMenuBar();
		myMenu = myMenuBar.get();
		Panel_Intro myIntroductionPanel = new Panel_Intro(this);
		myPanel = myIntroductionPanel.get();

		try {
			File file = new File("src/display/thumb.gif");
			Image img = ImageIO.read(file);
			myFrame.setIconImage(img);

		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		myFrame.setSize(new Dimension(800,600));
		myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		myFrame.add(myPanel);
		myFrame.setJMenuBar(myMenu);
		myFrame.setBackground(Runner.colors[2]);
	}
	
	public void setVisible(boolean val){
		myFrame.setVisible(val);
	}
	
	public void setPanel(JPanel panel){
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				myFrame.remove(myPanel);
				myFrame.add(panel);
				myFrame.invalidate();
				myFrame.validate();	
			}			
		});
	}
	
	class Panel_Intro {
		private MainFrame myFrame;
		
		private JPanel panel;
		private JButton button;
		private MyTextArea textarea;
		
		Panel_Intro(MainFrame frame){
			myFrame = frame;
			
			panel = new JPanel();
			panel.setLayout(new BorderLayout(3,1));
			panel.setBackground(Runner.colors[2]);
			
			textarea = new MyTextArea("Welcome to the Middle East and Northern Africa "
				+ "Think Tank database query. This program is "
				+ "only meant for use in the Think Tanks and Civil Society Program (TTCSP) "
				+ "of the University of Pennsylvania's Lauder Institute. "
				+ "If you wish to begin your query, please press the button bellow.");
			panel.add(textarea.get(),BorderLayout.NORTH);
			
			File file = new File("src/display/background.gif");
			ImageLabel imagelabel = new ImageLabel(file);
			panel.add(imagelabel.get());
			
			button = new JButton("Begin!");
			button.setFont(Runner.ButtonFont);
			button.setBackground(Runner.colors[0]);
			button.setForeground(Runner.colors[2]);
			Panel_File panel_file = new Panel_File(myFrame);
			button.addActionListener(new PanelSwap(myFrame, panel_file.get()));
			panel.add(button,BorderLayout.SOUTH);
		}
		
		JPanel get(){
			return panel;
		}
	}
	
	public class PanelSwap implements ActionListener{
		MainFrame myFrame;
		JPanel myPanel;
		
		public PanelSwap(MainFrame frame,JPanel panel){
			myFrame = frame;
			myPanel = panel;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			myFrame.setPanel(myPanel);
		}
		
	}
	
}
