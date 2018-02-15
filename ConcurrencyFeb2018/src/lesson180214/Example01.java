package lesson180214;

public class Example01 {
	
	public static void main(String[] args) {  //psvm
		System.out.println(Thread.currentThread().toString());
		
		Runnable task = new Runnable() {
			@Override
			public void run() {
				System.err.println("Hi there!");
			}
		};
		
		Thread thread = new Thread(task);
		thread.start();
	}

}
