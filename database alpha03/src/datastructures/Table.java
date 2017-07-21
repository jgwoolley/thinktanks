package datastructures;

import java.util.ArrayList;

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

public class Table{
	private ArrayList<ThinkTank> thinktanks;
	private ArrayList<String> invalidStrings;
	private World world;
	
	private Field<Name> activeStatuses;	
	private Field<Region> real_regions;
	private Field<SubRegion> real_subregions;
	private Field<Country> real_countries;
	private Field<Province> real_provinces;
	private Field<City> real_cities;
	private Field<Region> data_regions;
	private Field<SubRegion> data_subregions;
	private Field<Country> data_countries;
	private Field<Name> regiemetypes;	
	private Field<Affiliation> affiliations;
	private Field<Affiliation> ideologies;
	private Field<Affiliation> researchAreas;
	
	public Table(World world){
		thinktanks = new ArrayList<ThinkTank>();
		invalidStrings = new ArrayList<String>();
		this.world = world;		
		activeStatuses = new Field<Name>();	
		real_regions = new Field<Region>();
		real_subregions = new Field<SubRegion>();
		real_countries = new Field<Country>();
		real_provinces = new Field<Province>();
		real_cities = new Field<City>();
		data_regions = new Field<Region>();
		data_subregions = new Field<SubRegion>();
		data_countries = new Field<Country>();
		regiemetypes = new Field<Name>();	
		affiliations = new Field<Affiliation>();
		ideologies = new Field<Affiliation>();
		researchAreas = new Field<Affiliation>();
	}
	
	public int size(){
		return thinktanks.size();
	}
	
	public ThinkTank get(int index){
		return thinktanks.get(index);
	}
	
	public String toString(){
		String str = "ThinkTanks" + thinktanks.size() + "\n";
		
		for(ThinkTank tank: thinktanks){
			str+= tank.toString() + "\n";
		}
		str+= "Failed" + invalidStrings.size() + "\n";
		for(String str2: invalidStrings){
			str+= str2+ "\n";
		}
		return str;
	}
	
	public String[] getInvalidStrings(){
		int size = invalidStrings.size();
		String[] output = new String[size];
		for(int i = 0; i < size; i++){
			output[i] = invalidStrings.get(i);
		}
		
		return output;
	}
	
	public boolean update(String input){
		String[] strings = input.split(",");
		int max = 10;
		String[] temp = new String[max];		
		for(int i = 0; i < max;i++){
			temp[i] = strings[i];
		}
		strings = temp;
		
		Name valid = new Name(strings[0]);	
		City real_city = world.findCity(strings[1]);
		Country data_country = world.findCountry(strings[2]);
		Name name = new Name(strings[3]);
		Affiliations affiliation = new Affiliations(strings[4]);
		Affiliations ideology = new Affiliations(strings[5]);
		Affiliations researchArea = new Affiliations(strings[6]);
		Coordinates coordinates = new Coordinates(strings[7]);
		StreetAddress address = new StreetAddress(strings[8]);
		int datefounded = Integer.parseInt(strings[9]);
		ThinkTank thinktank = new ThinkTank(valid,real_city,data_country,name,affiliation
				,ideology,researchArea,coordinates, address, datefounded);
		if(thinktank.isValid()){
			add(thinktank);				
			return true;
		}
		else{
			invalidStrings.add(input);
			return false;
		}

	}	
	
	public void addAll(ArrayList<ThinkTank> thinktanks){
		for(ThinkTank t: thinktanks){
			add(t);
		}
	}
	
	public void add(ThinkTank thinktank){
		thinktanks.add(thinktank);		
		activeStatuses.add(thinktank.getActiveStatus(), thinktank);					
		real_regions.add(thinktank.getReal_city().getRegion(), thinktank);
		real_subregions.add(thinktank.getReal_city().getSubRegion(), thinktank);
		real_countries.add(thinktank.getReal_city().getCountry(), thinktank);
		real_provinces.add(thinktank.getReal_city().getProvince(), thinktank);
		real_cities.add(thinktank.getReal_city(), thinktank);				
		data_regions.add(thinktank.getData_country().getRegion(), thinktank);
		data_subregions.add(thinktank.getData_country().getSubRegion(), thinktank);
		data_countries.add(thinktank.getData_country(), thinktank);
		regiemetypes.add(thinktank.getReal_city().getCountry().getRegiemetype(), thinktank);	
		Affiliation[] iTemp = thinktank.getIdeology().getAffiliations();
		for(Affiliation a: iTemp){
			affiliations.add(a, thinktank, 1/iTemp.length);
		}
		Affiliation[] aTemp = thinktank.getAffiliation().getAffiliations();
		for(Affiliation a: aTemp){
			ideologies.add(a, thinktank, 1/aTemp.length);
		}
		Affiliation[] rTemp = thinktank.getResearchArea().getAffiliations();
		for(Affiliation a: rTemp){
			researchAreas.add(a, thinktank, 1/rTemp.length);
		}
	}

	public ArrayList<ThinkTank> getThinktanks() {
		return thinktanks;
	}
	
	public World getWorld() {
		return world;
	}

	public Field<Name> getActiveStatuses() {
		return activeStatuses;
	}

	public Field<Region> getReal_regions() {
		return real_regions;
	}

	public Field<SubRegion> getReal_subregions() {
		return real_subregions;
	}

	public Field<Country> getReal_countries() {
		return real_countries;
	}

	public Field<Province> getReal_provinces() {
		return real_provinces;
	}

	public Field<City> getReal_cities() {
		return real_cities;
	}

	public Field<Region> getData_regions() {
		return data_regions;
	}

	public Field<SubRegion> getData_subregions() {
		return data_subregions;
	}

	public Field<Country> getData_countries() {
		return data_countries;
	}

	public Field<Name> getRegiemetypes() {
		return regiemetypes;
	}

	public Field<Affiliation> getAffiliations() {
		return affiliations;
	}

	public Field<Affiliation> getIdeologies() {
		return ideologies;
	}

	public Field<Affiliation> getResearchAreas() {
		return researchAreas;
	}

	
	
}
