package client;
import java.io.*;
import java.net.*;

public class Client {
	private Socket aSocket;
	private PrintWriter socketOut;
	private BufferedReader socketIn;
	private GUI gui;
	
	
	public Client(String serverName, int portNumber) {
		try {
			aSocket = new Socket(serverName, portNumber);
			setSocketIn(new BufferedReader(new InputStreamReader(aSocket.getInputStream())));
			setSocketOut(new PrintWriter(aSocket.getOutputStream(), true));
			setGui(new GUI(this));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public String readServerInput() {
		try {
			String read = "";
			while(true) {
				read += socketIn.readLine();
				read += "\n";
				if(read.contains("\0")) {
					read = read.replace("\0", "");
					System.out.println(read);
					break;
				}
			}
			return read;
		}catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public PrintWriter getSocketOut() {
		return socketOut;
	}

	public void setSocketOut(PrintWriter socketOut) {
		this.socketOut = socketOut;
	}

	public BufferedReader getSocketIn() {
		return socketIn;
	}

	public void setSocketIn(BufferedReader socketIn) {
		this.socketIn = socketIn;
	}
	
	public GUI getGui() {
		return gui;
	}

	public void setGui(GUI gui) {
		this.gui = gui;
	}
	
	public static void main(String[] args) {
		Client theClient = new Client("localhost",31415);
	}


}
