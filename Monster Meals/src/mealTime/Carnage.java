package mealTime;


import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;



public class Carnage implements Comparator<Victim> {


	enum monster{
		Zombie, Vampire;
	}
	
	@Override
	public int compare(Victim initial, Victim newOne) { // This method might need to go in carnage
		double diff = initial.getAppearance() - newOne.getAppearance();
		if(diff > 0) return -1;
		else if (diff < 0) return 1;
		else return 0;
	}
	
	public LinkedHashMap monsterAttack(List<Victim> victimsIn, Integer monsterNumIn, monster type) {
		LinkedHashMap<Victim, Integer> mapa = new LinkedHashMap<Victim, Integer>();
		
		int round = 0;
		for(int i = 0; i < victimsIn.size(); i++) {
			mapa.put(victimsIn.remove(i), round % monsterNumIn);
			round ++;
		}	
		
		return mapa;
		
	}

}
