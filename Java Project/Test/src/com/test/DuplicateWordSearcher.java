package com.test;

import java.util.*;

public class DuplicateWordSearcher {
	public static void main(String[] args) {

		String text = "a,abc,xyz,a,abc,z,a";
		List<String> list = Arrays.asList(text.split(","));

		Set<String> uniqueWords = new HashSet<String>(list);
		for (String word : uniqueWords) {
			System.out.println(word + ": " + Collections.frequency(list, word));
		}
	}
}
