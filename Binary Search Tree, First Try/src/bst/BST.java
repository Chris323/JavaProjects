package bst;

public class BST <T extends Comparable <T>> {
	TNode<T> root;
	
	public BST() {
		super();
		root = new TNode<T>();
	}
	
//	public BST(T o) {
//		super();
//		root = new TNode<T>(o);
//	}
	
	public void add(T o) {
		if (root == null) {
			root = new TNode<T>(o);
		} else {
			root.insertInitial(o);
		}
	}
	
	public void inOrder(TNode<T> node) {
		if (node != null) {
			inOrder(node.left);
			node.showAll();	
			inOrder(node.right);
		}
	}
	
	public void traversal() {
		if (root != null) {
			inOrder(root);
		}
	}
}
