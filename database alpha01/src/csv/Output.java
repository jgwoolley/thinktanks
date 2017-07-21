package csv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import datastructures.Table;
import datastructures.ThinkTank;

public class Output {
	private String fileName;
	private Table table;
	private boolean success;
	
	public Output(File file, Table table){
		this.table = table;
		success = false;
		
		try{
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(fileWriter);
			
			int size = table.size();
			for(int i = 0; i < size;i++){
				writer.append(table.get(i).toString());
				writer.newLine();
			}
			
			size = table.getFailedStrings().length;
			for(String str: table.getFailedStrings()){
				writer.append(str);
				writer.newLine();
			}			
			
			writer.close();
			success = true;
		} catch(Exception e){
			System.out.println("Error in Table Writer");
		}
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
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
