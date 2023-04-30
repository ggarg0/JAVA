package Core.string;

import java.util.StringTokenizer;

public class StringTokenizerDemo {

	public static void main(String[] args) {
		String delims = ",";
		String splitString = "one,two, ,three,four,,five";

		System.out.println("StringTokenizer Example:\n========================");

		StringTokenizer st = new StringTokenizer(splitString);
		System.out.println("StringTokenizer Count Output: " + st.countTokens());
		while (st.hasMoreElements()) {
			System.out.println("StringTokenizer Output: " + st.nextElement());
		}
		
		System.out.println("\nStringTokenizer Example:\n========================");
		StringTokenizer st1 = new StringTokenizer(splitString, delims);
		System.out.println("StringTokenizer Count Output: " + st1.countTokens());
		while (st1.hasMoreElements()) {
			System.out.println("StringTokenizer Output: " + st1.nextElement());
		}
		
		System.out.println("\nStringTokenizer Example:\n========================");
		StringTokenizer st2 = new StringTokenizer(splitString, delims, true);
		System.out.println("StringTokenizer Count Output: " + st2.countTokens());
		while (st2.hasMoreElements()) {
			System.out.println("StringTokenizer Output: " + st2.nextElement());
		}
	}
}
