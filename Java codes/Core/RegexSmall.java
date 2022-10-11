package Core;

import java.util.regex.*;

class RegexSmall {
	private static final String PATTERN = "^[0-9]{2}.[0-9]{2}.[0-9]{2}$";

	public static void main(String[] a) {
		String test = "08.01.09";
		String test1 = "08.01.09 LANGUAGE PACK";
		System.out.println(test1.contains("PACK"));
		System.out.println(Pattern.compile(PATTERN).matcher(test1).find() && !test1.contains("PACK"));
	}
}