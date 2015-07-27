package test;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public class Solution {
		public List<String> generateParenthesis(int n) {
			List<String> result = new ArrayList<String>();

			if (n < 1)
				return result;

			dfs(result, "", n, n);

			return result;
		}

		private void dfs(List<String> result, String string, int l, int r) {
			if (l > r)
				return;

			if (l == 0 && r == 0) {
				if (!result.contains(string))
					result.add(string);
				return;
			}

			if (l > 0)
				dfs(result, string + "(", l - 1, r);
			if (r > 0)
				dfs(result, string + ")", l, r - 1);

		}
	}
}
