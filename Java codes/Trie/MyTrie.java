package Trie;

import java.util.Arrays;

public class MyTrie {

	public static class Node {
		Node[] children;
		boolean isEndWord;
		static final int ALPHABET_SIZE = 26;

		Node() {
			this.isEndWord = false;
			this.children = new Node[ALPHABET_SIZE];
		}

		public void markAsLeaf() {
			this.isEndWord = true;
		}

		public void unMarkAsLeaf() {
			this.isEndWord = false;
		}
	}

	private Node root;

	MyTrie() {
		root = new Node();
	}

	public int getIndex(char x) {
		return x - 'a';
	}

	public void insert(String key) {
		if (key == null) {
			System.out.println("Null Key can not be Inserted!");
			return;
		}
		key = key.toLowerCase();
		Node currentNode = this.root;
		int index = 0;

		for (int level = 0; level < key.length(); level++) {
			index = getIndex(key.charAt(level));
			if (currentNode.children[index] == null) {
				currentNode.children[index] = new Node();
			}
			currentNode = currentNode.children[index];
		}
		currentNode.markAsLeaf();
	}

	public boolean search(String key) {
		if (key == null)
			return false;

		key = key.toLowerCase();
		Node currentNode = this.root;
		int index = 0;

		for (int level = 0; level < key.length(); level++) {
			index = getIndex(key.charAt(level));
			if (currentNode.children[index] == null)
				return false;
			currentNode = currentNode.children[index];
		}
		return currentNode.isEndWord;
	}

	public static void main(String[] args) {
		String keys[] = { "the", "a", "there", "answer", "any", "by", "bye", "their", "abc" };
		MyTrie t = new MyTrie();
		System.out.println("Keys to insert: " + Arrays.toString(keys) + "\n");

		System.out.println("===========Insert======================");
		for (int i = 0; i < keys.length; i++) {
			t.insert(keys[i]);
			System.out.println("\"" + keys[i] + "\"" + "Inserted.");
		}

		System.out.println("===========Search======================");
		String searchWord = "ther";
		if (t.search(searchWord) == true)
			System.out.println(searchWord + " : Found");
		else
			System.out.println(searchWord + " : Not found");
	}
}
