package Core.serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializationDemo {

	public static void main(String[] a) {
		try {
			FileInputStream fis = new FileInputStream(
					"C:\\Mine\\GIT\\JAVA\\Java_codes\\src\\Core\\serialization\\TestSer.dat");
			ObjectInputStream obi = new ObjectInputStream(fis);
			Employee c = (Employee) obi.readObject();
			obi.close();

			System.out.println("Test : " + c.toString());
		} catch (Exception e) {
			System.out.println("Exp : " + e);
		}
	}
}
