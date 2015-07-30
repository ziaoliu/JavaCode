package test;

public class SearchInRotatedSortedArray {
	public class Solution {
		public int search(int[] A, int target) {
			if (A == null || A.length == 0)
				return -1;
			if (A.length == 1)
				return A[0] == target ? 0 : -1;

			int i = 0;
			int j = A.length - 1;
			while (i <= j) {
				int m = (i + j) / 2;
				if (A[m] == target)
					return m;
				if (A[m] < A[j]) {
					if (A[m] < target && target <= A[j])
						i = m + 1;
					else
						j = m - 1;
				} else {
					if (A[i] <= target && target < A[m])
						j = m - 1;
					else
						i = m + 1;
				}
			}
			return -1;
		}
	}
}
