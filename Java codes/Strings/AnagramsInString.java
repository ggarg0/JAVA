package Strings;

import java.util.ArrayList;
import java.util.List;

public class AnagramsInString {

	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";
		System.out.println(findAnagrams(s, p));
	
	}

	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<Integer>();
		int len = p.length();
		String temp = "";

		for (int i = 0; i <= s.length() - len; i++) {
			temp = s.substring(i, i + len);
			if (isAnagram(temp, p)) {
				result.add(i);
			}
		}
		return result;
	}

	public static boolean isAnagram(String s, String p) {
		StringBuilder temp = new StringBuilder(s);
		boolean result = false;
		for (int i = 0; i < p.length(); i++) {
			char a = p.charAt(i);
			int index = temp.indexOf(String.valueOf(a));
			if (index == -1)
				return false;
			temp.deleteCharAt(index);
		}
		result = temp.toString().isEmpty() ? true : false;
		return result;

	}
}
