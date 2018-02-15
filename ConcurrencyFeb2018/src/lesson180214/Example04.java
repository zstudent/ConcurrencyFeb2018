package lesson180214;

public class Example04 {
	
	
	public static void main(String[] args) {
		
		new MyThread().start();
		
	}

}


class MyThread extends Thread {
	
	@Override
	public void run() {
		while (true) {
			System.err.println("hi there");
		}
	}
	
}