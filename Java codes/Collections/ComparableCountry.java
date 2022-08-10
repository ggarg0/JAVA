package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Country implements Comparable<Country> {
	int countryId;
	String countryName;

	public Country(int countryId, String countryName) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
	}

	@Override
	public int compareTo(Country country) {
		return (this.countryId < country.countryId) ? -1 : (this.countryId > country.countryId) ? 1 : 0;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
}

public class ComparableCountry {
	public static void main(String[] args) {
		List<Country> listOfCountries = new ArrayList<Country>();
		listOfCountries.add(new Country(1, "India"));
		listOfCountries.add(new Country(4, "China"));
		listOfCountries.add(new Country(3, "Nepal"));
		listOfCountries.add(new Country(2, "Bhutan"));

		System.out.println("Before Sort  : ");
		for (int i = 0; i < listOfCountries.size(); i++) {
			Country country = (Country) listOfCountries.get(i);
			System.out.println("Country Id: " + country.getCountryId() + "||" + "Country name: " + country.getCountryName());
		}

		Collections.sort(listOfCountries);

		System.out.println("After Sort  : ");
		for (int i = 0; i < listOfCountries.size(); i++) {
			Country country = (Country) listOfCountries.get(i);
			System.out.println("Country Id: " + country.getCountryId() + "|| " + "Country name: " + country.getCountryName());
		}
	}
}
