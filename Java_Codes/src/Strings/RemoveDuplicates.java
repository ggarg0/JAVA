package Strings;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
	static String removeDuplicates(char[] str) {
		StringBuilder result = new StringBuilder(); 
		Set<Character> values = new HashSet<Character>();
		
		for (int i = 0; i < str.length; i++) {
			if(!values.contains(str[i])) {
				result.append(str[i]);
				values.add(str[i]);
			}

		}

		return result.toString();
	}

	public static void main(String[] args) {
		String str = "dabbac";
		System.out.println("1.     Before: " + str);
		char[] charStr = str.toCharArray();
		System.out.println("       After:  " + removeDuplicates(charStr));
		System.out.println(
				"\n-----------------------------------------------------------------------------------------------------\n");
		String str1 = "aabbbccdddeee";
		System.out.println("2.     Before: " + str1);
		charStr = str1.toCharArray();
		System.out.println("       After:  " + removeDuplicates(charStr));
		System.out.println(
				"\n-----------------------------------------------------------------------------------------------------\n");
		String str2 = "abcdef";
		System.out.println("3.     Before: " + str2);
		charStr = str2.toCharArray();
		System.out.println("       After:  " + removeDuplicates(charStr));
		System.out.println(
				"\n-----------------------------------------------------------------------------------------------------\n");

	}

}
