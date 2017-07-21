package field;

public class Affiliations {
	private Affiliation[] list;
	
	public Affiliations(Affiliation[] list){
		if(list == null || list.length < 0){
			Affiliation[] temp = {new Affiliation("Nothing")};
			this.list = temp;
		}
		this.list = list;

	}

	public int size(){
		return list.length;
	}
	
	public Affiliation[] getAffiliations(){
		return list;
	}
	
	public Affiliations(String string) {
		if(string == null || string.length() < 0){
			Affiliation[] temp = {new Affiliation("Nothing")};
			this.list = temp;
			return;
		}
		
		String[] strs = string.split(" ");
		int length = strs.length;
		Affiliation[] output = new Affiliation[length];
		for(int i= 0; i < length; i++){
			output[i] = new Affiliation(strs[i]);
		}
		list = output;
	}
	
	public Affiliation get(int index){
		return list[index];
	}
	
	public String toString(){
		String output = "";
		for(Affiliation aff: list){
			output+=aff.toString()+ " ";
		}
		
		return output;
		
	}
}
