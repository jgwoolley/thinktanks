package field;

import datastructures.Trait;

public class Name extends Trait{	
	public Name(String name){
		super(name);
	}
	
	public boolean equals(Object other){
		if((this != null) && (other != null) && (other instanceof Name) 
				 && (this.toString() != null) && (other.toString() != null)){
			String a = this.toString();
			String b = other.toString();
			
			return a.equals(b);
			}
		return false;
	}
	
}
