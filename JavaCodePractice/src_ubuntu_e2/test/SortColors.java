package test;

public class SortColors {
	public class Solution {
		public void sortColors(int[] A) {
			if (A == null || A.length == 0)
				return;
			int zero = 0;
			int one = 0;
			int two = 0;
			for (int i = 0; i < A.length; i++) {
				if (A[i] == 0) {
					A[two++] = 2;
					A[one++] = 1;
					A[zero++] = 0;
				} else if (A[i] == 1) {
					A[two++] = 2;
					A[one++] = 1;
				} else if (A[i] == 2) {
					A[two++] = 2;
				}
			}
		}// end of method
	}
}
