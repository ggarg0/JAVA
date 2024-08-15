package Arrays.GreedyAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://www.educative.io/courses/grokking-coding-interview-patterns-java/solution-largest-palindromic-number

public class LargestPalindrome {
    public static String largestPalindrome(String num) {
        Map<Character, Integer> occurrences = new HashMap<>();

        for (char digit : num.toCharArray()) {
            occurrences.put(digit, occurrences.getOrDefault(digit, 0) + 1);
        }

        List<String> firstHalf = new ArrayList<>();
        String middle = "";

        for (char digit = '9'; digit >= '0'; digit--) {
            if (occurrences.containsKey(digit)) {
                int digitCount = occurrences.get(digit);
                int numPairs = digitCount / 2;

                if (numPairs > 0) {
                    if (firstHalf.isEmpty() && digit == '0') {
                        occurrences.put('0', 1);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < numPairs; i++) {
                            sb.append(digit);
                        }
                        firstHalf.add(sb.toString());
                    }
                }

                if (digitCount % 2 == 1 && middle.isEmpty()) {
                    middle = Character.toString(digit);
                }
            }
        }

        if (middle.isEmpty() && firstHalf.isEmpty()) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        for (String part : firstHalf) {
            result.append(part);
        }
        String secondHalf = result.toString();
        result.append(middle).append(new StringBuilder(secondHalf).reverse().toString());

        return result.toString();
    }

    // Driver code
    public static void main(String[] args) {
        String[] numbers = {"00001", "1234287", "9876545367282", "000000", "146"};

        for (int i = 0; i < numbers.length; i++) {
            System.out.println((i + 1) + ".\tGiven number: \"" + numbers[i] + "\"");
            String result = largestPalindrome(numbers[i]);
            System.out.println("\n\tThe largest palindromic number: \"" + result + "\"");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
