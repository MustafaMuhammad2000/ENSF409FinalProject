
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class SearchCourse implements ActionListener{

	private GUI gui;
	private SearchCourseGUI coursegui;
	
	public SearchCourse (GUI thegui){
		gui = thegui;
	}
	public void actionPerformed(ActionEvent e) {
		coursegui = new SearchCourseGUI(gui);
	}


	public GUI getGui() {
		return gui;
	}
	public void setGui(GUI gui) {
		this.gui = gui;
	}
	
	
	

	
}