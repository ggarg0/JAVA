//Write a function that takes a string as input and checks whether it can be a valid palindrome by removing at most one character from it.
package Arrays.TwoPointers;

//https://www.educative.io/courses/grokking-coding-interview-patterns-java/valid-palindrome-ii

public class ValidPalindrome {
    public static void main(String[] a) {
        //   String str = "madame";
        // String str = "dead";
        //  String str = "abca";
        String str = "eecccbebaeeabebcccee1f";
        System.out.println("Is Palindrome : " + isPalindrome(str, 0, str.length() - 1, true));
        System.out.println("Is Palindrome : " + isValid(str, true));

    }

    public static boolean isValid(String str, boolean check) {

        if (str.length() <= 1) {
            return true;
        }

        if (str.charAt(0) != str.charAt(str.length() - 1)) {
            if (check) {
                check = !check;
                return isValid(str.substring(1, str.length()), check)
                        || isValid(str.substring(0, str.length() - 1), check);
            }
            return false;
        } else {
            return isValid(str.substring(1, str.length() - 1), check);
        }

    }


    public static boolean isPalindrome(String str, int start, int end, boolean check) {
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                if (check) {
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
