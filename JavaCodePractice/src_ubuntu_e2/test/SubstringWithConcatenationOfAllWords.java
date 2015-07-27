package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {
	public class Solution {
		public List<Integer> findSubstring(String S, String[] L) {
			List<Integer> result = new ArrayList<Integer>();
			if (S == null || S.length() == 0 || L.length == 0)
				return result;

			int len = L[0].length();
			if (S.length() < len * L.length)
				return result;

			HashMap<String, Integer> map = new HashMap<String, Integer>();
			for (String temp : L) {
				if (map.containsKey(temp))
					map.put(temp, (map.get(temp)) + 1);
				else
					map.put(temp, 1);
			}

			for (int i = 0; i < S.length() && i + len * L.length <= S.length(); i++) {
				HashMap<String, Integer> dup = (HashMap) map.clone();

				String substring = S.substring(i, i + len * L.length);
				for (int j = 0; j < substring.length(); j = j + len) {
					String sub = substring.substring(j, j + len);
					int count = dup.get(sub) == null ? 0 : dup.get(sub);
					if (count <= 0)
						break;
					else if (count == 1)
						dup.remove(sub);
					else if (count > 1)
						dup.put(sub, (dup.get(sub)) - 1);
				}

				if (dup.size() == 0)
					result.add(i);
			}

			return result;
		}
	}
}
