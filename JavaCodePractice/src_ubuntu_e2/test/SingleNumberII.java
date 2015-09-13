package test;

public class SingleNumberII {
	public class Solution {
		public int singleNumber(int[] nums) {
			if (nums == null || nums.length == 0)
				return 0;
			int[] binary = new int[32];
			int one = 0;
			for (int i = 0; i < 32; i++) {
				for (int j = 0; j < nums.length; j++) {
					binary[i] += (nums[j] >> i) & 1;
				}
			}
			for (int i = 0; i < 32; i++) {
				one += (binary[i] % 3) << i;
			}
			return one;
		}
	}
}
