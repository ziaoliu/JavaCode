package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal {
	public class Solution {
		public List<Integer> preorderTraversal(TreeNode root) {
			List<Integer> result = new ArrayList<Integer>();
			if (root == null)
				return result;
			LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
			stack.push(root);
			while (stack.size() > 0) {
				TreeNode node = stack.pop();
				result.add(node.val);
				if (node.right != null)
					stack.push(node.right);
				if (node.left != null)
					stack.push(node.left);
			}
			return result;
		}
	}
}
