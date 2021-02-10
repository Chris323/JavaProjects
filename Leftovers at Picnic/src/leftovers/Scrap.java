package leftovers;

public class Scrap {
	protected static int grams;
	protected static String scrap;
	
	public Scrap(int gramsIn, String scrapIn) {
		grams = gramsIn;
		scrap = scrapIn;
	}
	
	
	public int reduce(int amount) {
		if (amount > grams) {
			return 0;
		}
		
		else {
			
		int newGrams = grams - amount;
		
		return newGrams;
		}
	}
	
	public static int getGrams() {
		return grams;
	}

	public static String getScrap() {
		return scrap;
	}
	
}
