package registration;
import java.util.Scanner;

/**
 * the front end of the system, i didnt see make a front end class till way later
 * @author Nicholas Lee
 *
 */
public class RegistrationApp {
	//private Scanner scan;
	private Student student;
	private CourseCatalogue cat;
	
	public RegistrationApp() {
		//scan = new Scanner(System.in);
		cat = new CourseCatalogue();
		student = new Student("Nick", 30061802);  
	}
	

//	public void printMenu() {
//		System.out.println();
//		System.out.println("1. Search course catalogue.");
//		System.out.println("2. Add course to student courses.");
//		System.out.println("3. Remove course form student courses.");
//		System.out.println("4. View all courses in catalogue.");
//		System.out.println("5. View all courses taken by student.");
//		System.out.println("6. Quit."); 
//		System.out.println();
//	}
	
//	public void Menu() {
//		while(true) {
//			System.out.println("Pick one of the choices below:");
//			printMenu();
//			int choice = scan.nextInt();
//			scan.nextLine();
//			switch(choice) {
//				case 1:
//					findCourse();
//					break;
//				case 2:
//					addCourse();
//					break;
//				case 3:
//					removeCourse();
//					break;
//				case 4:
//					viewAllCourses();
//					break;
//				case 5:
//					viewStudentCourses();
//					break;
//				case 6:
//					System.out.println("\nSystem shutting down...Bye!");
//					System.exit(0);
//				default:
//					System.out.println("Invalid input, Try another one.");
//					break;
//			}
//		}
//	}
	public String viewStudentCourses() {
		return student.printStudentCourses();
	}
	
	public void printCourse(Course course) {
		if(course == null) {
			System.out.println("course not found");
			return;
		}
		System.out.println(course.getCourseName() +" "+ course.getCourseNum());
	}
	
	public String findCourse(String name, int id){
		String result = "";
		Course course = cat.searchCat(name, id);
		if(course!= null)
			result = course.toString();
		else
			result = "The course "+name+" "+id+" was not found in the catalogue";
		result += "\0";
		return result;
	}
	
	public String addCourse(Course course, int sec) {
		if(course != null)
			return student.addCourse(course, sec)+"\0";
		else
			return "The course specified was not found\0";
	}
	
	public String removeCourse(String name, int id) {
		String result = student.removeCourse(name, id);
		result+="\0";
		return result;
	}
	
	public String viewAllCourses() {
		return cat.toString();
	}


	public CourseCatalogue getCat() {
		return cat;
	}


	public void setCat(CourseCatalogue cat) {
		this.cat = cat;
	}

}
