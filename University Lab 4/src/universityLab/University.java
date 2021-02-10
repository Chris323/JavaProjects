package universityLab;

import java.util.ArrayList;
import java.util.Scanner;

public class University {
	private ArrayList<Student> pupils = new ArrayList<>();
	private ArrayList<FacultyMember> professor = new ArrayList<>();
	private ArrayList<Course> lecture = new ArrayList<>();
	boolean choice = true;
	Scanner input = new Scanner(System.in);

	public void monitor() {
		int choices = 0;
		while (choice) {
			menuMonitor();
			System.out.println("Choose From Above : ");
			choices = input.nextInt();
			switch (choices) {
			case 1:
				studentOptions();
				break;
			case 2:
				professorOptions();
				break;
			case 3:
				courseOptions();
				break;
			case 4:
				quit();
				break;

			}

		}
	}

	private void menuMonitor() {
		System.out.println("(1) Are you a Student");
		System.out.println("(2) Are you a Faculty Member ");
		System.out.println("(3) Go to Courses ");
		System.out.println("(4) Quit Monitor ");
	}

	public void studentOptions() {
		int choices = 0;
		while (choice) {
			menuStudent();
			System.out.println("Choose From Above : ");
			choices = input.nextInt();
			switch (choices) {
			case 1:
				createStudent();
				break;
			case 2:
				deleteStudent(input);
				break;
			case 3:
				listStudents();
				break;
//			case 4:
//				addCourseToSchedule();
//				break;
//			case 5:
//				deleteCourseFromSchedule();
//				break;
			case 6:
				monitor();
				break;
			case 7:
				quit();
				break;

			}

		}
	}

	private void menuStudent() {
		System.out.println("(1) Would you like to add a Student");
		System.out.println("(2) Would you like to delete a Student ");
		System.out.println("(3) Would you like to list Students");
		System.out.println("(4) Would you like to add Student to course");
		System.out.println("(5) Would you like to delete a course from Schedule");
		System.out.println("(6) Previous Menu ");
		System.out.println("(7) Quit ");
	}

	public void createStudent() {
		String name = "";
		int streetNumber = 0;
		String streetName = "";
		String city = "";
		int postalCode = 0;
		String country = "";
		double gpa = 0;

		System.out.println("Please enter students name:");
		name = input.next();
		System.out.println("Please enter students address (number only):");
		streetNumber = input.nextInt();
		System.out.println("Please enter street name:");
		streetName = input.next();
		System.out.println("Please enter city:");
		city = input.next();
		System.out.println("Please enter postal code:");
		postalCode = input.nextInt();
		System.out.println("Please enter country:");
		country = input.next();
		System.out.println("Please enter student gpa:");
		gpa = input.nextDouble();

		Address studentAddress = new Address(streetNumber, streetName, city, postalCode, country);
		Student addedStudent = new Student(name, studentAddress, gpa);

		pupils.add(addedStudent);

	}

	private void deleteStudent(Scanner input) {
		if (pupils.isEmpty()) {
			System.out.println("The List Is Empty");
			return;
		}

		listStudents();
		String name;
		System.out.println("Enter the Id to delete ");
		name = input.next();
		for (int i = 0; i < pupils.size(); i++) {
			if (pupils.get(i).getName() == name) {
				pupils.remove(i);
			}
		}
	}

	private void listStudents() {
		if (pupils.isEmpty()) {
			System.out.println("The List Is Empty");
			return;
		}

		System.out.println("----------------------- Here are the students --------------------");
		for (int i = 0; i < pupils.size(); i++) {
			System.out.println(pupils.get(i));
		}
	}

	public void professorOptions() {
		int choices = 0;
		while (choice) {
			menuProfessor();
			System.out.println("Choose From Above : ");
			choices = input.nextInt();
			switch (choices) {
			case 1:
				createFacultyMember();
				break;
			case 2:
				deleteFacultyMember(input);
				break;
			case 3:
				listFacultyMembers();
				break;
//			case 4:
//				addCourseToSchedule();
//				break;
//			case 5:
//				deleteCourseFromSchedule();
//				break;
			case 6:
				monitor();
				break;
			case 7:
				quit();
				break;

			}

		}
	}

	private void menuProfessor() {
		System.out.println("(1) Would you like to add a Faculty Member");
		System.out.println("(2) Would you like to delete a Faculty Member ");
		System.out.println("(3) Would you like to list Faculty Members");
		System.out.println("(4) Would you like to add a Faculty Member to a course");
		System.out.println("(5) Would you like to delete a course from Schedule");
		System.out.println("(6) Previous Menu ");
		System.out.println("(7) Quit ");
	}

	public void createFacultyMember() {
		String name = "";
		int streetNumber = 0;
		String streetName = "";
		String city = "";
		int postalCode = 0;
		String country = "";
		int employeeId = 0;

		System.out.println("Please enter students name:");
		name = input.next();
		System.out.println("Please enter students address (number only):");
		streetNumber = input.nextInt();
		System.out.println("Please enter street name:");
		streetName = input.next();
		System.out.println("Please enter city:");
		city = input.next();
		System.out.println("Please enter postal code:");
		postalCode = input.nextInt();
		System.out.println("Please enter country:");
		country = input.next();
		System.out.println("Please enter student gpa:");
		employeeId = input.nextInt();

		Address facultyAddress = new Address(streetNumber, streetName, city, postalCode, country);
		FacultyMember addedFaculty = new FacultyMember(name, facultyAddress, employeeId);

		professor.add(addedFaculty);

	}

	private void deleteFacultyMember(Scanner input) {
		if (professor.isEmpty()) {
			System.out.println("The List Is Empty");
			return;
		}

		listFacultyMembers();
		int employeeId;
		System.out.println("Enter the Id to delete ");
		employeeId = input.nextInt();
		for (int i = 0; i < professor.size(); i++) {
			if (professor.get(i).getEmployeeId() == employeeId) {
				professor.remove(i);
			}
		}
	}

	private void listFacultyMembers() {
		if (professor.isEmpty()) {
			System.out.println("The List Is Empty");
			return;
		}

		System.out.println("----------------------- Here are the professors --------------------");
		for (int i = 0; i < professor.size(); i++) {
			System.out.println(professor.get(i));
		}
	}

	public void courseOptions() {
		int choices = 0;
		while (choice) {
			menuCourse();
			System.out.println("Choose From Above : ");
			choices = input.nextInt();
			switch (choices) {
			case 1:
				createACourse();
				break;
			case 2:
				listCourses();
				break;
			case 3:
				monitor();
				break;
			case 4:
				quit();
				break;

			}

		}
	}

	private void menuCourse() {
		System.out.println("(1) Would you like to create a Course");
		System.out.println("(2) Would you like to list Courses ");
		System.out.println("(3) Previous Menu ");
		System.out.println("(4) Quit ");
	}

	public void createACourse() {
		String courseName = "";
		int units = 0;

		System.out.println("Please enter the course identifier name:");
		courseName = input.next();
		System.out.println("Please enter students address (number only):");
		units = input.nextInt();

		Course addedCourse = new Course(units, courseName);

		lecture.add(addedCourse);

	}
	
	private void listCourses() {
		if (lecture.isEmpty()) {
			System.out.println("The List Is Empty");
			return;
		}

		System.out.println("----------------------- Here are the Courses --------------------");
		for (int i = 0; i < lecture.size(); i++) {
			System.out.println(lecture.get(i));
		}
	}

	public void quit() {
		choice = false;
	}
}
