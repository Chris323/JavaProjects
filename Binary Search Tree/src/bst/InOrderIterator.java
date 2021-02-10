package bst;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InOrderIterator<T extends Comparable<T>> implements Iterator<T> {
	public List<T> list = new ArrayList<>();
	public int current = 0;
	BSTree<T> tree;
	
	public InOrderIterator() {
		inOrder();
	}
	
	public void inOrder() {
		inOrderIt(tree.root);
	}
	
	private void inOrderIt(TreeNode<T> root) {
		if (root == null) return;
		inOrderIt(root.left);
		list.add(root.element);
		inOrderIt(root.right);
		}
	
	@Override
	public boolean hasNext() {
		if (current < list.size()) {
			return true;
		}	
		else {
		return false;
		}
	}
	
	@Override
	public T next() {
		return list.get(current++);
	}

}
