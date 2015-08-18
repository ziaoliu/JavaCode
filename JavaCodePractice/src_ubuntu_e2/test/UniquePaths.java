package test;

public class UniquePaths {
	public class Solution {
		public int uniquePaths(int m, int n) {
			if (m <= 0 && n <= 0)
				return 0;
			int[][] dp = new int[m][n];
			for (int i = 0; i < m; i++)
				dp[i][0] = 1;
			for (int i = 0; i < n; i++)
				dp[0][i] = 1;
			for (int i = 1; i < m; i++)
				for (int j = 1; j < n; j++) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			return dp[m - 1][n - 1];
		}
	}

	public class SolutionTwo {
		public int uniquePaths(int m, int n) {
			return recur(0, 1, m, n) + recur(1, 0, m, n);
		}

		private int recur(int row, int col, int m, int n) {
			if (row > m || col > n)
				return 0;

			if (row == m && col == n)
				return 1;

			return recur(row + 1, col, m, n) + recur(row, col + 1, m, n);
		}
	}
}
