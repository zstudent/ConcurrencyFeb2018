package lesson180214;

public class RaceConditionExample {
	
	static class Turniket implements Runnable {

		static private int count;

		@Override
		public void run() {
			for (int i = 0; i < 1000000; i++) {
				synchronized (Turniket.class) {   //  mutual exclusive
					int tmp = count;
					tmp = tmp + 1;
					count = tmp;
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread thread1 = new Thread(new Turniket());
		thread1.start();
		Thread thread2 = new Thread(new Turniket());
		thread2.start();
		Thread thread3 = new Thread(new Turniket());
		thread3.start();
		
		thread1.join();
		thread2.join();
		
		while (thread3.isAlive());
		
		
		
		System.out.println(Turniket.count);
		
	}

}
