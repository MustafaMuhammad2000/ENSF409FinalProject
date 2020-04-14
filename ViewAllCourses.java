package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ViewAllCourses implements ActionListener {
	
	private GUI gui;
	
	ViewAllCourses (GUI thegui){
		gui = thegui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = "";
		gui.getTheClient().getSocketOut().println("1");
		
		s = gui.getTheClient().readServerInput();
		
		gui.getTheText().removeAll();
		System.out.println(s);
		gui.getTheText().setText(s);

	}

}
