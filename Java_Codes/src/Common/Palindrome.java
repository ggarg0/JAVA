package Common;

//https://takeuforward.org/data-structure/check-if-a-number-is-palindrome-or-not/

public class Palindrome {
    public static boolean palindrome(int num) {
        int original = num;
        int rev = 0;
        while (num > 0) {
            int lastDigit = num % 10;
            rev = (rev * 10) + lastDigit;
            num = num / 10;
        }
        return original == rev;
    }

    public static void main(String[] args) {
        int N = 7887;
        System.out.println("Palindrome : " + palindrome(N));
    }
}
