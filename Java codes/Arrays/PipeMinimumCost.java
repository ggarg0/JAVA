package Arrays;

import java.util.Arrays;

public class PipeMinimumCost {

	public static int minCost(int[] pipes) {
		int cost = 0;
		int sum = 0;
		int previousCost = 0;
		
		Arrays.sort(pipes);		
		for (int i = 0; i < pipes.length - 1; i++) {
			previousCost = cost;
			sum = sum + pipes[i];
			cost = sum + pipes[i + 1] + previousCost;
		}
		return cost;
	}

	public static void main(String[] args) {
		int[] pipes = { 2, 3, 4, 6 };
		System.out.println("Total cost for connecting pipes is " + minCost(pipes));
		int[] pipes1 = { 1, 1, 2, 6 };
		 System.out.println("Total cost for connecting pipes1 is " + minCost(pipes1));
	}
}
