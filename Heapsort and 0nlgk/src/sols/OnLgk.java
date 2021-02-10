package sols;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;


public class OnLgk {
	public static void generateList(int k, int l) {
		Random r = new Random();
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < k; i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for (int j = 0; j < l; j++) {
				temp.add(r.nextInt(100));
			}
			// sorting list
			Collections.sort(temp);
			list.add(temp);
		}
		System.out.println("First Part: " + list.toString());
		mergeLists(list);
	}

	public static void mergeLists(ArrayList<ArrayList<Integer>> list) {
		Queue<Integer> minHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				return i1.compareTo(i2);
			}
		});
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) != null) {
				minHeap.addAll(list.get(i));
			}
		}
		while (!minHeap.isEmpty()) {
			result.add(minHeap.poll());
		}
		System.out.println("Second Part: " + result.toString());
	}
}
