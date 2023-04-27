package Core.inputoutput;

import java.io.*;
import java.util.regex.*;

class Fileread {
	public static void main(String args[]) {
		try {
			int i = 0;
			String[] a = new String[50];
			FileInputStream fstream = new FileInputStream(
					"C:\\Mine\\GIT\\JAVA\\Java_codes\\src\\Core\\inputoutput\\Mine.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			while ((strLine = br.readLine()) != null) {
				a[i] = strLine.trim();
				System.out.println(a[i]);
				Pattern p = Pattern.compile("IO");
				Matcher m = p.matcher(a[i]);
				while (m.find()) {
					System.out.println("Matcher : " + m.start() + " ");
					String str[] = a[i].split(" ");
					for (int f = 0; f < str.length; f++) {
						System.out.println("Text : " + str[f]);
					}
				}
				i++;
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error: " + e.getMessage());
		}
	}
}