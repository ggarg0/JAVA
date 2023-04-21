package Arrays;

class ArrayMaxSumPair {
	public static void main(String[] args) {
		int arr[] = { 12, 34, 60, 45, 40 };
		int first, second;
		if (arr[0] > arr[1]) {
			first = arr[0];
			second = arr[1];
		} else {
			first = arr[1];
			second = arr[0];
		}
		for (int i = 2; i < arr.length; i++) {
			if (arr[i] > first) {
				second = first;
				first = arr[i];
			} else if (arr[i] > second && arr[i] != first)
				second = arr[i];
		}
		int sum = (first + second);
		System.out.println("Pair with given sum " + sum
				+ " is (" + first + ", " + second + ")");
	}
}