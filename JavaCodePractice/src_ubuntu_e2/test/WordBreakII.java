package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WordBreakII {
	public class Solution {
		public List<String> wordBreak(String s, Set<String> wordDict) {
			List<String> result = new ArrayList<String>();
			List<String> list = new ArrayList<String>();
			if (s == null || s.length() == 0 || wordDict == null
					|| wordDict.size() == 0)
				return result;

			boolean[] dp = new boolean[s.length() + 1];
			dp[0] = true;

			for (int i = 0; i < s.length(); i++) {
				for (int j = 0; j <= i; j++) {
					String sub = s.substring(j, i + 1);
					// word[0, j] has to be true
					// word[j, i] has to exist
					if (dp[j] && wordDict.contains(sub)) {
						dp[i + 1] = true;
						break;
					}
				}
			}
			if (!dp[s.length()])
				return result;

			dfs(result, list, s, wordDict, 0, dp);
			return result;
		}

		private void dfs(List<String> result, List<String> list, String s,
				Set<String> wordDict, int i, boolean[] dp) {
			if (i > s.length())
				return;
			if (!dp[i])
				return;
			if (i == s.length()) {
				String str = build(list);
				if (!result.contains(str))
					result.add(str);
				return;
			}
			for (int index = i + 1; index <= s.length(); index++) {
				String tmp = s.substring(i, index);
				if (wordDict.contains(tmp)) {
					list.add(tmp);
					dfs(result, list, s, wordDict, index, dp);
					list.remove(list.size() - 1);
				}
			}
		}

		private String build(List<String> list) {
			StringBuilder sb = new StringBuilder();
			for (String tmp : list)
				sb.append(tmp).append(" ");
			sb.deleteCharAt(sb.length() - 1);
			return sb.toString();
		}
	}
}
