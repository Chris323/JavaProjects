package lab7;

import java.util.Comparator;
import java.util.Map.Entry;

public class SortComparator implements Comparator<Entry<String, Integer>>{
	
	
	@Override
	public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
		
		Integer diff = o1.getValue() - o2.getValue();
		if(diff > 0) return -1;
		else if (diff < 0) return 1;
		else return 0;
	}
	
}