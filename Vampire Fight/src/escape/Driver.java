package escape;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Driver {
	static Stack<Victim> stack = new Stack<Victim>();
	static Queue<Victim> queue = new LinkedList<Victim>();
	
	static Victim carl = new Victim("Carl");
	static Victim dan = new Victim("Dan");
	static Victim fanny = new Victim("Fanny");
	static Victim jules = new Victim("Jules");
	static Victim mike = new Victim("Mike");
	static Victim pop = new Victim("Pop");
	static Victim ren = new Victim("Ren");
	

	
	public static void main(String[] args) {
		stack.add(carl);
		stack.add(dan);
		stack.add(fanny);
		stack.add(jules);
		stack.add(mike);
		stack.add(pop);
		stack.add(ren);
		
		while(!stack.empty()) {
			
			
			//stack.pop();
			queue.add(stack.pop());
			//queue.poll();
			//System.out.println(queue.peek() + "escapes by warding off Vampire with garlic");
		}
		while(!queue.isEmpty()) {
			System.out.println(queue.peek().getName() + " escapes by warding off Vampire with garlic");
			queue.poll();
		}
	}

}
