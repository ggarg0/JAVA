package Arrays.DivideAndConquer;

import java.util.ArrayList;
import java.util.Collections;

//https://www.educative.io/courses/algorithms-coding-interviews-java/solution-merge-a-number-of-sorted-arrays

public class MergeSortedArrays {
	public static ArrayList<Integer> mergeSortedArrays(int[][] arr, ArrayList<Integer> Output) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				Output.add(arr[i][j]);
			}
		}
		Collections.sort(Output);
		return Output;
	}

	public static void main(String[] args) {
		int[][] arr = { { 16, 25, 36 }, { 2, 9, 15 }, { 22, 55, 67 }, { 79, 38, 99 } };
		ArrayList<Integer> Output = new ArrayList<Integer>();
		System.out.print(mergeSortedArrays(arr, Output));
	}
}
