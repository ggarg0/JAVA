package Recursion;

public class StringReverse {

	public static String reversedString(String text) {
		String reversed = "";
		if (text.length() <= 1) {
			return text;
		} else {
			reversed = text.charAt(text.length() - 1) + reversedString(text.substring(0, text.length() - 1));
		}
		return reversed;
	}

	public static void main(String[] args) {
		String input = "hell";
		System.out.println("Original String : " + input + " and reverserd string : " + reversedString(input));
	}
}
