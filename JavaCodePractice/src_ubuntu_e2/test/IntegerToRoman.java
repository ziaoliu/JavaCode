package test;

public class IntegerToRoman {
	public class Solution {
		public String intToRoman(int num) {
			String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL",
					"X", "IX", "V", "IV", "I" };
			int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4,
					1 };
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < symbols.length; i++) {
				while (num >= values[i]) {
					sb.append(symbols[i]);
					num = num - values[i];
				}
			}
			return sb.toString();
		}
	}
}
