package roadmapforlab;

import java.util.ArrayList;
import java.util.List;

public class CityNode implements Comparable <CityNode>{
	private String cityName;
	private List<CityNode> neighbors = new ArrayList<CityNode>();
	
	public CityNode(String cityName) {
		this.cityName = cityName;		
	}
	
	public String getCityName() {return cityName;}
	
	// return the list of neighbor nodes
	public List<CityNode> getNeighborNodes() {return neighbors;}
	
	//return the city names of the neighbor nodes
	public List<String> getNeighborNames() {
		List<String> names = new ArrayList<String>();
		for(CityNode n: neighbors) names.add(n.getCityName());
		return names;
	}
		
	// add a new neighbor node to the list
	public void addNeighbor(CityNode other) {neighbors.add(other);}

	@Override
	public int compareTo(CityNode o) {
		return cityName.compareTo(o.cityName);// TODO Auto-generated method stub
		
	}
	
}