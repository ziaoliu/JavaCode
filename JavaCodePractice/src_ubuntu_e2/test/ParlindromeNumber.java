package test;

public class ParlindromeNumber {
	public class Solution {
		public boolean isPalindrome(int x) {
			if (x < 0)
				return false;
			if (x < 10)
				return true;

			int scale = 1;
			while (x / scale >= 10) {
				scale = scale * 10;
			}

			while (x > 0) {
				int start = x / scale;
				int end = x % 10;
				if (start != end)
					return false;
				x = (x % scale) / 10;
				scale = scale / 100;
			}
			return true;
		}
	}
}
