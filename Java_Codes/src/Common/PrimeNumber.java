package Common;

//https://takeuforward.org/data-structure/check-if-a-number-is-prime-or-not/

public class PrimeNumber {
    public static void main(String[] args) {
        int number = 12;
        System.out.println("Prime number : " + primeNumber(number));
    }

    public static boolean primeNumber(int num) {
        int count = 0;
        int sqrtNum = (int) Math.sqrt(num);

        for (int n = 1; n <= sqrtNum; n++) {
            if (num % n == 0) {
                count++;

                if (n != num / n)
                    count++;
            }
        }
        return (count == 2);
    }
}
