package Core.serialization;

import java.io.*;

class Emp implements Serializable {

	private String name;
	private String age;
	private String city;

	Emp() {
		name = "Test Me";
		age = "19";
		city = "Delhi";
	}

	@Override
	public String toString() {
		return "Emp [name=" + name + ", age=" + age + ", city=" + city + "]";
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
		Emp c = new Emp();
		try {
			FileOutputStream fs = new FileOutputStream(
					"C:\\Mine\\GIT\\JAVA\\Java_codes\\src\\Core\\serialization\\TestSer.dat");
			ObjectOutputStream obj = new ObjectOutputStream(fs);
			obj.writeObject(c);
			obj.close();

			c.setAge("29");
			FileInputStream fis = new FileInputStream(
					"C:\\Mine\\GIT\\JAVA\\Java_codes\\src\\\\Core\\serialization\\TestSer.dat");
			ObjectInputStream obi = new ObjectInputStream(fis);
			Emp c2 = (Emp) obi.readObject();
			obi.close();
			System.out.println("Test : " + c.toString());
			System.out.println("Test : " + c2.toString());
		} catch (Exception e) {
			System.out.println("Exp : " + e);
		}

	}

}