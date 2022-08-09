package com.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializaitonClass {
	public static void main(String[] args) {
		EmployeeSerialization emp = new EmployeeSerialization("Vivekanand","Gautam");
		emp.firstName = "Vivekanand";
		emp.lastName = "Gautam";
		emp.companyName = "JBT";
		emp.email = "testme";
		// Below part needs to be removed in case address field is made final
		emp.companyCEO = "ME CEO";
		try {
			FileOutputStream fileOut = new FileOutputStream("./employee.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(emp);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in ./employee.txt file");
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
}