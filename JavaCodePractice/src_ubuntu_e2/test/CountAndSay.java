package test;

public class CountAndSay {
	public class Solution {
		public String countAndSay(int n) {
			if (n <= 0)
				return "";
			StringBuilder sb = new StringBuilder();
			sb.append(1);

			for (int i = 0; i < n - 1; i++) {
				int count = 1;
				String temp = sb.toString();
				sb = new StringBuilder();
				int j = 1;
				while (j < temp.length()) {
					if (temp.charAt(j) == temp.charAt(j - 1)) {
						count++;
					} else {
						sb.append(count).append(temp.charAt(j - 1));
						count = 1;
					}
					j++;
				}
				sb.append(count).append(temp.charAt(j - 1));
			}

			return sb.toString();
		}
	}
}
