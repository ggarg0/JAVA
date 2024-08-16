package Recursion;

public class StringPalindrome {

    public static boolean isPalindrome(String text) {
        if (text.length() == 1) {
            return true;
        } else {
            if (text.charAt(0) == text.charAt(text.length() - 1)) {
                return isPalindrome(text.substring(1, text.length() - 1));
            }
        }
        return false;
    }

    public static boolean isPalindromeArray(String text) {
        char[] arr = text.toCharArray();
        return checkPalindromeArray(arr, 0, arr.length - 1);
    }

    public static boolean checkPalindromeArray(char[] arr, int start, int end) {
        if (start == end)
            return true;
        else {
            if (arr[start] == arr[end]) {
                return checkPalindromeArray(arr, start + 1, end - 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String input1 = "12221";
        String input2 = "12221";
        boolean answer1 = isPalindrome(input1);
        boolean answer2 = isPalindromeArray(input2);
        System.out.println("Is " + input1 + " a Palindrome? = " + answer1);
        System.out.println("Is " + input2 + " a Palindrome? = " + answer2);

    }

}
