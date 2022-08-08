public class SortInsertion {
	public static void main(String[] args) {
		int[] input = { 10, 34, 2, 56, 7, 67, 88, 42 };
		int len = input.length;

		for (int i = 1; i < len; i++) {
			int j = i - 1;
			int key = input[i];
			while (j >= 0 && input[j] > key) {
				input[j + 1] = input[j];
				j--;
			}
			display(input);
		}

	}

	public static void display(int[] input) {
		for (int r = 0; r < input.length; r++) {
			System.out.print(input[r] + ", ");
		}
		System.out.println();
	}
}