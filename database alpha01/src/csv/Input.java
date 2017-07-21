package csv;

import java.io.File;
import java.util.Scanner;

import datastructures.Table;
import datastructures.ThinkTank;

public class Input {
	private Table table;
	private boolean success;
	
	public Input(File file){
		table = new Table();
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

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
}
