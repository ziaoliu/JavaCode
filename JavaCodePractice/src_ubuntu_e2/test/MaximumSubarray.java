package test;

public class MaximumSubarray {
	public class Solution {
		public int maxSubArray(int[] nums) {
			return max(nums, 0, nums.length - 1);
		}

		private int max(int[] nums, int low, int high) {
			if (low == high)
				return nums[low];
			if (low == high - 1)
				return Math.max(nums[low] + nums[high],
						Math.max(nums[low], nums[high]));
			int mid = (low + high) / 2;
			int lmax = max(nums, low, mid - 1);
			int rmax = max(nums, mid + 1, high);

			int mmax = nums[mid];
			int tmp = mmax;
			for (int i = mid - 1; i >= low; i--) {
				tmp = tmp + nums[i];
				if (tmp > mmax)
					mmax = tmp;
			}
			tmp = mmax;
			for (int i = mid + 1; i <= high; i++) {
				tmp = tmp + nums[i];
				if (tmp > mmax)
					mmax = tmp;
			}
			return Math.max(mmax, Math.max(lmax, rmax));
		}
	}

	public class SolutionOn {
		public int maxSubArray(int[] nums) {
			int max = Integer.MIN_VALUE;
			int sum = 0;
			for (int i = 0; i < nums.length; i++) {
				sum = sum + nums[i];
				max = Math.max(max, sum);
				if (sum < 0)
					sum = 0;
			}
			return max;
		}
	}
}
