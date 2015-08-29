package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
	public class Solution {
		public List<List<Integer>> subsetsWithDup(int[] nums) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			List<Integer> list = new ArrayList<Integer>();

			if (nums == null || nums.length == 0)
				return result;

			Arrays.sort(nums);
			dfs(result, list, 0, nums);

			return result;
		}

		private void dfs(List<List<Integer>> result, List<Integer> list, int i,
				int[] nums) {
			if (!result.contains(list))
				result.add(new ArrayList<Integer>(list));
			for (int index = i; index < nums.length; index++) {
				list.add(nums[index]);
				dfs(result, list, index + 1, nums);
				list.remove(list.size() - 1);
				while (index < nums.length - 1
						&& nums[index] == nums[index + 1])
					index++;
			}
		}
	}
}
