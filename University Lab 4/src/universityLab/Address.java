package universityLab;

public class Address {
	private int streetNumber;
	private String streetName;
	private String city;
	private int postalCode;
	private String country;

	public Address(int streetNumberIn, String streetNameIn, String cityIn, int postalCodeIn, String countryIn) {
		streetNumber = streetNumberIn;
		streetName = streetNameIn;
		city = cityIn;
		postalCode = postalCodeIn;
		country = countryIn;
	}

	public int getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public String toString() {
		return streetNumber	+ streetName + "," + city + postalCode + "," + country;
				}

}
