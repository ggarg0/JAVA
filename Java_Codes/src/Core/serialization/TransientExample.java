package Core.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class NameStore implements Serializable {
	private String firstName;
	private transient String middleName;
	private String lastName;

	public NameStore(String fName, String mName, String lName) {
		this.firstName = fName;
		this.middleName = mName;
		this.lastName = lName;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer(40);
		sb.append("First Name : ");
		sb.append(this.firstName);
		sb.append("; Middle Name : ");
		sb.append(this.middleName);
		sb.append(" and Last Name : ");
		sb.append(this.lastName);
		return sb.toString();
	}
}

public class TransientExample {
	public static void main(String args[]) throws Exception {
		NameStore nameStore = new NameStore("Steve", "Apple", "Jobs");
		ObjectOutputStream o = new ObjectOutputStream(
				new FileOutputStream("C:\\Mine\\GIT\\JAVA\\Java_codes\\src\\Core\\serialization\\nameStore"));
		// writing to object
		o.writeObject(nameStore);
		o.close();
		System.out.println(nameStore);
		
		// reading from object
		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream("C:\\Mine\\GIT\\JAVA\\Java_codes\\src\\Core\\serialization\\nameStore"));
		NameStore nameStoreRead = (NameStore) in.readObject();
		System.out.println(nameStoreRead);
		in.close();
	}
}