package test;

public class BalancedBinaryTree {
	public class Solution {
		public boolean isBalanced(TreeNode root) {
			return depth(root) >= 0;
		}

		private int depth(TreeNode root) {
			if (root == null)
				return 0;
			int left = depth(root.left);
			int right = depth(root.right);
			if (left < 0 || right < 0)
				return -1;
			if (left == 0 && right == 0)
				return 1;
			int diff = Math.abs(left - right);
			if (diff > 1)
				return -1;
			return Math.max(left, right) + 1;
		}
	}
}
