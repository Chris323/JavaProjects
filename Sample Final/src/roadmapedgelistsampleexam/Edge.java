package roadmapedgelistsampleexam;

//do not change any code in this class

public class Edge {
	
	private CityNode node1;
	private CityNode node2;

	public Edge(CityNode node1, CityNode node2) {
		super();
		this.node1 = node1;
		this.node2 = node2;
	}

	public CityNode[] getVertices() {
		return new CityNode[] { node1, node2 };
	}

}
