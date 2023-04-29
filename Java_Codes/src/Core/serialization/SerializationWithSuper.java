package Core.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class A implements Serializable {
	int i;

	public A(int i) {
		this.i = i;
	}

	public A() {
		System.out.println("A's class constructor called");
	}
}

class B extends A {
	int j;
	public B(int i, int j) {
		super(i);
		this.j = j;
	}
}

// Driver class
public class SerializationWithSuper {
	static String file = "C:\\Mine\\GIT\\JAVA\\Java_codes\\src\\Core\\serialization\\SuperNotSerial.txt";

	public static void main(String[] args) throws Exception {
		B b1 = new B(10, 20);
		System.out.println("i = " + b1.i);
		System.out.println("j = " + b1.j);

		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(b1);
		oos.close();
		fos.close();
		System.out.println("Object has been serialized");

		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		B b2 = (B) ois.readObject();
		ois.close();
		fis.close();
		System.out.println("Object has been deserialized");

		System.out.println("i = " + b2.i);
		System.out.println("j = " + b2.j);
	}
}