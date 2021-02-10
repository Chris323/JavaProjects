package buildingInfo;

public class House extends Building {
	private String feature;

	public House(double sizeIn, boolean hauntedIn, String featureIn) {
		super(sizeIn, hauntedIn);
		feature = featureIn;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	@Override
	public String explore() {
		System.out.println("You pass a " + size + "sq meter house" + "with a(n)" + feature);

		if (haunted = true) {
			System.out.println("Watch out! A ghost!");
		}
		
		return null;
	}
	
	public String toString(){
		return explore();
	}
}
