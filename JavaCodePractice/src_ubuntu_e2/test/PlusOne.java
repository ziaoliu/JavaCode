package test;

public class PlusOne {
	public class Solution {
		public int[] plusOne(int[] digits) {
			if (digits == null || digits.length == 0)
				return digits;
			int carryOver = 1;
			for (int i = digits.length - 1; i >= 0; i--) {
				int sum = carryOver + digits[i];
				digits[i] = sum % 10;
				carryOver = sum / 10;
				if (carryOver == 0)
					return digits;
			}
			// if (carryOver == 1)
			int[] result = new int[digits.length + 1];
			result[0] = 1;
			return result;
		}
	}
}
