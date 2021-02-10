package persistence1;

import java.io.File;
import java.util.List;

public interface Persister<T>{
	
	public void saveObjectToFile(File f, T ob);	
	public void saveListToFile(File f, List<T> myList);
	public T readObjectFromFile(File f);
	public List<T> readListFromFile(File f);

}
