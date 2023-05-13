package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramGroup {

	public static String groupAnagrams(String[] arr) {
		StringBuilder anagrams = new StringBuilder();
		Map<String, List<String>> map = new HashMap<String, List<String>>();

		for (String word : arr) {
			char[] letters = word.toCharArray();
			Arrays.sort(letters);
			String sortedWord = new String(letters);

			if (map.containsKey(sortedWord)) {
				map.get(sortedWord).add(word);
			} else {
				List<String> list = new ArrayList<String>();
				list.add(word);
				map.put(sortedWord, list);
			}
		}

		for (String words : map.keySet()) 
			anagrams.append(map.get(words));

		return anagrams.toString();
	}

	public static void main(String[] args) {
		String[] arr = { "cat", "dog", "tac", "god", "act", "tom marvolo riddle ", "abc", "def", "cab", "fed",
				"clint eastwood ", "i am lord voldemort", "elvis", "old west action", "lives" };
		System.out.println(groupAnagrams(arr));
	}
}
