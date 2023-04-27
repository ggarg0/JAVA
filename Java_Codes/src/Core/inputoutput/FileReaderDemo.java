package Core.inputoutput;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class FileReaderDemo {

	public static void main(String[] args) {
		char[] array = new char[50];
		char[] in = new char[50];
		int size = 0;
		try {
			//Example 1
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

			//Example 2
			File file2 = new File("C:\\Mine\\GIT\\JAVA\\Java_codes\\src\\Core\\inputoutput\\Test.txt");
			FileWriter fw = new FileWriter(file2);
			fw.write("Java folks learning java");
			fw.flush();
			fw.close();

			FileReader fr = new FileReader(file2);
			size = fr.read(in);
			System.out.println("Size : " + size);
			for (char c : in)
				System.out.print(c);
			fr.close();

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

}
