package test;

public class SumRootToLeafNumbers {
	public class Solution {
		int sum = 0;

		public int sumNumbers(TreeNode root) {
			if (root == null)
				return 0;
			dfs(root, root.val);
			return sum;
		}

		private void dfs(TreeNode root, int val) {
			if (root.left == null && root.right == null)
				sum += val;
			if (root.left != null)
				dfs(root.left, val * 10 + root.left.val);
			if (root.right != null)
				dfs(root.right, val * 10 + root.right.val);
		}
	}
}
