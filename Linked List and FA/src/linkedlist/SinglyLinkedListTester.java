package linkedlist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SinglyLinkedListTester {

	@Test
	public void testListCreated() {
		SinglyLinkedList<String> l = new SinglyLinkedList<String>();
		assertNotNull(l);
	}

	@Test
	public void testLengthWithEmptyList() {
		SinglyLinkedList<String> l = new SinglyLinkedList<String>();
		assertEquals(l.size(), 0);
	}

	@Test
	public void testLengthWithOneNodeAdded() {
		SinglyLinkedList<String> l = new SinglyLinkedList<String>();
		String testString = "Godzilla";
		l.add(testString);
		assertEquals(l.size(), 1);
	}

	@Test
	public void testLengthWithTwoNodesAdded() {
		SinglyLinkedList<String> l = new SinglyLinkedList<String>();
		String testString = "Godzilla";
		l.add(testString);
		String testString2 = "Mothra";
		l.add(testString2);
		assertEquals(l.size(), 2);
	}

	@Test
	public void testLengthWithThreeNodesAdded() {
		SinglyLinkedList<String> l = new SinglyLinkedList<String>();
		String testString = "Godzilla";
		l.add(testString);
		String testString2 = "Mothra";
		l.add(testString2);
		String testString3 = "Jersey Devil";
		l.add(testString3);
		
		assertEquals(l.size(), 3);
	}
	
	@Test
	public void testLengthWithRemovedNode() {
		SinglyLinkedList<String> l = new SinglyLinkedList<String>();
		String testString = "Godzilla";
		l.add(testString);
		String testString2 = "Mothra";
		l.add(testString2);
		String testString3 = "Jersey Devil";
		l.add(testString3);
		l.remove(testString);
		
		assertEquals(l.size(), 2);
	}
	
	
	@Test
	public void testElementValueWithOneNodeAdded() {
		SinglyLinkedList<String> l = new SinglyLinkedList<String>();
		String testString = "Godzilla";
		l.add(testString);
		assertEquals(l.get(0), testString);
	}

	@Test
	public void testFirstElementValueWithTwoNodesAdded() {
		SinglyLinkedList<String> l = new SinglyLinkedList<String>();
		String testString = "Godzilla";
		String testString2 = "Mothra";
		l.add(testString);
		l.add(testString2);
		assertEquals(l.get(0), testString);
	}

	@Test
	public void testSecondElementValueWithTwoNodesAdded() {
		SinglyLinkedList<String> l = new SinglyLinkedList<String>();
		String testString = "Godzilla";
		String testString2 = "Mothra";
		l.add(testString);
		l.add(testString2);
		assertEquals(l.get(1), testString2);
	}

	@Test
	public void testGetWithEmptyList() {
		SinglyLinkedList<String> l = new SinglyLinkedList<String>();
		assertNull(l.get(0));
	}

	@Test
	public void testGetWithOneElement() {
		SinglyLinkedList<String> l = new SinglyLinkedList<String>();
		String testString = "Godzilla";
		l.add(testString);
		assertEquals(l.get(0), testString);
	}

	@Test
	public void testGetFirstOfTwoElements() {
		SinglyLinkedList<String> l = new SinglyLinkedList<String>();
		String testString = "Godzilla";
		String testString2 = "Mothra";
		l.add(testString);
		l.add(testString2);
		assertEquals(l.get(0), testString);
	}

	@Test
	public void testGetLastOfTwoElements() {
		SinglyLinkedList<String> l = new SinglyLinkedList<String>();
		String testString = "Godzilla";
		String testString2 = "Mothra";
		l.add(testString);
		l.add(testString2);
		assertEquals(l.get(1), testString2);
	}

	@Test
	public void testContainsWithEmptyList() {
		SinglyLinkedList<String> l = new SinglyLinkedList<String>();
		String testString = "Godzilla";

		assertFalse(l.contains(testString));
	}

	@Test
	public void testContainsFalseWithOneElement() {
		SinglyLinkedList<String> l = new SinglyLinkedList<String>();
		String testString = "Godzilla";
		l.add(testString);
		String testString2 = "Mothra";
		assertFalse(l.contains(testString2));
	}

	@Test
	public void testContainsTrueWithOneElement() {
		SinglyLinkedList<String> l = new SinglyLinkedList<String>();
		String testString = "Godzilla";
		l.add(testString);
		assertTrue(l.contains(testString));
	}

	@Test
	public void testContainsFalseWithTwoElements() {
		SinglyLinkedList<String> l = new SinglyLinkedList<String>();
		String testString = "Godzilla";
		l.add(testString);
		String testString2 = "Mothra";
		l.add(testString2);
		String testString3 = "Dracula";

		assertFalse(l.contains(testString3));
	}

	@Test
	public void testContainsTrueWithFirstElementOfTwo() {
		SinglyLinkedList<String> l = new SinglyLinkedList<String>();
		String testString = "Godzilla";
		l.add(testString);
		String testString2 = "Mothra";
		l.add(testString2);

		assertTrue(l.contains(testString));
	}

	@Test
	public void testContainsTrueWithLastElementOfTwo() {
		SinglyLinkedList<String> l = new SinglyLinkedList<String>();
		String testString = "Godzilla";
		l.add(testString);
		String testString2 = "Mothra";
		l.add(testString2);

		assertTrue(l.contains(testString2));
	}

	@Test
	public void testContainsTrueWithMiddleElement() {
		SinglyLinkedList<String> l = new SinglyLinkedList<String>();
		String testString = "Godzilla";
		l.add(testString);
		String testString2 = "Mothra";
		l.add(testString2);
		String testString3 = "Dracula";
		l.add(testString3);
		
		assertTrue(l.contains(testString2));
	}
	
	
	@Test
	public void testRemoveFromEmptyList() {
		SinglyLinkedList<String> l = new SinglyLinkedList<String>();
		String testString = "Godzilla";
		l.remove(testString);
		assertFalse(l.contains(testString));
	}

	@Test
	public void testRemoveFromListWithoutElement() {
		SinglyLinkedList<String> l = new SinglyLinkedList<String>();
		String testString = "Godzilla";
		String testString2 = "Mothra";
		l.add(testString);
		l.remove(testString2);
		assertFalse(l.contains(testString2));
	}

	@Test
	public void testRemoveWithFirstElement() {
		SinglyLinkedList<String> l = new SinglyLinkedList<String>();
		String testString = "Godzilla";
		String testString2 = "Mothra";
		l.add(testString);
		l.add(testString2);
		l.remove(testString);
		assertFalse(l.contains(testString));
	}

	@Test
	public void testRemoveWithMiddleElement() {
		SinglyLinkedList<String> l = new SinglyLinkedList<String>();
		String testString = "Godzilla";
		String testString2 = "Mothra";
		String testString3 = "Jersey Devil";
		l.add(testString);
		l.add(testString2);
		l.add(testString3);
		l.remove(testString2);
		assertTrue(l.contains(testString));
		assertFalse(l.contains(testString2));
		assertTrue(l.contains(testString3));
	}

	
	@Test
	public void testRemoveWithLastElementOfTwo() {
		SinglyLinkedList<String> l = new SinglyLinkedList<String>();
		String testString = "Godzilla";
		String testString2 = "Mothra";
		l.add(testString);
		l.add(testString2);		
		l.remove(testString2);
		assertFalse(l.contains(testString2));
	}
	
	@Test
	public void testRemoveWithLastElementOfThree() {
		SinglyLinkedList<String> l = new SinglyLinkedList<String>();
		String testString = "Godzilla";
		String testString2 = "Mothra";
		String testString3 = "Jersey Devil";
		l.add(testString);
		l.add(testString2);		
		l.add(testString3);
		l.remove(testString3);
						
		assertFalse(l.contains(testString3));
	}

	@Test
	public void testRemoveWithDuplicateElement() {
		SinglyLinkedList<String> l = new SinglyLinkedList<String>();
		String testString = "Godzilla";
		String testString2 = new String("Godzilla");
		l.add(testString);
		l.add(testString2);

		l.remove(testString);

		assertFalse(l.contains(testString));
		assertFalse(l.contains(testString2));
	}
	
	@Test
	public void testListWithNoNodes() {
		SinglyLinkedList<String> l = new SinglyLinkedList<String>();

		assertEquals(l.size(), 0);
	}
	
	@Test
	public void testNodeWithNoCycles() {
		SinglyLinkedList<String> l = new SinglyLinkedList<String>();
		String testString = "Godzilla";
		String testString2 = new String("Godzilla");
		l.add(testString);
		l.add(testString2);
		
	
		assertFalse(l.loopDectection());
	}
	
	@Test
	public void testNodeWithOne() {
		SinglyLinkedList<String> l = new SinglyLinkedList<String>();
		String testString = "Godzilla";
		Node newNode = new Node(testString);
		l.addToCreateCycle(newNode);
		
		
	
		assertTrue(l.loopDectection());
	}
	
	@Test
	public void testNodeWithEvenCycle() {
		SinglyLinkedList<String> l = new SinglyLinkedList<String>();
		String testString = "Godzilla";
		String testString2 = new String("Godzilla");
		Node newNode = new Node(testString);
		Node newNode2 = new Node(testString2);

		l.add(newNode);
		l.addToCreateCycle(newNode2);
		
		
		
	
		assertTrue(l.loopDectection());
		assertTrue(l.size()%2 == 0);
	}
	
	@Test
	public void testNodeWithOddCycle() {
		SinglyLinkedList<String> l = new SinglyLinkedList<String>();
		String testString = "Godzilla";
		String testString2 = new String("Godzilla");
		String testString3 = new String("Godzilla");
		
		Node newNode = new Node(testString);
		Node newNode2 = new Node(testString2);
		Node newNode3 = new Node(testString3);

		l.add(newNode);
		l.add(newNode2);
		l.addToCreateCycle(newNode3);
		
		
		
	
		assertTrue(l.loopDectection());
		assertTrue(l.size()%2 != 0);
	}
	
	
	

}
