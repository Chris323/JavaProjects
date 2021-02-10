package persistence1;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Tester {

	@Test
	public void testStudent() {
		Student newKid = new Student("superman", .01);
		assertNotNull(newKid);
	}

	@Test
	public void testWriteObject() {
		Student newKid = new Student("spiderman", 2.0);
		PersisterImpl newCase = new PersisterImpl();

		newCase.saveObjectToFile(new File("floppy"), newKid);

		assertTrue(true);
	}

	@Test
	public void testReadObject() {
		Student newKid = new Student("spiderman", 2.0);
		PersisterImpl newCase = new PersisterImpl();

		newCase.saveObjectToFile(new File("floppy1"), newKid);
		newCase.readObjectFromFile(new File("floppy1"));

		Student newKid2 = (Student) newCase.readObjectFromFile(new File("floppy1"));
		Boolean test = newKid.equals(newKid2);
		assertTrue(test);
	}

	@Test
	public void testWriteList() {
		Student newKid = new Student("spiderman", 2.0);
		Student newKid1 = new Student("spiderboy", 1.0);
		Student newKid2 = new Student("spidergwen", 5.0);
		Student newKid3 = new Student("spidergal", 3.0);

		ArrayList<Student> coolStudent = new ArrayList<>();

		coolStudent.add(newKid);
		coolStudent.add(newKid1);
		coolStudent.add(newKid2);
		coolStudent.add(newKid3);

		PersisterImpl newCase = new PersisterImpl();

		newCase.saveListToFile(new File("floppy"), coolStudent);

		assertTrue(true);
	}

	@Test
	public void testReadList() {

		Student newKid1 = new Student("spiderboy", 1.0);
		Student newKid2 = new Student("spidergwen", 5.0);
		Student newKid3 = new Student("spidergal", 3.0);

		ArrayList<Student> coolStudent = new ArrayList<>();

		coolStudent.add(newKid1);
		coolStudent.add(newKid2);
		coolStudent.add(newKid3);

		Course newCor = new Course("spiderman", coolStudent);

		PersisterImpl newCase = new PersisterImpl();

		newCase.saveListToFile(new File("floppy"), coolStudent);
		
		newCase.readListFromFile(new File ("floppy"));

		assertTrue(true);
	}

}
