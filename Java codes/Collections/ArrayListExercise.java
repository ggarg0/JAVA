package Collections;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArrayListExercise {
	public static void main(String args[]) {
		List<EmployeeDetails> list = new ArrayList<>();
		list.add(new EmployeeDetails("Alex", 23, "USA"));
		list.add(new EmployeeDetails("Dave", 34, "India"));
		list.add(new EmployeeDetails("Carl", 21, "USA"));
		list.add(new EmployeeDetails("Joe", 56, "Russia"));
		list.add(new EmployeeDetails("Amit", 64, "China"));
		list.add(new EmployeeDetails("Ryan", 19, "Brazil"));

		list.sort(Comparator.comparing(EmployeeDetails::getCountry).reversed());
		
		
		List<EmployeeDetails> list1 = list.stream().filter(e -> e.getAge() > 50).collect(toList());
		System.out.println(list1.toString());
		list1.stream().filter(emp -> emp.age > 50).map(emp -> emp.name).forEach(System.out::println);
		list1.stream().filter(emp -> emp.age > 50).forEach(System.out::println);
		
	}
}

class EmployeeDetails {

	String name;
	int age;
	String country;

	public EmployeeDetails(String name, int age, String country) {
		super();
		this.name = name;
		this.age = age;
		this.country = country;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", country=" + country + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}