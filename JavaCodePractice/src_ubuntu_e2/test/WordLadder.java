package test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class WordLadder {
	public class Solution {
		// BFS:
		// http://www.cnblogs.com/springfor/p/3893499.html
		// http://codeganker.blogspot.com/2014/04/word-ladder-leetcode.html
		public int ladderLength(String beginWord, String endWord,
				Set<String> wordDict) {
			LinkedList<String> queue = new LinkedList<String>();
			queue.add(beginWord);
			int count = 1;
			int curCount = 1;
			int nextCount = 0;
			while (queue.size() > 0) {
				String word = queue.remove(0);
				curCount--;
				if (word.equals(endWord))
					return count + 1;
				for (int i = 0; i < word.length(); i++) {
					char[] chars = word.toCharArray();
					for (char c = 'a'; c <= 'z'; c++) {
						chars[i] = c;
						String tmp = new String(chars);
						if (tmp.equals(endWord))
							return count + 1;
						if (wordDict.contains(tmp)) {
							nextCount++;
							wordDict.remove(tmp);
							queue.add(tmp);
						}
					}
				}
				if (curCount == 0) {
					curCount = nextCount;
					nextCount = 0;
					count++;
				}
			}
			return 0;
		}
	}

	public class SolutionTimeLimitExceededDFS {
		int minPath = Integer.MAX_VALUE;

		public int ladderLength(String beginWord, String endWord,
				Set<String> wordDict) {

			dfs(beginWord, endWord, wordDict, 1, new HashSet<String>());

			return minPath;
		}

		private void dfs(String beginWord, String endWord,
				Set<String> wordDict, int count, HashSet<String> visited) {
			visited.add(beginWord);
			HashSet<String> words = new HashSet<String>();
			for (int i = 0; i < beginWord.length(); i++) {
				char[] chars = beginWord.toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					chars[i] = c;
					String tmp = new String(chars);
					if (tmp.equals(endWord)) {
						minPath = Math.min(minPath, count + 1);
						return;
					}
					if (wordDict.contains(tmp))
						words.add(tmp);
				}
			}
			for (String tmp : words) {
				if (!visited.contains(tmp) && wordDict.contains(tmp))
					dfs(tmp, endWord, wordDict, count + 1, visited);
			}
			visited.remove(beginWord);
		}
	}
}
