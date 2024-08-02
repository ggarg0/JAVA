package Arrays.TwoPointers;

public class StringReverse {
	public static void main(String[] args) {

		String wordSt = "gaurav";
		char[] word = wordSt.toCharArray();
		int left = 0;
		int right = word.length - 1;

		// Using Loop
		for (int i = left; left < right; left++, right--) {
			char temp = word[left];
			word[left] = word[right];
			word[right] = temp;
		}
		wordSt = new String(word);
		System.out.println("Using Loop : " + wordSt);

		// Using reverse function
		String wordSt1 = "gaurav";
		StringBuilder st = new StringBuilder();
		st.append(wordSt1);
		st = st.reverse();
		System.out.println("Using reverse function : " + st);

		// Using recurrsion
		String wordSt2 = reverseString("gaurav");
		System.out.println("Using recurrsion function : " + wordSt2);
	}

	public static String reverseString(String str) {
		String reverse = "";
		if (str.length() == 1) {
			return str;
		} else {
			reverse = str.charAt(str.length() - 1) +
					reverseString(str.substring(0, str.length() - 1));
			return reverse;
		}
	}
}