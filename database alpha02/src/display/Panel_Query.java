package display;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import datastructures.Table;
import runner.Helper;

public class Panel_Query{
	private JPanel panel;
	private Table readTable;
	private Table queryTable;
	private int index;
	
	public Panel_Query(Table table){
		this(table,table);
	}
	
	public Panel_Query(Table readTable,Table queryTable){
		this(readTable,queryTable,-1);
	}
	
	public Panel_Query(Table readTable,Table queryTable, int index){
		super();
		panel.setLayout(new GridLayout(3,1));
		this.readTable = readTable;
		this.queryTable = queryTable;
		this.index = index;
		ComboPanel combopanel = new ComboPanel(this);
		panel.add(combopanel.get());
		PiePanel piepanel = new PiePanel(this);
		panel.add(piepanel.get());
		
		panel.add(new JScrollPane(new TablePanel(this)));
		
	}

	public Table getReadTable() {
		return readTable;
	}

	public Table getQueryTable() {
		return queryTable;
	}
	
	public int getIndex(){
		return index;
	}

	public JPanel get() {
		return panel;
	}
}
