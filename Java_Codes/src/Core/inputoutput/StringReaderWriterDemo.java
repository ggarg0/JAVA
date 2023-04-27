package Core.inputoutput;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

public class StringReaderWriterDemo {

	public static void main(String[] args) {
		String data = "This is the text read from StringReaderWriter.";
		char[] array = new char[50];
		try {
			StringReader input = new StringReader(data);
			input.read(array);
			System.out.println("Data read from the string: " + Arrays.toString(array));			
			input.close();
			
			System.out.println();
			StringWriter output = new StringWriter();
			output.write(data);
			System.out.println("Data in the StringWriter: " + output);
			output.close();

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

}
