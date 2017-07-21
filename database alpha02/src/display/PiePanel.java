package display;

import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import datastructures.Element;
import datastructures.Table;
import field.Affiliation;
import field.City;
import field.Coordinates;
import field.Country;
import field.Province;
import field.Region;
import field.SubRegion;

public class PiePanel{
	JPanel panel;
	
	Panel_Query frame;
	Table table;
	int index;
	
	public PiePanel(Panel_Query frame){
		panel = new JPanel();
		this.frame = frame;
		table = frame.getQueryTable();
		index = frame.getIndex();
		String beg = "";
		int count = 0;
		
		String output = "";		
		if(0 == index){//region
			ArrayList<Element<Region>> temp =  table.getRegion().toArrayList();
			beg = "Region" ;
			for(Element<Region> e: temp){
				output+= e.size() +" "+ e.getObject().toString() + "\n";
				count+= e.size();
			}
		}
		else if(1 == index){//subregion
			ArrayList<Element<SubRegion>> temp = table.getSubregion().toArrayList();
			beg = "SubRegion" ;
			for(Element<SubRegion> e: temp){
				output+= e.size() +" "+ e.getObject().toString() + "\n";
				count+= e.size();
			}	
		}
		else if(2 == index){//Country
			ArrayList<Element<Country>> temp =  table.getCountry().toArrayList();
			beg = "Country" ;
			for(Element<Country> e: temp){
				output+= e.size() +" "+ e.getObject().toString() + "\n";
				count+= e.size();
			}
		}
		else if(3 == index){//affiliations
			ArrayList<Element<Affiliation>> temp =  table.getAffiliations().toArrayList();
			beg = "Affiliations" ;
			for(Element<Affiliation> e: temp){
				output+= e.size() +" "+ e.getObject().toString() + "\n";
				count+= e.size();
			}
		}		
		else if(4 == index){//ideologies
			ArrayList<Element<Affiliation>> temp =  table.getIdeologies().toArrayList();
			for(Element<Affiliation> e: temp){
				output+= e.size() +" "+ e.getObject().toString() + "\n";
				count+= e.size();
			}
		}		
		else if(5 == index){//realCountry
			ArrayList<Element<Country>> temp =  table.getRealCountry().toArrayList();
			beg = "Real Country" ;
			for(Element<Country> e: temp){
				output+= e.size() +" "+ e.getObject().toString() + "\n";
				count+= e.size();
			}
		}		
		else if(6 == index){//city
			ArrayList<Element<City>> temp =  table.getCity().toArrayList();
			beg = "City" ;
			for(Element<City> e: temp){
				output+= e.size() +" "+ e.getObject().toString() + "\n";
				count+= e.size();
			}
		}		
		else if(7 == index){//province
			ArrayList<Element<Province>> temp =  table.getProvince().toArrayList();
			beg = "Province" ;
			for(Element<Province> e: temp){
				output+= e.size() +" "+ e.getObject().toString() + "\n";
				count+= e.size();
			}
		}		
		else if(8 == index){//coordinates
			ArrayList<Element<Coordinates>> temp =  table.getCoordinates().toArrayList();
			beg = "Coordinates" ;
			for(Element<Coordinates> e: temp){
				output+= e.size() +" "+ e.getObject().toString() + "\n";
				count+= e.size();
			}
		}		
		else{
			output = "Query Outputs will apear here.";
		}
		if(count !=0){
			output = beg + " size " + count + "\n" + output;
		}
		MyTextArea mytextarea = new MyTextArea(output, new Font("Courir", Font.PLAIN,18));
		panel.add(new JScrollPane(mytextarea.get()));
	}

	public Component get() {
		return panel;
	}
	
	
}
