package persistence2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PersisterImpl<T> implements Persister<T> {

	@Override
	public void saveObjectToFile(File newFileIn, T newObject) {
		ObjectOutputStream output = null;

		try {
			output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(newFileIn)));
			output.writeObject(newObject);
			output.close();

		} catch (Exception error) {
			error.printStackTrace();
		}

	}

	@Override
	public void saveListToFile(File f, List myList) {
		ObjectOutputStream output = null;

		try {
			output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
			output.writeObject(myList);
			output.close();

		} catch (Exception error) {
			error.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public T readObjectFromFile(File newFileIn) {
		ObjectInputStream input = null;
		T newObject = null;

		try {
			input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(newFileIn)));
			newObject = (T) input.readObject();
			input.close();

		} catch (Exception error) {
			error.printStackTrace();
		}

		return newObject;
	}

	@Override
	public List readListFromFile(File f) {
		ObjectInputStream input = null;
		List <T> newList = null;

		try {
			input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
			newList = (List<T>) input.readObject();
			input.close();

		} catch (Exception error) {
			error.printStackTrace();
		}

		return newList;
	}
	}
