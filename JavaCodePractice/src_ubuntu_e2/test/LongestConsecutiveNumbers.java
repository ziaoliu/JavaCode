package test;

import java.util.HashSet;

//[ 200 4 300 1 3 2]
public class LongestConsecutiveNumbers {
	public int find(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		HashSet<Integer> set = new HashSet<Integer>();

		int max = 0;
		for (int i : nums)
			set.add(i);

		for (int i = 0; i < nums.length; i++) {
			int count = 1;
			int temp = nums[i];
			if (!set.contains(temp))
				continue;
			set.remove(temp);

			int low = temp - 1;
			while (set.contains(low)) {
				set.remove(low);
				low--;
				count++;
			}
			int high = temp + 1;
			while (set.contains(high)) {
				set.remove(high);
				high++;
				count++;
			}
			max = Math.max(max, count);
		}
		return max;
	}
}
