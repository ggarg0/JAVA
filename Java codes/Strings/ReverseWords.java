package Strings;

public class ReverseWords {

	public static void main(String[] args) {
		String stringToReverse = "The quick brown fox jumped over the lazy dog.";
		String[] words = stringToReverse != null ? stringToReverse.split(" ") : new String[0];
		StringBuilder reversed = new StringBuilder();

		for (int i = words.length - 1; i >= 0; i--) 
			reversed.append(words[i] + " ");
		
		System.out.println(reversed.toString().trim().isEmpty() ? "Empty string" : reversed.toString().trim());
	}
}
