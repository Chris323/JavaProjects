package universityLab;

import java.util.ArrayList;

public class Student extends Person {
	private double gpa;
	private ArrayList<Course> courseSchedule = new ArrayList<>();

	public Student(String nameIn, Address currentAddressIn, double gpaIn) {
		super(nameIn, currentAddressIn);
		gpa = gpaIn;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public ArrayList<Course> getCourseSchedule() {
		return courseSchedule;
	}

	public void setCourseSchedule(ArrayList<Course> courseSchedule) {
		this.courseSchedule = courseSchedule;
	}
	
	public void addCourseToStudent(Course courseIn) {
		courseSchedule.add(courseIn);
	}
	
//	public void dropCourse()

	public String printCourseSchedule() {
		String listcourse = "";
		for (int i = 0; i < courseSchedule.size(); i++)
			listcourse += courseSchedule.get(i);
		return listcourse;
	}

	@Override
	public String toString() {
		return name + currentAddress + gpa + printCourseSchedule();
	}

}
