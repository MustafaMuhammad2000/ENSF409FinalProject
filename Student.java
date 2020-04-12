import java.util.ArrayList;
import java.util.Scanner;

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

	public void printStudentCourses() {
		if(offeringList.size() == 0) {
			System.out.println("student is not enrolled in any courses yet");
			return;
		}
		for(CourseOffering x: offeringList) {
			System.out.println(x);
		}
	}
	
	public void addCourse(Course course) {
		if(course.checkMinClassSize() == false) {
			System.out.println(course.getCourseName()+" " + course.getCourseNum()+" is not available as minimum class size was not achieved.");
			return;
		}
		if(course.checkStudentPrereq(this) == false) {
			System.out.println("Student is missing prerequisites.");
			return;
		}
		System.out.println(course);
		System.out.println("Enter the lecture section");
		int sec =scan.nextInt();
		if(course.getCourseOfferingAt(sec-1) == null) { // -1 cuz its a array list
			System.out.println("the section entered is not available");
			scan.nextLine();
			return;
		}
		Registration R = new Registration();
		R.completeRegistration(this, course.getCourseOfferingAt(sec-1));
		
		course.getCourseOfferingAt(sec-1).addRegistration(R);
		course.getCourseOfferingAt(sec-1).addStudent(this);
		this.addCourseOffering(course.getCourseOfferingAt(sec-1));
		System.out.println("Course Succussfully added.");
		scan.nextLine();
	}

	public void removeCourse() {
		String name = "";
		int id = 0;
		CourseOffering courseoffering;
		
		System.out.println("Please enter course name to be removed");
		name = scan.nextLine().toUpperCase();
		System.out.println("Please enter course number to be removed");
		id = scan.nextInt();
		
		courseoffering = this.searchForCourse(name, id);
		if(courseoffering == null) {
			System.out.println("Course not found");
			return;
		}
		System.out.println("student removed from course");
		this.removeCourseOffering(courseoffering);
		Registration R = this.searchRegistrar(name, id);
		this.removeRegistration(R);
		courseoffering.removeRegistration(R);
		courseoffering.removeStudent(this);
		scan.nextLine();
	}
	
	public boolean checkIfMaxCourses() {
		

		if(offeringList.size() < 8)
			return true;
		return false;
		
	}


}
