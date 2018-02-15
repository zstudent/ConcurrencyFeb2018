package lesson180214;

public class Example02 {
	
	public static void main(String[] args) {  //psvm
		System.out.println(Thread.currentThread().toString());
		
		Runnable task = new Runnable() {

			@Override
			public void run() {
				int count = 0;
				while (true) {
					System.out.println("Count = " + count++);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		Thread thread = new Thread(task);
		thread.start();
	}

}
