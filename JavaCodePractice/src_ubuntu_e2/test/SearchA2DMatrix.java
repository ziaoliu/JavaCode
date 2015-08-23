package test;

public class SearchA2DMatrix {
	public static void main(String[] args) {
		SearchA2DMatrix test = new SearchA2DMatrix();
		Solution t = test.new Solution();
		int[][] array = { { 1, 3, 5 } };
		System.out.println(t.searchMatrix(array, 3));
	}

	public class Solution {
		public boolean searchMatrix(int[][] matrix, int target) {
			if (matrix == null | matrix.length == 0 || matrix[0].length == 0)
				return false;
			int m = matrix.length;
			int n = matrix[0].length;
			int rowStart = 0;
			int rowEnd = m - 1;
			while (rowStart <= rowEnd) {
				int rowMid = (rowStart + rowEnd) / 2;
				if (target == matrix[rowMid][0])
					return true;
				if (target < matrix[rowMid][0])
					rowEnd = rowMid - 1;
				else if (target > matrix[rowMid][n - 1])
					rowStart = rowMid + 1;
				else { // target in {[rowMid, 0] ... [rowMid, n - 1]}
					int colStart = 0;
					int colEnd = n - 1;
					while (colStart <= colEnd) {
						int colMid = (colStart + colEnd) / 2;
						if (target == matrix[rowMid][colMid]) // <===col mid!!!
							return true;
						if (target < matrix[rowMid][colMid]) // <==== col mid!!!
							colEnd = colMid - 1;
						else
							colStart = colMid + 1;
					}
					return false;
				}
			}
			return false;
		}
	}
}
