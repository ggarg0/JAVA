package Strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithDistinctCharacter {

	public static int findLongestSubstring(String str) {
		int maxLength = 0;
		int start = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < str.length(); i++) {
			
			while (map.containsKey(str.charAt(i))) {
				map.put(str.charAt(start), map.get(str.charAt(start)) - 1);
				if (map.get(str.charAt(start)) == 0) {
					map.remove(str.charAt(start));
				}
				start++;
			}
			map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
			maxLength = Math.max(maxLength, i - start + 1);
		}

		return maxLength;
	}

	public static void main(String[] args) {
		System.out.println("Length of the longest substring: " + findLongestSubstring("abcabcbb"));
		System.out.println("Length of the longest substring: " + findLongestSubstring("abbbb"));
		System.out.println("Length of the longest substring: " + findLongestSubstring("abccde"));
	}

}
