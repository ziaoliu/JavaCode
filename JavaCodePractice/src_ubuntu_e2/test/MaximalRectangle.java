package test;

import java.util.LinkedList;

public class MaximalRectangle {
	public class Solution {
		public int maximalRectangle(char[][] matrix) {
			if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
				return 0;
			int max = 0;
			int[] row = new int[matrix[0].length];
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					row[j] = matrix[i][j] == '0' ? 0 : row[j] + 1;
				}
				max = Math.max(max, maxArea(row));
			}
			return max;
		}

		private int maxArea(int[] row) {
			int max = 0;
			LinkedList<Integer> stack = new LinkedList<Integer>();
			for (int i = 0; i < row.length; i++) {
				while (!stack.isEmpty() && row[i] <= row[stack.peek()]) {
					int index = stack.pop();
					int area = 0;
					if (stack.isEmpty())
						area = i * row[index];
					else
						area = (i - stack.peek() - 1) * row[index];
					max = Math.max(max, area);
				}
				stack.push(i);
			}
			while (!stack.isEmpty()) {
				int index = stack.pop();
				int area = 0;
				if (stack.isEmpty())
					area = row.length * row[index];
				else
					area = (row.length - stack.peek() - 1) * row[index];
				max = Math.max(max, area);
			}
			return max;
		}
	}
}
