package bst;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode<T extends Comparable<T>> {
	Queue<TreeNode<T>> perma = new LinkedList<TreeNode<T>>();
	T element;
	TreeNode<T> left;
	TreeNode<T> right;
	BSTree<T> tree;

	public TreeNode(T elementIn) {
		element = elementIn;
	}

	public boolean insertDriver(T o, TreeNode<T> rootIn) {
		if (rootIn == null)
			rootIn = new TreeNode<T>(o);

		else {
			TreeNode<T> parent = null;
			TreeNode<T> current = rootIn;
			while (current != null)
				if (o.compareTo(current.element) < 0) {
					parent = current;
					current = current.left;
				} else if (o.compareTo(current.element) > 0) {
					parent = current;
					current = current.right;
				} else
					return false;

			if (o.compareTo(parent.element) < 0)
				parent.left = new TreeNode<T>(o);
			else
				parent.right = new TreeNode<T>(o);
		}
		return true;

	}

	public T getDriver(T o, TreeNode<T> input) {
		if (input == null) {
			return null;
		}
		if (o.compareTo(input.element) < 0) {
			return getDriver(o, input.left);
		}
		if (o.compareTo(input.element) > 0) {
			return getDriver(o, input.right);
		} else {

		}
		return input.element;
	}
	
	public boolean deleteDriver(T o, TreeNode<T> rootIn) {
		TreeNode<T> parent = null;
		TreeNode<T> current = rootIn;
		while (current != null) {
			if (o.compareTo(current.element) < 0){
				parent = current;
				current = current.left;
			}
			else if (o.compareTo(current.element) > 0) {
				parent = current;
				current = current.right;
			}
			else
				break;
		}
		if (current == null) 
		return false;
		
		if (current.left == null) {
			if(parent == null) {
				rootIn = current.right;
			}
			else {
				if(o.compareTo(parent.element) < 0)
				parent.left = current.right;
				else
					parent.right = current.left;			
			}				
		}
		else {
			TreeNode<T> pOfRightMost = current;
			TreeNode<T> rightMost = current.left;
			while(rightMost.right != null) {
				pOfRightMost = rightMost;
				rightMost = rightMost.right;
			}
			current.element = rightMost.element;
			
			if (pOfRightMost.right == rightMost) 
				pOfRightMost.right = rightMost.left;
			else
				pOfRightMost.left = rightMost.left;
		}
		return true;
	}
	
	private void breadthFirst(TreeNode<T> rootIn) {
	     if(rootIn == null)
	       return;   
	 
	     Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
	     queue.add(rootIn);
	    	   
	     while (!queue.isEmpty()) {
	          TreeNode<T> node = queue.remove();
	          perma.add(node);
	    
	          if (node.left != null)
	              queue.add(node.left);
	          if (node.right != null)
	              queue.add(node.right);
	     }      
	 
	   }
	
	public String visit() {
		return " " + this.element;

	}
}
