package test;

public class RemoveElement {
	public class SolutionBest {
		public int removeElement(int[] A, int elem) {
			if (A == null || A.length == 0)
				return 0;

			int i = 0;
			for (int j = 0; j < A.length; j++) {
				if (A[j] != elem)
					A[i++] = A[j];
			}
			return i;
		}
	}
}
