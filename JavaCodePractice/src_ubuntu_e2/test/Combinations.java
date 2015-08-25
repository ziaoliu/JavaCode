package test;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	public class Solution {
		public List<List<Integer>> combine(int n, int k) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			List<Integer> list = new ArrayList<Integer>();
			if (n <= 0 || k <= 0)
				return result;

			dfs(result, list, n, k, 1);

			return result;
		}

		private void dfs(List<List<Integer>> result, List<Integer> list, int n,
				int k, int curr) {
			if (list.size() == k) {
				if (!result.contains(list))
					result.add(new ArrayList<Integer>(list));
				return;
			}
			if (curr > n) // check after adding list
				return;
			for (int i = curr; i <= n; i++) {
				list.add(i);
				dfs(result, list, n, k, i + 1);
				list.remove(list.size() - 1);
			}
		}
	}
}
