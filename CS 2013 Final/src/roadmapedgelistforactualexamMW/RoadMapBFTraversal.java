package roadmapedgelistforactualexamMW;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class RoadMapBFTraversal {
	private RoadMap c;
	private List<CityNode> neighbors = new ArrayList<CityNode>();

	public RoadMapBFTraversal(RoadMap c) {
		this.c = c;
	}
	
	
	public List<String> getTraversal(String home) {
		CityNode start = new CityNode(home);
		Queue<CityNode> queue = new LinkedList<CityNode>();
		queue.add(start);
		ArrayList<String> list = new ArrayList<String>();

		while (!queue.isEmpty()) {

			CityNode element = queue.remove();
			System.out.print(element + "t");
			ArrayList<CityNode> neighbours = (ArrayList<CityNode>) getNeighborNodes();
			for (int i = 0; i < neighbours.size(); i++) {
				CityNode n = neighbours.get(i);
				if (n != null) {
					queue.add(n);
				}
			}
		}
		
		while (!queue.isEmpty()) {
			list.add(queue.remove().getCityName());

		}
		return list;
	}
	
	public void addNeighbor(CityNode other) {neighbors.add(other);}
	public List<CityNode> getNeighborNodes() {return neighbors;}
	}