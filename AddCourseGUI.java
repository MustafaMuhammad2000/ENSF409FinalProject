package client;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class AddCourseGUI {
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
	
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == next) {
				gui.getTheClient().getSocketOut().println("4");
				getFrame().dispatchEvent(new WindowEvent(getFrame(), WindowEvent.WINDOW_CLOSING));
				String name = getCourseName().getText().toUpperCase();
				int id = Integer.parseInt(getCourseID().getText());
				
				gui.getTheClient().getSocketOut().println(courseName.getText().toUpperCase()+";"+ courseID.getText());
				String course = gui.getTheClient().readServerInput();
				
				if(course.contains("not")) {
					gui.getTheText().removeAll();
					System.out.println("Course not found");
					JOptionPane.showMessageDialog(new JFrame(), "Course not found");
					return;
				}
				
				String section = JOptionPane.showInputDialog(new JFrame(), "Please select a section number from the follwing sections\n"+ course,
						"Section Select", JOptionPane.PLAIN_MESSAGE);
				
				gui.getTheClient().getSocketOut().println(section);
				String result = gui.getTheClient().readServerInput();
				JOptionPane.showMessageDialog(new JFrame(), result);
				
				
			}
			else if(e.getSource() == cancel) {
				getFrame().dispatchEvent(new WindowEvent(getFrame(), WindowEvent.WINDOW_CLOSING));
			}
		}


	}
	public AddCourseGUI(GUI thegui) {

		gui = thegui;
		next = new JButton("Next");
		cancel = new JButton("Cancel");

		next.addActionListener(new AddingTheCourse());
		cancel.addActionListener(new AddingTheCourse());

		JLabel a = new JLabel("Please fill out fields");
		JLabel b = new JLabel("Course Name: ");
		JLabel c = new JLabel("Course ID: ");

		courseName = new JTextField(20);
		courseID = new JTextField(20);

		frame = new JFrame("Courses");
		frame.setSize(350,200);

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


