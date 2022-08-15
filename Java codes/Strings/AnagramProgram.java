package Strings;

public class AnagramProgram {

	public static void main(String[] args) {
		String input1 = "caa";
		String input2 = "aca";
		System.out.println(input1 + " and " + input2 + " : isAnagram => " + isAnagram(input1, input2));
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
