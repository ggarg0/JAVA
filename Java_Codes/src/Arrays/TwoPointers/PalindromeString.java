package Arrays.TwoPointers;

public class PalindromeString {
	public static void main(String[] a) {
		String str = "122221";
		char[] arr = str.toCharArray();
		boolean isPalindrome = true;
		int left = 0;
		int right = (arr.length-1);

		for (int i = left; left<right; left++, right--) {
			if (arr[left] == arr[right]) {
				continue;
			}
			else {
				isPalindrome = false;
				break;
			}
		}
		System.out.println("Is Palindrome : " + isPalindrome);
	}
}