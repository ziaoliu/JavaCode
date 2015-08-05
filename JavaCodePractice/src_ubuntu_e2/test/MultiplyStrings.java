package test;

public class MultiplyStrings {
	public class Solution {
		public String multiply(String num1, String num2) {
			if (num1 == null && num2 == null || num1.length() == 0
					&& num2.length() == 0)
				return "0";
			if (num1 == null || num2 == null || num1.length() == 0
					|| num2.length() == 0)
				return "0";

			num1 = new StringBuilder(num1).reverse().toString();
			num2 = new StringBuilder(num2).reverse().toString();

			int[] sum = new int[num1.length() + num2.length()];

			for (int i = 0; i < num1.length(); i++) {
				int a = num1.charAt(i) - '0';
				for (int j = 0; j < num2.length(); j++) {
					int b = num2.charAt(j) - '0';
					sum[i + j] = sum[i + j] + a * b;
				}
			}

			StringBuilder result = new StringBuilder();
			for (int i = 0; i < sum.length; i++) {
				int carryOver = sum[i] / 10;
				int digit = sum[i] % 10;
				result.insert(0, digit);
				if (carryOver > 0 && i + 1 < sum.length)
					sum[i + 1] += carryOver;
			}

			while (result.length() > 0 && result.charAt(0) == '0')
				result.deleteCharAt(0);

			return result.length() == 0 ? "0" : result.toString();
		}
	}
}
