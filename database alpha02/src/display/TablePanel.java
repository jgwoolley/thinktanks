package display;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import datastructures.Table;
import datastructures.ThinkTank;

public class TablePanel extends JPanel{
	private Table table;
	private ArrayList<ThinkTank> thinktanks;
	public TablePanel(Panel_Query frame){
		super();
		table = frame.getQueryTable();
		thinktanks = table.getThinktanks();
		this.setLayout(new GridLayout(thinktanks.size()+1,11));
		
		ArrayList<JButton> list = new ArrayList<JButton>();
		
		list.add(new JButton("Name"));//name
		list.add(new JButton("Region"));// region;
		list.add(new JButton("SubRegion"));// subregion;
		list.add(new JButton("Country"));// country;
		list.add(new JButton("Affiliations"));// affiliations;
		list.add(new JButton("Ideologies"));// ideologies;
		list.add(new JButton("Real Country"));// realCountry;
		list.add(new JButton("City"));// city;
		list.add(new JButton("Province"));// province;
		list.add(new JButton("Coordinates"));// coordinates;
		list.add(new JButton("Address"));// address;
		for(JButton butt: list){
			butt.setFont(new Font(butt.getFont().getFontName(), Font.BOLD, butt.getFont().getSize()));
			add(butt);
		}
		
		
		for(ThinkTank tank: thinktanks){
			ThinkTankPanel temp = new ThinkTankPanel(frame,tank);
			TraitButton[] temp2 = temp.getButtons();
			for(TraitButton butt: temp2){
				add(butt);
			}
		}
		
	}
}
