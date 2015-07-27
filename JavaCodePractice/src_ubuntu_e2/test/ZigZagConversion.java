package test;

public class ZigZagConversion {
	public class Solution {
		public String convert(String s, int numRows) {
			if (s == null || s.length() == 0)
				return s;
			if (s.length() == 1 || s.length() < numRows)
				return s;
			if (numRows < 2)
				return s;

			int size = 2 * numRows - 2;
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < numRows; i++) {// miss
				for (int j = i; j < s.length(); j = j + size) {
					sb.append(s.charAt(j));
					if (i != 0 && i != numRows - 1) {// miss
						int diag = j + size - (2 * (i + 1) - 2);
						if (diag < s.length())
							sb.append(s.charAt(diag));
					}
				}
			}
			return sb.toString();
		}
	}
}
