package universityLab;

import java.util.ArrayList;

public class FacultyMember extends Person {
	private int employeeId;
	private ArrayList<Course> teachingSchedule;

	public FacultyMember(String nameIn, Address currentAddressIn, int employeeIdIn) {
		super(nameIn, currentAddressIn);
		employeeId = employeeIdIn;
	
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public ArrayList<Course> getTeachingSchedule() {
		return teachingSchedule;
	}

	public void setTeachingSchedule(ArrayList<Course> teachingSchedule) {
		this.teachingSchedule = teachingSchedule;
	}
	
	public void addCourseToFaculty(Course courseIn) {
		teachingSchedule.add(courseIn);
	}
	
//	public void dropCourse() {
//		
//	}
//	
	
	public String printTeachingSchedule() {
		String teachingcourses = "";
		for (int i = 0; i < teachingSchedule.size(); i++)
			teachingcourses += teachingSchedule.get(i);
		return teachingcourses;
	}
	
	@Override
	public String toString() {
		return name + currentAddress + employeeId + printTeachingSchedule();
	}
}
