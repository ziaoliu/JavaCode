package test;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
	public class Solution {
		public List<TreeNode> generateTrees(int n) {
			return generate(1, n);
		}

		private List<TreeNode> generate(int left, int right) {
			List<TreeNode> result = new ArrayList<TreeNode>();
			if (left > right) {
				result.add(null);
				return result;// return result
			}
			for (int i = left; i <= right; i++) {// possible [left, right]
				List<TreeNode> leftTree = generate(left, i - 1);
				List<TreeNode> rightTree = generate(i + 1, right);
				for (TreeNode l : leftTree) {
					for (TreeNode r : rightTree) {
						TreeNode root = new TreeNode(i);
						root.left = l;
						root.right = r;
						result.add(root);
					}
				}
			}
			return result;
		}
	}
}
