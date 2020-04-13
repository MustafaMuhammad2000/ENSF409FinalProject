import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class AddCourse implements ActionListener{

	private GUI gui;
	private AddCourseGUI coursegui;
	
	public AddCourse (GUI thegui){
		gui = thegui;
	}
	public void actionPerformed(ActionEvent e) {
		coursegui = new AddCourseGUI(gui);
	}


	public GUI getGui() {
		return gui;
	}
	public void setGui(GUI gui) {
		this.gui = gui;
	}
	public AddCourseGUI getCoursegui() {
		return coursegui;
	}
	public void setCoursegui(AddCourseGUI coursegui) {
		this.coursegui = coursegui;
	}
	

	
}