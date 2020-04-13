import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewAllCourses implements ActionListener{

	private GUI gui;
	
	ViewAllCourses (GUI thegui){
		gui = thegui;
	}
	public void actionPerformed(ActionEvent e) {
		String s = gui.getRegistrationApp().getCat().toString();
		gui.getTheText().removeAll();
		System.out.println(s);
		gui.getTheText().setText(s);
		
	}

}
