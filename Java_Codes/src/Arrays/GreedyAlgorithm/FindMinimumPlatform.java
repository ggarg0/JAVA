package Arrays.GreedyAlgorithm;

import java.util.Arrays;

//https://www.educative.io/courses/algorithms-coding-interviews-java/solution-minimum-number-of-platforms-required-for-trainstation

public class FindMinimumPlatform {

    public static int findPlatform(int[] arrival, int[] departure) {

        Arrays.sort(arrival);
        Arrays.sort(departure);
        int platforms = 1;
        int arr = 1;
        int dep = 0;

        while (arr < arrival.length && dep < departure.length) {
            if (arrival[arr] <= departure[dep]) {
                platforms++;
            } else {
                dep++;
            }
			arr++;
        }
        return platforms;
    }

    public static void main(String[] args) {
        int arrival[] = {900, 940, 950, 1100, 1500, 1800};
        int departure[] = {910, 1200, 1120, 1130, 1900, 2000};
        int answer = findPlatform(arrival, departure);
        System.out.println("Minimum Number of Platforms Required for Plan1 = " + answer);

        System.out.println();

        int arrival1[] = {200, 210, 300, 320, 350, 500};
        int departure1[] = {230, 240, 320, 430, 400, 520};
        int answer2 = findPlatform(arrival1, departure1);
        System.out.println("Minimum Number of Platforms Required for Plan2 = " + answer2);
    }
}
