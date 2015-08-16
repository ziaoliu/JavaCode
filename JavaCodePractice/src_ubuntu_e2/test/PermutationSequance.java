package test;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequance {
	public class Solution {
		public String getPermutation(int n, int k) {
			if (n <= 0 || k <= 0)
				return "";
			k--;
			List<String> list = new ArrayList<String>();
			int total = 1;
			for (int i = 1; i <= n; i++) {
				total = total * i;
				list.add(Integer.toString(i));
			}
			if (k > total - 1)
				return "";
			StringBuilder sb = new StringBuilder();
			total = total / n--;
			for (; n >= 0; n--) {
				int group = k / total;
				k = k % total;
				sb.append(list.get(group));
				list.remove(group);
				if (n > 0)
					total = total / n;
			}
			return sb.toString();
		}
	}
}
