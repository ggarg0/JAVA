package Strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithDistinctCharacter {

	public static int findLongestSubstring(String str) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int max = 0;
		int start = 0;

		for (int end = 0; end < str.length(); end++) {
			if (map.containsKey(str.charAt(end))) 
				start = Math.max(start, map.get(str.charAt(end)) + 1);
						
			map.put(str.charAt(end), end);
			max = Math.max(max, end - start + 1);
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println("Length of the longest substring: " + findLongestSubstring("abcabcbb"));
		System.out.println("Length of the longest substring: " + findLongestSubstring("pwwkew"));
		System.out.println("Length of the longest substring: " + findLongestSubstring("geeksforgeeks"));
	}

}
