package universityLab;

public class Course {
	private int units;
	private String courseIdentifier;

	public Course(int unitsIn, String courseIdentifierIn) {
		units = unitsIn;
		courseIdentifier = courseIdentifierIn;

	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public String getCourseNumber() {
		return courseIdentifier;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseIdentifier = courseNumber;
	}

	public String toString() {
		return courseIdentifier + units + "units";
	}

}
