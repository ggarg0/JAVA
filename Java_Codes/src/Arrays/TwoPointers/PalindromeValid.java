//Write a function that takes a string as input and checks whether it can be a valid palindrome by removing at most one character from it.
package Arrays.TwoPointers;

public class PalindromeValid {
    public static void main(String[] a) {
        System.out.println("Is Palindrome : " + isPalindrome("madame"));
		System.out.println("Is Palindrome : " + isPalindrome("dead"));
		System.out.println("Is Palindrome : " + isPalindrome("abca"));
		System.out.println("Is Palindrome : " + isPalindrome("eeccccbebaeeabebccceea"));
    }

    public static boolean isPalindrome(String str) {
		System.out.println("Verifying : " + str);
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return validPalindrome(str, start + 1, end) || validPalindrome(str, start, end - 1);
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean validPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
