package field;

import java.util.ArrayList;

import datastructures.Trait;

public class Province extends Trait{	
	private Country country;
	private ArrayList<City> cities;
	
	public Province(String name, Country country){
		super(name);
		cities = new ArrayList<City>();
		this.country = country;
		country.add(this);
	}
	
	public Country getCountry(){
		return country;
	}
	
	public SubRegion getSubRegion(){
		return getCountry().getSubRegion();
	}
	
	public Region getRegion(){
		return getCountry().getSubRegion().getRegion();
	}
	
	public City[] getCities(){
		int length = this.cities.size();
		City[] temp = new City[length];
		for(int i = 0; i < length;i++){
			temp[i] = this.cities.get(i);
		}
		return temp;
	}
	
	public boolean equals(Object other){
		if((this != null) && (other != null) && (other instanceof Province) 
				 && (this.toString() != null) && (other.toString() != null)){
			String a = this.toString();
			String b = other.toString();
			
			return a.equals(b);
			}
		return false;
	}

	public void add(City city) {
		cities.add(city);		
	}
	
}
