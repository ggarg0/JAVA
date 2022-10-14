package Trie;

import java.util.Arrays;

public class MyTrieWithArray {

	public static class Node {
		Node[] children;
		boolean isEndWord;

		public Node() {
			children = new Node[26];
			isEndWord = false;
		}

		public void markAsLeaf() {
			isEndWord = true;
		}

		public void unMarkAsLeaf() {
			isEndWord = false;
		}
	}

	Node root;

	public MyTrieWithArray() {
		root = new Node();
	}

	public int getIndex(char x) {
		return (x - 'a');
	}

	public void insert(String key) {
		if (key == null || key.isEmpty()) {
			System.out.println("Key can not be inserted!!");
			return;
		}

		String word = key.toLowerCase();
		Node current = root;
		int index = 0;
		for (int i = 0; i < word.length(); i++) {
			index = getIndex(word.charAt(i));
			if (current.children[index] == null) {
				current.children[index] = new Node();
			}
			current = current.children[index];
		}
		current.markAsLeaf();

	}

	public boolean search(String key) {
		if (key == null || key.isEmpty()) {
			System.out.println("Key can not be search!!");
			return false;
		}

		String word = key.toLowerCase();
		Node current = root;
		int index = 0;
		for (int i = 0; i < word.length(); i++) {
			index = getIndex(word.charAt(i));
			if (current.children[index] == null) {
				return false;
			}
			current = current.children[index];
		}
		return current.isEndWord;
	}

	public static void main(String[] args) {
		String keys[] = { "the", "a", "there", "answer", "any", "by", "bye", "their", "abc" };
		MyTrieWithArray t = new MyTrieWithArray();
		System.out.println("Keys to insert: " + Arrays.toString(keys) + "\n");

		System.out.println("===========Insert======================");
		for (int i = 0; i < keys.length; i++) {
			t.insert(keys[i]);
			System.out.println("\"" + keys[i] + "\"" + " Inserted.");
		}

		System.out.println("===========Search======================");
		String searchWord = "their";
		if (t.search(searchWord) == true)
			System.out.println(searchWord + " : Found");
		else
			System.out.println(searchWord + " : Not found");
	}
}