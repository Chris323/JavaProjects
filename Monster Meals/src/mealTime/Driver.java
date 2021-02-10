package mealTime;



import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

import mealTime.Carnage.monster;

public class Driver {

	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int looper = 0;	
		while(looper == 0) {
			
		System.out.println("Please enter the amount of a monster type");
		int amount = input.nextInt();		
		System.out.println("Would you like a (1) Zombie or (2) Vampire. Please enter 1 or 2.");
		int monsterChoice = input.nextInt();
		
		if (monsterChoice == 1) {
			monster mType = Carnage.monster.Zombie;
			
			PriorityQueue<Victim> pq = new PriorityQueue<Victim>();
			List<Victim> listo = new ArrayList<Victim>();// might have to be a queue and possibly even linkedlist
			Carnage printer = new Carnage();
			
			pq.add(new Victim("Molina", 80, 2));
			pq.add(new Victim("Ash", 190, 1));
			pq.add(new Victim("Carmelita", 191, 4));
			pq.add(new Victim("Yacky", 160, 3));
			pq.add(new Victim("Bea", 100, 9));
			pq.add(new Victim("Stef", 120, 6));
			
			int round = 0;
					
			while (!pq.isEmpty()) {
				//getName() + ": " + "intelligence " + pq.peek().iq + ", appearance " + pq.peek().appearance
				System.out.println(pq.peek().toString() + ", is eaten by " 
					+ mType + " " + round % amount);			
				listo.add(pq.remove()); // fix dis
				round++;
			}			
			System.out.println(printer.monsterAttack(listo, amount, mType)); // fix dis
		
		}
		
 
		else /*(monsterChoice.equals("vampire"))*/ {
			monster mType2 = Carnage.monster.Vampire;
			
			Comparator comp = new Carnage();
			PriorityQueue pq2 = new PriorityQueue<Victim>(comp);
			List<Victim> listo2 = new ArrayList<Victim>();// might have to be a queue and possibly even linkedlist
			Carnage printer = new Carnage();
			
			pq2.add(new Victim("Molina", 80, 2));
			pq2.add(new Victim("Ash", 190, 1));
			pq2.add(new Victim("Carmelita", 191, 4));
			pq2.add(new Victim("Yacky", 160, 3));
			pq2.add(new Victim("Bea", 100, 9));
			pq2.add(new Victim("Stef", 120, 6));
			
			int round = 0;
			
			while (!pq2.isEmpty()) {
				//getName() + ": " + "intelligence " + pq.peek().iq + ", appearance " + pq.peek().appearance
				System.out.println(pq2.peek().toString() + ", is eaten by " 
					+ mType2 + " " + round % amount);
//				pq2.remove();
				listo2.add((Victim) pq2.remove());// fix dis
				round++;
			}			
			System.out.println(printer.monsterAttack(listo2, amount, mType2));//fix dis
		
		}
		
	}
	}
	
}
