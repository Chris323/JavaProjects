package persistence2;

import java.io.Serializable;

public class Student implements Serializable {
	protected String firstName;
	protected String lastName;
	protected double GPA;

	public Student(String firstNameIn, String lastNameIn, double GPAIn) {
		firstName = firstNameIn;
		lastName = lastNameIn;
		GPA = GPAIn;
	}

	private boolean isEquals(Student newStu) {
		System.out.println(newStu.GPA+" "+ this.GPA );
		if (firstName.equals(newStu.firstName) && lastName.equals(newStu.lastName) && GPA == newStu.GPA) {
			
			return true;
		} 
		else {
			return false;
			}
	}
}