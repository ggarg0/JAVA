package Core.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializaitonClass {
	public static void main(String[] args) {
		EmployeeSerialization emp = new EmployeeSerialization("Steve", "Mason");
		emp.firstName = "Steven";
		emp.lastName = "Kelly";
		emp.companyName = "JBT";
		emp.email = "testme";
		emp.companyCEO = "ME CEO";
		try {
			FileOutputStream fileOut = new FileOutputStream(
					"C:\\Mine\\GIT\\JAVA\\Java codes\\Core\\serialization\\employee.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(emp);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in employee.txt file");
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
}