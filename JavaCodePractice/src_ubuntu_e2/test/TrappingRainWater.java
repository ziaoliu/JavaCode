package test;

public class TrappingRainWater {
	public class Solution {
		public int trap(int[] A) {
			if (A == null || A.length == 0)
				return 0;

			int maxLeft[] = new int[A.length];
			int maxRight[] = new int[A.length];

			int max = A[0];
			for (int i = 1; i < A.length; i++) {
				maxLeft[i] = max;
				if (A[i] > max)
					max = A[i];
			}

			max = A[A.length - 1];
			for (int i = A.length - 2; i >= 0; i--) {
				maxRight[i] = max;
				if (A[i] > max)
					max = A[i];
			}

			int sum = 0;
			for (int i = 0; i < A.length; i++) {
				int bucket = Math.min(maxLeft[i], maxRight[i]) - A[i];
				if (bucket < 0)
					continue;
				sum = sum + bucket;
			}
			return sum;
		}
	}
}
