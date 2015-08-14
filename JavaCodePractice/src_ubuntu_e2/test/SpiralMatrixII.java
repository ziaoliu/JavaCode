package test;

public class SpiralMatrixII {
	public class Solution {
		public int[][] generateMatrix(int n) {
			int[][] result = new int[n][n];
			if (n == 0)
				return result;
			int level = n / 2;
			int count = 1;
			for (int i = 0; i < level; i++) {
				for (int j = i; j < n - 1 - i; j++)
					result[i][j] = count++;
				for (int j = i; j < n - 1 - i; j++)
					result[j][n - 1 - i] = count++;
				for (int j = n - 1 - i; j > i; j--)
					result[n - 1 - i][j] = count++;
				for (int j = n - 1 - i; j > i; j--)
					result[j][i] = count++;
			}
			if (n % 2 == 1) {
				result[level][level] = count;
			}
			return result;
		}
	}
}
