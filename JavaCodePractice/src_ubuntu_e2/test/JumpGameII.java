package test;

public class JumpGameII {
	public class Solution {
		public int jump(int[] nums) {
			int max = 0;
			int last = 0;
			int count = 0;

			for (int i = 0; i < nums.length; i++) {
				if (i > last) {
					count++;
					last = max;
				}
				max = Math.max(max, i + nums[i]);
			}
			return max >= nums.length - 1 ? count : 0;
		}
	}
}
