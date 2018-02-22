package lesson180221;

public class ThreadStopExample2 {
	
	private static boolean stop = false;

	public static void main(String[] args) {

		new Thread(() -> {
			long count = 0;
			while (!isStop()) {
				// Utils.pause();
				count++;
			}
			System.out.println(count);
		}).start();

		Utils.pause();
		setStop(true);
	}

	static boolean isStop() {
		synchronized (ThreadStopExample2.class) {
			return stop;
		}
	}

	synchronized static void setStop(boolean stop) {
		ThreadStopExample2.stop = stop;
	}
}
