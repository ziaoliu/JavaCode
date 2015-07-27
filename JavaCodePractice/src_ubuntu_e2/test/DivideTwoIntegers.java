package test;

public class DivideTwoIntegers {
	public class Solution {
		public int divide(int dividend, int divisor) {
			if (dividend == 0 && divisor != 0)
				return 0;

			if (divisor == 0)
				return Integer.MAX_VALUE;

			long absDividend = Math.abs((long) dividend);
			long absDivisor = Math.abs((long) divisor);

			if (absDividend < absDivisor)
				return 0;

			int result = 0;
			while (absDividend >= absDivisor) {
				long dup = absDivisor;// <<<<<<<< multiple divisor!!!
				int count = 1;

				while (absDividend > dup) {
					dup = dup << 1;
					count = count << 1;
				}

				if (absDividend != dup) { // <<<<<<<<< condition
					dup = dup >> 1;
					count = count >> 1;
				}

				result = result + count;
				if (result < 0)
					return (dividend > 0 ^ divisor > 0) ? Integer.MIN_VALUE
							: Integer.MAX_VALUE;
				absDividend = absDividend - dup;
			}
			return result * ((dividend > 0 ^ divisor > 0) ? -1 : 1);
		}
	}
}
