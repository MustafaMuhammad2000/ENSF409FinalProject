import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewStudentCourses implements ActionListener{

	private GUI gui;
	
	ViewStudentCourses (GUI thegui){
		gui = thegui;
	}
	public void actionPerformed(ActionEvent e) {
		String s = gui.getRegistrationApp().getStudent().printStudentCourses();
		gui.getTheText().removeAll();
		System.out.println(s);
		gui.getTheText().setText(s);
		
	}

}