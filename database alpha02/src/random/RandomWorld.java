package random;

import java.util.ArrayList;
import java.util.Random;

import field.City;
import field.Coordinates;
import field.Country;
import field.Province;
import field.Region;
import field.StreetAddress;
import field.SubRegion;

public class RandomWorld {
	private static final String[] randomNames = {"zaspoassau","gescialand","rochein","osnyae","steitho","stiuca",
			"osken","eshistan","spoy strela","swoe stror","Highkeep","Griffinton","Westerwynne","xusheurhiel",
			"muchaecia","boclain","ewhurg","stoydan","treiria","oskait","echya","sceuw chax","bleuv smana","odriasia","uthiulor","koflurg","xapra","craiya",
			"glaynia","astrurg","athon","stroum chus","pruil shium","gopruyvania","iofliuland","pacren","qotria","snoera","blaonia",
			"atron","othurg","swaeq sneau","staoz flurg","edriawana","iupreosal","jotra","vedrijan","craorhiel","friysil","ostryae","atren",
			"greom clax","blob skos","apreyles","guswouca","osmurg","iethana","fleisau","priestein","eshington","ogrya","fleis flye","claog fleau"
	};
	private static final int num = 100;
	
	private ArrayList<RegionData> regions;
	private Random rand;
	
	public RandomWorld(){
		regions = new ArrayList<RegionData>();
		rand = new Random();
		
		int temp = 1 + rand.nextInt(4);
		for(int i = 0; i < temp;i++){
			regions.add(new RegionData());
		}
	}
	
	public RegionData getRandomRegionData(){
		int size = regions.size();
		return regions.get(rand.nextInt(size));
	}
	
	public class RegionData{
		private Region myRegion;
		private ArrayList<SubRegionData> subregions;
		
		public RegionData(){
			myRegion = new Region(getName());
			subregions = new ArrayList<SubRegionData>();
			int temp = 1 + rand.nextInt(num)/8;
			for(int i = 0; i < temp;i++){
				subregions.add(new SubRegionData());
			}
		}
		
		public Region getRegion(){
			return myRegion;
		}
		
		public SubRegionData getRandomSubRegionData(){
			int size = subregions.size();
			return subregions.get(rand.nextInt(size));
		}
	}
	
	public class SubRegionData{
		private SubRegion mySubRegion;
		private ArrayList<CountryData> countries;
		
		public SubRegionData(){
			mySubRegion = new SubRegion(getName());
			countries = new ArrayList<CountryData>();
			int temp = 1 + rand.nextInt(num)/8;
			for(int i = 0; i < temp;i++){
				countries.add(new CountryData());
			}
		}
		
		public SubRegion getSubRegion(){
			return mySubRegion;
		}
		
		public CountryData getRandomCountryData(){
			int size = countries.size();
			return countries.get(rand.nextInt(size));
		}
	}
	
	public class CountryData{
		private Country myCountry;
		private ArrayList<ProvinceData> provinces;
		
		public CountryData(){
			myCountry = new Country(getName());
			provinces = new ArrayList<ProvinceData>();
			int temp = 1 + rand.nextInt(num)/8;
			for(int i = 0; i < temp;i++){
				provinces.add(new ProvinceData());
			}
		}
		
		public Country getCountry(){
			return myCountry;
		}
		
		public ProvinceData getRandomProvinceData(){
			int size = provinces.size();
			return provinces.get(rand.nextInt(size));
		}
	}
	
	public class ProvinceData{
		private Province myProvince;
		private ArrayList<CityData> cities;
		
		public ProvinceData(){
			myProvince = new Province(getName());
			cities = new ArrayList<CityData>();
			int temp = 1 + rand.nextInt(num)/8;
			for(int i = 0; i < temp;i++){
				cities.add(new CityData());
			}
		}
		
		public Province getProvince(){
			return myProvince;
		}
		
		public CityData getRandomCityData(){
			int size = cities.size();
			return cities.get(rand.nextInt(size));
		}
	}
	
	public class CityData{
		private City myCity;
		private ArrayList<LocationData> locations;
		
		public CityData(){
			myCity = new City(getName());
			locations = new ArrayList<LocationData>();
			int temp = 1 + rand.nextInt(num)/8;
			for(int i = 0; i < temp;i++){
				locations.add(new LocationData());
			}
		}
		
		public City getCity(){
			return myCity;
		}
		
		public LocationData getRandomLocationData(){
			int size = locations.size();
			return locations.get(rand.nextInt(size));
		}		

	}
	
	public class LocationData{
		Coordinates coords;
		StreetAddress address;
		
		public LocationData(){
			coords = getRandomCoordinates();
			address = getRandomStreetAddress();
		}
		
		public Coordinates getCoordinates(){
			return coords;
		}
		public StreetAddress getStreetAddress(){
			return address;
		}
	}
	
	public Coordinates getRandomCoordinates(){
		int a = rand.nextInt(360);
		int b = rand.nextInt(60);
		double c = rand.nextInt(59) + rand.nextDouble();
		int d = rand.nextInt(360);
		int e = rand.nextInt(60);
		double f = rand.nextInt(59) + rand.nextDouble();
		
		return new Coordinates(a,b,c,'n',d,e,f,'w');
	}
	
	public StreetAddress getRandomStreetAddress(){
		String name = "";
		
		name+= rand.nextInt(360);
		int b = rand.nextInt(4);
		if(b == 1){
			name+= " N ";
		}
		if(b == 2){
			name+= " S ";
		}
		if(b == 3){
			name+= " E ";
		}
		if(b == 4){
			name+= " W ";
		}
		
		name+=getName();
		
		b = rand.nextInt(4);
		if(b == 1){
			name+= " Street";
		}
		if(b == 2){
			name+= " Lane";
		}
		if(b == 3){
			name+= " Road";
		}
		if(b == 4){
			name+= " AlleyWay";
		}
		
		return new StreetAddress(name);
	}
	
	public String getName(){
		String name = "";
		int b = rand.nextInt(50);
		if(b == 1){
			name+= "North ";
		}
		if(b == 2){
			name+= "South ";
		}
		if(b == 3){
			name+= "East ";
		}
		if(b == 4){
			name+= "West ";
		}
		
		name+=randomNames[rand.nextInt(randomNames.length)];
		
		return name;
	}
}
