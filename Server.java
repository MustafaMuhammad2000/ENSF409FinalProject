package server;
import java.io.*;
import java.net.*;

import client.GUI;
import registration.*;

public class Server {
	private ServerSocket serverSocket;
	private Socket aSocket;
	private BufferedReader socketIn;
	private PrintWriter socketOut;
	private RegistrationApp registration;
	
	public Server(int portNumber) {
		try {
			serverSocket = new ServerSocket(portNumber);
			System.out.println("Server is on and running\nwaiting for client...");
			aSocket = serverSocket.accept();
			System.out.println("Connection accepted from client, now connected");
			socketIn = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
			socketOut = new PrintWriter(aSocket.getOutputStream(), true);
			registration = new RegistrationApp();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public RegistrationApp getRegisteration() {
		return registration;
	}

	public void setRegisteration(RegistrationApp registration) {
		this.registration = registration;
	}

	private void recieveCommad() {
		int choice;
		while(true) {
			while(true) {
				try {
					choice = Integer.parseInt(socketIn.readLine());
					 break;
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			switch(choice) {
				case 1:
					printCatalogue();
					break;
				case 2:
					viewCoursesTaken();
					break;
				case 3:
					searchForCourse();
					break;
				case 4:
					addCourse();
					break;
				case 5:
					removeCourse();
					break;
				case 6:
					return;
				
			}
			
		}
		
	}
	
	private void removeCourse() {
		String input="";
		try {
			input = socketIn.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		String [] course = input.split(";");
		String output = registration.removeCourse(course[0], Integer.parseInt(course[1]));
		socketOut.println(output);
		
		
	}

	private void addCourse() {
		String input="";
		try {
			input = socketIn.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		String [] course = input.split(";");
		Course theCourse = registration.getCat().searchCat(course[0], Integer.parseInt(course[1]));
		String result = "";
		result = theCourse.toString();
		socketOut.println(result + "\0");
		int sec = 0;
		
		try {
			sec = Integer.parseInt(socketIn.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		result = registration.addCourse(theCourse, sec);
		
		socketOut.println(result);
		
	}

	private void searchForCourse() {
		String input="";
		try {
			input = socketIn.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		String [] course = input.split(";");
		String output = registration.findCourse(course[0], Integer.parseInt(course[1]));
		socketOut.println(output);
		
	}

	private void viewCoursesTaken() {
		socketOut.println(registration.viewStudentCourses());
		
	}

	private void printCatalogue() {
		socketOut.println(registration.viewAllCourses());
	}

	public static void main(String[] args) {
		Server theServer = new Server(31415);
		theServer.recieveCommad();
	}

}
