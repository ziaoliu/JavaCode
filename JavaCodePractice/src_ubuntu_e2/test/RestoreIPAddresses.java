package test;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
	public class Solution {
		public List<String> restoreIpAddresses(String s) {
			List<String> result = new ArrayList<String>();
			List<String> list = new ArrayList<String>();
			if (s == null || s.length() == 0)
				return result;
			dfs(result, list, 0, s);
			return result;
		}

		private void dfs(List<String> result, List<String> list, int i, String s) {
			if (list.size() > 4)
				return;
			if (list.size() == 4 && i == s.length()) {
				StringBuilder sb = new StringBuilder("");
				for (String str : list) {
					str = process(str);
					sb.append(str).append(".");
				}
				sb.deleteCharAt(sb.length() - 1);
				if (sb.length() == s.length() + 3)
					if (!result.contains(sb.toString()))
						result.add(sb.toString());
				return;
			}
			for (int index = i; index < i + 3 && index < s.length(); index++) {
				String tmp = s.substring(i, index + 1);
				if (Integer.parseInt(tmp) < 256) {
					list.add(tmp);
					dfs(result, list, index + 1, s);
					list.remove(list.size() - 1);
				}
			}
		}

		private String process(String str) {
			int index = -1;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) != '0') {
					index = i;
					break;
				}
			}
			if (index == -1)
				return "0";

			return str.substring(index);
		}
	}
}
