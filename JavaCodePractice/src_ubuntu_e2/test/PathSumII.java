package test;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
	public class Solution {
		public List<List<Integer>> pathSum(TreeNode root, int sum) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			if (root == null)
				return result;
			List<Integer> list = new ArrayList<Integer>();
			list.add(root.val);
			recur(result, list, sum - root.val, root);
			return result;
		}

		private void recur(List<List<Integer>> result, List<Integer> list,
				int sum, TreeNode root) {
			if (root == null)
				return;
			if (root.left == null && root.right == null && sum == 0) {
				result.add(new ArrayList<Integer>(list));
				return;
			}
			if (root.left != null) {
				list.add(root.left.val);
				recur(result, list, sum - root.left.val, root.left);
				list.remove(list.size() - 1);
			}
			if (root.right != null) {
				list.add(root.right.val);
				recur(result, list, sum - root.right.val, root.right);
				list.remove(list.size() - 1);
			}
		}
	}
}
