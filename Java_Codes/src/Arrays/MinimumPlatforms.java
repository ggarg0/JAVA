package Arrays;

import java.util.Arrays;

public class MinimumPlatforms {
	public static int findPlatform(int[] arr, int[] dep) {

		int n = arr.length;
		Arrays.sort(arr);
		Arrays.sort(dep);

		int plat_needed = 1;
		int result = 1;
		int a = 1, d = 0;

		while (a < n && d < n) {
			if (arr[a] < dep[d]) {
				plat_needed++;
				a++;
				if (result < plat_needed) {
					result = plat_needed;
				}
			} else {
				plat_needed--;
				d++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int arrival[] = { 900, 940, 950, 1100, 1500, 1800 };
		int departure[] = { 910, 1200, 1120, 1130, 1900, 2000 };
		int answer = findPlatform(arrival, departure);
		System.out.println("Minimum Number of Platforms Required for Plan = " + answer);
	}
}
