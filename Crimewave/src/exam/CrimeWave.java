package exam;

import java.lang.Thread.State;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class CrimeWave {
	private Random r = new Random();
	private Queue crimes = new PriorityQueue();
	private Integer committed = 0;
	private Integer solved = 0;
	
	public static void main(String[] args) {
		CrimeWave c = new CrimeWave();
		c.meanStreets(50);
		System.exit(0);
	}
	
	public void meanStreets(int crimesPerCriminal) {
		Detective d1 = new Detective("d1");
		Detective d2 = new Detective("d2");
		Criminal c1 = new Criminal("c1", crimesPerCriminal);
		Criminal c2 = new Criminal("c2", crimesPerCriminal);

// create the Threads and start them here
		Thread t1 = new Thread(d1);
		Thread t2 = new Thread(d2);
		Thread t3 = new Thread(c1);
		Thread t4 = new Thread(c2);
		t1.start();
		t2.start();
		t3.start();
		t4.start();


		while (t3.getState() != State.TERMINATED
				|| t4.getState() != State.TERMINATED || !(crimes.isEmpty())) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("committed: " + committed);
		System.out.println("solved: " + solved);
	}

// write the void commitCrime() method here.  It should take a Crime as //parameter, add it to the queue, and increment the number of crimes //committed. 

	public void commitCrime(Crime crimeIn) {
		crimes.add(crimeIn);
		committed ++;
	}

// write the void solveCrimes() method here.  It should take the name of // a detective as a parameter.  If there are no crimes in the queue, the // detective should wait 60 ms, then check again, repeatedly.  If there // is at least one crime in the queue, remove the highest-priority crime
// increment solved, and show the correct output.
	
	public void solveCrimes(String stringIn) {
		try {
		if (!crimes.isEmpty()) {
			System.out.println(stringIn + " solves a crime of severity " + ((Crime) crimes.poll()).getSeverity() );
			solved++;
		}
		else {
			Thread.sleep(60);
		}
	}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		

	private class Crime implements Comparable {
		private int severity;

		public Crime(int severityIn) {
			severity = severityIn;
		}

		public int getSeverity() {
			return severity;
		}

		// override Crime’s compareTo() method here
		@Override
		public int compareTo(Object o) {
			return (this.severity < ((Crime) o).getSeverity() ? 1:-1);
		}

	}

	private class Criminal implements Runnable {
		String name;
		int numCrimesToCommit;
		
		private Criminal(String nameIn, int numCrimesIn) {
			name = nameIn;
			numCrimesToCommit = numCrimesIn;
		}

		@Override
		public void run() {
			for (int i = 0; i < numCrimesToCommit; i++) {
				try {
					Thread.sleep(r.nextInt(100));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				int s = (r.nextInt(5));
				Crime c = new Crime(s);
				System.out.println(name + " commits a crime of severity " + s);
				commitCrime(c);
			}
		}
	}

	private class Detective implements Runnable {
		String name;

		private Detective(String nameIn) {
			name = nameIn;
		}

		@Override
		public void run() {
			while (true) {
				solveCrimes(name);
				try {
					Thread.sleep(60);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}

