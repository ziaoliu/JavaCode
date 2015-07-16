package test;

import java.util.ArrayList;

public class LetterCombinationsOfAPhoneNumber {
	public class Solution {
		public ArrayList<String> letterCombinations(String digits) {
			ArrayList<String> result = new ArrayList<String>();
			if (digits == null || digits.length() == 0)
				return result;

			dfs(result, digits, 0, new StringBuilder());

			return result;
		}

		private void dfs(ArrayList<String> result, String digits, int i,
				StringBuilder sb) {
			if (i > digits.length())
				return;
			if (i == digits.length()) {
				if (!result.contains(sb.toString()))
					result.add(sb.toString());
				return;
			}

			String[] mapping = { "", "abc", "def", "ghi", "jkl", "mno", "pqrs",
					"tuv", "wxyz" };
			int digit = digits.charAt(i) - '0';

			if (digit > 9 || digit < 2)
				return;

			String curr = mapping[digit - 1];
			for (int j = 0; j < curr.length(); j++) {
				dfs(result, digits, i + 1, sb.append(curr.charAt(j)));
				sb.deleteCharAt(sb.length() - 1);
			}

		}
	}
}
