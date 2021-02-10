package buildingInfo;

public class Asylum extends Building {
	private String name;
	
	public Asylum(double sizeIn, boolean hauntedIn, String nameIn) {
		super(sizeIn, hauntedIn);
		name = nameIn;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String explore() {
		System.out.println("You pass a " + size + "sq meter asylum" + "called" + name);

		if (haunted = true) {
			System.out.println("Watch out! A ghost!");
		}
		
		return null;
	}
	
	public String toString(){
		return explore();
	}
}
