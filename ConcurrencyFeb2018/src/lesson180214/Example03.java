package lesson180214;

import java.io.PrintStream;

public class Example03 {
	
	private static final class Task implements Runnable {
		
		private PrintStream stream;

		public Task(PrintStream stream) {
			this.stream = stream;
		}
		
		@Override
		public void run() {
			int count = 0;
			while (true) {
				stream.println(Thread.currentThread() + " Count = " + count++);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {  //psvm
		System.out.println(Thread.currentThread().toString());
		
		Runnable task1 = new Task(System.out);
		Runnable task2 = new Task(System.err);
		
		Thread thread = new Thread(task2);
		thread.start();
		
//		task1.run();
		
		ThreadGroup threadGroup = new ThreadGroup("Special");
		
		new Thread(threadGroup, () -> {
			System.out.println(Thread.currentThread());
		}).start();
		
	}

}
