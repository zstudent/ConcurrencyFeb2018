package lesson180221;

public class ThreadStopByInterruptExample {

	public static void main(String[] args) {

		Thread thread = new Thread(() -> {
			long count = 0;
			while (!Thread.interrupted()) {
				count++;
			}
			System.out.println(count);
		});
		thread.start();
		
		Utils.pause();
		
		thread.interrupt();

	}

}
