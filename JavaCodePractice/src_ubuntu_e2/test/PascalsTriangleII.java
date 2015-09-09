package test;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
	public class Solution {
		public List<Integer> getRow(int numRows) {
			List<Integer> list = new ArrayList<Integer>();
			if (numRows < 0)
				return null;
			if (numRows == 0) {
				list.add(1);
				return list;
			}
			list.add(1);
			for (int i = 1; i <= numRows; i++) {
				for (int j = list.size() - 1; j > 0; j--) {
					list.set(j, list.get(j) + list.get(j - 1));
				}
				list.add(1);
			}
			return list;
		}
	}
}
