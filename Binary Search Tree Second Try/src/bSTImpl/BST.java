package bSTImpl;

public class BST<T extends Comparable<T>> {
	TreeNode<T> root;

	public BST() {
		super();
	}

	public void add(T o) {
		root.insertDriver(o, root);
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
}
