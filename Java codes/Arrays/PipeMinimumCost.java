package Arrays;

import java.util.Arrays;

public class PipeMinimumCost {

	public static int minCost(int[] pipes) {

		int cost = 0;
		int n = pipes.length;

		Arrays.sort(pipes);
		for (int i = 0; i < n - 1; i++) {
			int prevCost = cost;
			cost = pipes[i] + pipes[i+1];
			cost = prevCost + cost;
		}
		return cost;
	}

	public static void main(String[] args) {
		int[] pipes = { 2,3,4,6};
		System.out.println("Total cost for connecting pipes is " + minCost(pipes));
		int[] pipes1 = { 1, 1, 2, 6 };
		System.out.println("Total cost for connecting pipes1 is " + minCost(pipes1));

	}

}
