package DesignPatterns.Singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class MySingleton implements Serializable {

	private static final long serialVersionUID = 1L;
	private volatile static MySingleton _instance;

	private MySingleton() {
	}

	public static MySingleton getNewInstance() {
		if (_instance == null) {
			synchronized (MySingleton.class) {
				if (_instance == null) {
					_instance = new MySingleton();
				}
			}
		}
		return _instance;
	}

	protected Object readResolve() {
		return _instance;
	}

	private int i = 10;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
}

public class SingletonWithSerialization {

	public static void main(String[] args) throws Exception {
		try {
			MySingleton instanceOne = MySingleton.getNewInstance();

			ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
			out.writeObject(instanceOne);
			out.close();

			instanceOne.setI(20);

			// Serialize to a file
			ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
			MySingleton instanceTwo = (MySingleton) in.readObject();
			in.close();

			System.out.println(instanceOne.getI());
			System.out.println(instanceTwo.getI());

		} catch (Exception e) {
			System.out.println("Exception clone : " + e.toString());
		}

	}
}
