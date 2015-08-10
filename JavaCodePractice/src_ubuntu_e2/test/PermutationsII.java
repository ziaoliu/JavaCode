package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
	public class Solution {
		public List<List<Integer>> permuteUnique(int[] nums) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			List<Integer> list = new ArrayList<Integer>();
			if (nums == null || nums.length == 0)
				return result;

			Arrays.sort(nums);

			dfs(result, list, new boolean[nums.length], nums);

			return result;
		}

		private void dfs(List<List<Integer>> result, List<Integer> list,
				boolean[] used, int[] nums) {
			if (list.size() == nums.length) {
				result.add(new ArrayList<Integer>(list));
				return;
			}
			for (int i = 0; i < nums.length; i++) {
				if (i > 0 && !used[i - 1] && nums[i] == nums[i - 1])
					continue;
				if (!used[i]) {
					used[i] = true;
					list.add(nums[i]);
					dfs(result, list, used, nums);
					list.remove(list.size() - 1);
					used[i] = false;
				}
			}
		}// end of dfs
	}
}
