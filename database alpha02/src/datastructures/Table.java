package datastructures;

import java.util.ArrayList;

import field.Affiliation;
import field.Affiliations;
import field.City;
import field.Coordinates;
import field.Country;
import field.Province;
import field.Region;
import field.StreetAddress;
import field.SubRegion;

public class Table{
	private ArrayList<ThinkTank> thinktanks;
	private Field<Region> region;
	private Field<SubRegion> subregion;
	private Field<Country> country;
	private Field<Affiliation> affiliation;
	private Field<Affiliation> ideology;
	private Field<Country> realCountry;
	private Field<City> city;
	private Field<Province> province;
	private Field<Coordinates> coordinates;
	private ArrayList<String> failedStrings;
	
	public Table(){
		thinktanks = new ArrayList<ThinkTank>();
		region = new Field<Region>();
		subregion = new Field<SubRegion>();
		country = new Field<Country>();
		affiliation = new Field<Affiliation>();
		ideology = new Field<Affiliation>();
		realCountry = new Field<Country>();
		city = new Field<City>();
		province = new Field<Province>();
		coordinates = new Field<Coordinates>();
		failedStrings = new ArrayList<String>();
	}
	
	public int size(){
		return thinktanks.size();
	}
	
	public ThinkTank get(int index){
		return thinktanks.get(index);
	}
	
	public String FieldtoString(){
		String str = "";
		
		str += "region\n" + region.toString();
		str += "subregion\n" +subregion.toString();
		str += "country\n" +country.toString();
		str += "affiliations\n" + affiliation.toString();
		str += "ideologies\n" + ideology.toString();
		str += "realCountry\n" +realCountry.toString();
		str += "city\n" +city.toString();
		str += "province\n" +province.toString();
		str += "coordinates\n" +coordinates.toString();
		
		return str;
	}
	
	public String toString(){
		String str = "ThinkTanks" + thinktanks.size() + "\n";
		
		for(ThinkTank tank: thinktanks){
			str+= tank.toString() + "\n";
		}
		str+= "Failed" + failedStrings.size() + "\n";
		for(String str2: failedStrings){
			str+= str2+ "\n";
		}
		return str;
	}
	
	public String[] getFailedStrings(){
		int size = failedStrings.size();
		String[] output = new String[size];
		for(int i = 0; i < size; i++){
			output[i] = failedStrings.get(i);
		}
		
		return output;
	}
	
	public void update(String input){
		String[] strings = input.split(",");
		boolean isValid = update(strings);
		if(!isValid){
			failedStrings.add(input);
		}
	}
	
	private boolean update(String[] input){
		boolean isValid = false;
		String[] temp = new String[12];
		int max = 12;
		
		
		if(input.length < max){
			max = input.length;
		}
		
		for(int i = 0; i < max;i++){
			temp[i] = input[i];
		}
		input = temp;
				
		if(input[0].equals("TRUE")){
			Region region = new Region(input[1]);
			SubRegion subregion = new SubRegion(input[2]);
			Country country = new Country(input[3]);						
			String name = input[4];
			Affiliations affiliations = new Affiliations(input[5]);
			Affiliations ideologies = new Affiliations(input[6]);
			Country realCountry = new Country(input[7]);
			City city = new City(input[8]);
			Province province = new Province(input[9]);;
			Coordinates coordinates = new Coordinates(input[10]);
			StreetAddress address = new StreetAddress(input[11]);
			
			ThinkTank thinktank = new ThinkTank(region,subregion,country,name,affiliations
					,ideologies,realCountry,city, province, coordinates, address);
			if(thinktank.isValid()){
				isValid = true;
				add(thinktank);				
			}				
		}
		return isValid;

	}	
	
	public void addAll(ArrayList<ThinkTank> thinktanks){
		for(ThinkTank t: thinktanks){
			add(t);
		}
	}
	
	public void add(ThinkTank thinktank){
		thinktanks.add(thinktank);
		region.add(thinktank.getRegion(), thinktank);
		subregion.add(thinktank.getSubregion(), thinktank);
		country.add(thinktank.getCountry(), thinktank);		
		Affiliation[] tempAff = thinktank.getAffiliations().getAffiliations();
		for(Affiliation a: tempAff){
			affiliation.add(a, thinktank, 1/tempAff.length);
		}		
		Affiliation[] tempIde = thinktank.getAffiliations().getAffiliations();
		for(Affiliation a: tempIde){
			ideology.add(a, thinktank,1/tempAff.length);
		}		
		realCountry.add(thinktank.getRealCountry(), thinktank);
		city.add(thinktank.getCity(), thinktank);
		province.add(thinktank.getProvince(), thinktank);
		coordinates.add(thinktank.getCoordinates(), thinktank);
	}

	public ArrayList<ThinkTank> getThinktanks() {
		return thinktanks;
	}

	public Field<Region> getRegion() {
		return region;
	}

	public Field<SubRegion> getSubregion() {
		return subregion;
	}

	public Field<Country> getCountry() {
		return country;
	}

	public Field<Affiliation> getAffiliations() {
		return affiliation;
	}

	public Field<Affiliation> getIdeologies() {
		return ideology;
	}

	public Field<Country> getRealCountry() {
		return realCountry;
	}

	public Field<City> getCity() {
		return city;
	}

	public Field<Province> getProvince() {
		return province;
	}

	public Field<Coordinates> getCoordinates() {
		return coordinates;
	}
}
