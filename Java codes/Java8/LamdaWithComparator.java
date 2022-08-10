package Java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LamdaWithComparator {
	static List<Employee> employeeList = Arrays.asList(
			new Employee("Tom Jones", 45), new Employee("Harry Major", 35), 
			new Employee("Harry Major", 25), new Employee("Ethan Hardy", 65), 
			new Employee("Nancy Smith", 15), new Employee("Deborah Sprightly", 29));

	public static void main(String[] args) {
		//creating name comparator
		Comparator<Employee> empNameComparator = (emp1, emp2) -> {
			return (emp1.getName().compareTo(emp2.getName()));
		};
		//creating age comparator
		Comparator<Employee> empAgeComparator = 
				(emp1, emp2) -> emp1.getAge() - emp2.getAge();

		System.out.println("Sorting by Name : ");
		Collections.sort(employeeList, empNameComparator);
		employeeList.forEach(System.out::println);

		System.out.println("\nSorting by age : ");
		Collections.sort(employeeList, empAgeComparator);
		employeeList.forEach(Employee -> System.out.println(Employee.toString()));

		System.out.println("\nSorting by age reversed : ");
		employeeList.sort(Comparator.comparing(Employee::getAge).reversed());
		employeeList.forEach(System.out::println);

		System.out.println("\nSorting by name and age: ");
		employeeList.sort(Comparator.comparing(Employee::getName).thenComparing(Employee::getAge));
		employeeList.forEach(System.out::println);
	}
}

class Employee {
	String name;
	int age;

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

	public Employee(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return "Employee Name : " + this.name + "  Age : " + this.age;
	}
}
