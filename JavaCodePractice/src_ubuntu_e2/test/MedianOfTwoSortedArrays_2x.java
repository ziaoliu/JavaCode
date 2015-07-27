package test;

public class MedianOfTwoSortedArrays_2x {
	public class Solution {
		public double findMedianSortedArrays(int[] nums1, int[] nums2) {
			int m = nums1.length;
			int n = nums2.length;

			if ((m + n) % 2 == 1)
				return findKth(nums1, 0, m - 1, nums2, 0, n - 1,
						(m + n) / 2 + 1);
			else
				return (findKth(nums1, 0, m - 1, nums2, 0, n - 1, (m + n) / 2) + findKth(
						nums1, 0, m - 1, nums2, 0, n - 1, (m + n) / 2 + 1)) / 2.0;
		}

		private int findKth(int[] nums1, int i, int i2, int[] nums2, int j,
				int j2, int k) {
			int m = i2 - i + 1;
			int n = j2 - j + 1;

			if (m > n)
				return findKth(nums2, j, j2, nums1, i, i2, k);
			if (m == 0)
				return nums2[j + k - 1];
			if (k == 1)
				return Math.min(nums1[i], nums2[j]);

			int a = Math.min(k / 2, m);
			int b = k - a;

			// ??????????compare conditions!!!!!!!!!!!
			if (nums1[i + a - 1] > nums2[j + b - 1])
				return findKth(nums1, i, i + a - 1, nums2, j + b, j2, k - b);
			else if (nums1[i + a - 1] < nums2[j + b - 1])
				return findKth(nums1, i + a, i2, nums2, j, j + b - 1, k - a);
			else
				return nums1[i + a - 1];
		}
	}
}
