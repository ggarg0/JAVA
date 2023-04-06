package Core.serialization;

import java.io.*;

class SerializationWithSuper {
	public static void main(String[] a) {
		Dog d = new Dog(12, 12, "Gaurav");
		System.out.println("Before Serial name : " + "Id : " + d.id + " named : " + d.name + " & weight : " + d.weight);
		try {
			FileOutputStream fos = new FileOutputStream("SuperNotSerial.txt");
			ObjectOutputStream bos = new ObjectOutputStream(fos);
			bos.writeObject(d);
			bos.close();
		} catch (Exception e) {
			System.out.println("EXP : " + e);
		}

		try {
			d.name = "Garg";
			d.id = 111;
			d.weight = 123;
			System.out.println("Before object : " + "Id : " + d.id + " named : " + d.name + " & weight : " + d.weight);
			FileInputStream fis = new FileInputStream("SuperNotSerial.txt");
			ObjectInputStream bis = new ObjectInputStream(fis);
			d = (Dog) bis.readObject();
			bis.close();
		} catch (Exception e) {
			System.out.println("EXP : " + e);
		}
		System.out.println("Recovered object : " + "Id : " + d.id + " named : " + d.name + " & weight : " + d.weight);
	}
}

class Dog extends Animal {
	String name;
	int weight;

	Dog(int id, int w, String n) {
		super(id);
		weight = w;
		name = n;
	}
}

class Animal implements Serializable {
	static int id;

	public Animal(int id2) {
		id = id2;
	}

}