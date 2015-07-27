package test;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters {
	public class Solution {
		public int lengthOfLongestSubstring(String s) {
			if (s == null || s.length() == 0)
				return 0;
			int max = 1;
			int length = 0;
			int[] table = new int[256];
			Arrays.fill(table, -1);

			for (int i = 0; i < s.length(); i++) {
				char curr = s.charAt(i);
				if (table[curr] != -1) {
					max = Math.max(max, length);
					length = 0;
					i = table[curr] + 1;
					Arrays.fill(table, -1);
				}
				table[s.charAt(i)] = i;
				length++;
			}
			return Math.max(max, length);
		}
	}
}
