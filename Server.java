package server;
import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import client.GUI;
import registration.*;

public class Server {
	private ServerSocket serverSocket;

	private ExecutorService pool;
	
	
	public Server(int portNumber) {
		try {
			serverSocket = new ServerSocket(portNumber);
//			System.out.println("Server is on and running\nwaiting for client...");
//			aSocket = serverSocket.accept();
//			System.out.println("Connection accepted from client, now connected");

			
			pool = Executors.newCachedThreadPool();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void connectWithClient()  {
		try {
			while(true) {
				System.out.println("awaiting client connection...");
				ServerController sc = new ServerController(serverSocket.accept());
				System.out.println("client connected!");
				pool.execute(sc);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}


	
	

	public static void main(String[] args) {
		Server theServer = new Server(31415);
		theServer.connectWithClient();
		
	}

}
