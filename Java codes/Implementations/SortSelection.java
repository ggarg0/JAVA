public class SortSelection {
	public static void main(String a[]) {
		int[] input = { 10, 34, 2, 56, 7, 67, 88, 42 };
		int len = input.length;
		for (int i = 0; i < len - 1; i++) {
			int index = i;
			for (int j = i + 1; j < len; j++)
				if (input[j] < input[index]) {
					index = j;
				}
			int smallerNumber = input[index];
			input[index] = input[i];
			input[i] = smallerNumber;
		}
		for (int i = 0; i < len; i++) {
			System.out.print(input[i] + ", ");
		}
	}
}