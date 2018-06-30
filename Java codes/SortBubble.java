public class SortBubble {
	public static void main(String[] args) {
		int[] input = { 10, 34, 2, 56, 7, 67, 88, 42 };
		int len = input.length;
		int temp;
		for (int i = 0; i < len - 1; i++) {
			for (int j = 1; j < (len - i); j++) {
				if (input[j] < input[j - 1]) {
					temp = input[j];
					input[j] = input[j - 1];
					input[j - 1] = temp;
				}
			}
		}
		for (int i = 0; i < len; i++) {
			System.out.print(input[i] + ", ");
		}
	}
}