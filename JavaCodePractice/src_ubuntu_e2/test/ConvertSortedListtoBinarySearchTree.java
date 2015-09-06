package test;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListtoBinarySearchTree {
	public class Solution {
		public TreeNode sortedListToBST(ListNode head) {
			if (head == null)
				return null;
			int count = 0;
			ListNode cur = head;
			while (cur != null) {
				cur = cur.next;
				count++;
			}
			List<ListNode> list = new ArrayList<ListNode>();
			list.add(head);
			return recur(list, 0, count - 1);
		}

		private TreeNode recur(List<ListNode> list, int start, int end) {
			if (start > end)
				return null;
			int mid = (start + end) / 2;
			TreeNode left = recur(list, start, mid - 1);
			TreeNode root = new TreeNode(list.get(0).val);
			root.left = left;
			list.add(0, list.get(0).next);// insert node in the beginning
			TreeNode right = recur(list, mid + 1, end);
			root.right = right;
			return root;
		}
	}
}
