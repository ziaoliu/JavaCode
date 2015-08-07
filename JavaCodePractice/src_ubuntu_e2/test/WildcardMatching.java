package test;

public class WildcardMatching {
	public class Solution {
		public boolean isMatch(String str, String pattern) {
			int i = 0;
			int j = 0;
			int star = -1;
			int mark = -1;
			while (i < str.length()) {
				if (j < pattern.length()
						&& (str.charAt(i) == pattern.charAt(j) || pattern
								.charAt(j) == '?')) {
					i++;
					j++;
				} else if (j < pattern.length() && pattern.charAt(j) == '*') {
					star = j;
					j++;
					mark = i;
				} else if (star != -1) {
					j = star + 1;
					mark++;
					i = mark;
				} else
					return false;
			}
			while (j < pattern.length() && pattern.charAt(j) == '*')
				j++;
			return j == pattern.length();
		}
	}
}
