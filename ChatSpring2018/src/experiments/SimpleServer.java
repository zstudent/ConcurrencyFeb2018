package experiments;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class SimpleServer {
	
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

	public static void processServerSocketConnections(ServerSocket serverSocket) {
		try {
			Socket socket  = serverSocket.accept();
			processConnection(socket);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void processConnection(Socket socket) throws IOException {
		System.out.println("got it! " + socket);
		OutputStream outputStream = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(outputStream);
		
		pw.println("hello!  time is " + new Date() );
		pw.flush();
		
		socket.close();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
