package datastructures;

import java.util.ArrayList;

import datastructures.Element;

public class TableData<T>{
	private ArrayList<Element<T>> list;
	
	public TableData(){
		list = new ArrayList<Element<T>>();
	}
	
	public TableData(ArrayList<Element<T>> inputs){
		list = inputs;
	}
	
	public void update(T input, ThinkTank thinktank, int length){
		int index = getElemIndex(input);
		if(index == -1){
			Element<T> e = new Element<T>(input);
			e.update(thinktank,length);
			list.add(e);
		}
		else{
			list.get(index).update(thinktank,length);
		}
	}
	
	public boolean contains(T object){
		int temp = getElemIndex(object);
		if(temp == -1){
			return false;
		}
		return true;
	}
	
	public ArrayList<T> getElements(){
		ArrayList<T> temp = new ArrayList<T>();
		for(Element<T> e: list){
			temp.add( (T) e.getObject());
		}		
		return temp;
	}
	
	public ArrayList<ThinkTank> getThinkTanks(T object){
		return getElement(object).getThinkTanks();
	}
	
	public Element<T> getElement(T object){
		int temp = getElemIndex(object);
		if(temp !=-1){			
			return list.get(temp);
		}
		else{
			return new Element<T>(object);
		}
	}
	
	public int getElemIndex(T object){
		int index = -1;
		int size = list.size();
		for(int i = 0; i < size; i++){
			if(list.get(i).getObject().equals(object)){	
				index = i;
				break;
			}
		}		
		return index;
	}
	
	public ArrayList<ThinkTank> getThinkTanks(String name){
		return getElement(name).getThinkTanks();
	}
	
	public Element<T> getElement(String str){
		int temp = getElemIndex(str);
		if(temp !=-1){			
			return list.get(temp);
		}
		else{
			return null;
		}
	}
	
	public int getElemIndex(String str){
		int index = -1;
		int size = list.size();
		for(int i = 0; i < size; i++){
			String myName = list.get(i).toString();
			String yourName = list.get(i).toString();						
			if(myName.equals(yourName)){	
				index = i;
				break;
			}
		}		
		return index;
	}
	
	public String toString(){
		String str = "";
		for(Element<T> e: list){
			str+=e.getObject().toString() + "\n";
		}
		return str;
	}
	
	public ArrayList<Element<T>> toArrayList(){
		return list;
	}

	public ArrayList<String> getElementsString() {
		ArrayList<String> output = new ArrayList<String>();
		ArrayList<T> temp = getElements();
		for(T t: temp){
			output.add(t.toString());
		}
		
		return output;
	}


	
}