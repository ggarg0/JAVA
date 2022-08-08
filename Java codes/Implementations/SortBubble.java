public class SortBubble {
	public static void main(String[] args) {
		int[] input = { 10, 34, 2, 56, 7, 67, 88, 42 };
		boolean sort = true;
		while (sort) {
			sort = false;
			for (int i = 0; i < input.length - 1; i++) {
				if (input[i] > input[i + 1]) {
					int temp = input[i];
					input[i] = input[i + 1];
					input[i + 1] = temp;
					sort = true;
				}
			}
			for (int i : input) {
				System.out.print(i + ", ");
			}
			System.out.println();
		}

		
	}
}