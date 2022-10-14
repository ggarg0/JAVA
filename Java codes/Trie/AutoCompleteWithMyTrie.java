package Trie;

import java.util.LinkedList;
import java.util.List;

import Trie.MyTrieWithMap.TrieNode;

public class AutoCompleteWithMyTrie {

	public static List<String> autocomplete(String prefix, TrieNode node) {
		List<String> res = new LinkedList<String>();

		for (char ch : prefix.toCharArray()) {
			if (node.children.containsKey(ch))
				node = node.children.get(ch);
			else
				return res;
		}

		helper(node, res, prefix.substring(0, prefix.length() - 1));
		return res;
	}

	public static void helper(TrieNode node, List<String> res, String prefix) {
		if (node.isEndWord)
			res.add((prefix + node.data).trim());
		for (Character ch : node.children.keySet())
			helper(node.children.get(ch), res, prefix + node.data);
	}

	public static void main(String[] args) {
		MyTrieWithMap t = new MyTrieWithMap();
		t.insert("amazon");
		t.insert("amazon prime");
		t.insert("amazing");
		t.insert("amazing spider man");
		t.insert("amazed");
		t.insert("apple");

		System.out.println(autocomplete("", t.root));
	}
}
