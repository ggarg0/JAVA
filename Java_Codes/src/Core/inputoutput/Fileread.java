package Core.inputoutput;

import java.io.*;
import java.util.regex.*;

class Fileread {
	public static void main(String args[]) {
		try {
			int i = 0;
			String[] a = new String[50];
			// Open the file that is the first
			// command line parameter
			FileInputStream fstream = new FileInputStream("C:\\Mine\\GIT\\JAVA\\Java_codes\\src\\Core\\inputoutput\\Test.txt");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			// Read File Line By Line
			while ((strLine = br.readLine()) != null) {
				// Print the content on the console

				a[i] = strLine.trim();
				System.out.println(a[i]);

				Pattern p = Pattern.compile("id");
				Matcher m = p.matcher(a[i]);

				while (m.find()) {
					System.out.println("Matcher : " + m.start() + " ");
					String str[] = a[i].split("=");
					System.out.println("required 12: " + str[1]);
					for (int f = 0; f < str.length; f++) {
						System.out.println("required : " + str[f]);
					}
				}
				i++;
			}
			// System.out.println (a[0].length());
			// Close the input stream
			in.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
}