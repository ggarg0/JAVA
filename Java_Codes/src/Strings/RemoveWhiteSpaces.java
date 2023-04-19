package Strings;

import java.util.Arrays;

public class RemoveWhiteSpaces {

	static String removeWhiteSpaces(String s) {

		// Approach 1
		String result = s.replace(" ", "").replace("\t", "");

		// Approach2
		String result2 = "";
		char[] arr = s.toCharArray();

		int len = arr.length;
		int read = 0;
		int write = 0;
		char[] resultArr = new char[len];

		while (read < len) {

			if (arr[read] != ' ' && arr[read] != '\t') {
				resultArr[write] = arr[read];
				write++;
			}
			read++;
		}

		result2 = String.valueOf(Arrays.copyOfRange(resultArr, 0, write));
		return result2;

	}

	public static void main(String[] args) {

		String str1 = "All greek to me.";
		System.out.println("1.    Actual string:	           " + str1);

		System.out.println(" String without spaces or tabs: " + removeWhiteSpaces(str1));
		System.out.println(
				"-----------------------------------------------------------------------------------------------------\n");
		String str2 = "We love	Java	";
		System.out.println("2.    Actual string:            " + str2);

		System.out.println(" String without spaces or tabs: " + removeWhiteSpaces(str2));
		System.out.println(
				"-----------------------------------------------------------------------------------------------------\n");
		String str3 = "You are amazing";
		System.out.println("3.    Actual string:            " + str3);

		System.out.println(" String without spaces or tabs: " + removeWhiteSpaces(str3));
		System.out.println(
				"-----------------------------------------------------------------------------------------------------\n");
	}
}
