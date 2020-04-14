package client;
import javax.swing.*;
import java.awt.*;

/**
 * main gui
 * @author Nicho
 *
 */
public class GUI extends JFrame {
	private JButton searchCourses;
	private JButton addCourse;
	private JButton removeCourse;
	private JButton viewAllCourses;
	private JButton viewStudentCourses;
	private JButton exit;
	private JTextArea theText;
	private JScrollPane scroll;
	private JFrame theFrame;
	private JPanel southPanel;
	private JPanel masterPanel;
	private Client theClient;
	//private RegistrationApp registrationApp;

	
	public GUI(Client c) {
		setTheClient(c);
		//registrationApp = theregistrationApp;
		searchCourses = new JButton("Search Courses");
		addCourse = new JButton("Add Course");
		removeCourse = new JButton("Remove Course");
		viewAllCourses = new JButton("View Course Catalog");
		viewStudentCourses = new JButton("View Your Courses");
		exit = new JButton("Exit");
		theText = new JTextArea();
		scroll = new JScrollPane(theText);
		
//		insert.addActionListener(theListener);
//		find.addActionListener(theListener);
//		browse.addActionListener(theListener);
//		readFile.addActionListener(theListener);
		viewAllCourses.addActionListener(new ViewAllCourses(this));
		exit.addActionListener(new ExitButton(this));
		viewStudentCourses.addActionListener(new ViewStudentCourses(this));
		addCourse.addActionListener(new AddCourse(this));
		searchCourses.addActionListener(new SearchCourse(this));
		removeCourse.addActionListener(new RemoveCourse(this));
		
		
		theFrame = new JFrame("An application to maintain student Records");
		theFrame.setSize(800,800);
		
		masterPanel = new JPanel();
		masterPanel.setLayout(new BorderLayout());
		
		southPanel = new JPanel();
		southPanel.setLayout(new FlowLayout());
		
		masterPanel.add(southPanel, BorderLayout.PAGE_END);
		masterPanel.add(scroll,BorderLayout.CENTER);
		
		southPanel.add(searchCourses);
		southPanel.add(addCourse);
		southPanel.add(removeCourse);
		southPanel.add(viewAllCourses);
		southPanel.add(viewStudentCourses);
		southPanel.add(exit);
		
		theFrame.setContentPane(masterPanel);
		theFrame.setVisible(true);
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}


	public JButton getSearchCourses() {
		return searchCourses;
	}


	public void setSearchCourses(JButton searchCourses) {
		this.searchCourses = searchCourses;
	}


	public JButton getAddCourse() {
		return addCourse;
	}


	public void setAddCourse(JButton addCourse) {
		this.addCourse = addCourse;
	}


	public JButton getRemoveCourse() {
		return removeCourse;
	}


	public void setRemoveCourse(JButton removeCourse) {
		this.removeCourse = removeCourse;
	}


	public JButton getViewAllCourses() {
		return viewAllCourses;
	}


	public void setViewAllCourses(JButton viewAllCourses) {
		this.viewAllCourses = viewAllCourses;
	}


	public JButton getViewStudentCourses() {
		return viewStudentCourses;
	}


	public void setViewStudentCourses(JButton viewStudentCourses) {
		this.viewStudentCourses = viewStudentCourses;
	}


	public JButton getExit() {
		return exit;
	}


	public void setExit(JButton exit) {
		this.exit = exit;
	}


	public JTextArea getTheText() {
		return theText;
	}


	public void setTheText(JTextArea theText) {
		this.theText = theText;
	}


	public JScrollPane getScroll() {
		return scroll;
	}


	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}


	public JFrame getTheFrame() {
		return theFrame;
	}


	public void setTheFrame(JFrame theFrame) {
		this.theFrame = theFrame;
	}


	public JPanel getSouthPanel() {
		return southPanel;
	}


	public void setSouthPanel(JPanel southPanel) {
		this.southPanel = southPanel;
	}


	public JPanel getMasterPanel() {
		return masterPanel;
	}


	public void setMasterPanel(JPanel masterPanel) {
		this.masterPanel = masterPanel;
	}


	public Client getTheClient() {
		return theClient;
	}


	public void setTheClient(Client theClient) {
		this.theClient = theClient;
	}


//	public RegistrationApp getRegistrationApp() {
//		return registrationApp;
//	}
//
//
//	public void setRegistrationApp(RegistrationApp registrationApp) {
//		this.registrationApp = registrationApp;
//	}
	
	//basic getters and setters.
	
	



}
