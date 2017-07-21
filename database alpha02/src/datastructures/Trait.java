package datastructures;

public abstract class Trait{
	private String myName;
	
	public abstract String toString();
	
	public boolean equals(Object other){
		if((this != null) && (other != null) && (other instanceof Trait) 
				 && (this.toString() != null) && (other.toString() != null)){
			String a = this.toString();
			String b = other.toString();
			
			return a.equals(b);
			}
		return false;
	}
	
	public String getName(){
		return myName;
	}
	
	public void setName(String name){
		myName = name;
	}
}
