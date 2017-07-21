package display;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.MutableComboBoxModel;

import datastructures.Field;
import datastructures.Table;
import datastructures.ThinkTank;
import datastructures.Trait;
import field.Affiliation;
import field.Affiliations;
import field.City;
import field.Coordinates;
import field.Country;
import field.Name;
import field.Province;
import field.Region;
import field.StreetAddress;
import field.SubRegion;
import field.World;

public class ComboPanel extends JPanel{
	
	private static String[] queryList = {"activeStatuses",
			"real_regions","real_subregions","real_countries",
			"real_provinces","real_cities","data_regions",
			"data_subregions","data_countries","regiemetypes",
			"affiliations","ideologies","researchAreas"};
		
	private QueryFrame frame;
	private myComboBox query;
	private myComboBox elements;
	private myComboBox affiliations;	
	private JButton last;
	private JButton last2;
	
	public ComboPanel(QueryFrame qf){
		frame = qf;
		
		query = new myComboBox(queryList);
		query.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> list = new ArrayList<String>();
				elements.removeAllItems();			
				
				Table table = frame.getReadTable();
				int index = query.getSelectedIndex();
								
				
				if(0 == index){//activeStatuses
					list = table.getActiveStatuses().getElementsString();
				}
				else if(1 == index){//real_regions
					list = table.getReal_regions().getElementsString();
				}
				else if(2 == index){//real_subregions
					list = table.getReal_subregions().getElementsString();
				}
				else if(3 == index){//real_countries
					list = table.getReal_countries().getElementsString();
				}
				else if(4 == index){//real_provinces
					list = table.getReal_provinces().getElementsString();
				}
				else if(5 == index){//real_cities
					list = table.getReal_cities().getElementsString();
				}
				else if(6 == index){//data_regions
					list = table.getData_regions().getElementsString();
				}
				else if(7 == index){//data_subregions
					list = table.getData_subregions().getElementsString();
				}
				else if(8 == index){//data_countries
					list = table.getData_countries().getElementsString();
				}
				else if(9 == index){//regiemetypes
					list = table.getRegiemetypes().getElementsString();
				}
				else if(10 == index){//affiliations
					list = table.getAffiliations().getElementsString();
				}
				else if(11 == index){//ideologies
					list = table.getIdeologies().getElementsString();
				}
				else if(12 == index){//researchAreas
					list = table.getResearchAreas().getElementsString();
				}

				for(String str: list){
					elements.addItem(str);
				}
				
			}						
		});
				
		ArrayList<String> list = frame.getQueryTable().getActiveStatuses().getElementsString();
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
				QueryFrame other = new QueryFrame(frame.getReadTable());
				other.setVisible(true);
				frame.dispose();
			}
			
		});
		
		add(query);
		add(elements);
		add(affiliations);
		add(last);
		add(last2);
	}
	
	public static void createQuery(QueryFrame frame, Table table, String str, int index1, int index3){
		Table output = new Table(table.getWorld());
		ArrayList<ThinkTank> thinktanks = table.getThinktanks();
		
		if(0 == index1){//activeStatuses
			thinktanks = table.getActiveStatuses().getElement(str).getThinkTanks();

		}
		else if(1 == index1){//real_regions
			thinktanks = table.getReal_regions().getElement(str).getThinkTanks();
		}
		else if(2 == index1){//real_subregions
			thinktanks = table.getReal_subregions().getElement(str).getThinkTanks();
			table.getReal_subregions().getElementsString();
		}
		else if(3 == index1){//real_countries
			thinktanks = table.getReal_countries().getElement(str).getThinkTanks();
		}
		else if(4 == index1){//real_provinces
			thinktanks = table.getReal_provinces().getElement(str).getThinkTanks();

		}
		else if(5 == index1){//real_cities
			thinktanks = table.getReal_cities().getElement(str).getThinkTanks();
		}
		else if(6 == index1){//data_regions
			thinktanks = table.getData_regions().getElement(str).getThinkTanks();
		}
		else if(7 == index1){//data_subregions
			thinktanks = table.getData_subregions().getElement(str).getThinkTanks();
		}
		else if(8 == index1){//data_countries
			thinktanks = table.getData_countries().getElement(str).getThinkTanks();
		}
		else if(9 == index1){//regiemetypes
			thinktanks = table.getRegiemetypes().getElement(str).getThinkTanks();
		}
		else if(10 == index1){//affiliations
			thinktanks = table.getAffiliations().getElement(str).getThinkTanks();
		}
		else if(11 == index1){//ideologies
			thinktanks = table.getIdeologies().getElement(str).getThinkTanks();
		}
		else if(12 == index1){//researchAreas
			thinktanks = table.getResearchAreas().getElement(str).getThinkTanks();
		}
		output.addAll(thinktanks);		
		QueryFrame other = new QueryFrame(table,output, index3);
		other.setVisible(true);
		frame.dispose();	
	}
}
