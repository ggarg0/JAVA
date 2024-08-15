package Common;

//https://takeuforward.org/data-structure/find-gcd-of-two-numbers/

public class GCD {

    public static int getGCD(int a, int b) {

        while (a > 0 && b > 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }

        if (a == 0) {
            return b;
        }
        return a;
    }

    public static void main(String[] args) {
        int n1 = 18, n2 = 3;
        System.out.println("GCD : " + getGCD(n1, n2));
    }
}
