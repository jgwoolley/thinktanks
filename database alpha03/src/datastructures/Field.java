package datastructures;

import java.util.ArrayList;

import field.Affiliation;

public class Field<T> {
	protected TableData<T> database;
	
	public Field(){
		database = new TableData<T>();
	}
	
	public void add(T input, ThinkTank thinktank){
		add(input, thinktank,1);
	}	
	
	public void add(T input, ThinkTank thinktank, int length) {
		database.update(input,thinktank,length);
		
	}
	
	public String toString(){
		return database.toString();
	}
	
	public ArrayList<ThinkTank> getThinkTanks(T object){
		return database.getThinkTanks(object);
	}
	
	public ArrayList<T> getElements(){
		return database.getElements();
	}
	
	public ArrayList<String> getElementsString(){
		return database.getElementsString();
	}

	public ArrayList<Element<T>> toArrayList(){
		return database.toArrayList();
	}
	
	//only works with Traits
	public Element<T> getElement(String str){
		return database.getElement(str);
	}
}
