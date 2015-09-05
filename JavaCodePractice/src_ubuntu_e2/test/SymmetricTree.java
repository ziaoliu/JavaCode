package test;

public class SymmetricTree {
	public class Solution {
		public boolean isSymmetric(TreeNode root) {
			if (root == null)
				return true;
			return recur(root.left, root.right);
		}

		private boolean recur(TreeNode left, TreeNode right) {
			if (left == null && right == null)
				return true;
			if (left == null || right == null)
				return false;
			if (left.val != right.val)
				return false;
			return recur(left.left, right.right)
					&& recur(left.right, right.left);
		}
	}
}
