package Core.inputoutput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class ByteArrayStreamDemo {
	public static void main(String[] args) {
		byte[] array = { 1, 2, 3, 4 };
		try {
			ByteArrayInputStream input = new ByteArrayInputStream(array);
			System.out.print("The bytes read from the input stream: ");
			for (int i = 0; i < array.length; i++) {
				int data = input.read();
				System.out.print(" " + data);
			}
			input.close();
			System.out.println();

			ByteArrayOutputStream output = new ByteArrayOutputStream();
			byte[] buffer = { 97, 98, 99, 100 };

			output.write(buffer);
			System.out.print("The bytes read from the output stream: : ");
			byte[] result = output.toByteArray();
			for (byte b : result) {
				System.out.print(" " + b);
			}
			output.close();

			System.out.println();
			String data = "This is a line of text inside the string.";
			byte[] arrayOut = data.getBytes();
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			out.write(arrayOut);
			String streamData = out.toString();

			System.out.println("Output stream: " + streamData);

			out.close();

		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}
