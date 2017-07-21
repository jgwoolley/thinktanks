package field;

import java.util.ArrayList;

import datastructures.Trait;

public class Region extends Trait{	
	private World world;
	private ArrayList<SubRegion> subregions;
	
	public Region(String name, World world){
		super(name);
		subregions = new ArrayList<SubRegion>();
		this.world = world;
	}
	
	public World getWorld(){
		return world;
	}
	
	public SubRegion[] getSubRegions(){
		int length = this.subregions.size();
		SubRegion[] temp = new SubRegion[length];
		for(int i = 0; i < length;i++){
			temp[i] = this.subregions.get(i);
		}
		return temp;
	}
	
	public void add(SubRegion subregion) {
		subregions.add(subregion);
	}
	
	public boolean equals(Object other){
		if((this != null) && (other != null) && (other instanceof Region) 
				 && (this.toString() != null) && (other.toString() != null)){
			String a = this.toString();
			String b = other.toString();
			
			return a.equals(b);
			}
		return false;
	}
	
}
