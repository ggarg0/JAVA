package Core.serialization;

import java.io.*;

class Employee implements Serializable {

	private String name;
	private String age;
	private String city;

	Employee() {
		name = "Test Me";
		age = "19";
		city = "Delhi";
		System.out.println("Employee constructor called");
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", city=" + city + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}

public class SerializationDemo {
	public static void main(String[] a) {
		Employee c = new Employee();
		try {
			FileOutputStream fs = new FileOutputStream(
					"C:\\Mine\\GIT\\JAVA\\Java_codes\\src\\Core\\serialization\\TestSer.dat");
			ObjectOutputStream obj = new ObjectOutputStream(fs);
			obj.writeObject(c);
			obj.close();

			c.setAge("29");
			System.out.println("Test : " + c.toString());
		} catch (Exception e) {
			System.out.println("Exp : " + e);
		}
	}
}