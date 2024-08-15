package Common;

import java.util.ArrayList;
import java.util.List;

public class PrintAllDivisors {
    public static void main(String[] args) {
        int number = 13;
        List<Integer> divisors = findDivisors(number);
        System.out.println("Divisors of " + number + ": " + divisors);
    }

    public static List<Integer> findDivisors(int num) {
        List<Integer> result = new ArrayList<>();
        int sqrtNum = (int) Math.sqrt(num);

        for (int divisor = 1; divisor <= sqrtNum; divisor++) {
            if (num % divisor == 0) {
                result.add(divisor);
                if (divisor != num / divisor) {
                    // Avoid duplicate divisors (except for perfect squares)
                    result.add(num / divisor);
                }
            }
        }

        return result;
    }
}
