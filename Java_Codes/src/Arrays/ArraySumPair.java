package Arrays;

import java.util.HashSet;
import java.util.Set;

public class ArraySumPair {
	public static void main(String[] args) {
		int[] arr = { 1, 8, 45, 6, 10, 8 };
		int sum = 16;
		Set<Integer> s = new HashSet<Integer>();
		for (int j : arr) {
			int temp = sum - j;
			if (temp >= 0 && s.contains(temp)) {
				System.out.println("Pair with given sum " + sum
						+ " is (" + j + ", " + temp + ")");
			}
			s.add(j);
		}
	}
}
