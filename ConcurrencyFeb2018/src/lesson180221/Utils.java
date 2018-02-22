package lesson180221;

public class Utils {

	public static void pause() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
