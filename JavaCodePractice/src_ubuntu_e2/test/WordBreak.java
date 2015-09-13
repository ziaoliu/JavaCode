package test;

import java.util.Set;

public class WordBreak {
	public class Solution {
		public boolean wordBreak(String s, Set<String> wordDict) {
			if (s == null || s.length() == 0 || wordDict == null
					|| wordDict.size() == 0)
				return false;
			boolean[] dp = new boolean[s.length() + 1];
			dp[0] = true;
			for (int i = 1; i <= s.length(); i++) {
				for (int j = 0; j < i; j++) {
					String str = s.substring(j, i);
					if (dp[j] && wordDict.contains(str)) {
						dp[i] = true;
						break;
					}
				}
			}
			return dp[s.length()];
		}
	}
}
