package creation;

public class BSTree<T extends Comparable<T>> {
	TreeNode<T> root;

	public BSTree() {
		super();
		this.root = new TreeNode<T>();
	}

	public BSTree(T o) {
		super();
		// TODO Auto-generated constructor stub
		TreeNode<T> node = new TreeNode<T>(o);
		this.root = node;
	}

	public void add(T o) {
		if (root == null) {
			root = new TreeNode<T>(o);
		} else {
			root.insert(o);
		}
	}

	public void inOrderHelper(TreeNode<T> node) {
		if (node != null) {
			inOrderHelper(node.left);
			node.visit();
			inOrderHelper(node.right);
		}
	}

	public void inOrder() {
		if (root != null) {
			inOrderHelper(root);
		}
	}

}
