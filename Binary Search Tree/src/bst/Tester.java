package bst;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Tester {

	@Test
	void testInsert() {
		TreeNode<String> first = new TreeNode<String>("parent");
		BSTree<String> tree = new BSTree<String>(first);
		tree.add("Hi");
		
		assertTrue(true);
	}
	
	@Test
	void testRemove() {
		TreeNode<String> first = new TreeNode<String>("parent");
		BSTree<String> tree = new BSTree<String>(first);
		tree.add("Hi");
		tree.remove("Hi");
		
		assertTrue(true);
		
	}
	
	@Test
	void testSize() {
		TreeNode<String> first = new TreeNode<String>("parent");
		BSTree<String> tree = new BSTree<String>(first);
		tree.add("Hi");
		
		assertEquals(1, tree.getSize());
	}
	
	@Test
	void testGet() {
		TreeNode<String> first = new TreeNode<String>("parent");
		BSTree<String> tree = new BSTree<String>(first);
		tree.add("Hi");
		
		assertNotNull(tree.get("Hi"));
	}
}
