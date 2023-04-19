package Strings;

public class MinimumDeletionsInsertions {

	private static int findLCSLength(String s1, String s2) {
		int result = 0;
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];

		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
				result = Math.max(result, dp[i][j]);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String S1 = "passport";
		String S2 = "ppsspt";

		int len = findLCSLength(S1, S2);
		System.out.println("Deletion : " + (S1.length() - len) + " and insertion : " + (S2.length() - len));
	}
}
