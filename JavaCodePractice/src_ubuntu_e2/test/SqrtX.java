package test;

public class SqrtX {
	public class Solution {
		public int mySqrt(int x) {
			if (x < 0)
				return -1;
			if (x == 0)
				return 0;
			int i = 1;
			int j = x / 2 + 1;
			while (i <= j) {
				int m = (i + j) / 2;
				if (m <= x / m && x / (m + 1) < m + 1)
					return m;
				if (m < x / m)
					i = m + 1;
				else
					j = m - 1;
			}
			return 0;
		}
	}
}
