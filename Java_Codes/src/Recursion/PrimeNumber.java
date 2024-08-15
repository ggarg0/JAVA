package Recursion;

public class PrimeNumber {

    public static boolean isPrimeNum(int num, int i) {
        if (num < 2)
            return false;
        else if (i == 1)
            return true;
        else if (num % i == 0)
            return false;

        return isPrimeNum(num, i - 1);
    }

    public static void main(String[] args) {
        int input = 111;
        boolean result = isPrimeNum(input, input / 2);
        if (result) {
            System.out.println(input + " is a prime number");
        } else {
            System.out.println(input + " is not a prime number");
        }
    }

}
