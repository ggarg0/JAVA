package Common;

public class MathUtil {
    static int countDigits(int n) {
        int cnt = (int) (Math.log10(n) + 1);
        return cnt;
    }

    static int absoluteValue(int n) {
        return Math.abs(n);
    }

    static double powerOf(int n, int pow) {
        return Math.pow(n, pow);
    }

    static int sqrt(int n) {
        return (int) Math.sqrt(n);
    }


    public static void main(String[] args) {
        int N = 329823;
        System.out.println("Number of Digits in N: " + countDigits(N));
        System.out.println("Power Of : " + powerOf(4, 3));
        System.out.println("sqrt Of : " + sqrt(40));
        System.out.println("Absolute Value: " + absoluteValue(-100));
    }

}
