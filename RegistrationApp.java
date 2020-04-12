import java.util.Scanner;

/**
 * the front end of the system, i didnt see make a front end class till way later
 * @author Nicholas Lee
 *
 */
public class RegistrationApp {
	private Scanner scan;
	private Student student;
	private CourseCatalogue cat;
	
	public RegistrationApp() {
		scan = new Scanner(System.in);
		cat = new CourseCatalogue();
		student = new Student("Nick", 30061802);  
	}
	

	public void printMenu() {
		System.out.println();
		System.out.println("1. Search course catalogue.");
		System.out.println("2. Add course to student courses.");
		System.out.println("3. Remove course form student courses.");
		System.out.println("4. View all courses in catalogue.");
		System.out.println("5. View all courses taken by student.");
		System.out.println("6. Quit."); 
		System.out.println();
	}
	
	public void Menu() {
		while(true) {
			System.out.println("Pick one of the choices below:");
			printMenu();
			int choice = scan.nextInt();
			scan.nextLine();
			switch(choice) {
				case 1:
					findCourse();
					break;
				case 2:
					addCourse();
					break;
				case 3:
					removeCourse();
					break;
				case 4:
					viewAllCourses();
					break;
				case 5:
					viewStudentCourses();
					break;
				case 6:
					System.out.println("\nSystem shutting down...Bye!");
					System.exit(0);
				default:
					System.out.println("Invalid input, Try another one.");
					break;
			}
		}
	}
	private void viewStudentCourses() {
		student.printStudentCourses();
	}
	
	private void printCourse(Course course) {
		if(course == null) {
			System.out.println("course not found");
			return;
		}
		System.out.println(course.getCourseName() +" "+ course.getCourseNum());
	}
	
	private void findCourse(){
		System.out.println("Please enter course name: ");
		String name = scan.nextLine().toUpperCase();
		System.out.println("Please enter course number: ");
		int id = scan.nextInt();
		printCourse(cat.searchCat(name, id));
	}
	
	private void addCourse() {
		System.out.println("Please enter course name: ");
		String name = scan.nextLine().toUpperCase();
		System.out.println("Please enter course number: ");
		int id = scan.nextInt();
		Course course = cat.searchCat(name, id);
		
		if(course == null) {
			System.out.println("course not found");
			return;
		}
		student.addCourse(course);
	}
	
	private void removeCourse() {
		student.removeCourse();
	}
	
	private void viewAllCourses() {
		System.out.println(cat);
	}
	
	public static void main (String [] args) {
		RegistrationApp RA = new RegistrationApp();
		RA.Menu();

		
	}

}
