package test;

public class FlattenBinaryTreeToLinkedList {
	public class Solution {
		TreeNode pre = null;

		public void flatten(TreeNode root) {
			if (root == null)
				return;
			TreeNode right = root.right;// save a copy
			if (pre != null) {
				pre.left = null;
				pre.right = root;// pre to root
			}
			pre = root;
			flatten(root.left);
			flatten(right);
		}
	}
}
