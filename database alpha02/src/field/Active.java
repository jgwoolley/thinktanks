package field;

import datastructures.Trait;

public class Active extends Trait{
	boolean isActive;
	
	public Active(String str){
		str = str.toLowerCase();
		if(str.equals("true") | str.equals("yes")){
			isActive = true;
		}
		else if(str.equals("false") | str.equals("no")){
			isActive = false;
		}
	}
	
	@Override
	public String toString() {
		return "" + isActive;
	}

}
