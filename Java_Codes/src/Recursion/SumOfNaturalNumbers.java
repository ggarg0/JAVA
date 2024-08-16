package Recursion;

public class SumOfNaturalNumbers {
    public static int sumOfNaturalNumbers(int n) {

        if (n == 1)
            return n;

        return n + sumOfNaturalNumbers(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("Sum : " + sumOfNaturalNumbers(6));
    }
}
