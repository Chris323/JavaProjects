package thread;

class Thread_1 extends Thread{
	
	public void run() {
		for(int i = 0; i < 5; i++);{
			System.out.println("-------");
		}
	}
}


class Thread_2 extends Thread{
	
	public void run() {
		for(int i = 0; i < 5; i++);{
			System.out.println("++++++");
		}
	}
}

public class Threading {

	public static void main(String[] args) {
		Thread t1 = new Thread_1();
		t1.start();
		
		Thread t2 = new Thread_1();
		t2.start();

	}

}
