package Strings;

import java.util.regex.*;

class RegexSmall {
	private static final String PATTERN = "^[0][8].[0][1].[0-9]{2}$";

	public static void main(String[] a) {
		String test = "08.01.16";

		System.out.println(Pattern.compile(PATTERN).matcher(test).find());
	}
}