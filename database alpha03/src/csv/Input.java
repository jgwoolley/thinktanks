package csv;

import java.io.File;
import java.util.Scanner;

import datastructures.Table;
import datastructures.ThinkTank;

public class Input {
	private Table table;
	private boolean success;
	
	public Input(File thinktanks,File provinces, File countries){
		
		
		String[] strings
		success = false;
		
		try{
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()){
				table.update(scanner.nextLine());
			}
			scanner.close();
			success = true;
		} catch(Exception e){
			
		}
	}
	
	public 
	
}
