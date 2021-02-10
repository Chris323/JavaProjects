package roadmapedgelistforactualexamMW;

public class CityNode implements Comparable <CityNode>{
	
	private String cityName;
	
	public CityNode(String cityName) {
		this.cityName = cityName;		
	}
	
	public String getCityName() {return cityName;}
	
	
	@Override
	public int compareTo(CityNode o) {
		return cityName.compareTo(o.cityName);// TODO Auto-generated method stub
		
	}
	
}
