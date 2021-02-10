package roadmapedgelistsampleexam;

// you may add more tests, but do not change anything that is already in this code
// when you are done with the problem, all the tests should succeed

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
	