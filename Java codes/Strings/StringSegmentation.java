package Strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class StringSegmentation {

	public static boolean canSegmentString(String inputString, Set<String> dictionary) {

		// StringBuilder word = new StringBuilder(inputString);
		String word = inputString;
		Iterator<String> itr = dictionary.iterator();
		while (itr.hasNext()) {
			String wordCheck = itr.next();
			if (word.contains(wordCheck)) {
				word = word.replace(wordCheck, "");
			}

			if (word.isEmpty())
				return true;
		}

		return false;
	}

	public static void main(String[] args) {
		String[] inputStr = { "hellonow", "nowok", "applepie", "applejuice" };
		String[][] wordsDictionary = { { "hello", "hell", "on", "now" }, { "hello", "hell", "on", "now" },
				{ "apple", "pear", "pier", "pie" }, { "apple", "pear", "pier", "pie" } };
		for (int i = 0; i < inputStr.length; i++) {
			Set<String> dict = new HashSet<String>(Arrays.asList(wordsDictionary[i]));

			// Custom function to print a set of strings
			System.out.println((i + 1) + ". Words dictionary: [" + Arrays.asList(wordsDictionary[i]) + "]");

			System.out.println("   Input string: \"" + inputStr[i] + "\"");
			if (canSegmentString(inputStr[i], dict))
				System.out.println("   Result: String can be segmented");
			else
				System.out.println("   Result: String can not be segmented");
			System.out.println(
					"---------------------------------------------------------------------------------------------------\n");
		}

	}

}
