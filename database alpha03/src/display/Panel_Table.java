package display;

import javax.swing.JPanel;
import javax.swing.JTable;

import datastructures.Field;
import datastructures.Table;
import datastructures.ThinkTank;
import field.Affiliation;
import field.City;
import field.Country;
import field.Name;
import field.Province;
import field.Region;
import field.SubRegion;

public class Panel_Table extends JPanel{
	QueryFrame frame;
	Table table;
	
	public Panel_Table(QueryFrame frame){
		super();
		this.frame = frame;
		this.table = frame.getQueryTable();
        int length = table.size();
		
		//headers for the table
        String[] columns = new String[] {
            "Active","Name","Data Regions","Data SubRegion","Data Country",
            "Real Region", "Real Sub Region", "Real Country","Real Province","Real City",
            "Affiliations","Ideologies","Research Areas","GDP per Capita","Literacy Rate",
            "Population","Freedom of Press","Regime Type"
        };
        
        //actual data for the table in a 2d array

        String[][] data = new String[length][18];
        for(int i = 0; i < length;i++){
        	ThinkTank tank = table.get(i);
        	data[i][0] = tank.getActiveStatus().toString();//Active
        	data[i][1] = tank.getName().toString();//Name
        	data[i][2] = tank.getData_country().getRegion().toString();//Region data
        	data[i][3] = tank.getData_country().getSubRegion().toString();//SubRegion data
        	data[i][4] = tank.getData_country().toString();//Country data
        	
           	data[i][5] = tank.getActiveStatus().toString();//Region real
        	data[i][6] = tank.getActiveStatus().toString();//SubRegion real
        	data[i][7] = tank.getActiveStatus().toString();//Country real
        	data[i][8] = tank.getActiveStatus().toString();//Province real
        	data[i][9] = tank.getActiveStatus().toString();//City real
        	
        	data[i][10] = tank.getAffiliation().toString();//Affiliations
        	data[i][11] = tank.getIdeology().toString();//Ideologies
        	data[i][12] = tank.getResearchArea().toString();//Research
        	data[i][13] = "" + tank.getData_country().getGDP_per_capita();//GDP
        	data[i][14] = "" + tank.getData_country().getLiteracyRate();//Literacy
        	data[i][15] = "" + tank.getData_country().getPopulation();//Population
        	data[i][16] = "" + tank.getData_country().getFreedomOfPress();//Freedom
        	data[i][17] = "" + tank.getData_country().getRegiemetype();//Regime

        }
        
        
        //create table with data
        JTable jtable = new JTable(data, columns);
         this.add(jtable);
	}	
}
