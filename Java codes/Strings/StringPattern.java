package Strings;

import java.util.regex.Pattern;

class StringPattern {
	public static final Pattern validIAPattern = Pattern.compile("abc|efg");

	public void emailCheck(String a) {
		if (validIAPattern.matcher(a).matches()) {
			System.out.println("Fine : " + a);
		} else {
			System.out.println("not Fine : " + a);
		}
	}

	public static void main(String[] a) {
		try {
			StringPattern obj = new StringPattern();
			obj.emailCheck("1abc");
		} catch (Exception e) {
			System.out.println("Divide by Zero ..... ");
		}
	}
}