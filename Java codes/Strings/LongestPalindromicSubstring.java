package Strings;

public class LongestPalindromicSubstring {

	public static boolean isPalindrome(int start, int end, String input) {
		while (end > start) {
			if (input.charAt(start) != input.charAt(end))
				return false;

			end--;
			start++;
		}
		return true;
	}

	public static String longestPalindromicSubstring(String s) {
		if (s == null || s.isEmpty())
			return "";
		
		String longestOne = "";
		for (int i = 0; i < s.length(); i++) {
			for (int j = s.length() - 1; j > 0; j--) {
				//System.out.println("i : " + i + " and j : " + j);
				if (i > j || j - i < longestOne.length())
					break;

				if (isPalindrome(i, j, s) && s.substring(i, j + 1).length() > longestOne.length()) {
					longestOne = s.substring(i, j + 1);
					//System.out.println(longestOne);
					break;
				}
			}
		}

		return longestOne;
	}

	public static void main(String[] args) {
		String[] inputs = { "", "abc", "1010", "aaccbababcbc", null };

		int index = 0;
		for (String input : inputs) {
			String inputStr = (input == null) ? "null" : "\"" + input + "\"";
			System.out.println((++index) + ". Input string: " + inputStr);
			System.out.println("   Longest Palindromic Substring: \"" + longestPalindromicSubstring(input) + "\"");
			System.out.println(
					"-------------------------------------------------------------------------------------------------\n");
		}
	}
}
