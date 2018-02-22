package lesson180221;

public class ThreadStopByStopFatalExample {
	
	public static void main(String[] args) {
		
		Data data = new Data();
		
		Thread thread = new Thread(()-> {
			while (true) {
				data.change();
			}
		});
		thread.start();
		Utils.pause();
		thread.stop();
		System.err.println(data.x + data.y == 0);
	}
}

class Data {
	int x;
	int y;
	
	public void change() {
		x++;
		y--;
	}
	
	
}
