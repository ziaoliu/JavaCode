package test;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	public class Solution {
		public List<List<Integer>> generate(int numRows) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			if (numRows <= 0)
				return result;
			List<Integer> list = new ArrayList<Integer>();
			list.add(1);
			if (numRows == 1) {
				result.add(list);
				return result;
			}
			result.add(list);
			for (int i = 2; i <= numRows; i++) {
				List<Integer> pre = result.get(result.size() - 1);
				list = new ArrayList<Integer>();
				list.add(1);
				for (int j = 1; j <= pre.size() - 1; j++) { // = sign needed!
					list.add(pre.get(j) + pre.get(j - 1));
				}
				list.add(1);
				result.add(list);
			}
			return result;
		}
	}
}
