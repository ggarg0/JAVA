package Implementations;

class Country {

	private String name;
	private int population;

	public Country(String n, int p) {
		name = n;
		population = p;
	}

	public String getName() {
		return name;
	}
}

class Person {

	private String name;
	private Country country; // An instance of Country class

	public Person(String n, Country c) {
		name = n;
		country = c;
	}

	public void printDetails() {
		String nameLocal = "Local";
		System.out.println("Name: " + name);
		System.out.println("Country: " + country.getName());
		System.out.println("nameLocal: " + nameLocal);
	}
}

public class Test {
	public static void main(String args[]) {
		Country country = new Country("USA", 1);
		{
			Person user = new Person("John Smith", country);
			user.printDetails();
		}
		// The user object's lifetime is over
		System.out.println(country.getName()); // The country object still exists!
	}
}