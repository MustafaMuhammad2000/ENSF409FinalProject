package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewStudentCourses implements ActionListener {

	private GUI gui;
	
	ViewStudentCourses (GUI thegui){
		gui = thegui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = "";
		gui.getTheClient().getSocketOut().println("2");
		
		s = gui.getTheClient().readServerInput();
		
		gui.getTheText().removeAll();
		System.out.println(s);
		gui.getTheText().setText(s);
	}

}
