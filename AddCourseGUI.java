import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
/**
 * gui for getting info from user about a particular course they are interested in
 */
public class AddCourseGUI extends JFrame {
	private GUI gui;
	private JButton next;
	private JButton cancel;
	private JPanel masterPanel;
	private JPanel north;
	private JPanel south;
	private JPanel centre;
	private JFrame frame;
	private JTextField courseName;
	private JTextField courseID;
	
	/**
	 * for second gui
	 * @author Nicho
	 *
	 */
	public class AddingTheCourse implements ActionListener{
		private GUI gui;
		private AddCourseGUI coursegui;
		
		public AddingTheCourse(GUI thegui, AddCourseGUI thecoursegui){
			gui = thegui;
			coursegui = thecoursegui;
		}

		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == coursegui.getNext()) {
				coursegui.getFrame().dispatchEvent(new WindowEvent(coursegui.getFrame(), WindowEvent.WINDOW_CLOSING));
				String name = coursegui.getCourseName().getText().toUpperCase();
				int id = Integer.parseInt(coursegui.getCourseID().getText());
				
				Course course = gui.getRegistrationApp().getCat().searchCat(name, id);
				
				if(course == null) {
					gui.getTheText().removeAll();
					System.out.println("Course not found");
					gui.getTheText().setText("Course not found");
					return;
				}
				gui.getRegistrationApp().getStudent().addCourse(course,gui);
				
			}
			else if(e.getSource() == coursegui.getCancel()) {
				coursegui.getFrame().dispatchEvent(new WindowEvent(coursegui.getFrame(), WindowEvent.WINDOW_CLOSING));
			}
			
		}
		
		
		
	}
	
	public AddCourseGUI(GUI thegui) {
		
		gui = thegui;
		next = new JButton("Next");
		cancel = new JButton("Cancel");
		
		next.addActionListener(new AddingTheCourse(gui,this));
		cancel.addActionListener(new AddingTheCourse(gui,this));
		
		JLabel a = new JLabel("Please fill out fields");
		JLabel b = new JLabel("Course Name: ");
		JLabel c = new JLabel("Course ID: ");
		
		courseName = new JTextField(20);
		courseID = new JTextField(20);
		
		frame = new JFrame("Courses");
		frame.setSize(200,200);
		
		masterPanel = new JPanel();
		masterPanel.setLayout(new BorderLayout());
		
		north = new JPanel();
		north.setLayout(new FlowLayout());
		
		centre = new JPanel();
		centre.setLayout(new FlowLayout());
		
		south = new JPanel();
		south.setLayout(new FlowLayout());
		
		north.add(a);
		
		centre.add(b);
		centre.add(courseName);
		
		centre.add(c);
		centre.add(courseID);
		
		south.add(next);
		south.add(cancel);
		
		
		masterPanel.add(north, BorderLayout.PAGE_START);
		masterPanel.add(centre, BorderLayout.CENTER);
		masterPanel.add(south, BorderLayout.PAGE_END);
		
		frame.setContentPane(masterPanel);
		frame.setVisible(true);
		
	}

	public JButton getNext() {
		return next;
	}

	public void setNext(JButton next) {
		this.next = next;
	}

	public JButton getCancel() {
		return cancel;
	}

	public void setCancel(JButton cancel) {
		this.cancel = cancel;
	}

	public JPanel getMasterPanel() {
		return masterPanel;
	}

	public void setMasterPanel(JPanel masterPanel) {
		this.masterPanel = masterPanel;
	}

	public JPanel getNorth() {
		return north;
	}

	public void setNorth(JPanel north) {
		this.north = north;
	}

	public JPanel getSouth() {
		return south;
	}

	public void setSouth(JPanel south) {
		this.south = south;
	}

	public JPanel getCentre() {
		return centre;
	}

	public void setCentre(JPanel centre) {
		this.centre = centre;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getCourseName() {
		return courseName;
	}

	public void setCourseName(JTextField courseName) {
		this.courseName = courseName;
	}

	public JTextField getCourseID() {
		return courseID;
	}

	public void setCourseID(JTextField courseID) {
		this.courseID = courseID;
	}
	
	//basic getters and setters
	



}
