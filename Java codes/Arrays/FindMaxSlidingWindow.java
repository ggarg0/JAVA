package Arrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class FindMaxSlidingWindow {

	public static void main(String[] args) {
		int[] targetList = { 3, 2, 1, 2 };
		int[][] numsList = { { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
				{ 10, 6, 9, -3, 23, -1, 34, 56, 67, -1, -4, -8, -2, 9, 10, 34, 67 }, { 4, 5, 6, 1, 2, 3 },
				{ 9, 5, 3, 1, 6, 3 } };
		for (int i = 0; i < targetList.length; i++) {
			System.out.println((i + 1) + ". Original list:\t" + Arrays.toString(numsList[i]));
			System.out.println("   Window size:\t\t" + targetList[i]);
			ArrayDeque<Integer> ouput = findMaxSlidingWindow(numsList[i], targetList[i]);
			System.out.println("   Max:\t\t\t" + ouput);
			System.out.println(
					"-----------------------------------------------------------------------------------------------------\n");
		}

	}

	public static ArrayDeque<Integer> findMaxSlidingWindow(int[] arr, int windowSize) {
		ArrayDeque<Integer> result = new ArrayDeque<>(); // ArrayDeque for storing values
		Deque<Integer> list = new ArrayDeque<Integer>(); // creating a linked list

		if (arr.length > 0) {

			if (arr.length < windowSize)
				windowSize = arr.length;
			for (int i = 0; i < windowSize; ++i) {

				while (!list.isEmpty() && arr[i] >= arr[list.peekLast()]) {
					list.removeLast();
				}

				list.addLast(i);
			}

			for (int i = windowSize; i < arr.length; ++i) {
				result.add(arr[list.peek()]);

				while ((!list.isEmpty()) && list.peek() <= i - windowSize)
					list.removeFirst();

				while ((!list.isEmpty()) && arr[i] >= arr[list.peekLast()])
					list.removeLast();

				list.addLast(i);
			}

			result.add(arr[list.peek()]);
			return result;
		} else
			return result;
	}

}
