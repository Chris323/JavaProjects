import java.util.ArrayList;

class Process_PCB{
String name;
	int burstTime;
	int arriveTime;
	int startTime;
	int finishTime;
	public int waitTime;
	
	public Process_PCB(String name, int burstTime, int arriveTime) {
		super();
		this.name = name;
		this.burstTime = burstTime;
		this.arriveTime = arriveTime;
	}
	
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	
	public void runProcess() {
		finishTime = startTime + burstTime;
		waitTime = startTime - arriveTime;
	}

	public int getFinishTime() {
		return finishTime;
	}
}

class ReadyQueue{
		ArrayList<Process_PCB> process_ReadyQ;
		
		public ReadyQueue() {
			process_ReadyQ = new ArrayList<Process_PCB>();
		}
		
		public void addProcess(Process_PCB pcb) {
			process_ReadyQ.add(pcb);
		}
		
		public Process_PCB getProcess() {
			Process_PCB pcb = process_ReadyQ.get(0);
			return pcb;
		}
		
		public void removeProcess() {
			process_ReadyQ.remove(0);
		}
		
		public boolean queueEmpty() {
			return process_ReadyQ.isEmpty();
		}
}

public class FCFS_Scheduling {	
	

	public static void main(String[] args) {
		ReadyQueue readyQueue = new ReadyQueue();
		Process_PCB[] pcbs = new Process_PCB[5];
		pcbs[0] = new Process_PCB("p1", 10, 0);
		pcbs[1] = new Process_PCB("p2", 29, 0);
		pcbs[2] = new Process_PCB("p3", 3, 0);
		pcbs[3] = new Process_PCB("p4", 7, 0);
		pcbs[4] = new Process_PCB("p5", 12, 0);
		
		for(int i = 0; i < 5; i ++) {
			readyQueue.addProcess(pcbs[i]);
		}
		
		int timeLine = 0;
		int totalWait = 0;
		while(!readyQueue.queueEmpty()) {
			Process_PCB pcb = readyQueue.getProcess();
			pcb.setStartTime(timeLine);
			pcb.runProcess();
			timeLine = pcb.getFinishTime();
			readyQueue.removeProcess();
			
			totalWait = totalWait + pcb.waitTime;
			
		}
		
		System.out.println("All process finsihed at: " + timeLine);
		
//		double avgWait =  (double)timeLine/5;
		
		System.out.println("Average waiting: " + totalWait/5);
	}}
	
