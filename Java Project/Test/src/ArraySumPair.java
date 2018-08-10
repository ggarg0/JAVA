import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ArraySumPair {
	public static void main(String[] args) {
		Integer[] arr = { 1, 8, 45, 6, 10, 8};
		int sum = 16;


		HashSet<Integer> s = new HashSet<Integer>();
		for (int i = 0; i < arr.length; ++i) {
			int temp = sum - arr[i];
			System.out.print("Temp : " + temp);
			if (temp >= 0 && s.contains(temp)) {
				System.out.print("   Pair with given sum " + sum 
						+ " is (" + arr[i] + ", " + temp + ")");
			}
			s.add(arr[i]);
			System.out.println("   ArrAy : " + s);
		}
	}
}
