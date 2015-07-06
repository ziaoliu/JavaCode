package test;

public class PalindromePartitioningIIOJ {
	public class Solution {
		public int minCut(String s) {
			if (s == null || s.length() == 0)
				return 0;

			int[] cuts = new int[s.length() + 1];
			boolean[][] matrix = new boolean[s.length()][s.length()];

			for (int i = 0; i < cuts.length; i++)
				cuts[i] = s.length() - i;

			for (int i = s.length() - 1; i >= 0; i--) {
				for (int j = i; j < s.length(); j++) {
					if ((s.charAt(i) == s.charAt(j) && j - i < 2)
							|| (s.charAt(i) == s.charAt(j) && matrix[i + 1][j - 1])) {
						matrix[i][j] = true;
						cuts[i] = Math.min(cuts[i], cuts[j + 1] + 1);
					}
				}
			}

			return cuts[0] - 1;
		}
	}
}
