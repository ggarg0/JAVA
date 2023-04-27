package Core.inputoutput;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class FileReaderDemo {

	public static void main(String[] args) {
		char[] array = new char[36];

		try {
			FileReader file = new FileReader("C:\\Mine\\GIT\\JAVA\\Java_codes\\src\\Core\\inputoutput\\Mine.txt");
			BufferedReader input = new BufferedReader(file);
			input.read(array);

			System.out.println("Data in the file: ");
			System.out.println(Arrays.toString(array));
			System.out.println(array.length);
			input.close();

			String data = "This is the data in the output file from FileReader";
			FileWriter outputFile = new FileWriter(
					"C:\\Mine\\GIT\\JAVA\\Java_codes\\src\\Core\\inputoutput\\FileReader.txt");
			BufferedWriter output = new BufferedWriter(outputFile);
			output.write(data);
			output.close();

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

}
