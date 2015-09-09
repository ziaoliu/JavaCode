package test;

import java.util.List;

public class Triangle {
	public class Solution {
		public int minimumTotal(List<List<Integer>> triangle) {
			if (triangle == null || triangle.size() == 0)
				return 0;
			if (triangle.size() == 1)
				return triangle.get(0).get(0);
			List<Integer> list = triangle.get(triangle.size() - 1);
			int[] array = new int[list.size()];
			for (int i = 0; i < list.size(); i++)
				array[i] = list.get(i);
			for (int i = triangle.size() - 2; i >= 0; i--) {
				list = triangle.get(i);
				for (int j = 0; j <= list.size() - 1; j++) {
					array[j] = list.get(j) + Math.min(array[j], array[j + 1]);
				}
			}
			return array[0];
		}
	}
}
