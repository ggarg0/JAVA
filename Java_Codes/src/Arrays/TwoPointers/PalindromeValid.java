//Write a function that takes a string as input and checks whether it can be a valid palindrome by removing at most one character from it.
package Arrays.TwoPointers;

public class PalindromeValid {
    public static void main(String[] a) {
        //   String str = "madame";
        // String str = "dead";
        //  String str = "abca";
        String str = "eeccccbebaeeabebccceea";
        System.out.println("Is Palindrome : " + isPalindrome(str, 0, str.length() - 1, false));

    }

    public static boolean isPalindrome(String str, int start, int end, boolean check) {
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                if (!check) {
                    check = !check;
                    return (isPalindrome(str, start + 1, end, check) || isPalindrome(str, start, end - 1, check));
                }
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
