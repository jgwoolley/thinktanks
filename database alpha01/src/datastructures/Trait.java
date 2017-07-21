package datastructures;

public abstract class Trait{
	private String name;
	
	public Trait(String name){
		if(name == null || name.length() <= 0){
			this.name = "Nothing";
		}		
		this.name = name;
	}
	
	public String toString(){
		return name;
		
	}
	
	public boolean equals(Object other){
		if((this != null) && (other != null) && (other instanceof Trait) 
				 && (this.toString() != null) && (other.toString() != null)){
			String a = this.toString();
			String b = other.toString();
			
			return a.equals(b);
			}
		return false;
	}
	
	public void setName(String name){
		this.name = name;
	}
}
