package roadmapedgelistsampleexam;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class RoadMap {

	private Set<CityNode> nodes = new HashSet<CityNode>();
	private List<Edge> edges = new LinkedList<Edge>();

	public int getNumNodes() {
		return nodes.size();
	}

	public int getNumEdges() {
		return edges.size();
	}
	
	// create a new node
	public void addCity(String name) {
		CityNode newCity = new CityNode(name);
		nodes.add(newCity);
	}

	// connect two nodes
	public void buildRoad(String first, String second) {
		CityNode one = new CityNode(first);
		CityNode two = new CityNode(second);
		Edge connect = new Edge(one, two);
		edges.add(connect);
		
	}

	// return the list of neighbor nodes
	public List<CityNode> getNeighborNodes(CityNode c) {
		List<CityNode> neighbors = new ArrayList<CityNode>();
		
	}

	// return a list of the city names of the neighbor nodes
	// leave this code as it is
	public List<String> getNeighborNames(CityNode c) {
		List<CityNode> neighbors = getNeighborNodes(c);
		List<String> names = new ArrayList<String>();
		for (CityNode n : neighbors)
			names.add(n.getCityName());
		return names;
	}

	// look up a node by city name and return a reference to the node
	public CityNode findCityNodeByName(String cityName) {
		for(CityNode i: nodes) {
			if(cityName.equals(i.getCityName())) {

	}
	
}

