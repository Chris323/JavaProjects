package buildingInfo;

import java.util.ArrayList;

public class Street {
	private String streetName;
	private ArrayList<Building> structure = new ArrayList<>();
	
	public Street(String streetNameIn) {
		streetName = streetNameIn;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	
	public void addHouse(double sizeIn, boolean hauntedIn, String featureIn) {
		House b4 = new House(sizeIn, hauntedIn, featureIn);
		structure.add(b4);
	}
	
	public void addAsylum(double sizeIn, boolean hauntedIn, String nameIn) {
		House b1 = new House(sizeIn, hauntedIn, nameIn);
		structure.add(b1);
	}
	
	public void getHaunted() {
		System.out.println("Enter the Id to delete ");
		for (int i = 0; i < structure.size(); i++) {
			if (haunted = true) {
				
			}
		}
	}
	
	public void stroll() {
		
	}
	
	
}
