package Arrays;

public class FindMinSubArrayForSum {

	public static void main(String[] args) {

		int[] arr = { 2, 1, 5, 2, 3, 2 };
		int key = 8;
		
		int count = 0;
		int minCount = arr.length;
		
		int sum = 0;		
		int start = 0;		

		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			count++;
			while (sum >= key) {
				minCount = Math.min(count, minCount);
				sum = sum - arr[start];
				start++;
				count--;
			}
		}
		System.out.println(minCount);
	}
}
