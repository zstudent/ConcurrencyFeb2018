package experiments;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class EchoServer {

	public static void main(String[] args) {

		System.out.println("start");

		try {
			ServerSocket serverSocket = new ServerSocket(10000);
			while (true) {
				processServerSocketConnections(serverSocket);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void processServerSocketConnections(
			ServerSocket serverSocket) {
		try {
			Socket socket = serverSocket.accept();
			new Thread(() -> processConnection(socket)).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

	public static void processConnection(Socket socket) {
		try {
			System.out.println("got it! " + socket);
			OutputStream outputStream = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(outputStream);

			Runnable sendHeartBeat = () -> {
				pw.println("hello!  time is " + new Date());
				pw.flush();
			};
			
			service.scheduleAtFixedRate(sendHeartBeat, 0, 3, TimeUnit.SECONDS);

			Scanner scanner = new Scanner(socket.getInputStream());

			while (scanner.hasNextLine()) {
				String nextLine = scanner.nextLine();
				System.out.println(socket.getInetAddress() + " >> " + nextLine);
				pw.println(nextLine);
				pw.flush();
			}

			socket.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
