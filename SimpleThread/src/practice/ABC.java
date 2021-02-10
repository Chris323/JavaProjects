package practice;

public class ABC {

	public static void main(String[] args) {
		ABC beg = new ABC();
		beg.start();

	}
	public void start() {
		LoopA a = new LoopA();
		LoopB b = new LoopB();
		LoopC c = new LoopC();
		
		Thread ta = new Thread(a);
		Thread tb = new Thread(b);
		Thread tc = new Thread(c);
		
		ta.start();
		tb.start();
		tc.start();
	}
	
	private class LoopA implements Runnable{

		@Override
		public void run() {
				for(int i = 1; i <= 100; i++) {
					System.out.println("a" + i);
			
		}
		
	}
	}
	
	private class LoopB implements Runnable{

		@Override
		public void run() {
				for(int i = 1; i <= 100; i++) {
					System.out.println("b" + i);
			
		}
		
	}
	}
	
	private class LoopC implements Runnable{

		@Override
		public void run() {
				for(int i = 1; i <= 100; i++) {
					System.out.println("c" + i);
			
		}
		
	}
	}

}
