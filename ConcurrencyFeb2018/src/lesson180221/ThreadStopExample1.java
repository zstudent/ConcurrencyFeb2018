package lesson180221;

public class ThreadStopExample1 {
	
	volatile static boolean stop = false;

	public static void main(String[] args) {

		new Thread(() -> {
			long count = 0;
			while (!stop) {
				// Utils.pause();
				count++;
			}
			System.out.println(count);
		}).start();

		Utils.pause();
		stop = true;
	}
}
