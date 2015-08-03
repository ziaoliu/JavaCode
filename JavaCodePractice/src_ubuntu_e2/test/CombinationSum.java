package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	public class Solution {
		public List<List<Integer>> combinationSum(int[] candidates, int target) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			List<Integer> list = new ArrayList<Integer>();
			if (candidates == null || candidates.length == 0)
				return result;
			Arrays.sort(candidates);

			dfs(result, list, 0, candidates, target);

			return result;
		}

		private void dfs(List<List<Integer>> result, List<Integer> list, int i,
				int[] candidates, int target) {
			if (target < 0)
				return;
			if (target == 0) {
				if (!result.contains(list))
					result.add(new ArrayList<Integer>(list));
				return;
			}
			for (; i < candidates.length; i++) {
				if (i > 0 && candidates[i] == candidates[i - 1])
					continue;
				list.add(candidates[i]);
				dfs(result, list, i, candidates, target - candidates[i]);
				list.remove(list.size() - 1);
			}
		}// end of dfs
	}
}
