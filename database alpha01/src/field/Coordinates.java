package field;

import datastructures.Trait;

public class Coordinates extends Trait{
	double[] coordinates;
	boolean valid;
	
	private Coordinates(){
		super("Nothing");
		coordinates = new double[6];
		for(int i = 0; i < 6;i++){
			coordinates[i] = 9000.0;
		}
		valid = false;
	}
	
	public Coordinates(int a0, int a1, double a2, char a3, int b0, int b1, double b2, char b3){
		this();
		coordinates[0] = a0;coordinates[1] = a1;coordinates[2] = a2;
		coordinates[3] = b0;coordinates[4] = b1;coordinates[5] = b2;

		char a = Character.toLowerCase(a3);
		char b = Character.toLowerCase(b3);

		if(a == 's'){
			coordinates[0] = -coordinates[0];
		}
		else if(a != 'n'){
			coordinates[0] = 9000;
		}
		
		if(b == 'w'){
			coordinates[3] = -coordinates[3];
		}
		else if(b != 'e'){
			coordinates[3] = 9000;
		}
		
		validUpdate();
	}
	
	public Coordinates(String str){
		this();
		
		if(str == null){
			return;
		}
		
		String[] strs = str.split(" ");
		int length = strs.length;
		if(length != 8){
			return;
		}		
		coordinates[0] = Integer.parseInt(strs[0]);
		coordinates[1] = Integer.parseInt(strs[1]);
		coordinates[2] = Double.parseDouble(strs[2]);
		char a = strs[3].toCharArray()[0];
		a = Character.toLowerCase(a);
		coordinates[3] = Integer.parseInt(strs[4]);
		coordinates[4] = Integer.parseInt(strs[5]);
		coordinates[5] = Double.parseDouble(strs[6]);
		char b = strs[7].toCharArray()[0];
		b = Character.toLowerCase(b);

		if(a == 's'){
			coordinates[0] = -coordinates[0];
		}
		else if(a != 'n'){
			coordinates[0] = 9000;
		}
		
		if(b == 'w'){
			coordinates[3] = -coordinates[3];
		}
		else if(b != 'e'){
			coordinates[3] = 9000;
		}
		
		validUpdate();
	}
	
	public double compareTo(Coordinates other) {
		if(!this.valid | !other.valid){
			return -1;
		}
		
		double[] thisLongLat = this.convertLongLat();
		double[] otherLongLat = other.convertLongLat();
		
		double temp = (180 - Math.abs(thisLongLat[0] - otherLongLat[0]))/180;
		double temp2 = (180 - Math.abs(thisLongLat[1] - otherLongLat[1]))/180;
		
		if(temp == 0 | temp2 == 0){
			return 0.003;
		}
		return Math.abs(temp*temp2);
	}
	
	private void validUpdate(){
		for(int i = 0; i < 6; i++){
			int temp = 60;
			if(i == 0 | i == 3){
				temp = 360;
			}			
			else if(temp <= Math.abs(coordinates[i])){
				valid = false;
				return;
			}
		}
		valid = true;
		setName(toString());
	}
		
	public String toString(){
		if(!this.valid){
			return "None";
		}
		return coordinates[0] + " " + coordinates[1] + " " + coordinates[2] + " " + coordinates[3]
				+ " " + coordinates[4] + " " + coordinates[5];
	}
	
	private double[] convertLongLat(){
		double[] output = new double[2];
		boolean[] positive = new boolean[2];
		for(int i = 0; i < 2; i++){
			if(1 == Math.abs(coordinates[i+3])/coordinates[i+3]){
				positive[i] = true;
			}
			if(-1 == Math.abs(coordinates[i+3])/coordinates[i+3]){
				positive[i] = false;
			}			
			output[i] = coordinates[i] + coordinates[i+1]/60 + coordinates[i+2]/60;
			if(!positive[i]){
				output[i] = -output[i];
			}
		}
		return output;
	}
}
