package field;

import java.util.ArrayList;

public class World {
	private ArrayList<Region> regions;
	private ArrayList<SubRegion> subregions;
	private ArrayList<Country> countries;
	private ArrayList<Province> provinces;
	private ArrayList<City> cities;
	private ArrayList<Name> regiemetype;
	
	public World(){
		regions = new ArrayList<Region>();
		subregions = new ArrayList<SubRegion>();
		countries = new ArrayList<Country>();
		provinces = new ArrayList<Province>();
		cities = new ArrayList<City>();
	}
	
	 String[] CountriesToString(){
		int length = countries.size();
		String[] list = new String[length];
		for(int i = 0; i < length; i++){
			Country country = countries.get(i);
			String str = country.getRegion().toString() + ",";
			str += country.getSubRegion().toString() + ",";
			str += country.toString() + ",";
			Province[] provinces = country.getProvinces();
			for(Province province: provinces){
				str+= province.toString() + ";";
			}
			if(i != length - 1){
				str+=";";
			}
			
			str+= "," + country.getGDP_per_capita() + ",";
			str+= country.getLiteracyRate() + ",";
			str+= country.getPopulation() + ",";
			str+= country.getFreedomOfPress() + ",";
			str+= country.getRegiemetype().toString() + ",";			
			
			list[i] = str;
		}
		return list;
	}
	
	public void updateCountry(String input){
		String[] strings = input.split(",");
		int max = 9;
		String[] temp = new String[max];		
		for(int i = 0; i < max;i++){
			temp[i] = strings[i];
		}
		strings = temp;
		
		String region_n = strings[0];
		String subregion_n = strings[1];
		String country_n = strings[2];
		String[] provinces_n = strings[3].split(";");
		int provinces_length = provinces_n.length;
		double gdp_per_capita = Double.parseDouble(strings[4]);
		double literacy_rate = Double.parseDouble(strings[5]);
		int population = Integer.parseInt(strings[6]);
		int freedom_of_press = Integer.parseInt(strings[7]);
		String regiemetype_n = strings[8];
		Name regiemetype = new Name(regiemetype_n);
		Region region = new Region(region_n,this);
		SubRegion subregion = new SubRegion(subregion_n,region);
		Country country = new Country(country_n,subregion,gdp_per_capita,literacy_rate
				,population,freedom_of_press,regiemetype);
		Province[] provinces = new Province[provinces_length];
		for(int i = 0; i < provinces_length; i++){
			provinces[i] = new Province(provinces_n[i],country);
			this.provinces.add(provinces[i]);
		}
		
		regions.add(region);
		subregions.add(subregion);
		countries.add(country);
		this.regiemetype.add(regiemetype);
	}

	
	
	public void updateProvince(String input){
		String[] strings = input.split(",");
		int max = 2;
		String[] temp = new String[max];		
		for(int i = 0; i < max;i++){
			temp[i] = strings[i];
		}
		strings = temp;
		
		String province_n = strings[0];
		String[] cities = strings[1].split(";");		
		
		Province province = findProvince(province_n);
		for(String str: cities){
			province.add(new City(str,province));
		}
	}
	
	public void add(Region region) {
		regions.add(region);
		
	}

	public ArrayList<Region> getRegions() {
		return regions;
	}

	public Region findRegion(String region_n){
		Region region = null;
		for(Region region_t: regions){
			String region_t_n = region_t.toString();
			if(region_t_n.equals(region_n)){
				region = region_t;
				break;
			}
		}
		return region;
	}
	
	public ArrayList<SubRegion> getSubregions() {
		return subregions;
	}

	public SubRegion findSubRegion(String subregion_n){
		SubRegion subregion = null;
		for(SubRegion subregion_t: subregions){
			String subregion_t_n = subregion_t.toString();
			if(subregion_t_n.equals(subregion_n)){
				subregion = subregion_t;
				break;
			}
		}
		return subregion;
	}
	
	public ArrayList<Country> getCountries() {
		return countries;
	}

	public Country findCountry(String country_n){
		Country country = null;
		for(Country country_t: countries){
			String province_t_n = country_t.toString();
			if(province_t_n.equals(province_t_n)){
				country = country_t;
				break;
			}
		}
		return country;
	}
	
	public ArrayList<Province> getProvinces() {
		return provinces;
	}

	public Province findProvince(String province_n){
		Province province = null;
		for(Province province_t: provinces){
			String province_t_n = province_t.toString();
			if(province_t_n.equals(province_n)){
				province = province_t;
				break;
			}
		}
		return province;
	}
	
	public ArrayList<City> getCities() {
		return cities;
	}

	public City findCity(String city_n){
		City city = null;
		for(City city_t: cities){
			String city_t_n = city_t.toString();
			if(city_t_n.equals(city_n)){
				city = city_t;
				break;
			}
		}
		return city;
	}
	
	public ArrayList<Name> getRegiemeType() {
		return regiemetype;
	}
	
	public Name findRegiemeType(String province_n){
		Name regiemetype = null;
		for(Name regiemetype_t: this.regiemetype){
			String regiemetype_t_n = regiemetype_t.toString();
			if(regiemetype_t_n.equals(province_n)){
				regiemetype = regiemetype_t;
				break;
			}
		}
		return regiemetype;
	}
}
