package Recursion;

public class ReverseString {

    public static String reversedString(String text) {
        char[] arr = text.toCharArray();
        return String.valueOf(reverse(arr, 0, arr.length - 1));
    }

    public static char[] reverse(char[] arr, int start, int end) {
        if (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            reverse(arr, start + 1, end - 1);
        }
        return arr;
    }

    public static void main(String[] args) {
        String input = "hell0";
        System.out.println("Original String : " + input + " and reversed string : " + reversedString(input));
    }
}

