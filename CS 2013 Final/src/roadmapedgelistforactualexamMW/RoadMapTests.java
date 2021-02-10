package roadmapedgelistforactualexamMW;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.swing.JOptionPane;

import org.junit.jupiter.api.Test;

class RoadMapTests {

	@Test
	void testMapCreated() {
		RoadMap r = new RoadMap();
		assertNotNull(r);
	}

	@Test
	void testSizeEmptyMap() {
		RoadMap r = new RoadMap();
		assertEquals(r.getNumEdges(), 0);
		assertEquals(r.getNumNodes(), 0);
	}

	@Test
	void testSizeOneCity() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		assertEquals(r.getNumEdges(), 0);
		assertEquals(r.getNumNodes(), 1);
	}

	@Test
	void testSizeTwoCities() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		assertEquals(r.getNumEdges(), 0);
		assertEquals(r.getNumNodes(), 2);
	}

	@Test
	void testNodeNeighborsEmpty() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		assertEquals(r.getNumEdges(), 0);
		assertEquals(r.getNumNodes(), 2);
		assertEquals(r.getNeighborNodes(r.findCityNodeByName("Los Angeles")).size(), 0);
	}

	@Test
	void testNodeNeighborsOneNeighbor() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		r.buildRoad("Los Angeles", "San Diego");

		assertEquals(r.getNumEdges(), 1);
		assertEquals(r.getNumNodes(), 2);
		assertEquals(r.getNeighborNodes(r.findCityNodeByName("Los Angeles")).size(), 1);
	}

	@Test
	void testNodeNeighborNamesContainsCorrect() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		r.buildRoad("Los Angeles", "San Diego");
		assertTrue(r.getNeighborNames(r.findCityNodeByName("Los Angeles")).contains("San Diego"));
	}

	@Test
	void testNodeNeighborNamesContainsIncorrect() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		r.buildRoad("Los Angeles", "San Diego");
		assertFalse(r.getNeighborNames(r.findCityNodeByName("Los Angeles")).contains("Tijuana"));
	}

	@Test
	void testNeighborNodesContainsCorrect() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		r.buildRoad("Los Angeles", "San Diego");
		assertTrue(r.getNeighborNodes(r.findCityNodeByName("Los Angeles")).contains(r.findCityNodeByName("San Diego")));
	}

	@Test
	void testNodeNeighborNodesContainsIncorrect() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		r.buildRoad("Los Angeles", "San Diego");
		assertFalse(r.getNeighborNodes(r.findCityNodeByName("Los Angeles")).contains(r.findCityNodeByName("Tijuana")));
	}

	@Test
	void testNodeNeighborsSymmetric() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		r.buildRoad("Los Angeles", "San Diego");
		assertTrue(r.getNeighborNames(r.findCityNodeByName("San Diego")).contains("Los Angeles"));
	}

	@Test
	void testNodeNeighborsNotReflexive() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		r.buildRoad("Los Angeles", "San Diego");
		assertFalse(r.getNeighborNames(r.findCityNodeByName("Los Angeles")).contains("Los Angeles"));
	}

	@Test
	void testNodeNeighborsNotTransitive() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		r.addCity("Phoenix");

		r.buildRoad("Los Angeles", "San Diego");
		r.buildRoad("San Diego", "Phoenix");
		assertFalse(r.getNeighborNames(r.findCityNodeByName("Los Angeles")).contains("Phoenix"));
	}
	@Test
	void testNeighborsSizeIndirect() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		r.addCity("Phoenix");

		r.buildRoad("Los Angeles", "San Diego");
		r.buildRoad("Los Angeles", "Phoenix");

		assertEquals(r.getNeighborNodes(r.findCityNodeByName("San Diego")).size(), 1);
	}

	@Test
	void testSortOrder() {

		RoadMap r = new RoadMap();

		r.addCity("Los Angeles");
		r.addCity("Las Vegas");
		r.addCity("San Diego");
		r.addCity("Phoenix");
		r.addCity("Denver");

		assertTrue(r.getSortedListOfNodes().size() == 5);
	}
	
	

	@Test
	void testBFTSizeNoNeighbors() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");

		assertEquals(r.getBFTraversal("Los Angeles").size(), 1);
	}

	@Test
	void testBFTSizeOneNeighbor() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		r.buildRoad("Los Angeles", "San Diego");

		assertEquals(r.getBFTraversal("Los Angeles").size(), 2);
	}

	@Test
	void testBFTSizeTwoNeighbors() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		r.addCity("Phoenix");

		r.buildRoad("Los Angeles", "San Diego");
		r.buildRoad("Los Angeles", "Phoenix");

		assertEquals(r.getBFTraversal("Los Angeles").size(), 3);
	}

	@Test
	void testBFTSizeIndirect() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("Las Vegas");
		r.addCity("San Diego");
		r.addCity("Phoenix");

		r.buildRoad("Los Angeles", "Las Vegas");
		r.buildRoad("Los Angeles", "San Diego");
		r.buildRoad("San Diego", "Phoenix");
		r.buildRoad("Phoenix", "Las Vegas");

		assertEquals(r.getBFTraversal("San Diego").size(), 4);
	}

	@Test
	void testConnectedNodesSameSizeTraversal() {
		RoadMap r = new RoadMap();

		r.addCity("Los Angeles");
		r.addCity("Las Vegas");
		r.addCity("San Diego");
		r.addCity("Phoenix");
		r.addCity("Denver");

		r.buildRoad("Los Angeles", "Las Vegas");
		r.buildRoad("Los Angeles", "San Diego");
		r.buildRoad("San Diego", "Phoenix");
		r.buildRoad("Phoenix", "Las Vegas");
		r.buildRoad("Phoenix", "Denver");

		assertEquals(r.getBFTraversal("San Diego").size(), r.getBFTraversal("Las Vegas").size());
	}

	@Test
	void testDifferentOrderInputSameSizeTraversal() {

		RoadMap r = new RoadMap();

		r.addCity("Los Angeles");
		r.addCity("Las Vegas");
		r.addCity("San Diego");
		r.addCity("Phoenix");
		r.addCity("Denver");

		r.buildRoad("Los Angeles", "Las Vegas");
		r.buildRoad("Los Angeles", "San Diego");
		r.buildRoad("San Diego", "Phoenix");
		r.buildRoad("Phoenix", "Las Vegas");
		r.buildRoad("Phoenix", "Denver");

		RoadMap s = new RoadMap();

		s.addCity("San Diego");
		s.addCity("Denver");
		s.addCity("Phoenix");
		s.addCity("Las Vegas");
		s.addCity("Los Angeles");

		s.buildRoad("Phoenix", "Denver");
		s.buildRoad("Los Angeles", "San Diego");
		s.buildRoad("San Diego", "Phoenix");
		s.buildRoad("Los Angeles", "Las Vegas");
		s.buildRoad("Phoenix", "Las Vegas");

		assertEquals(r.getBFTraversal("San Diego").size(), s.getBFTraversal("San Diego").size());
	}
}
