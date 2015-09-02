package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal {
	public class SolutionIterate {
		public List<Integer> inorderTraversal(TreeNode root) {
			List<Integer> result = new ArrayList<Integer>();
			LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
			if (root == null)
				return result;
			while (root != null || stack.size() > 0) {
				if (root != null) {
					stack.push(root);
					root = root.left;
				} else {
					root = stack.pop();
					result.add(root.val);
					root = root.right;
				}
			}
			return result;
		}
	}

	public class SolutionRecur {
		public List<Integer> inorderTraversal(TreeNode root) {
			List<Integer> result = new ArrayList<Integer>();
			if (root == null)
				return result;
			dfs(result, root);
			return result;
		}

		private void dfs(List<Integer> result, TreeNode root) {
			if (root == null)
				return;
			if (root != null)
				dfs(result, root.left);
			result.add(root.val);
			if (root != null)
				dfs(result, root.right);
		}
	}
}
