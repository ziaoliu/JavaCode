package test;

import java.util.LinkedList;

public class ValidParentheses {
	public class Solution {
		public boolean isValid(String s) {
			if (s == null || s.length() <= 1)
				return false;

			LinkedList<Character> stack = new LinkedList<Character>();

			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c == '(' || c == '[' || c == '{')
					stack.push(c);
				else {
					if (stack.size() == 0)
						return false;
					char pre = stack.peek();
					if (pre == '(' && c == ')' || pre == '[' && c == ']'
							|| pre == '{' && c == '}')
						stack.pop();
					else
						return false;
				}
			}

			if (stack.size() != 0)
				return false;
			return true;
		}
	}
}
