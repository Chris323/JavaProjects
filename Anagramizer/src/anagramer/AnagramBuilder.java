package anagramer;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AnagramBuilder {

	private List saveToList() {
		ArrayList<String> newList = new ArrayList<String>();
		Scanner scan;

		try {
			scan = new Scanner(new File("/Anagramizer/src/anagramer/wrdlst.txt"));

			while (scan.hasNext()) {
				newList.add(scan.next());
			}
			scan.close();
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return newList;
	}

	private void anagramize(String inString) {
		System.out.println("input string: " + inString);
		List<String> l = filter(anagramizeRecursive(inString.toLowerCase()));
		System.out.println("Anagrams: " + l);
	}

	public List<String> anagramizeRecursive(String stringIn) {
		List<String> newStringList = new ArrayList<>();

			for (int i = 0; i < stringIn.length(); i++) {
				
				if(i < 1) {
					newStringList.add(stringIn);
//					System.out.print(stringIn + " ");
				}
//				
				if(i == stringIn.length()-1) {
				System.exit(1);
				
				}
				
				else {
				StringBuilder alpha = new StringBuilder(stringIn);
				char charlie = stringIn.charAt(i);
				String delta = Character.toString(charlie);
				StringBuilder bravo = alpha.deleteCharAt(i);
				String echo = bravo.toString();
				String foxtrot = echo + delta;
				

////				anagramizeRecursive(foxtrot);
				System.out.print(foxtrot + " ");
				newStringList.add(foxtrot);
				}
				
			
		

	}
			
			
			return newStringList;
}

	private String recursivefilter(List <String> ListIn) {
		String dummy = null;
		int i = 0;
//		
//		
//		if () {
//			
//			
//			return dummy;	
//		}
//		else 
//		{
			return null;
//		}
	}

	private List<String> filter(List<String> listIn) {
		List<String> filteredWords = new ArrayList<>();

		for (int i = 0; i < listIn.size(); i++) {
			String currentWord = listIn.get(i);
			String[] newArray = currentWord.split(" ");
			List<String> stringList = Arrays.asList(newArray);

			String filtered = recursivefilter(stringList);
			if (filtered == null) {

			}

			else {
				filteredWords.add(filtered);
}		
}

		return listIn;

	}
	}
