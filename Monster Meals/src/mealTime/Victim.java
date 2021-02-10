package mealTime;

public class Victim implements Comparable<Victim>{
	protected String name;
	protected int iq;
	protected int appearance;
	
	public Victim(String nameIn, int iqIn, int appearanceIn) {
		name = nameIn;
		
		if (iqIn >= 50 && iqIn <= 200) {
		iq = iqIn;
		}
		else 
			iq = 125;
		
		if(appearanceIn >= 1 && appearanceIn <= 10) {
		appearance = appearanceIn;
		}
		else 
			appearance = 5;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIq() {
		return iq;
	}

	public void setIq(int iq) {
		if(iq >= 50 && iq <= 200) {
			this.iq = iq;	
		}
		
		else {
			this.iq = 125;
		}
	}

	public int getAppearance() {
		return appearance;
	}

	public void setAppearance(int appearance) {
		if(appearance >= 1 && appearance <= 10) {
			this.appearance = appearance;
			}
			else {
				appearance = 5;
			}
		
	}
	
	@Override
	public int compareTo(Victim newVictim) { //descending order
		return (this.iq < newVictim.iq ? 1:-1);
	}
	

	@Override
	public String toString() {
		return (name + ": intelligence " + iq + ", appearance " + appearance);
	}




	
	
}
