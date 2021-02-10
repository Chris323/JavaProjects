package leftovers;

public class Scavenger {
	protected int mouthCapacity;

	public void bite(Scrap newScrap) {
//		if (Scrap.getGrams() > mouthCapacity) {
//			this.getMouthCapacity();
//
//		} 
		
//		else {
			newScrap.reduce(Scrap.getGrams());
//		}
	}

	public int getMouthCapacity() {
		return mouthCapacity;
	}

	@Override
	public String toString() {
		return " bites " + Scrap.getGrams() + " mg of " + Scrap.getScrap() + " and gets ";

	}
}
