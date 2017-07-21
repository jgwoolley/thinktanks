package datastructures;

import field.Affiliations;
import field.City;
import field.Coordinates;
import field.Country;
import field.Name;
import field.Province;
import field.Region;
import field.StreetAddress;
import field.SubRegion;

public class ThinkTank{
	private Region region;
	private SubRegion subregion;
	private Country country;
	private Name name;
	private Affiliations affiliations;
	private Affiliations ideologies;
	private Country realCountry;
	private City city;
	private Province province;
	private Coordinates coordinates;
	private StreetAddress address;
	
	public ThinkTank(Region region, SubRegion subregion,Country country, String name, Affiliations affiliations, Affiliations ideologies, Country realCountry, City city, Province province, Coordinates coordinates, StreetAddress address){
		
		this.region=region;
		this.subregion=subregion;
		this.country=country;
		this.name= new Name(name);
		this.affiliations=affiliations;
		this.ideologies=ideologies;
		this.realCountry=realCountry;
		this.city=city;
		this.province=province;
		this.coordinates=coordinates;
		this.address=address;

	}
	
	public String toString(){
		return "TRUE"				
				+ "," + region.toString() 
				+ "," + subregion.toString() 
				+ "," + country.toString() 
				+ "," + name.toString()
				+ "," + affiliations.toString() 
				+ "," + ideologies.toString() 
				+ "," + realCountry.toString()
				+ "," + city.toString() 
				+ "," + province.toString() 
				+ "," + coordinates.toString() 
				+ "," + address.toString();
	}

	public boolean isValid(){
		return true;
	}
	
	public Region getRegion() {
		return region;
	}

	public SubRegion getSubregion() {
		return subregion;
	}

	public Country getCountry() {
		return country;
	}

	public Name getName(){
		return name;
	}

	public Affiliations getAffiliations() {
		return affiliations;
	}

	public Affiliations getIdeologies() {
		return ideologies;
	}

	public Country getRealCountry() {
		return realCountry;
	}

	public City getCity() {
		return city;
	}

	public Province getProvince() {
		return province;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public StreetAddress getAddress() {
		return address;
	}

}
