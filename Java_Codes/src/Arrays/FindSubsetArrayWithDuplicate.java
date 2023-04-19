package Arrays;

import java.util.ArrayList;
import java.util.List;

public class FindSubsetArrayWithDuplicate {

	public static List<List<Integer>> findSubsets(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<>();
		subsets.add(new ArrayList<Integer>());

		for (int num : nums) {
			int size = subsets.size();
			for (int i = 0; i < size; i++) {
				List<Integer> list = new ArrayList<Integer>(subsets.get(i));
				list.add(num);
				subsets.add(list);
			}
		}
		return subsets;
	}

	public static void main(String[] args) {
		List<List<Integer>> result = findSubsets(new int[] { 1, 3, 3 });
		System.out.println("Result: " + result);

		result = findSubsets(new int[] { 1, 5, 3 });
		System.out.println("Result: " + result);

	}

}
