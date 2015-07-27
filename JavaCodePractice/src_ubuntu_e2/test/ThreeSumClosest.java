package test;

import java.util.Arrays;

public class ThreeSumClosest {
	public class Solution {
		public int threeSumClosest(int[] nums, int target) {
			int result = Integer.MAX_VALUE;
			if (nums == null || nums.length <= 2)
				return result;

			Arrays.sort(nums);

			int diff = Integer.MAX_VALUE;

			for (int i = 0; i < nums.length - 2; i++) {
				int j = i + 1;
				int k = nums.length - 1;
				while (j < k) {
					int sum = nums[i] + nums[j] + nums[k];

					if (diff > Math.abs(target - sum)) {
						diff = Math.abs(target - sum);
						result = sum;
					}

					if (sum == target)
						return target;
					else if (sum > target)
						k--;
					else
						j++;
				}

			}
			return result;
		}
	}
}
