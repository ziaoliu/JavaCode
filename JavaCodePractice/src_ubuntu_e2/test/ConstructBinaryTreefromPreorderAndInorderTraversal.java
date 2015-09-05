package test;

import java.util.HashMap;

public class ConstructBinaryTreefromPreorderAndInorderTraversal {
	public class Solution {
		public TreeNode buildTree(int[] preorder, int[] inorder) {
			if (preorder == null || inorder == null)
				return null;
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int i = 0; i < inorder.length; i++)
				map.put(inorder[i], i);
			return recur(preorder, 0, preorder.length - 1, inorder, 0,
					inorder.length - 1, map);
		}

		private TreeNode recur(int[] preorder, int preL, int preR,
				int[] inorder, int inL, int inR, HashMap<Integer, Integer> map) {
			if (preL > preR || inL > inR)
				return null;
			TreeNode root = new TreeNode(preorder[preL]);
			int index = map.get(preorder[preL]);
			root.left = recur(preorder, preL + 1, preL + index - inL, inorder,
					inL, index - 1, map);
			root.right = recur(preorder, preL + index - inL + 1, preR, inorder,
					index + 1, inR, map);
			return root;
		}
	}
}
