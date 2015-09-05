package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigZagLevelOrderTraversal {
	public class Solution {
		public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			if (root == null)
				return result;
			LinkedList<TreeNode> list = new LinkedList<TreeNode>();
			LinkedList<TreeNode> next = new LinkedList<TreeNode>();
			list.add(root);
			List<Integer> values = new ArrayList<Integer>();
			boolean reverse = false;
			while (list.size() > 0) {
				TreeNode node = list.remove();
				if (!reverse)
					values.add(node.val);
				else
					values.add(0, node.val);
				if (node.left != null)
					next.add(node.left);
				if (node.right != null)
					next.add(node.right);
				if (list.size() == 0) {
					reverse = !reverse;
					list = next;
					next = new LinkedList<TreeNode>();
					result.add(values);
					values = new ArrayList<Integer>();
				}
			}
			return result;
		}
	}
}
