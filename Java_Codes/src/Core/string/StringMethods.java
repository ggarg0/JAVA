package Core.string;

public class StringMethods {
	public static void main(String[] args) {

		String s = "LearningJava";

		// Returns the number of characters in the String.
		System.out.println("String length = " + s.length());

		// Returns the character at ith index.
		System.out.println("Character at 3rd position = " + s.charAt(3));

		// Return the substring from the ith index character
		// to end of string
		System.out.println("Substring " + s.substring(3));

		// Returns the substring from i to j-1 index.
		System.out.println("Substring = " + s.substring(2, 5));

		// Concatenates string2 to the end of string1.
		String s1 = "Learning";
		String s2 = "Java";
		System.out.println("Concatenated string = " + s1.concat(s2));
		System.out.println("Concatenated string = " + s1);
		System.out.println("Concatenated string = " + s2);

		// Returns the index within the string
		// of the first occurrence of the specified string.
		String s4 = "Learn Share Learn";
		System.out.println("Index of Share " + s4.indexOf("Share"));

		// Checking equality of Strings
		Boolean out = "Java".equals("java");
		System.out.println("Checking Equality " + out);
		out = "Java".equals("Java");
		System.out.println("Checking Equality " + out);

		out = "Java".equalsIgnoreCase("jAva");
		System.out.println("Checking Equality " + out);

		// Converting cases
		System.out.println("Changing to lower Case " + s.toLowerCase());

		// Converting cases
		System.out.println("Changing to UPPER Case " + s.toUpperCase());

		// Trimming the word
		String word4 = " Learn Java   ";
		System.out.println("String length = " + word4.length());
		System.out.println("Trim the word : " + word4.trim());
		System.out.println("String length = " + word4.trim().length());

		// Replacing characters
		String str1 = "Learn Java";
		System.out.println("Original String " + str1);
		String str2 = str1.replace('a', '@');
		System.out.println("Replaced a with @ -> " + str2);
	}
}
