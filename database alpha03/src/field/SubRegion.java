package field;

import java.util.ArrayList;

import datastructures.Trait;

public class SubRegion extends Trait{	
	private Region region;
	private ArrayList<Country> countries;
	
	public SubRegion(String name, Region region){
		super(name);
		countries = new ArrayList<Country>();
		this.region = region;
		region.add(this);
	}
	
	public Region getRegion(){
		return region;
	}
	
	public Country[] getCountries(){
		int length = this.countries.size();
		Country[] temp = new Country[length];
		for(int i = 0; i < length;i++){
			temp[i] = this.countries.get(i);
		}
		return temp;
	}
	
	public void add(Country country) {
		countries.add(country);
	}
	
	public boolean equals(Object other){
		if((this != null) && (other != null) && (other instanceof SubRegion) 
				 && (this.toString() != null) && (other.toString() != null)){
			String a = this.toString();
			String b = other.toString();
			
			return a.equals(b);
			}
		return false;
	}
	
}
