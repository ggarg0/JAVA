package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class AnagramGroup {

	public static String groupAnagrams(String[] arr) {
		StringBuilder anagrams = new StringBuilder();
		Map<String, List<String>> map = new HashMap<>();

		for (String word : arr) {
			char[] letters = word.toCharArray();
			Arrays.sort(letters);
			String sortedWord = new String(letters);

			map.computeIfAbsent(sortedWord, k -> new ArrayList<>()).add(word);
		}

		for (List<String> words : map.values()) {
			anagrams.append(words);
		}
		return anagrams.toString();
	}

	public static void main(String[] args) {
		String[] arr = { "cat", "dog", "tac", "god", "act", "tom marvolo riddle ", "abc", "def", "cab", "fed",
				"clint eastwood ", "i am lord voldemort", "elvis", "old west action", "lives" };
		System.out.println(groupAnagrams(arr));
	}
}
