package test;

public class LongestParlindromicSubstring {
	public class Solution {
		public String longestPalindrome(String s) {
			if (s == null || s.length() == 0)
				return "";
			String max = "";
			for (int i = 0; i < s.length(); i++) {
				String curr = check(s, i, i);
				if (curr.length() > max.length())
					max = curr;

				curr = check(s, i, i + 1);
				if (curr.length() > max.length())
					max = curr;
			}
			return max;
		}

		private String check(String s, int i, int j) {
			char[] array = s.toCharArray();
			while (i > -1 && j < s.length()) {
				if(array[i] != array[j])
					break;
				i--;
				j++;
			}
			return s.substring(i + 1, j);
		}
	}
}
