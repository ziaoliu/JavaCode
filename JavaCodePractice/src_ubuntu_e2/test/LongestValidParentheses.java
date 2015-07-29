package test;

import java.util.LinkedList;

public class LongestValidParentheses {
	public class Solution {
		// "()(()()", "())()()"
		public int longestValidParentheses(String s) {
			if (s == null || s.length() == 0)
				return 0;

			LinkedList<Integer> stack = new LinkedList<Integer>();
			int max = 0;
			int start = -1;

			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c == '(')
					stack.push(i);
				else {
					if (stack.size() != 0) {
						stack.pop();
						if (stack.size() != 0)
							max = Math.max(max, i - stack.peek());
						else
							max = Math.max(max, i - start);
					} else
						start = i;
				}
			}
			return max;
		}
	}
}
