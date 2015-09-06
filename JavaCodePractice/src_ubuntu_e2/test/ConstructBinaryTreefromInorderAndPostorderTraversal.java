package test;

import java.util.HashMap;

public class ConstructBinaryTreefromInorderAndPostorderTraversal {
	public class Solution {
		public TreeNode buildTree(int[] inorder, int[] postorder) {
			if (inorder == null || postorder == null)
				return null;
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int i = 0; i < inorder.length; i++)
				map.put(inorder[i], i);
			return recur(inorder, 0, inorder.length - 1, postorder, 0,
					postorder.length - 1, map);
		}

		private TreeNode recur(int[] inorder, int inL, int inR,
				int[] postorder, int postL, int postR,
				HashMap<Integer, Integer> map) {
			if (inL > inR || postL > postR)
				return null;
			TreeNode root = new TreeNode(postorder[postR]);
			int index = map.get(postorder[postR]);
			root.left = recur(inorder, inL, index - 1, postorder, postL, postL
					+ index - inL - 1, map);
			root.right = recur(inorder, index + 1, inR, postorder, postL
					+ index - inL, postR - 1, map);
			return root;
		}
	}
}
