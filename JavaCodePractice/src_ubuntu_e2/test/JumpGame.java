package test;

public class JumpGame {
	public class Solution {
		public boolean canJump(int[] nums) {
			if (nums.length == 1)
				return true;
			int max = 0;
			for (int i = 0; i < nums.length; i++) {
				if (i > max)
					return false;
				max = Math.max(max, i + nums[i]);
			}
			return max >= nums.length - 1;
		}
	}
}
