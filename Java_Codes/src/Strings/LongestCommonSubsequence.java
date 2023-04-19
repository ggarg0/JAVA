package Strings;

public class LongestCommonSubsequence {

	public static int findLCSLength(String s1, String s2) {
		int result = 0;
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];

		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
				result = Math.max(result, dp[i][j]);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(findLCSLength("abdca", "cbda"));
		System.out.println(findLCSLength("passport", "ppsspt"));

	}

}
