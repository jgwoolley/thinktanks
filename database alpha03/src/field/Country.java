package field;

import java.util.ArrayList;

import datastructures.Trait;

public class Country extends Trait{	
	private SubRegion subregion;
	private ArrayList<Province> provinces;
	private double gdp_per_capita;
	private double literacy_rate;
	int population;
	int freedom_of_press;
	Name regiemetype;
	
	
	public Country(String name, SubRegion subregion,double gdp_per_capita, double literacy_rate, int population, int freedom_of_press,Name regiemetype){
		super(name);
		provinces = new ArrayList<Province>();
		this.subregion = subregion;
		subregion.add(this);
		this.gdp_per_capita = gdp_per_capita;
		this.literacy_rate = literacy_rate;
		this.population = population;
		this.freedom_of_press = freedom_of_press;
		this.regiemetype = regiemetype;
	}
	
	public SubRegion getSubRegion(){
		return subregion;
	}
	
	public Region getRegion(){
		return getSubRegion().getRegion();
	}
	
	public Province[] getProvinces(){
		int length = this.provinces.size();
		Province[] temp = new Province[length];
		for(int i = 0; i < length;i++){
			temp[i] = this.provinces.get(i);
		}
		return temp;
	}
	
	public void add(Province province) {
		provinces.add(province);
	}
	
	public boolean equals(Object other){
		if((this != null) && (other != null) && (other instanceof Country) 
				 && (this.toString() != null) && (other.toString() != null)){
			String a = this.toString();
			String b = other.toString();
			
			return a.equals(b);
			}
		return false;
	}

	public double getGDP_per_capita() {
		return gdp_per_capita;
	}

	public double getLiteracyRate() {
		return literacy_rate;
	}

	public int getPopulation() {
		return population;
	}

	public int getFreedomOfPress() {
		return freedom_of_press;
	}

	public Name getRegiemetype() {
		return regiemetype;
	}	
}
