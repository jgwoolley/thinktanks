package datastructures;

import field.Affiliations;
import field.City;
import field.Coordinates;
import field.Country;
import field.Name;
import field.StreetAddress;

public class ThinkTank{
	private Name activeStatus;	
	private City real_city;
	private Country data_country;
	private Name name;
	private Affiliations affiliation;
	private Affiliations ideology;
	private Affiliations researchArea;
	private Coordinates coordinates;
	private StreetAddress address;
	private int datefounded;
	
	public ThinkTank(Name arg0, City arg1, Country arg2, Name arg3, Affiliations arg4, Affiliations arg5, Affiliations arg6, Coordinates arg7, StreetAddress arg8, int arg9){
		activeStatus = arg0;	
		real_city = arg1;
		data_country = arg2;
		name = arg3;
		affiliation = arg4;
		ideology = arg5;
		researchArea = arg6;
		coordinates = arg7;
		address = arg8;
		datefounded = arg9;

	}
	
	public String toString(){
		return activeStatus				
				+ "," + real_city.toString() 
				+ "," + data_country.toString()
				+ "," + name.toString() 
				+ "," + affiliation.toString() 
				+ "," + ideology.toString()
				+ "," + researchArea.toString() 
				+ "," + coordinates.toString() 
				+ "," + address.toString();
	}

	public Name getActiveStatus() {
		return activeStatus;
	}

	public City getReal_city() {
		return real_city;
	}

	public Country getData_country() {
		return data_country;
	}

	public Affiliations getAffiliation() {
		return affiliation;
	}

	public Affiliations getIdeology() {
		return ideology;
	}

	public Affiliations getResearchArea() {
		return researchArea;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public StreetAddress getAddress() {
		return address;
	}
	
	public Name getName(){
		return name;
	}
	
	public int getDatefounded() {
		return datefounded;
	}

	public boolean isValid() {
		return true;
	}

}
