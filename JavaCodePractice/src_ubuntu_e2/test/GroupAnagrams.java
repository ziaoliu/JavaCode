package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
	public class Solution {
		public List<List<String>> groupAnagrams(String[] strs) {
			List<List<String>> result = new ArrayList<List<String>>();
			if (strs == null || strs.length == 0)
				return result;
			HashMap<String, List<String>> map = new HashMap<String, List<String>>();
			for (String str : strs) {
				char[] array = str.toCharArray();
				Arrays.sort(array);// =========>sort
				String key = new String(array);
				if (map.containsKey(key)) {
					List<String> list = map.get(key);
					list.add(str);
					map.put(key, list);
				} else {
					List<String> list = new ArrayList<String>();
					list.add(str);
					map.put(key, list);
				}
			}
			for (List<String> list : map.values()) {
				Collections.sort(list);
				result.add(list);
			}
			return result;
		}
	}

}
