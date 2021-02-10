package bst;

public class Driver {

	public static void main(String[] args) {
		BST<String> tree = new BST<String>();
			
		tree.add("Chris");
		tree.add("Max");
		tree.add("Muncy");
		tree.add("Olga");
		tree.add("Boomquisha");
		tree.add("Gertrude");
		tree.add("Guut");
		
		tree.traversal();
		
	}

}
