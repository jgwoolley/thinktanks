package display;

import javax.swing.JPanel;

import datastructures.ThinkTank;
import field.Affiliations;
import field.City;
import field.Coordinates;
import field.Country;
import field.Name;
import field.Province;
import field.Region;
import field.StreetAddress;
import field.SubRegion;

public class ThinkTankPanel extends JPanel{
	private ThinkTank tank;
	private TraitButton[] buttons;
	private TraitButton<Region> region;
	private TraitButton<SubRegion> subregion;
	private TraitButton<Country> country;
	private TraitButton<Name> name;
	private TraitButton<Affiliations> affiliations;
	private TraitButton<Affiliations> ideologies;
	private TraitButton<Country> realCountry;
	private TraitButton<City> city;
	private TraitButton<Province> province;
	private TraitButton<Coordinates> coordinates;
	private TraitButton<StreetAddress> address;
	
	
	public ThinkTankPanel(Panel_Query frame, ThinkTank tank){
		super();
		this.tank = tank;		
		region = new TraitButton<Region>(frame,tank.getRegion(),0);
		subregion = new TraitButton<SubRegion>(frame,tank.getSubregion(),1);
		country = new TraitButton<Country>(frame,tank.getCountry(),2);
		name = new TraitButton<Name>(frame,tank.getName(),3);
		affiliations = new TraitButton<Affiliations>(frame,tank.getAffiliations(),4);
		ideologies = new TraitButton<Affiliations>(frame,tank.getIdeologies(),5);
		realCountry = new TraitButton<Country>(frame,tank.getRealCountry(),6);
		city = new TraitButton<City>(frame,tank.getCity(),7);
		province = new TraitButton<Province>(frame,tank.getProvince(),8);
		coordinates = new TraitButton<Coordinates>(frame,tank.getCoordinates(),9);
		address = new TraitButton<StreetAddress>(frame,tank.getAddress(),10);
		buttons = new TraitButton[11];
		
		
		buttons[0] = name;
		buttons[1] = region;
		buttons[2] = subregion;
		buttons[3] = country;
		buttons[4] = affiliations;
		buttons[5] = ideologies;
		buttons[6] = realCountry;
		buttons[7] = city;
		buttons[8] = province;
		buttons[9] = coordinates;
		buttons[10] = address;
		
		for(TraitButton butt: buttons){
			add(butt);
		}
	}
	
	public TraitButton[] getButtons(){
		return buttons;
	}
}
