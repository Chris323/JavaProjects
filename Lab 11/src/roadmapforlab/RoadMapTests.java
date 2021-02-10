package roadmapforlab;

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
		assertEquals(r.getSize(), 0);
	}

	@Test
	void testSizeOneCity() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		assertEquals(r.getSize(), 1);
	}

	@Test
	void testSizeTwoCities() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		assertEquals(r.getSize(), 2);
	}

	@Test
	void testNodeNeighborsEmpty() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		assertEquals(r.findCityNodeByName("Los Angeles").getNeighborNodes().size(), 0);
	}

	@Test
	void testNodeNeighborsOneNeighbor() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		r.buildRoad("Los Angeles", "San Diego");
		assertEquals(r.findCityNodeByName("Los Angeles").getNeighborNodes().size(), 1);
	}

	@Test
	void testNodeNeighborsFirstCorrectUsingNode() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		r.buildRoad("Los Angeles", "San Diego");
		assertEquals(r.findCityNodeByName("Los Angeles").getNeighborNodes().get(0).getCityName(), "San Diego");
	}

	@Test
	void testNodeNeighborsFirstCorrectUsingNames() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		r.buildRoad("Los Angeles", "San Diego");
		assertEquals(r.findCityNodeByName("Los Angeles").getNeighborNames().get(0), "San Diego");
	}

	@Test
	void testContains() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		r.buildRoad("Los Angeles", "San Diego");
		assertTrue(r.findCityNodeByName("Los Angeles").getNeighborNames().contains("San Diego"));
	}

	@Test
	void testNodeNeighborsSymmetric() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		r.buildRoad("Los Angeles", "San Diego");
		assertTrue(r.findCityNodeByName("San Diego").getNeighborNames().contains("Los Angeles"));
	}

	@Test
	void testNodeNeighborsNotReflexive() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		r.buildRoad("Los Angeles", "San Diego");
		assertFalse(r.findCityNodeByName("Los Angeles").getNeighborNames().contains("Los Angeles"));
	}

	@Test
	void testNodeNeighborsNotTransitive() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		r.addCity("Phoenix");

		r.buildRoad("Los Angeles", "San Diego");
		r.buildRoad("San Diego", "Phoenix");
		assertFalse(r.findCityNodeByName("Los Angeles").getNeighborNames().contains("Phoenix"));
	}

	@Test
	void testNeighborsSizeIndirect() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		r.addCity("Phoenix");

		r.buildRoad("Los Angeles", "San Diego");
		r.buildRoad("Los Angeles", "Phoenix");

		assertEquals(r.findCityNodeByName("San Diego").getNeighborNodes().size(), 1);
	}

	

// add tests here to determine if your BFT and MergeSort are correct
}