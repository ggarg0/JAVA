package Core.string;

import java.util.StringTokenizer;

public class StringSplitDemo {

	public static void main(String[] args) {
		String delims = ",";
		String splitString = "one,two, ,three,four,,five";

		System.out.println("StringTokenizer Example: \n========================");
		StringTokenizer st = new StringTokenizer(splitString, delims);
		System.out.println("StringTokenizer Count Output: " + st.countTokens());
		while (st.hasMoreElements()) {
			System.out.println("StringTokenizer Output: " + st.nextElement());
		}

		System.out.println("\n\nSplit Example: \n==================");
		String[] tokens = splitString.split(delims);
		int tokenCount = tokens.length;
		System.out.println("String Split Count Output: " + tokenCount);
		for (String token : tokens) {
			System.out.println("Split Output: " + token);
		}
	}
}
