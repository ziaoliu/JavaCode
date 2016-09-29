package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q001_TwoSum {
	public class Solution {
		public int[] twoSum(int[] nums, int target) {
			int[] result = new int[2];

			if (nums == null || nums.length == 0 || nums.length == 1)
				return result;

			Map<Integer, Integer> map = new HashMap<>();

			for (int i = 0; i < nums.length; i++) {
				int key = target - nums[i];
				if (!map.containsKey(nums[i]))
					map.put(key, i);
				else {
					result[0] = map.get(nums[i]);
					result[1] = i;
					return result;
				}
			}

			return result;
		}
	}
}
