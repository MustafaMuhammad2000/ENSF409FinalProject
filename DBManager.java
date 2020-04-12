import java.util.ArrayList;

//This class is simulating a database for our
//program
public class DBManager {
	
	ArrayList <Course> courseList;

	public DBManager () {
		courseList = new ArrayList<Course>();
	}

	public ArrayList<Course> readFromDataBase() {        
		
		Student chad = new Student("chad", 3000);
		Student brad = new Student("brad", 3001);
		Student  nick = new Student("nick", 3002);
		Student stacy = new Student("stacy", 3003);
		Student ken = new Student("ken", 3004);
		Student bob = new Student("bob", 3005);
		Student kid = new Student("kid", 3006);
		Student dog = new Student("dog", 3007);
		Student cat = new Student("cat", 3008);
		Student sara = new Student("sara", 3009);
		
		
		courseList.add(new Course ("ENGG", 233));
		courseList.get(0).addOffering(new CourseOffering(1, 50));
		courseList.get(0).addOffering(new CourseOffering(2, 50));
		courseList.get(0).addOffering(new CourseOffering(3, 50));
		courseList.get(0).addOffering(new CourseOffering(4, 50));	
		courseList.get(0).getCourseOfferingAt(0).addStudent(chad);
		courseList.get(0).getCourseOfferingAt(0).addStudent(brad);
		courseList.get(0).getCourseOfferingAt(1).addStudent(nick);
		courseList.get(0).getCourseOfferingAt(1).addStudent(stacy);
		courseList.get(0).getCourseOfferingAt(1).addStudent(ken);
		courseList.get(0).getCourseOfferingAt(2).addStudent(bob);
		courseList.get(0).getCourseOfferingAt(2).addStudent(kid);
		courseList.get(0).getCourseOfferingAt(3).addStudent(dog);
		courseList.get(0).getCourseOfferingAt(3).addStudent(cat);
		courseList.get(0).getCourseOfferingAt(3).addStudent(sara);
		
		
		courseList.add(new Course ("PHYS", 259));
		courseList.get(1).addOffering(new CourseOffering(1, 150));
		courseList.get(1).addOffering(new CourseOffering(2, 150));
		courseList.get(1).addOffering(new CourseOffering(3, 150));
		courseList.get(1).addOffering(new CourseOffering(4, 150));	
		courseList.get(0).getCourseOfferingAt(0).addStudent(chad);
		courseList.get(0).getCourseOfferingAt(0).addStudent(brad);
		courseList.get(0).getCourseOfferingAt(1).addStudent(nick);
		courseList.get(0).getCourseOfferingAt(1).addStudent(stacy);
		courseList.get(0).getCourseOfferingAt(1).addStudent(ken);
		courseList.get(0).getCourseOfferingAt(1).addStudent(bob);
		courseList.get(0).getCourseOfferingAt(2).addStudent(kid);
		courseList.get(0).getCourseOfferingAt(2).addStudent(dog);
		courseList.get(0).getCourseOfferingAt(3).addStudent(cat);
		courseList.get(0).getCourseOfferingAt(3).addStudent(sara);
		
		
		courseList.add(new Course ("PHYS", 365));
		courseList.get(2).addOffering(new CourseOffering(1, 150));
		courseList.get(2).addOffering(new CourseOffering(2, 150));
		courseList.get(0).getCourseOfferingAt(0).addStudent(chad);
		courseList.get(0).getCourseOfferingAt(0).addStudent(brad);
		courseList.get(0).getCourseOfferingAt(1).addStudent(nick);
		courseList.get(0).getCourseOfferingAt(1).addStudent(stacy);
		courseList.get(0).getCourseOfferingAt(1).addStudent(ken);
		courseList.get(0).getCourseOfferingAt(0).addStudent(bob);
		courseList.get(0).getCourseOfferingAt(1).addStudent(kid);
		courseList.get(0).getCourseOfferingAt(0).addStudent(dog);
		courseList.get(0).getCourseOfferingAt(1).addStudent(cat);
		courseList.get(0).getCourseOfferingAt(0).addStudent(sara);
		
		
		
		return courseList;
	}

}
