package Arrays.DivideAndConquer;

public class PeakElement {
	public static int findPeak(int[] array) {
		int len = array.length;
		if (len == 0) {
			return -1;
		}
		if (len == 1) {
			return array[0];
		}
		if (array[0] >= array[1]) {
			return array[0];
		}

		for (int i = 1; i < len - 1; i++) {
			if (array[i] >= array[i - 1] && array[i] >= array[i + 1]) {
				return array[i];
			}
		}

		if (array[len - 1] >= array[len - 2]) {
			return array[len - 1];
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] array = { 7, 11, 22, 13, 4, 0 };
		System.out.println("Peak element is: " + findPeak(array));

		int[] array1 = { 0, 3, 100, 2, -1, 0 };
		System.out.println("Peak element is: " + findPeak(array1));

	}

}
