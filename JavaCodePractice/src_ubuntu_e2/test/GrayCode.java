package test;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
	public class Solution {
		public List<Integer> grayCode(int n) {
			if (n < 0) {
				List<Integer> result = new ArrayList<Integer>();
				return result;
			}
			if (n == 0) {
				List<Integer> result = new ArrayList<Integer>();
				result.add(0);
				return result;
			}
			List<Integer> tmp = grayCode(n - 1);
			int add = 1 << (n - 1);
			List<Integer> result = new ArrayList<Integer>(tmp);
			for (int i = tmp.size() - 1; i >= 0; i--) {
				result.add(add + tmp.get(i));
			}
			return result;
		}
	}
}
