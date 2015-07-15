package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSum {
	public class Solution {
		public List<List<Integer>> threeSum(int[] nums) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			if (nums == null || nums.length < 3)
				return result;

			Arrays.sort(nums); // need to be sorted

			for (int i = 0; i < nums.length - 2; i++) {
				int target = -nums[i]; // have to prepare the target
				int start = i + 1;
				int end = nums.length - 1;
				while (start < end) {
					if (nums[start] + nums[end] == target) {
						List<Integer> list = new ArrayList<Integer>();
						list.add(nums[i]);
						list.add(nums[start]);
						list.add(nums[end]);
						if (!result.contains(list))
							result.add(list);
						start++;
						end--;
						while (start < end && nums[start] == nums[start - 1])
							start++;
						while (start < end && nums[end] == nums[end + 1])
							end--;
					} else if (nums[start] + nums[end] > target)
						end--;
					else
						start++;
				}
			}
			return result;
		}
	}
}
