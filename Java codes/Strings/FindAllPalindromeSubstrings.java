package Strings;

import java.util.ArrayList;
import java.util.List;

public class FindAllPalindromeSubstrings {

	public static boolean isPalindrome(int start, int end, String input) {
		while (end > start) {

			if (input.charAt(start) != input.charAt(end)) {
				return false;
			}
			end--;
			start++;
		}
		return true;
	}

	public static List<String> findAllPalindromeSubstrings(String input) {
		List<String> result = new ArrayList<String>();

		for (int i = 0; i < input.length(); i++) {
		//	result.add(input.substring(i, i + 1));
			for (int j = i + 1; j < input.length(); j++) {
				if (isPalindrome(i, j, input)) {
					result.add(input.substring(i, j + 1));
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		String[] inputStr = { "abdbca", "cddpd", "educative" };
		for (int i = 0; i < inputStr.length; i++) {
			List<String> result = findAllPalindromeSubstrings(inputStr[i]);
			System.out.println((i + 1) + ".   Input string: " + inputStr[i]);
			System.out.println("     Palindromes: " + result.toString());
			System.out.println("     Total palindrome substrings: " + result.size());
			System.out.println(
					"----------------------------------------------------------------------------------------------------\n");
		}

	}

}
