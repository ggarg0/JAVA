package Core.inputoutput;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileStreamDemo {

	public static void main(String[] args) {
		String data = "This is a line of text inside the file from FileStreamDemo";
		try {
			FileOutputStream output = new FileOutputStream(
					"C:\\Mine\\GIT\\JAVA\\Java_codes\\src\\Core\\inputoutput\\FileStreamDemo.txt");
			byte[] array = data.getBytes();

			output.write(array);
			output.close();

			FileInputStream input = new FileInputStream(
					"C:\\Mine\\GIT\\JAVA\\Java_codes\\src\\Core\\inputoutput\\FileStreamDemo.txt");
			int i = input.read();
			while (i != -1) {
				System.out.print((char) i);
				i = input.read();
			}
			input.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}
