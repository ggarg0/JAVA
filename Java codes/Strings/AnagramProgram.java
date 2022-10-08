package Strings;

public class AnagramProgram {

	public static void main(String[] args) {
		String input1 = "ab";
		String input2 = "a";
		System.out.println(input1 + " and " + input2 + " : isAnagram => " + isAnagramCheck(input1, input2));
	}

	public static boolean isAnagramCheck(String s, String t) {
		int[] arr = new int[26];
		for (int i = 0; i < s.length(); i++) {
			arr[s.charAt(i) - 'a']++;
		}

		for (int i = 0; i < t.length(); i++) {
			if (arr[t.charAt(i) - 'a'] == 0)
				return false;
			arr[t.charAt(i) - 'a']--;
		}
		return true;
	}

	public static boolean isAnagram(String word, String anagram) {
		boolean isAnagram = false;
		if (word != null && anagram != null && word.length() == anagram.length()) {
			char[] arr = word.toCharArray();
			StringBuilder temp = new StringBuilder(anagram);

			for (char ch : arr) {
				int index = temp.indexOf(String.valueOf(ch));
				if (index != -1) {
					temp.deleteCharAt(index);
				}
			}
			isAnagram = temp.toString().isEmpty();
		}
		return isAnagram;
	}

}
