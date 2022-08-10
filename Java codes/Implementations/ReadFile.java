package Implementations;

import java.io.File;
import java.util.Scanner;

public class ReadFile {
	public static void SpeakIt(String fileName) {
		try {

			long startTime = System.currentTimeMillis();
		
			//Java 8: Stream class
			/*Path file = Paths.get(fileName);
            Stream<String> lines = Files.lines(file, StandardCharsets.UTF_8);
            
            for( String line : (Iterable<String>) lines::iterator )
            {
               //System.out.println(line);
            }*/
			
            //BufferedReader 
			/*BufferedReader br = null;
			FileReader fr = null;

			fr = new FileReader(fileName);
			br = new BufferedReader(fr);

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
				if(sCurrentLine.contains("better"))
					break;
			}
*/
			//Scanner 
			int count = 0;
			File file = new File(fileName);
			Scanner sc = new Scanner(file);
			while (sc.hasNext()) {

				/*if (sc.findInLine("pg") != null)
					count++;*/
				System.out.println(sc.nextLine());
			}
			System.out.println(count);
			sc.close();

			long endTime = System.currentTimeMillis();
			System.out.println("Execution Time: " + ((endTime - startTime)) + " milliseconds");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SpeakIt("samplefile.txt"); // change the path of the desired file.
	}
}
