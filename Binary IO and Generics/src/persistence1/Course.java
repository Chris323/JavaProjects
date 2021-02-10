package persistence1;

import java.io.Serializable;
import java.util.ArrayList;


public class Course implements Serializable{
	protected String name;
	protected ArrayList<Student> student = new ArrayList<>();
	
	public Course(String nameIn, ArrayList<Student> studentIn) {
		name = nameIn;
		student = studentIn;
		
	}
	public void add(Student me) {
		student.add(me);
	}
	
	private boolean isEquals(Course newCourse) {

		if (name.equals(newCourse.name)) {
			return true;
		} 
		
		else
			return false;
	}
	
}
