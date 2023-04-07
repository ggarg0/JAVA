package Core.inputoutput;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadFileExample {

	private static final String FILENAME = "C:\\Mine\\GIT\\JAVA\\Java codes\\Core\\inputoutput\\Test.txt";

	public static void main(String[] args) {

		BufferedReader br = null;
		FileReader fr = null;

		// br = new BufferedReader(new FileReader(FILENAME));
		try {
			fr = new FileReader(FILENAME);

			br = new BufferedReader(fr);

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}