package display;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.MutableComboBoxModel;

import datastructures.Table;
import datastructures.ThinkTank;
import datastructures.Trait;
import field.Affiliation;
import field.Affiliations;
import field.City;
import field.Coordinates;
import field.Country;
import field.Province;
import field.Region;
import field.SubRegion;

public class ComboPanel{
	private static String[] queryList = {"region","subregion","country","affiliations","ideologies","realCountry","city","province","coordinates"};
	private JPanel panel;	
	//private Panel_Query frame;
	private myComboBox query;
	private myComboBox elements;
	private myComboBox affiliations;	
	private JButton last;
	private JButton last2;
	
	public ComboPanel(Panel_Query qf){
		panel = new JPanel();
		frame = qf;		
		query = new myComboBox(queryList);
		query.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> list = new ArrayList<String>();
				elements.removeAllItems();			
				
				Table table = frame.getReadTable();
				int index = query.getSelectedIndex();
				
				if(0 == index){//region
					list = table.getRegion().getElementsString();
				}
				else if(1 == index){//subregion
					list = table.getSubregion().getElementsString();
				}
				else if(2 == index){//Country
					list = table.getCountry().getElementsString();
				}
				else if(3 == index){//affiliations
					list = table.getAffiliations().getElementsString();
				}
				else if(4 == index){//ideologies
					list = table.getIdeologies().getElementsString();
				}
				else if(5 == index){//realCountry
					list = table.getRealCountry().getElementsString();
				}
				else if(6 == index){//city
					list = table.getCity().getElementsString();
				}
				else if(7 == index){//province
					list = table.getProvince().getElementsString();
				}
				else if(8 == index){//coordinates
					list = table.getCoordinates().getElementsString();
				}
				else{
					list.add("inv index");
				}
				for(String str: list){
					elements.addItem(str);
				}
			}						
		});
				
		ArrayList<String> list = frame.getQueryTable().getRegion().getElementsString();
		String[] list2 = new String[list.size()];
		for(int i = 0; i < list.size();i++){
			list2[i] = list.get(i);
		}		
		elements = new myComboBox(list2);
		affiliations = new myComboBox(queryList);
		last = new JButton("Query Data");
		last.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Table readTable = frame.getReadTable();
				int tempindx = elements.getSelectedIndex();				
				String temp = elements.getItemAt(tempindx);
				
				createQuery(frame,readTable,temp,query.getSelectedIndex(),affiliations.getSelectedIndex());		
			}		
		});
		last2 = new JButton("Clear Querries");
		last2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Panel_Query other = new Panel_Query(frame.getReadTable());
				other.setVisible(true);
				frame.dispose();
			}
			
		});
		
		panel.add(query);
		panel.add(elements);
		panel.add(affiliations);
		panel.add(last);
		panel.add(last2);
	}
	
	public static void createQuery(Panel_Query frame, Table table, String str, int index1, int index3){
		Table output = new Table();
		ArrayList<ThinkTank> thinktanks = new ArrayList<ThinkTank>();
		
		if(0 == index1){//region
			thinktanks = table.getRegion().getThinkTanks(new Region(str));
		}
		else if(1 == index1){//subregion
			thinktanks = table.getSubregion().getThinkTanks(new SubRegion(str));
		}
		else if(2 == index1){//country
			thinktanks = table.getCountry().getThinkTanks(new Country(str));
		}
		else if(3 == index1){//affiliations
			thinktanks = table.getAffiliations().getThinkTanks(new Affiliation(str));
		}
		else if(4 == index1){//ideologies
			thinktanks = table.getIdeologies().getThinkTanks(new Affiliation(str));
		}
		else if(5 == index1){//realCountry
			thinktanks = table.getRealCountry().getThinkTanks(new Country(str));
		}
		else if(6 == index1){//city
			thinktanks = table.getCity().getThinkTanks(new City(str));
		}
		else if(7 == index1){//province
			thinktanks = table.getProvince().getThinkTanks(new Province(str));
		}
		else if(8 == index1){//coordinates
			thinktanks = table.getCoordinates().getThinkTanks(new Coordinates(str));
		}
		output.addAll(thinktanks);		
		Panel_Query other = new Panel_Query(table,output, index3);
		other.setVisible(true);
		frame.dispose();	
	}

	public Component get() {
		// TODO Auto-generated method stub
		return null;
	}
}
