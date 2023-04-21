package Core.inputoutput;

import java.io.*;

class CreateFile {
	public static void main(String[] a) {

		try {
			boolean newFile;
			File file = new File("C:\\Mine\\GIT\\JAVA\\Java_codes\\src\\Core\\inputoutput\\Test.txt");
			System.out.println(file.exists());
			newFile = file.createNewFile();
			System.out.println(newFile);
			System.out.println(file.exists());

		} catch (Exception e) {
			System.out.println("Exp : " + e);
		}
	}

}