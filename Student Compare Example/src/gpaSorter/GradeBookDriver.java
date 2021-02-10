package gpaSorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GradeBookDriver {
	public static void main(String[] args) {
		List<Student> students = new ArrayList<Student>();

		String[] names = {"Skipper", "Gilligan", "Mary Anne", "Ginger", "Mr. Howell", "Mrs. Howell", "The Professor"};
		double[] gpas = {2.7, 2.1, 3.9, 3.5, 3.4, 3.2, 4.0};

		Student currStudent;
		
		for(int counter = 0; counter < names.length; counter++){
			currStudent=new Student(names[counter], gpas[counter]);
			students.add(currStudent);
		}

		// output the data
		System.out.println("Unsorted:");
		for(Student s: students)
			System.out.println(s);

		Collections.sort(students);

		System.out.println("\nSorted:");
		for(Student s: students)
		System.out.println(s);
		
		System.out.println("Result of calling compareTo on " + students.get(0) + " with " + students.get(3) + " as parameter: " + students.get(0).compareTo(students.get(3)));
		System.out.println("Result of calling compareTo on " + students.get(6) + " with " + students.get(2) + " as parameter: " + students.get(6).compareTo(students.get(2)));
	}
}

