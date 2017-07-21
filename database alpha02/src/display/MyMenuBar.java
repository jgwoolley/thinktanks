package display;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.KeyEvent;

import javax.swing.JMenu;

public class MyMenuBar {
	private JMenuBar menu;
	
	public MyMenuBar(){
		menu = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		menu.add(fileMenu);
		
		JMenuItem item = new JMenuItem("New", KeyEvent.VK_N);
		fileMenu.add(item);
	}

	public JMenuBar get() {
		return menu;
	}
}
