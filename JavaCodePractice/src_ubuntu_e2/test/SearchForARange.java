package test;

public class SearchForARange {
	public class Solution {
		public int[] searchRange(int[] nums, int target) {
			int[] result = { -1, -1 };
			if (nums == null || nums.length == 0)
				return result;

			int i = 0;
			int j = nums.length - 1;
			while (i <= j) {
				int c = (i + j) / 2;
				if (nums[c] < target)// condition to narrow range
					i = c + 1;
				else
					j = c - 1;
			}

			int m = 0;
			int n = nums.length - 1;
			while (m <= n) {
				int c = (m + n) / 2; // <<<<<<<<<<<< don't copy!!
				if (nums[c] > target)// condition to narrow range
					n = c - 1;
				else
					m = c + 1;
			}

			if (i <= n) {
				result[0] = i;
				result[1] = n;// <<<<<<<<index wrong
			}
			return result;
		}
	}
}
