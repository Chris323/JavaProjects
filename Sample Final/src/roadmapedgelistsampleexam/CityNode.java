package roadmapedgelistsampleexam;

//do not change any code in this class

public class CityNode implements Comparable <CityNode>{
	private String cityName;
	
	public CityNode(String cityName) {
		this.cityName = cityName;		
	}
	
	public String getCityName() {return cityName;}
	
	
	@Override
	public int compareTo(CityNode o) {
		return cityName.compareTo(o.cityName);		
	}
	
}
