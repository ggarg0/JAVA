package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Country1 {
	int countryId;
	String countryName;

	public Country1(int countryId, String countryName) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
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

class CountrySortByIdComparator implements Comparator<Country1> {
	@Override
	public int compare(Country1 country1, Country1 country2) {
		return (country1.getCountryId() < country2.getCountryId()) ? -1
				: (country1.getCountryId() > country2.getCountryId()) ? 1 : 0;
	}
}


public class ComparatorCountry {
	public static void main(String[] args) {

		List<Country1> listOfCountries = new ArrayList<Country1>();
		listOfCountries.add(new Country1(1, "India"));
		listOfCountries.add(new Country1(4, "China"));
		listOfCountries.add(new Country1(3, "Nepal"));
		listOfCountries.add(new Country1(2, "Bhutan"));

		System.out.println("Before Sort by id : ");
		for (int i = 0; i < listOfCountries.size(); i++) {
			Country1 country = (Country1) listOfCountries.get(i);
			System.out.println("Country Id: " + country.getCountryId() + "||" + "Country name: " + country.getCountryName());
		}

		Collections.sort(listOfCountries, new CountrySortByIdComparator());

		System.out.println("After Sort by id: ");
		for (int i = 0; i < listOfCountries.size(); i++) {
			Country1 country = (Country1) listOfCountries.get(i);
			System.out.println("Country Id: " + country.getCountryId() + "|| " + "Country name: " + country.getCountryName());
		}

		Collections.sort(listOfCountries, new Comparator<Country1>() {
			@Override
			public int compare(Country1 o1, Country1 o2) {
				return o1.getCountryName().compareTo(o2.getCountryName());
			}
		});

		System.out.println("After Sort by name: ");
		for (int i = 0; i < listOfCountries.size(); i++) {
			Country1 country = (Country1) listOfCountries.get(i);
			System.out.println(
					"Country Id: " + country.getCountryId() + "|| " + "Country name: " + country.getCountryName());
		}
	}

}
