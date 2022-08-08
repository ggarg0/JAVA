package Array;

public class CheckMergeArray {

	public static void main(String[] args) {

		int[] arr1 = { 1, 3, 4, 5, 17, 18, 20 };
		int[] arr2 = { 2, 6, 7, 8, 9 };

		int s1 = arr1.length;
		int s2 = arr2.length;

		int[] result = new int[s1 + s2];

		int i = 0;
		int j = 0;
		int n = 0;
		while (i < s1 && j < s2) {
			if (arr1[i] < arr2[j])
				result[n++] = arr1[i++];
			else
				result[n++] = arr2[j++];
		}

		while (i < s1)
			result[n++] = arr1[i++];

		while (j < s2)
			result[n++] = arr2[j++];

		for (int l = 0; l < result.length; l++) {
			System.out.print(result[l] + ", ");
		}
	}
}
