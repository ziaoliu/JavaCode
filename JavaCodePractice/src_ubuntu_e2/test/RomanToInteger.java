package test;

public class RomanToInteger {
	public class Solution {
		public int romanToInt(String s) {
			if (s == null || s.length() == 0)
				return 0;
			int result = 0;
			char[] array = s.toCharArray();
			for (int i = 0; i < s.length(); i++) {
				if (i < s.length() - 1
						&& helper(array[i]) < helper(array[i + 1])) {
					result = result + helper(array[i + 1]) - helper(array[i]);
					i++;
				} else
					result = result + helper(array[i]);
			}
			return result;
		}

		private int helper(char d) {
			int temp = 0;
			switch (d) {
			case 'I':
				temp = 1;
				break;
			case 'V':
				temp = 5;
				break;
			case 'X':
				temp = 10;
				break;
			case 'L':
				temp = 50;
				break;
			case 'C':
				temp = 100;
				break;
			case 'D':
				temp = 500;
				break;
			case 'M':
				temp = 1000;
				break;
			}
			return temp;
		}
	}
}
