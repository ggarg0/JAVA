package Collections;

import java.util.HashSet;

public class ArraySumPair {
	public static void main(String[] args) {
		int arr[] = { 1, 8, 45, 6, 10, 8 };
		int sum = 16;
		HashSet<Integer> s = new HashSet<Integer>();
		for (int i = 0; i < arr.length; ++i) {
			int temp = sum - arr[i];
			if (temp >= 0 && s.contains(temp)) {
				System.out.println("Pair with given sum " + sum 
						+ " is (" + arr[i] + ", " + temp + ")");
			}
			s.add(arr[i]);
		}
	}
}
