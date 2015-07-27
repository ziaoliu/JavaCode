package test;

public class RemoveDuplicatesFromSortedArrayII {
	public class Solution {
		public int removeDuplicates(int[] A) {
			if (A == null)
				return 0;
			if (A.length <= 2)
				return A.length;

			int i = 1;
			for (int j = 2; j < A.length; j++) {
				if (A[i - 1] != A[j])
					A[++i] = A[j];
			}
			return i + 1;
		}
	}
}
