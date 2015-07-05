package test;

import java.util.ArrayList;
import java.util.List;

public class PalindromPartitioningOJ {
	public class Solution {
		public List<List<String>> partition(String s) {
			List<List<String>> results = new ArrayList<List<String>>();
			List<String> result = new ArrayList<String>();
			if (s == null || s.length() == 0)
				return results;

			dfs(s, result, results);

			return results;
		}

		private void dfs(String s, List<String> result,
				List<List<String>> results) {
			if (s == null || s.length() == 0) {
				results.add(new ArrayList<String>(result));
				return;
			}

			for (int i = 1; i <= s.length(); i++) {
				String substring = s.substring(0, i);
				if (isPalindrome(substring)) {
					result.add(substring);
					dfs(s.substring(i), result, results);
					result.remove(result.size() - 1);
				}

			}
		}

		private boolean isPalindrome(String substring) {
			if (substring == null || substring.length() == 0)
				return true;
			int i = 0;
			int j = substring.length() - 1;
			while (i < j) {
				if (substring.charAt(i) != substring.charAt(j))
					return false;
				i++;
				j--;
			}
			return true;
		}
	}
}
