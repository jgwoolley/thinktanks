package field;

import datastructures.Trait;

public class City extends Trait{
	private Province province;
	
	public City(String name, Province province){
		super(name);
		this.province = province;
		province.add(this);
	}
	
	public Province getProvince(){
		return province;
	}
	
	public Country getCountry(){
		return province.getCountry();
	}
	
	public SubRegion getSubRegion(){
		return getCountry().getSubRegion();
	}
	
	public Region getRegion(){
		return getCountry().getSubRegion().getRegion();
	}
	
	public boolean equals(Object other){
		if((this != null) && (other != null) && (other instanceof City) 
				 && (this.toString() != null) && (other.toString() != null)){
			String a = this.toString();
			String b = other.toString();
			
			return a.equals(b);
			}
		return false;
	}
	
}
