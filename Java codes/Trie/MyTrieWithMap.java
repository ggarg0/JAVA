package Trie;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MyTrieWithMap {

	public static class TrieNode {
		char data;
		Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
		boolean isEndWord = false;

		public TrieNode() {}
		
		public TrieNode(char c) {
			data = c;
		}
	}

	TrieNode root;

	public MyTrieWithMap() {
		root = new TrieNode();
	}

	// Add a word to trie, Iteration, Time O(s), Space O(s), s is word length
	public void insert(String word) {
		if (word == null || word.isEmpty()) {
			System.out.println("Not a valid word for searched!!");
			return;
		}

		TrieNode node = root;
		for (char c : word.toCharArray()) {
			if (!node.children.containsKey(c)) {
				node.children.put(c, new TrieNode(c));
			}
			node = node.children.get(c);
		}
		node.isEndWord = true;
		System.out.println(word + " inserted !!");
	}

	public boolean search(String word) {
		if (word == null || word.isEmpty()) {
			System.out.println("Not a valid word for searched!!");
			return false;
		}

		TrieNode node = root;
		for (char c : word.toCharArray()) {
			if (!node.children.containsKey(c)) {
				return false;
			}
			node = node.children.get(c);
		}
		return node.isEndWord = true;
	}

	public static void main(String[] args) {
		String keys[] = { "the", "a*", "there", "answer", "any", "by", "bye", "their", "abc" };
		MyTrieWithMap t = new MyTrieWithMap();
		System.out.println("Keys to insert: " + Arrays.toString(keys) + "\n");

		System.out.println("===========Insert======================");
		for (String word : keys)
			t.insert(word);

		System.out.println("===========Search======================");
		String searchWord = "a*";
		if (t.search(searchWord) == true)
			System.out.println(searchWord + " : Found");
		else
			System.out.println(searchWord + " : Not found");

	}

}
