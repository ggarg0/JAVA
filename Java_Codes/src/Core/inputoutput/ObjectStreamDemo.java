package Core.inputoutput;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamDemo {
	public static void main(String[] args) {
		int data1 = 5;
		String data2 = "This is Object Stream Demo";

		try {
			FileOutputStream file = new FileOutputStream("C:\\Mine\\GIT\\JAVA\\Java_codes\\src\\Core\\inputoutput\\ObjectStreamDemo.txt");
			ObjectOutputStream output = new ObjectOutputStream(file);

			output.writeInt(data1);
			output.writeObject(data2);

			FileInputStream fileStream = new FileInputStream("C:\\Mine\\GIT\\JAVA\\Java_codes\\src\\Core\\inputoutput\\ObjectStreamDemo.txt");
			
			ObjectInputStream objStream = new ObjectInputStream(fileStream);
			System.out.println("Integer data :" + objStream.readInt());
			System.out.println("String data: " + objStream.readObject());
			output.close();
			objStream.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}
