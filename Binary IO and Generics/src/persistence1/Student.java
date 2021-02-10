package persistence1;

import java.io.Serializable;

public class Student implements Serializable {
	protected String name;
	protected double GPA;

	public Student(String nameIn, double GPAIn) {
		name = nameIn;
		GPA = GPAIn;
	}

	private boolean isEquals(Student newStu) {
		System.out.println(newStu.GPA+" "+ this.GPA );
		if (name.equals(newStu.name) && GPA == newStu.GPA) {
			
			return true;
		} 
		else {
			return false;
			}
	}
}
