package lesson180221;

public class ThreadStopByStop {

	public static void main(String[] args) {
		
		System.out.println("start");

		Thread thread = new Thread(() -> {
			long count = 0;
			boolean t = true;
			while (t) {
				count++;
			}
			System.out.println(count);
		});
		thread.start();
		
		Utils.pause();
		
		thread.stop();

	}

}
