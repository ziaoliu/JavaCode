package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BinaryTreePostorderTraversal {
	public class Solution {
		public List<Integer> postorderTraversal(TreeNode root) {
			List<Integer> result = new ArrayList<Integer>();
			if (root == null)
				return result;
			Set<TreeNode> visited = new HashSet<TreeNode>();
			LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
			stack.push(root);
			while (stack.size() > 0) {
				TreeNode node = stack.peek();
				if (node.left == null && node.right == null
						|| visited.contains(node)) {
					stack.pop();
					result.add(node.val);
					continue;// skip to next node
				}
				if (node.right != null || node.left != null)
					visited.add(node);
				if (node.right != null)
					stack.push(node.right);
				if (node.left != null)
					stack.push(node.left);
			}
			return result;
		}
	}
}
