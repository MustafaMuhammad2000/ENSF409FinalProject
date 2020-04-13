import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Student {
	
	private String studentName;
	private int studentId;
	private ArrayList<CourseOffering> offeringList;
	private ArrayList<Registration> studentRegList;
	private Scanner scan;
	
	public Student (String studentName, int studentId) {
		this.setStudentName(studentName);
		this.setStudentId(studentId);
		studentRegList = new ArrayList<Registration>();
		offeringList = new ArrayList<CourseOffering>();
		scan = new Scanner(System.in);
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	public ArrayList<CourseOffering> getOfferingList() {
		return offeringList;
	}
	
	@Override
    public String toString () {
		String st = "Student Name: " + getStudentName() + "\n" +
				"Student Id: " + getStudentId() + "\n\n";
		return st;
	}

	public void addRegistration(Registration registration) {
		// TODO Auto-generated method stub
		studentRegList.add(registration);
	}
	
	public void removeRegistration(Registration registration) {
		// TODO Auto-generated method stub
		studentRegList.remove(registration);
	}
	
	public void addCourseOffering(CourseOffering course) {
		offeringList.add(course);
	}
	
	public void removeCourseOffering(CourseOffering course) {
		offeringList.remove(course);
	}
	
	public CourseOffering searchForCourse(String name, int id) {
		for(CourseOffering x : offeringList) {
			if(x.getTheCourse().getCourseName().equals(name)) {
				if(x.getTheCourse().getCourseNum() == id) {
					return x;
				}
			}
		}
		return null;
	}

	public Registration searchRegistrar(String name, int id) {
		for(Registration x : studentRegList) {
			if(x.getTheOffering().getTheCourse().getCourseName() == name) {
				if(x.getTheOffering().getTheCourse().getCourseNum() == id) {
					return x;
				}
			}
		}
		return null;
	}

	public String printStudentCourses() {
		String s = "";
		if(offeringList.size() == 0) {
			return("student is not enrolled in any courses yet");
			
		}
		for(CourseOffering x: offeringList) {
			s += x +"\n";
		}
		return s;
	}
	
	public void addCourse(Course course, GUI gui) {
		if(course.checkMinClassSize() == false) {
			String s = course.getCourseName()+" " + course.getCourseNum()+" is not available as minimum class size was not achieved.";
			gui.getTheText().removeAll();
			System.out.println(s);
			gui.getTheText().setText(s);
			return;
		}
		if(course.checkStudentPrereq(this) == false) {
			String s = "Student is missing prerequisites.";
			gui.getTheText().removeAll();
			System.out.println(s);
			gui.getTheText().setText(s);
			return;
		}
	
		gui.getTheText().removeAll();
		System.out.println(course.toString());
		gui.getTheText().setText(course.toString());
		int sec = Integer.parseInt(JOptionPane.showInputDialog("Enter the lecture section"));
		
		if(course.getCourseOfferingAt(sec-1) == null) { // -1 cuz its a array list
			String s = "the section entered is not available";
			gui.getTheText().removeAll();
			System.out.println(s);
			gui.getTheText().setText(s);
			return;
		}
		Registration R = new Registration();
		R.completeRegistration(this, course.getCourseOfferingAt(sec-1));
		
		course.getCourseOfferingAt(sec-1).addRegistration(R);
		course.getCourseOfferingAt(sec-1).addStudent(this);
		this.addCourseOffering(course.getCourseOfferingAt(sec-1));
		
		String s = "Course Succussfully added.";
		gui.getTheText().removeAll();
		System.out.println(s);
		gui.getTheText().setText(s);
		
	}

	public void removeCourse(String thename, int theid, GUI gui) {
		String name = thename;
		int id = theid;
		CourseOffering courseoffering;
		
		courseoffering = this.searchForCourse(name, id);
		if(courseoffering == null) {
			String s ="Course not found";
			gui.getTheText().removeAll();
			System.out.println(s);
			gui.getTheText().setText(s);
			return;
		}
		String s ="student removed from course";
		
		gui.getTheText().removeAll();
		System.out.println(s);
		gui.getTheText().setText(s);
		
		this.removeCourseOffering(courseoffering);
		Registration R = this.searchRegistrar(name, id);
		this.removeRegistration(R);
		courseoffering.removeRegistration(R);
		courseoffering.removeStudent(this);
	}
	
	public boolean checkIfMaxCourses() {
		

		if(offeringList.size() < 8)
			return true;
		return false;
		
	}


}
