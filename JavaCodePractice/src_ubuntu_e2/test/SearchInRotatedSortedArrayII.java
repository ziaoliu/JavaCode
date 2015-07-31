package test;

public class SearchInRotatedSortedArrayII {
	public class Solution {
		public boolean search(int[] A, int target) {
			if (A == null || A.length == 0)
				return false;
			int i = 0;
			int j = A.length - 1;
			while (i <= j) {
				int c = (i + j) / 2;
				if (A[c] == target)
					return true;
				if (A[c] < A[i]) {// lower section not in order
					if (A[c] < target && target <= A[j])
						i = c + 1;
					else
						j = c - 1;
				} else if (A[c] > A[i]) {// lower section in order
					if (A[i] <= target && target < A[c])
						j = c - 1;
					else
						i = c + 1;
				} else
					i++;
			}
			return false;
		}
	}
}
