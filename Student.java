package registration;
import java.util.ArrayList;
import java.util.Scanner;

public class Student {
	
	private String studentName;
	private int studentId;
	private ArrayList<CourseOffering> offeringList;
	private ArrayList<Registration> studentRegList;

	
	public Student (String studentName, int studentId) {
		this.setStudentName(studentName);
		this.setStudentId(studentId);
		studentRegList = new ArrayList<Registration>();
		offeringList = new ArrayList<CourseOffering>();

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
			s += "student is not enrolled in any courses yet";
			s += "\0";
			return s;
		}
		for(CourseOffering x: offeringList) {
			s += x;
		}
		s+="\0";
		return s;
	}
	
	public String addCourse(Course course, int sec) {
		String s = "";
		if(course.checkMinClassSize() == false) {
			s += course.getCourseName()+" " + course.getCourseNum()+" is not available as minimum class size was not achieved.\n";
			return s;
		}
		if(course.checkStudentPrereq(this) == false) {
			s += "Student is missing prerequisites.\n";
			return s;
		}
		System.out.println(course);

		if(course.getCourseOfferingAt(sec-1) == null) { // -1 cuz its a array list
			s += "The section entered is not available\n";
			return s;
		}
		Registration R = new Registration();
		R.completeRegistration(this, course.getCourseOfferingAt(sec-1));
		
		course.getCourseOfferingAt(sec-1).addRegistration(R);
		course.getCourseOfferingAt(sec-1).addStudent(this);
		this.addCourseOffering(course.getCourseOfferingAt(sec-1));
		s += "Course Succussfully added.\n";
		return s;
	}

	public String removeCourse(String name, int id) {
		String s = "";
		CourseOffering courseoffering;
		
		courseoffering = this.searchForCourse(name, id);
		if(courseoffering == null) {
			s += "Course not found\n";
			return s;
		}
		s += "student removed from course\n";
		this.removeCourseOffering(courseoffering);
		Registration R = this.searchRegistrar(name, id);
		this.removeRegistration(R);
		courseoffering.removeRegistration(R);
		courseoffering.removeStudent(this);
		return s;
	}
	
	public boolean checkIfMaxCourses() {
		

		if(offeringList.size() < 8)
			return true;
		return false;
		
	}


}
