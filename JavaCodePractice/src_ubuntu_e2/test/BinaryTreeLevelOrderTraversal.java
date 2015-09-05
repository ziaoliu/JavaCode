package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
	public class Solution {
		public List<List<Integer>> levelOrder(TreeNode root) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			if (root == null)
				return result;
			LinkedList<TreeNode> list = new LinkedList<TreeNode>();
			LinkedList<TreeNode> next = new LinkedList<TreeNode>();
			List<Integer> values = new ArrayList<Integer>();
			list.add(root);
			while (list.size() > 0) {
				TreeNode node = list.remove();
				if (node.left != null)
					next.add(node.left);
				if (node.right != null)
					next.add(node.right);
				values.add(node.val);
				if (list.size() == 0) {
					result.add(values);
					values = new ArrayList<Integer>();
					list = next;
					next = new LinkedList<TreeNode>();
				}
			}
			return result;
		}
	}
}
