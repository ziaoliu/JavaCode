package test;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public class Solution {
		public List<Integer> spiralOrder(int[][] matrix) {
			List<Integer> result = new ArrayList<Integer>();
			if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
				return result;

			int min = Math.min(matrix.length, matrix[0].length);
			int level = min / 2;

			for (int i = 0; i < level; i++) {
				for (int j = i; j < matrix[0].length - i - 1; j++)
					result.add(matrix[i][j]);
				for (int j = i; j < matrix.length - i - 1; j++)
					result.add(matrix[j][matrix[0].length - 1 - i]);
				for (int j = matrix[0].length - 1 - i; j > i; j--)
					result.add(matrix[matrix.length - 1 - i][j]);
				for (int j = matrix.length - 1 - i; j > i; j--)
					result.add(matrix[j][i]);
			}

			if (min % 2 == 1) {
				if (matrix.length > matrix[0].length) {
					for (int i = level; i < matrix.length - level; i++)
						result.add(matrix[i][level]);
				} else {
					for (int i = level; i < matrix[0].length - level; i++)
						result.add(matrix[level][i]);
				}
			}
			return result;
		}
	}
}
