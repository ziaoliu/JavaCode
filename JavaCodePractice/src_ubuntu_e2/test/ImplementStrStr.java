package test;

public class ImplementStrStr {
	public class Solution {
		public int strStr(String haystack, String needle) {
			if (haystack == null || needle == null)
				return -1;

			if (haystack.length() < needle.length())
				return -1;

			if (haystack.equals(needle))
				return 0;

			if ("".equals(haystack) && !"".equals(needle))
				return -1;

			if (!"".equals(haystack) && "".equals(needle))
				return 0;

			char[] hays = haystack.toCharArray();
			char[] nees = needle.toCharArray();

			int j = 0;
			for (; j < haystack.length(); j++) {
				int i = 0;
				// <<<<<< conditions to get into checking the sub string
				if (j + nees.length <= haystack.length() && hays[j] == nees[i]) {
					boolean flag = true;
					while (i < nees.length && flag) {
						if (hays[j + i] != nees[i]) {
							flag = false;
							break;
						}
						i++;
					}
					if (flag)
						return j;
				}
			}
			return -1;
		}
	}
}
