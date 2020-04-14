package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitButton implements ActionListener {
	GUI thegui;
	
	public ExitButton(GUI gui) {
		thegui = gui;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		thegui.getTheClient().getSocketOut().println("6");
		System.exit(0);	
		
	}

}
