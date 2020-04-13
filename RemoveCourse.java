
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class RemoveCourse implements ActionListener{

	private GUI gui;
	private RemoveCourseGUI coursegui;
	
	public RemoveCourse (GUI thegui){
		gui = thegui;
	}
	public void actionPerformed(ActionEvent e) {
		coursegui = new RemoveCourseGUI(gui);
	}


	public GUI getGui() {
		return gui;
	}
	public void setGui(GUI gui) {
		this.gui = gui;
	}
	
	
	

	
}