package universityLab;

public class Person {
	protected String name;
	protected Address currentAddress;
	
	public Person(String nameIn, Address currentAddressIn) {
		name = nameIn;
		currentAddress = currentAddressIn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(Address currentAddress) {
		this.currentAddress = currentAddress;
	}
	public String toString() {
		return name + currentAddress;
				}
}
