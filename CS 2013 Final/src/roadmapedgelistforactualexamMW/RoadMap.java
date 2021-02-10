package roadmapedgelistforactualexamMW;

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
		nodes.add(new CityNode(name));
	}

	// connect two nodes
	public void buildRoad(String first, String second) {
		CityNode firstNode = null;
		CityNode secondNode = null;
		for (CityNode c : nodes) {
			if (c.getCityName().equals(first))
				firstNode = c;
			if (c.getCityName().equals(second))
				secondNode = c;
		}

		if (firstNode != null && secondNode != null) {
			edges.add(new Edge(firstNode, secondNode));
		}

	}

	// return the list of neighbor nodes
	public List<CityNode> getNeighborNodes(CityNode c) {
		List<CityNode> neighbors = new ArrayList<CityNode>();
		for (Edge e : edges) {
			CityNode[] endpoints = e.getVertices();

			if (endpoints[0] == c)
				neighbors.add(endpoints[1]);
			if (endpoints[1] == c)
				neighbors.add(endpoints[0]);
		}
		return neighbors;
	}

	// return a list of the city names of the neighbor nodes
	public List<String> getNeighborNames(CityNode c) {
		List<CityNode> neighbors = getNeighborNodes(c);
		List<String> names = new ArrayList<String>();
		for (CityNode n : neighbors)
			names.add(n.getCityName());
		return names;
	}

	// look up a node by city name and return a reference to the node
	public CityNode findCityNodeByName(String cityName) {
		for (CityNode c : nodes)
			if (c.getCityName().equals(cityName))
				return c;
		return null;
	}

	public List<CityNode> getSortedListOfNodes() {
		CityNodeMergeSorter s = new CityNodeMergeSorter();
		return s.getSortedList(nodes);
	}
	
	public List<String> getBFTraversal(String start) {
		RoadMapBFTraversal t = new RoadMapBFTraversal(this);
		return t.getTraversal(start);
	}

}

