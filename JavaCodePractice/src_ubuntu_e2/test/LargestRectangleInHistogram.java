package test;

import java.util.LinkedList;

public class LargestRectangleInHistogram {
	public class Solution {
		public int largestRectangleArea(int[] height) {
			if (height == null || height.length == 0)
				return 0;
			LinkedList<Integer> stack = new LinkedList<Integer>();
			int max = 0;
			for (int i = 0; i < height.length; i++) {
				while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {
					int index = stack.pop();
					int area = 0;
					if (stack.isEmpty()) {
						area = i * height[index];
					} else {
						area = (i - stack.peek() - 1) * height[index];
					}
					max = Math.max(area, max);
				}
				stack.push(i);
			}
			while (!stack.isEmpty()) {
				int index = stack.pop();
				int area = 0;
				if (stack.isEmpty()) {
					area = height.length * height[index];
				} else {
					area = (height.length - stack.peek() - 1) * height[index];
				}
				max = Math.max(area, max);
			}

			return max;
		}
	}
}
