package random;

import field.Affiliation;
import field.Affiliations;
import field.City;
import field.Coordinates;
import field.Country;
import field.Name;
import field.Province;
import field.Region;
import field.StreetAddress;
import field.SubRegion;
import random.RandomWorld.CityData;
import random.RandomWorld.CountryData;
import random.RandomWorld.LocationData;
import random.RandomWorld.ProvinceData;
import random.RandomWorld.RegionData;
import random.RandomWorld.SubRegionData;

import java.util.Random;

import datastructures.Table;
import datastructures.ThinkTank;

public class RandomTable extends Table{
	private Random rand;
	private static final Affiliation[] randAffiliations = {new Affiliation("Independent"),new Affiliation("Government")
			,new Affiliation("Corporate"),new Affiliation("Religious")};
	private static final Affiliation[] randIdeologies = {new Affiliation("Liberal"),new Affiliation("Conservative")
			,new Affiliation("Nationalist"),new Affiliation("Radical Left"),new Affiliation("Radical Right"),new Affiliation("Neutral")};
	private static final Affiliation[] randIdeologies2 = {new Affiliation("Humanitarian"), new Affiliation("Foreign Policy"),
			new Affiliation("Social Science"), new Affiliation("Hard Science")};
	private static final String[] names = {"Jason","Carol","Ebzen","Darol","Mera","Dorris","Borris","Rose","Paul","Terry","James","Woolley"
			,"Sophie","Anna","Gene","Elizabeth","Hannah","Lee","Betsy","Jameson","Robert","Gale","Rock"};
	private static final String[] names2 = {"Think Tank","Research Institute","Watch","Institute","Council"};
	
	private RandomWorld world;
	
	public RandomTable(){
		super();
		rand = new Random();
		world = new RandomWorld();
		int max = rand.nextInt(2000) + 5;
		
		for(int i = 0; i < max; i++){
			add(getRandomThinkTank());
		}		
	}
	
	public ThinkTank getRandomThinkTank(){
		RegionData data0 = world.getRandomRegionData();
		SubRegionData data1 = data0.getRandomSubRegionData();
		CountryData data2 = data1.getRandomCountryData();
		ProvinceData data3 = data2.getRandomProvinceData();
		CityData data4 = data3.getRandomCityData();
		LocationData data5 = data4.getRandomLocationData();
		
		
		Region region= data0.getRegion();
		SubRegion subregion= data1.getSubRegion();
		Country country=data2.getCountry();
		Affiliations affiliations=getRandomAffiliation();
		Affiliations ideologies=getRandomIdeologies();
		Country realCountry=data2.getCountry();
		City city=data4.getCity();
		Province province=data3.getProvince();
		Coordinates coordinates= data5.getCoordinates();
		StreetAddress address= data5.getStreetAddress();
		
		Name name= new Name(names[rand.nextInt(names.length)] + " " + ideologies.get(rand.nextInt(ideologies.size())) + " " + names2[rand.nextInt(names2.length)]);
		
		return new ThinkTank(region,subregion,country,name.toString(), affiliations,ideologies,realCountry,city,province,coordinates,address);
	}
	
	public Affiliations getRandomIdeologies(){
		Affiliation[] temp2 = new Affiliation[2];
		temp2[0] = getIdeology();
		temp2[1] = getIdeology2();
		return new Affiliations(temp2);
	}
	
	public Affiliation getIdeology2(){
		return randIdeologies2[rand.nextInt(randIdeologies2.length - 1) + 1];
	}
	
	public Affiliation getIdeology(){
		return randIdeologies[rand.nextInt(randIdeologies.length - 1) + 1];
	}
	
	public Affiliation getAffiliation(){
		return randAffiliations[rand.nextInt(randAffiliations.length - 1) + 1];
	}
	
	public Affiliations getRandomAffiliation(){
		int temp = rand.nextInt(4);
		Affiliation[] temp2;
		if(temp==0){
			temp2 = new Affiliation[1];
			temp2[0] = randAffiliations[0];
		}
		else if(temp==1){
			temp2 = new Affiliation[1];
			temp2[0] = getAffiliation();
		}
		else if(temp==2){
			temp2 = new Affiliation[2];
			temp2[0] = getAffiliation();
			temp2[1] = getAffiliation();
		}
		else{
			temp2 = new Affiliation[3];
			temp2[0] = getAffiliation();
			temp2[1] = getAffiliation();
			temp2[2] = getAffiliation();

		}
		return new Affiliations(temp2);
	}
}
