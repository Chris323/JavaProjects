package bst;

public class TNode<T extends Comparable<T>> {
	T element;
	TNode<T> right;
	TNode<T> left;

	public TNode(T o) {
		element = o;
		left = null;
		right = null;
	}

	public TNode() {
		element = null;
		left = null;
		right = null;
	}

	public T getLeft() {
		return (T) this.left;
	}

	public T getRight() {
		return (T) this.right;
	}

	public void setLeft(T input) {
		this.left = (TNode<T>) input;
	}

	public void setRight(T input) {
		this.right = (TNode<T>) input;
	}

	public void insertInitial(T o) {
		if (element.compareTo(o) < 0 && right == null) {
			right = new TNode<T>(o);
		}
		if (element.compareTo(o) < 0 && right != null) {
			right.insertInitial(o);
		} else if (element.compareTo(o) > 0) {
			insertCont(o);
		}
	}

	public void insertCont(T o) {
		if (left == null) {
			left = new TNode<T>(o);
		} else if (left != null) {
			left.insertCont(o);
		}
	}

	public T getElement() {
		return this.element;
	}

	public void setElement(T o) {
		this.element = o;
	}

	public String showAll() {
		return " " + this.element;

	}
}
