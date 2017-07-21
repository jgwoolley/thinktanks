package field;

import datastructures.Trait;

public class Valid extends Trait{
	boolean isValid;
	
	public Valid(boolean val){
		isValid = val;
	}
	
	@Override
	public String toString() {
		return "" + isValid;
	}

}
