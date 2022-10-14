package Trie;

import java.util.Arrays;

public class FormWordFromDictionary {

	public static boolean isFormationPossible(String dict[], String word) {
		if (word.length() < 2 || dict.length < 2) 
			return false;
		
		MyTrieWithArray trie = new MyTrieWithArray();

		for (String dictWord : dict)
			trie.insert(dictWord);

		for(int i = 0; i < word.length(); i++) {
			String first = word.substring(0, i);
			String second = word.substring(i, word.length());
			
			if(trie.search(first) && trie.search(second)) 
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// Input dict (use only 'a' through 'z' and lower case)
		String dict[] = { "the", "hello", "there", "answer", "any", "dragon", "world", "their", "inc" };
		System.out.println("Keys: " + Arrays.toString(dict));

		if (isFormationPossible(dict, "answerany"))
			System.out.println("true");
		else
			System.out.println("false");

	}

}
