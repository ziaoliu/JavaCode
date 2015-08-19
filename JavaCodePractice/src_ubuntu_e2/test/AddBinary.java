package test;

public class AddBinary {
	public class Solution {
		public String addBinary(String a, String b) {
			int l1 = a.length() - 1;
			int l2 = b.length() - 1;
			int carryOver = 0;
			StringBuilder sb = new StringBuilder();
			while (l1 >= 0 | l2 >= 0) {
				int a1 = 0;
				int b1 = 0;
				if (l1 >= 0)
					a1 = a.charAt(l1--) - '0';
				if (l2 >= 0)
					b1 = b.charAt(l2--) - '0';
				int sum = a1 + b1 + carryOver;
				carryOver = sum / 2;
				sb.insert(0, sum % 2);
			}
			if (carryOver == 1)
				sb.insert(0, 1);
			return sb.toString();
		}
	}
}
