package lesson180221;

public class WaitNotifyExample {

	public static void main(String[] args) {
		Object mutex = new Object();
		new Thread(() -> {
			System.out.println("waiting for signal");
			synchronized (mutex) {
				try {
					mutex.wait();
					System.out.println("got it");
				} catch (Exception e) {
					System.out.println("interrupted");
				}
				System.out.println("finished");
			}
		}).start();
		Utils.pause();
		Utils.pause();
		Utils.pause();
		Utils.pause();
		synchronized (mutex) {
			mutex.notify();
		}
		
	}

}
