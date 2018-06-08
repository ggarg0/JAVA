import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileExample
{

	private static final String FILENAME = "D:\\GIT\\JAVA\\Java codes\\Test.txt";

	public static void main(String[] args) {

		BufferedReader br = null;
		FileReader fr = null;

			//br = new BufferedReader(new FileReader(FILENAME));
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}

	}

}