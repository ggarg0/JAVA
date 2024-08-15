package Common;

//https://takeuforward.org/maths/reverse-digits-of-a-number

public class ReverseNumber {

    public static int reverse(int num) {
        int rev = 0;
        while (num > 0) {
            int lastDigit = num % 10;
            if (rev > (Integer.MAX_VALUE - lastDigit) / 10) {
                return 0;
            }
            rev = rev * 10 + lastDigit;
            num = num / 10;
        }
        return rev;
    }

    public static void main(String[] args) {
        int N = 1534236469;
        System.out.println("Reversed number : " + reverse(N));
    }
}
