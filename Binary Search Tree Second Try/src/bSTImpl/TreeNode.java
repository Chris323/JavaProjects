package bSTImpl;

public class TreeNode<T extends Comparable<T>>{
	T data;
	TreeNode<T> left;
	TreeNode<T> right;
	
	public TreeNode(T dataIn) {
		data = dataIn;
		left = null;
		right = null;
	}
	
	public TreeNode(T dataIn, TreeNode<T> leftIn, TreeNode<T> rightIn) {
		data = dataIn;
		left = leftIn;
		right = rightIn;
	}
	
	public TreeNode<T> insertDriver(T o, TreeNode<T> dataIn){
		if (dataIn == null) {
			dataIn = new TreeNode<T>(o);
			return dataIn;
		}
		if (o.compareTo(dataIn.data) < 0) {
			dataIn.left = insertDriver(o, dataIn.left);
		}
		if (o.compareTo(dataIn.data) > 0) {
			dataIn.right = insertDriver(o, dataIn.right);
		}
		else {
			
		}
		return dataIn;				
	}
	
	
	
	public T getDriver(T o, TreeNode<T> input){
		if (input == null) {
			return null;
		}
		if (o.compareTo(input.data) < 0) {
			return getDriver(o, input.left);
		}
		if (o.compareTo(input.data) > 0) {
			return getDriver(o, input.right);
		}
		else {
			
		}
		return input.data;
	}
	
	public String visit() {
		return " " + this.data;

	}
	
	
}
