package test;

public class RemoveDuplicatesFromSortedArray {
	public class Solution {
		public int removeDuplicates(int[] A) {
			if (A == null || A.length < 2)
				return A == null ? 0 : A.length;

			int i = 0;
			for (int j = 1; j < A.length; j++) {
				if (A[i] != A[j])
					A[++i] = A[j];
			}

			return i + 1;
		}
	}
}
