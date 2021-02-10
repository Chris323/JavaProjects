package bst;

import java.util.Iterator;

public class BSTree<T extends Comparable<T>> {
	TreeNode<T> root;
	int size = 0;

	public BSTree(TreeNode<T> nodeIn) {
		super();
		root = nodeIn;
		
	}

	public void add(T o) {
		root.insertDriver(o, root);
		size++;
	}

	public void inOrder(TreeNode<T> node) {
		if (node != null) {
			inOrder(node.left);
			node.visit();
			inOrder(node.right);
		}
	}

	public T get(T o) {
		return root.getDriver(o, root);
	}

	public void showAll() {
		inOrder(root);
		System.out.println();
	}
	
	public void remove(T o) {
		root.deleteDriver(o, root);
		size--;
	}

	public int getSize() {
		return size;
	}

	public Iterator<T> iterator() {
		return new InOrderIterator<T>();
	}

	public void breadthFirstTraversal() {
		while (!root.perma.isEmpty()) {
			System.out.println(root.perma.remove());
		}
	}
}
