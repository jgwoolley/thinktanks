package datastructures;

import java.util.ArrayList;

import field.Affiliation;

public class Element<T>{
	private T object;
	private ArrayList<ThinkTank> thinktanks;	
	private int size;
	
	public Element(T object){
		thinktanks = new ArrayList<ThinkTank>();
		this.object = object;
		size = 1;
	}
	
	public void update(ThinkTank a, int length){			
		for(ThinkTank b: thinktanks){			
			if(a.equals(b)){
				return;
			}
		}
		thinktanks.add(a);
		size += length;
	}
	
	public ArrayList<ThinkTank> getThinkTanks(){
		return thinktanks;
	}
	
	public T getObject(){
		return object;		
	}
	
	public int size(){
		return size;
	}
}
