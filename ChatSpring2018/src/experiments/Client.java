package experiments;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		
		if (args.length != 2) {
			System.out.println("Usage: <host> <port>");
			System.exit(0);
		}
		
		String hostName = args[0];
		int port = Integer.parseInt(args[1]);

		try {
			Socket socket = new Socket(hostName, port);
			new Thread(() -> processInput(socket)).start();
			new Thread(() -> processOutput(socket)).start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void processOutput(Socket socket) {
		Scanner scanner = new Scanner(System.in);
		try {
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				pw.println(line);
				pw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		} 
	}

	private static void processInput(Socket socket) {
		Scanner scanner;
		try {
			scanner = new Scanner(socket.getInputStream());
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
