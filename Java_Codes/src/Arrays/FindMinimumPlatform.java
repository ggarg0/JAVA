package Arrays;

import java.util.Arrays;

public class FindMinimumPlatform {

	public static int findPlatform(int[] arrival, int[] departure) {

		int len = arrival.length;
		Arrays.sort(arrival);
		Arrays.sort(departure);

		int plat_needed = 1;
		int result = 1;
		int i = 1;
		int j = 0;

		while ((i < len) && (j < len)) {
			if (arrival[i] < departure[j]) {
				plat_needed += 1;
				i += 1;
				if (plat_needed > result) {
					result = plat_needed;
				}
			} else {
				plat_needed -= 1;
				j += 1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int arrival[] = { 900, 940, 950, 1100, 1500, 1800 };
		int departure[] = { 910, 1200, 1120, 1130, 1900, 2000 };
		int answer = findPlatform(arrival, departure);
		System.out.println("Minimum Number of Platforms Required for Plan1 = " + answer);

		System.out.println();

		int arrival1[] = { 200, 210, 300, 320, 350, 500 };
		int departure1[] = { 230, 240, 320, 430, 400, 520 };
		int answer2 = findPlatform(arrival1, departure1);
		System.out.println("Minimum Number of Platforms Required for Plan2 = " + answer2);
	}
}
