package test;

public class StringToInteger {
	public class Solution {
		public int myAtoi(String str) {
			if (str == null || str.length() == 0)
				return 0;

			int result = 0;
			boolean negative = false;

			char[] array = str.trim().toCharArray();
			for (int i = 0; i < array.length; i++) {
				char curr = array[i];
				if (i == 0) {
					if (curr == '+')
						continue;
					else if (curr == '-') {
						negative = true;
						continue;
					}
				}
				int diff = curr - '0';
				if (diff <= 9 && diff >= 0) {
					// overflow
					if (result > Integer.MAX_VALUE / 10)
						return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;

					result = result * 10 + diff;

					// overflow
					if (result < 0)
						return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;

				} else
					return negative ? result * -1 : result;
			}
			return negative ? result * -1 : result;
		}
	}
}
