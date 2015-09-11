package test;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	public static void main(String[] args) {
		PalindromePartitioning test = new PalindromePartitioning();
		Solution s = test.new Solution();
		System.out.println(s.partition("a"));
	}

	public class Solution {
		public List<List<String>> partition(String s) {
			List<List<String>> result = new ArrayList<List<String>>();
			List<String> list = new ArrayList<String>();
			if (s == null || s.length() == 0)
				return result;
			dfs(result, list, s, 0);
			return result;
		}

		private void dfs(List<List<String>> result, List<String> list,
				String s, int i) {
			if (i == s.length()) {
				if (!result.contains(list))
					result.add(new ArrayList<String>(list));
				return;
			}
			if (i > s.length())
				return;
			for (int index = i + 1; index <= s.length(); index++) {
				String tmp = s.substring(i, index);
				if (tmp == null || tmp.length() == 0)
					continue;
				if (isPalindrome(tmp)) {
					list.add(tmp);
					dfs(result, list, s, index);// pass index
					list.remove(list.size() - 1);
				}
			}
		}

		private boolean isPalindrome(String tmp) {
			int s = 0;
			int e = tmp.length() - 1;
			while (s <= e) {
				if (tmp.charAt(s) != tmp.charAt(e))
					return false;
				s++;
				e--;
			}
			return true;
		}
	}
}
