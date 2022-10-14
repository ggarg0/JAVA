package Trie;

import java.util.ArrayList;
import java.util.Arrays;
import Trie.MyTrieWithArray.Node;

public class AllWordsInMyTrieWithArray {

	public static void findWord(Node node, int level, char[] word, ArrayList<String> result) {

		if (node.isEndWord) {
			String temp = "";
			for (int i = 0; i < level; i++) {
				temp += word[i];
			}
			result.add(temp);
		}

		for (int i = 0; i < 26; i++) {
			if(node.children[i] != null) {
				word[level] = (char) (i + 'a');
				findWord(node.children[i], level + 1, word, result) ;
			}
		}

	}

	public static ArrayList<String> findWords(Node node) {
		ArrayList<String> result = new ArrayList<String>();
		char[] word = new char[26];
		findWord(node, 0, word, result);
		return result;
	}

	public static void main(String[] args) {
		// String keys[] = { "a", "dc" };
		String keys[] = { "the", "a", "there", "answer", "any", "by", "bye", "their", "abc" };
		MyTrieWithArray t = new MyTrieWithArray();
		System.out.println("Keys: " + Arrays.toString(keys));
		for (int i = 0; i < keys.length; i++)
			t.insert(keys[i]);

		ArrayList<String> list = findWords(t.root);
		System.out.println("Number of words : " + list.size());
		System.out.println("Words in sorted order : " + list.toString());
	}

}
