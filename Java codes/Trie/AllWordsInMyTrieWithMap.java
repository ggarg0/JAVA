package Trie;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import Trie.MyTrieWithMap.TrieNode;

public class AllWordsInMyTrieWithMap {

	public static List<String> findWords(TrieNode node) {
		List<String> res = new LinkedList<String>();
		String word = "";
		findWord(node, res, word);
		return res;
	}

	public static void findWord(TrieNode node, List<String> res, String word) {
		if (node.isEndWord)
			res.add((word + node.data).trim());
		for (Character ch : node.children.keySet())
			findWord(node.children.get(ch), res, word + node.data);
	}

	public static void main(String[] args) {
		String keys[] = { "the", "a", "there", "answer", "88", "by", "bye", "their", "abc" , "@ad" , "*5*/"};
		//String keys[] = { "1" };
		MyTrieWithMap t = new MyTrieWithMap();
		System.out.println("Keys: " + Arrays.toString(keys));
		for (int i = 0; i < keys.length; i++)
			t.insert(keys[i]);

		List<String> list = findWords(t.root);
		System.out.println("Number of words : " + list.size());
		System.out.println("Words in sorted order : " + list.toString());
	}

}
