package creation;

public class Driver {

	public static void main(String[] args) {
		BSTree<String> tree = new BSTree<String>();
		
		tree.add("Chris");
		tree.add("Max");
		tree.add("Muncy");
		tree.add("Olga");
		tree.add("Boomquisha");
		tree.add("Gertrude");
		tree.add("Guut");
		
		
		tree.inOrder();
	}

}
