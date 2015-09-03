package test;

import java.util.LinkedList;

public class ValidateBinarySearchTree {
	public class Solution {
		public boolean isValidBST(TreeNode root) {
			if (root == null)
				return true;
			LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
			TreeNode pre = null;
			while (root != null || stack.size() > 0) {
				if (root != null) {
					stack.push(root);
					root = root.left;
				} else {
					root = stack.pop();
					if (pre != null && pre.val >= root.val)
						return false;
					pre = root;
					root = root.right;
				}
			}
			return true;
		}
	}
}
