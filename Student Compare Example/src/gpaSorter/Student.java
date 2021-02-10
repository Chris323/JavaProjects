package gpaSorter;

public class Student implements Comparable<Student>{
	private String name;
	private double gpa;

	public Student(String nameIn, Double gpaIn){
		name = nameIn;
		gpa = gpaIn;
	}

	public String toString(){
		return "Name: " + name + "; GPA: " + gpa;
	}

@Override
	public int compareTo(Student otherStudent) {
		return (this.gpa < otherStudent.gpa? -1:1);
	}
}
