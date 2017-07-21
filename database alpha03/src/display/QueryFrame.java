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

public class QueryFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private Table readTable;
	private Table queryTable;
	private int index;
	
	public QueryFrame(Table table){
		this(table,table);
	}
	
	public QueryFrame(Table readTable,Table queryTable){
		this(readTable,queryTable,-1);
	}
	
	public QueryFrame(Table readTable,Table queryTable, int index){
		super();
		this.setTitle("MENA Querry: Query");
		this.setSize(new Dimension(800,600));
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new GridLayout(3,1));
		this.readTable = readTable;
		this.queryTable = queryTable;
		this.index = index;
		
		this.add(new ComboPanel(this));
		//this.add(new PiePanel(this));		
		this.add(new JScrollPane(new Panel_Table(this)));
		
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
}
