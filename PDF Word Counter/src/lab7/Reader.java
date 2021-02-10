package lab7;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class Reader {
	public Scanner user = new Scanner(System.in);
	public HashMap<String, Integer> finalList = new LinkedHashMap<String, Integer>();

	public String userFilePath() {
		System.out.println("Please enter the file path of the PDF you would like to read");
		String in = user.nextLine();

		String text = null;

		PDDocument pd;
		File input = new File(in);

		try {
			pd = PDDocument.load(input);
			PDFTextStripper strip = new PDFTextStripper();
			strip.setEndPage(20);
			text = strip.getText(pd);

			if (pd != null) {
				pd.close();
			}
		}

		catch (IOException e) {
			e.printStackTrace();
		}

		return text;
	}

	public static String clean(String s) {
		String r = "";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isLetter(c)) {
				r = r + c;
			}
		}
		return r.toLowerCase();
	}

	public HashMap<String, Integer> wordCounter(String input) {
		Map<String, Integer> frequencies = new HashMap<String, Integer>();
		

		System.out.println(input);
		String[] wordsPDF = input.split("\\s+");

		for (int i = 0; i < wordsPDF.length; i++) {
			String word = clean(wordsPDF[i]);

			if (word != "") {
				Integer count = frequencies.get(word);

				if (count == null) {
					count = 1;
				} 
				else {
					count = count + 1;
				}
				frequencies.put(word, count);
			}			
		}
		
		//for (String key : frequencies.keySet()) {
		//System.out.println(key + ": " + frequencies.get(key));

	  //}
		
		List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(frequencies.entrySet());
		Collections.sort(list, new SortComparator());
		list = list.subList(0, 10);
		
//		System.out.println(list);
		
		 
        for (Map.Entry<String, Integer> mapa : list) { 
            finalList.put(mapa.getKey(), mapa.getValue());
            
        } 
        System.out.println(finalList);
		return finalList;
	}
	
}
