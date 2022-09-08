package Strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {

	public static int findLength(String str, int k) {
		int start = 0;
		int max = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < str.length(); i++) {
			map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
			while (map.size() > k) {
				map.put(str.charAt(start), map.get(str.charAt(start)) - 1);
				if (map.get(str.charAt(start)) == 0) {
					map.remove(str.charAt(start));
				}
				start++;
			}
			max = Math.max(max, i - start + 1);
		}

		return max;
	}

	public static void main(String[] args) {
		System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
		System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
		System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));

	}

}
