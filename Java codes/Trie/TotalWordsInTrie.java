package Trie;

import java.util.Arrays;
import Trie.MyTrieWithArray.Node;

public class TotalWordsInTrie {

	public static int totalWords(Node root) {
		int result = 0;
		
		if (root.isEndWord)
			result++;

		for (int i = 0; i < 26; i++) {
			if (root.children[i] != null)
				result += totalWords(root.children[i]);
		}
		return result;
	}

	public static void main(String[] args) {
		String keys[] = {  "a", "bd", "abc" };
		System.out.println("Keys: " + Arrays.toString(keys));
		MyTrieWithArray t = new MyTrieWithArray();
		for (int i = 0; i < keys.length; i++)
			t.insert(keys[i]);

		System.out.println("Total number of words : " + totalWords(t.root));
	}
}
